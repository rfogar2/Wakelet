package com.example.wakelet.repositories

import com.example.wakelet.extensions.toModel
import com.example.wakelet.models.Photograph
import com.example.wakelet.services.PhotographService
import io.reactivex.Single
import javax.inject.Inject

interface PhotographRepository {
    fun getPhotographs(): Single<List<Photograph>>
}

class PhotographRepositoryImpl @Inject constructor(
    private val photographService: PhotographService
) : PhotographRepository {
    override fun getPhotographs(): Single<List<Photograph>> =
        photographService.getPhotographs()
            .map { photographDtos -> photographDtos.map { it.toModel() } }
}