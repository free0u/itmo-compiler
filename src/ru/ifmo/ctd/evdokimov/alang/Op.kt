package ru.ifmo.ctd.evdokimov.alang

class Op(
        val type : OpType,
        val x : OpArg,
        val y : OpArg,
        val res : OpArg
        ) {

    override fun toString(): String{
        return "$type $x $y $res"
    }
}

