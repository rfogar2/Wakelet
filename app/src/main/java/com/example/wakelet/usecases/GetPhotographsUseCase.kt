package com.example.wakelet.usecases

import com.example.wakelet.models.Photograph
import com.example.wakelet.repositories.PhotographRepository
import io.reactivex.Single
import javax.inject.Inject

interface GetPhotographsUseCase {
    fun invoke(): Single<List<Photograph>>
}

class GetPhotographsUseCaseImpl @Inject constructor(
    private val photographRepository: PhotographRepository
) : GetPhotographsUseCase {
    override fun invoke(): Single<List<Photograph>> = photographRepository.getPhotographs()
}