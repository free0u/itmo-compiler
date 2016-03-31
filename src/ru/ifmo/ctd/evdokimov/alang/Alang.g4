grammar Alang;

program
    : globalVars funcs
    ;

globalVars
    : (varDecl ';')*
    ;

funcs
    : funcDef*
    ;

topLevelDecl
    : varDecl ';'
    | funcDef
    ;

varDecl
    : type var
    ;


type
    : intType
    | boolType
    | voidType
    ;

funcDef
    : type funcName '(' funArgs? ')' scope
    ;

funArgs
    : varDecl (',' varDecl)*
    ;


scope
    : '{' statements '}'
    ;

statements
    : statement*
    ;

statement
    : varDecl ';'
    | assign ';'
    | ifStatement
    | whileStatement
    | printStatement ';'
    | readStatement ';'
    | procStatement ';'
    | returnStatement ';'
    ;

assign
    : var '=' expr
    ;

procStatement
    : funcName '(' exprList? ')'
    ;

whileStatement
    : 'while' '(' expr ')' whileScope
    ;

returnStatement
    : 'return' expr?
    ;

whileScope : scope;

ifStatement
    : 'if' '(' expr ')' ifThenScope 'else' ifElseScope
    ;

ifThenScope: scope;
ifElseScope: scope;

readStatement
    : 'read' '(' var ')'
    ;

printStatement
    : 'print' '(' expr ')'
    ;


expr
    : NUM                              # NumExpr
    | boolConst                        # BoolExpr
    | var                              # VarExpr
    | funcName '(' exprList? ')'       # CallExpr
    | expr op=('*'|'/'| '%') expr      # MulExpr
    | expr op=('+'|'-') expr           # AddExpr
    | expr op=('<'|'>'|'>='|'<=') expr # CompExpr
    | expr op=('!='|'==') expr         # EqCompExpr
    | expr op=('&&'|'||') expr         # BoolCompExpr
    | '(' expr ')'                     # ParExpr
    ;


exprList
    : funArg (',' funArg)*
    ;

funArg
    : expr
    ;

var : ID;
funcName : ID;

intType : 'int';
boolType : 'bool';
voidType : 'void';

boolConst : ('true' | 'false' );

ID : [a-zA-Z][a-zA-Z0-9]*;
NUM : [+-]?[0-9][0-9]*;
COMMENTS : '//' ~('\r' | '\n')* -> skip;
WS : [ \t\r\n]+ -> skip;
