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
    : type funcName '()' scope
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
    ;

assign
    : var '=' expr
    ;

whileStatement
    : 'while' '(' expr ')' whileScope
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
    | expr op=('*'|'/'| '%') expr      # MulExpr
    | expr op=('+'|'-') expr           # AddExpr
    | expr op=('<'|'>'|'>='|'<=') expr # CompExpr
    | expr op=('!='|'==') expr         # EqCompExpr
    | expr op=('&&'|'||') expr         # BoolCompExpr
    | '(' expr ')'                     # ParExpr
    ;


var : ID;
funcName : ID;

intType : 'int';
boolType : 'bool';
voidType : 'void';

boolConst : ('true' | 'false' );

ID : [a-zA-Z][a-zA-Z0-9]*;
NUM : [+-]?[0-9][0-9]*;

WS : [ \t\r\n]+ -> skip;
