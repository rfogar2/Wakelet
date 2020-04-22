package com.example.wakelet.models

import java.io.Serializable

data class Photograph(
    val image: String, val description: String, val name: String, val bio: String?
) : Serializable