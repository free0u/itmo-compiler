package ru.ifmo.ctd.evdokimov.alang

enum class OpType {
    ASSIGN, // ASSIGN <idx> <idx|const>
    PRINT, // PRINT <idx|const>
    IADD, // IADD <idx> <idx|const> <idx|const> # int -> int > int
    ISUB, // ISUB <idx> <idx|const> <idx|const> # int -> int > int
    ;
}