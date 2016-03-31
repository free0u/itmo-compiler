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

        fun label(v : Int) : OpArg {
            return OpArg(ArgType.LABEL, v)
        }

        fun bool(v : String) : OpArg {
            return OpArg(ArgType.BOOL, if (v.equals("true")) 1 else 0)
        }

        fun func(v : String) : OpArg {
            return OpArg(ArgType.FUNCTION, v)
        }


    }

    override fun toString(): String{
        when (type) {
            ArgType.EMPTY -> return "_"
            ArgType.INT -> return value.toString()
            ArgType.IDX -> return "#$value"
            ArgType.BOOL -> return "b$value"
            ArgType.LABEL -> return "%$value"
            ArgType.FUNCTION -> return "<$value>"
            else -> return "OpArg(type=$type, value=$value)"
        }
    }


}

enum class ArgType {
    IDX,
    INT,
    BOOL,
    FUNCTION,
    LABEL,
    EMPTY
}