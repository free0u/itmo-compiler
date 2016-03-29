package ru.ifmo.ctd.evdokimov.alang

enum class OpType {
    ASSIGN, // ok ASSIGN <idx> <idx|const>
    PRINT, // ok? (need better support of bool) PRINT <idx|const>

    IADD, // ok IADD <idx|const> <idx|const> <idx> # int -> int > int
    ISUB, // ok ISUB <idx|const> <idx|const> <idx> # int -> int > int
    IMUL, // ok IMUL <idx|const> <idx|const> <idx> # int -> int > int
    IDIV, // ok IDIV <idx|const> <idx|const> <idx> # int -> int > int
    IMOD, // ok IMOD <idx|const> <idx|const> <idx> # int -> int > int

    IG, // ok IG <idx|const> <idx|const> <idx> # int -> int > int # >
    IL, // ok IL <idx|const> <idx|const> <idx> # int -> int > int # <
    IGE, // ok IGE <idx|const> <idx|const> <idx> # int -> int > int # >=
    ILE, // ok ILE <idx|const> <idx|const> <idx> # int -> int > int # <=

    BAND, // ok BAND <idx|const> <idx|const> <idx> # bool -> bool > bool #
    BOR, // ok BOR <idx|const> <idx|const> <idx> # bool -> bool > bool #

    EQ, // ok EQ <idx|const> <idx|const> <idx> # int or bool -> int > bool # ==
    NEQ, // ok NEQ <idx|const> <idx|const> <idx> # int -> int > bool # !=

    LABEL, // <label>
    JMP, // <label>
    JMPT, // <idx|const> <label>
    JMPF, // <idx|const> <label>

    ;
}