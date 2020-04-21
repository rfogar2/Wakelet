package com.example.wakelet.stubs

import com.example.wakelet.wrappers.ResourcesWrapper
import java.io.InputStream

class ResourceWrapperStub : ResourcesWrapper {
    var text = ""

    override fun openRawResource(id: Int): InputStream {
        return text.byteInputStream()
    }
}