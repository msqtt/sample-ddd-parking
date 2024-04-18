package com.example.dddparking.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

class CarBlackListImplTest {

    @Test
    fun test_case0() {
        try {
            val eventQueue = TestEventQueue()
            CarBlackListImpl(plate = Plate("p1"), isBaned = true)
                .add(
                    eventQueue, AddCarToBlackListCommand(plate = Plate("p1"), time = LocalDateTime.now())
                )
        } catch (e: IllegalArgumentException) {
            assertEquals("Plate is already in the black list", e.message)
        }
    }

    @Test
    fun test_case1() {
        try {
            val eventQueue = TestEventQueue()
            CarBlackListImpl(plate = Plate("p1"), isBaned = false)
                .remove(
                    eventQueue, RemoveCarFromBlackListCommand(plate = Plate("p1"), time = LocalDateTime.now())
                )
        } catch (e: IllegalArgumentException) {
            assertEquals("Plate is not in the black list", e.message)
        }
    }
}