package com.example.wakelet.services

import com.example.wakelet.R
import com.example.wakelet.wrappers.ResourcesWrapper
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import dtos.PhotographDto
import io.reactivex.Single
import java.io.StringWriter
import java.lang.reflect.Type
import javax.inject.Inject


interface PhotographService {
    fun getPhotographs(): Single<List<PhotographDto>>
}

class PhotographServiceImpl @Inject constructor(
    private val resourcesWrapper: ResourcesWrapper
) : PhotographService {
    override fun getPhotographs(): Single<List<PhotographDto>> {
        val json = resourcesWrapper
            .openRawResource(R.raw.unsplash_edited)
            .bufferedReader()
            .use { it.readText() }

        val moshi = Moshi.Builder()
            .build()

        val listOfPhotographsType: Type = Types.newParameterizedType(
            List::class.java,
            PhotographDto::class.java
        )
        val jsonAdapter: JsonAdapter<List<PhotographDto>> = moshi.adapter(listOfPhotographsType)
        val photographDtos = jsonAdapter.fromJson(json) ?: return Single.error(Exception("Error parsing json"))

        return Single.just(photographDtos)
    }
}