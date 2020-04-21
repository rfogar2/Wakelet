package com.example.wakelet.wrappers

import android.content.res.Resources
import androidx.annotation.RawRes
import java.io.InputStream

interface ResourcesWrapper {
    fun openRawResource(@RawRes id: Int): InputStream
}

class ResourcesWrapperImpl(private val resources: Resources) : ResourcesWrapper {
    override fun openRawResource(id: Int): InputStream = resources.openRawResource(id)

}