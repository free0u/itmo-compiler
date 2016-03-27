grammar Calc;

prog
    : stmt*
    ;

stmt
    : assign
    | print
    ;


assign
    : ID '=' expr
    ;

expr
    : expr '+' expr     # Add
    | NUM               # Number
    | ID                # Var
    ;

print
    : ID
    ;

NUM
    : [+-]?[1-9][0-9]*
    ;


ID
    :
    [_a-zA-Z][-_a-zA-Z0-9]*
    ;


WS
    :
    [ \t\r\n]+ -> skip
    ;
