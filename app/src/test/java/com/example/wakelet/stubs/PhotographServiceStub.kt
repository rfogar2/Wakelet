package com.example.wakelet.stubs

import com.example.wakelet.dtos.PhotographDto
import com.example.wakelet.services.PhotographService
import io.reactivex.Single

class PhotographServiceStub : PhotographService {
    var photographDtos: List<PhotographDto> = emptyList()

    override fun getPhotographs(): Single<List<PhotographDto>> = Single.just(photographDtos)
}