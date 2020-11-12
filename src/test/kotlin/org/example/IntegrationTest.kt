package org.example

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

@Tag("IntegrationTest")
class IntegrationTest {
    @Test
    fun test(){
        println("IntegrationTest")
        assertTrue(true)
    }
}
