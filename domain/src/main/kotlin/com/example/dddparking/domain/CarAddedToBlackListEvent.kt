package com.example.dddparking.domain

class CarAddedToBlackListEvent(
    val plate: Plate
) : DomainEvent