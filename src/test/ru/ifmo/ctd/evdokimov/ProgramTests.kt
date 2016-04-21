package ru.ifmo.ctd.evdokimov

import main.ru.ifmo.ctd.evdokimov.alang.testProgram
import kotlin.test.assertTrue
import org.junit.Test as test

class ProgramTests {
    @test fun testSum() {
        assertTrue(testProgram("test-programs/sum.a", "2 3", "5"))
        assertTrue(testProgram("test-programs/sum.a", "-1 1", "0"))
        assertTrue(testProgram("test-programs/sum.a", "0 0", "0"))
        assertTrue(testProgram("test-programs/sum.a", "-1 2", "1"))
        assertTrue(testProgram("test-programs/sum.a", "2 -1", "1"))
        assertTrue(testProgram("test-programs/sum.a", "-3 -2", "-5"))
    }

    @test fun testPower() {
        assertTrue(testProgram("test-programs/fast-power.a", "2 10", "1024"))
        assertTrue(testProgram("test-programs/fast-power.a", "0 10", "0"))
        assertTrue(testProgram("test-programs/fast-power.a", "1 100", "1"))
        assertTrue(testProgram("test-programs/fast-power.a", "10 0", "1"))
        assertTrue(testProgram("test-programs/fast-power.a", "10 1", "10"))
        assertTrue(testProgram("test-programs/fast-power.a", "10 2", "100"))

    }


}
