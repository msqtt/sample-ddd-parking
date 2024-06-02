package com.example.dddparking.domain

import org.springframework.stereotype.Component
import java.time.LocalDateTime

class RemoveCarFromBlackListCommand(
    val plate: Plate,
    val time: LocalDateTime
)

@Component
class RemoveCarFromBlackListCommandHandler(
    private val carBlackListRepository: CarBlackListRepository
) {
    fun handle(eventQueue: EventQueue, command: RemoveCarFromBlackListCommand) {
        val blackList = this.carBlackListRepository.findByIdOrError(command.plate)
        blackList.remove(eventQueue, command)
        carBlackListRepository.save(blackList)
    }
}