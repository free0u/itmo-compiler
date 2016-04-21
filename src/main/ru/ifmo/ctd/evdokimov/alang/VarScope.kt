package ru.ifmo.ctd.evdokimov.alang

import java.util.*

class VarScope : HashMap<String, VarDescr>() {
}

class VarDescr(val name : String, val type : VarTypes, val id : Int ) {
    override fun toString(): String{
        return "Var($type $name $id)"
    }
}

enum class VarTypes {
    INT, BOOL, VOID;

    companion object {
        fun parse(s : String) : VarTypes {
            return when (s) {
                "int" -> INT
                "bool" -> BOOL
                else -> VOID
            }
        }
    }
}