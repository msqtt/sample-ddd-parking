package com.example.dddparking.domain

import java.time.LocalDateTime

class FacadeCommand(
    val plate: Plate,
    val checkInTime: LocalDateTime
)
