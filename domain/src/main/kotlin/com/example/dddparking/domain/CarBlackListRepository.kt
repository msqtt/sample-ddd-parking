package com.example.dddparking.domain

interface CarBlackListRepository {
    fun findByIdOrError(plate: Plate): CarBlackList
    fun save(blackList: CarBlackList)
}