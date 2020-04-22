package com.example.wakelet.extensions

import com.example.wakelet.dtos.PhotographDto
import com.example.wakelet.models.Photograph

fun PhotographDto.toModel() = Photograph(image, description, name, bio)