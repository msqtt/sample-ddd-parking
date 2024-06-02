package com.example.dddparking.domain

import org.springframework.stereotype.Component
import java.time.LocalDateTime

class AddCarToBlackListCommand(
    val plate: Plate,
    val time: LocalDateTime
)

@Component
class AddCarToBlackListCommandHandler(
    private val carBlackListRepository: CarBlackListRepository
) {
    fun handle(eventQueue: EventQueue, command: AddCarToBlackListCommand) {
        val blackList = this.carBlackListRepository.findByIdOrError(command.plate)
        blackList.add(eventQueue, command)
        carBlackListRepository.save(blackList)
    }
}