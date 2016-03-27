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
    | writeStatement ';'
    | printStatement ';'
    ;

assign
    : var '=' expr
    ;

whileStatement
    : 'while' '(' expr ')' scope
    ;

ifStatement
    : 'if' '(' expr ')' scope 'else' scope
    ;

printStatement
    : 'print' '(' var ')'
    ;

writeStatement
    : 'write' '(' expr ')'
    ;


expr
    : NUM                    # NumExpr
    | boolConst              # BoolExpr
    | var                    # VarExpr
    | expr op=('+'|'-') expr # AddExpr
    | expr op=('*'|'/') expr # MulExpr
    | expr op=('<'|'>') expr # CompExpr
    | '(' expr ')'           # ParExpr
    ;


var : ID;
funcName : ID;

intType : 'int';
boolType : 'bool';
voidType : 'void';

boolConst : ('true' | 'false' );

ID : [a-zA-Z][a-zA-Z0-9]*;
NUM : [+-]?[1-9][0-9]*;

WS : [ \t\r\n]+ -> skip;
