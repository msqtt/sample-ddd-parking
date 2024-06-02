package com.example.dddparking.domain

class CarRemoveFromBlackListEvent(
    val plate: Plate
) : DomainEvent