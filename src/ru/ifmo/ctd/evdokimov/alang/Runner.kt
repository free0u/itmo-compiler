package main.ru.ifmo.ctd.evdokimov.alang

import org.antlr.v4.runtime.ANTLRFileStream
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTreeWalker
import ru.ifmo.ctd.evdokimov.alang.AlangListener
import ru.ifmo.ctd.evdokimov.alang.ByteCodeLoader
import ru.ifmo.ctd.evdokimov.alang.antlr.AlangLexer
import ru.ifmo.ctd.evdokimov.alang.antlr.AlangParser
import ru.ifmo.ctd.evdokimov.alang.getByteCode
import ru.ifmo.ctd.evdokimov.alang.parseFuncTypes
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.util.*


fun tokenize(s : String) : List<String> {
    val ret = ArrayList<String>()
    val t = StringTokenizer(s);
    while (t.hasMoreTokens()) {
        ret.add(t.nextToken())
    }
    return ret
}

fun compareOutput(realOut : String, expectedOut : String) : Boolean {
    val realTokens = tokenize(realOut)
    val expectedTokens = tokenize(expectedOut)

    return realTokens.equals(expectedTokens)
}

fun testProgram(programName : String, input : String, expectedOut : String) : Boolean {

    val functionTypes = parseFuncTypes(programName)


    val lexer = AlangLexer(ANTLRFileStream(programName))
    val parser = AlangParser(CommonTokenStream(lexer))

    val walker = ParseTreeWalker();
    val listener = AlangListener(functionTypes)
    walker.walk(listener, parser.program())
    val bytes = getByteCode(listener)


    println("run compiled class")
    val aClass = ByteCodeLoader.clazz.loadClass(bytes)
    val meth = aClass.getMethod("main", Array<String>::class.java)
    val arr : Array<String> = arrayOf()


    val oldOut = System.out

    val baos = ByteArrayOutputStream()
    val outputStream = PrintStream(baos)
    System.setIn(input.byteInputStream())
    System.setOut(outputStream)

    meth.invoke(null, arr)

    System.setOut(oldOut)

    val realOutput = baos.toString("UTF-8")

    return compareOutput(realOutput, expectedOut)
}