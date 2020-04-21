package com.example.wakelet.services

import dtos.PhotographDto
import io.reactivex.Single
import javax.inject.Inject

interface PhotographService {
    fun getPhotographs(): Single<List<PhotographDto>>
}

class PhotographServiceImpl @Inject constructor() : PhotographService {
    override fun getPhotographs(): Single<List<PhotographDto>> {
        return Single.just(emptyList())
    }
}