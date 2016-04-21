package ru.ifmo.ctd.evdokimov

import ru.ifmo.ctd.evdokimov.alang.testProgram
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

    @test fun testSwitch() {
        assertTrue(testProgram("test-programs/switch.a", "1", "20"))
        assertTrue(testProgram("test-programs/switch.a", "2", "40"))
        assertTrue(testProgram("test-programs/switch.a", "3", "60"))
        assertTrue(testProgram("test-programs/switch.a", "4", "80"))
        assertTrue(testProgram("test-programs/switch.a", "5", "100"))
        assertTrue(testProgram("test-programs/switch.a", "31", "0"))
    }

    @test fun testIf() {
        assertTrue(testProgram("test-programs/if.a", "10", "10"))
        assertTrue(testProgram("test-programs/if.a", "20", "20"))
        assertTrue(testProgram("test-programs/if.a", "30", "30"))
        assertTrue(testProgram("test-programs/if.a", "40", "40"))
        assertTrue(testProgram("test-programs/if.a", "50", "50"))
        assertTrue(testProgram("test-programs/if.a", "60", "-1"))
    }

    @test fun testCmp() {
        assertTrue(testProgram("test-programs/cmp.a", "1 2", "-1"))
        assertTrue(testProgram("test-programs/cmp.a", "2 2", "0"))
        assertTrue(testProgram("test-programs/cmp.a", "2 1", "1"))
        assertTrue(testProgram("test-programs/cmp.a", "-1 -2", "1"))
        assertTrue(testProgram("test-programs/cmp.a", "-2 -1", "-1"))
        assertTrue(testProgram("test-programs/cmp.a", "-2 -2", "0"))
        assertTrue(testProgram("test-programs/cmp.a", "-2 2", "-1"))
        assertTrue(testProgram("test-programs/cmp.a", "2 -2", "1"))
        assertTrue(testProgram("test-programs/cmp.a", "0 0", "0"))
    }

    @test fun testWhile() {
        assertTrue(testProgram("test-programs/while.a", "", "2 4 6 8 10"))
    }

    @test fun testRecFib() {
        assertTrue(testProgram("test-programs/fib-rec.a", "", "1 1 2 3 5 8 13 21 34 55"))
    }

    @test fun testRecFact() {
        assertTrue(testProgram("test-programs/fact-rec.a", "5 1 2 3 4 5", "1 2 6 24 120"))
    }




}
