package com.example.dddparking.domain

import org.springframework.stereotype.Component

@Component
class CarParkingService(
    private val checkInCommandHandler: CheckInCommandHandler,
    private val carBlackListRepository: CarBlackListRepository

) {


    fun handle(eventQueue: EventQueue, facadeCommand: FacadeCommand) {
        var carBlackList = carBlackListRepository.findByIdOrError(facadeCommand.plate)
        if (carBlackList.isBaned()) {
            throw RuntimeException("车辆已被禁止入场")
        }
        checkInCommandHandler.handle(eventQueue, CheckInCommand(facadeCommand.plate, facadeCommand.checkInTime))
    }
}