package ru.ifmo.ctd.evdokimov.alang



class OpArg(val type : ArgType,
            val value : Any) {

    companion object {
        val empty = OpArg(ArgType.EMPTY, 0)

        fun int(v : Int) : OpArg {
            return OpArg(ArgType.INT, v)
        }

        fun idx(v : Int) : OpArg {
            return OpArg(ArgType.IDX, v)
        }
    }

    override fun toString(): String{
        if (type == ArgType.EMPTY)
            return "_"
        if (type == ArgType.INT) {
            return value.toString()
        }
        if (type == ArgType.IDX) {
            return "#$value"
        }
        return "OpArg(type=$type, value=$value)"
    }


}

enum class ArgType {
    IDX,
    INT,
    BOOL,
    EMPTY
}