package com.example.wakelet.services

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dtos.PhotographDto
import io.reactivex.Single
import java.lang.reflect.Type
import javax.inject.Inject

interface PhotographService {
    fun getPhotographs(): Single<List<PhotographDto>>
}

class PhotographServiceImpl @Inject constructor() : PhotographService {
    val json = """
        [{"image":"https://images.unsplash.com/photo-1587315119275-80455dfc9d64?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max&ixid=eyJhcHBfaWQiOjgwNDd","description":"green palm tree on green grass field during daytime","name":"Taylor Simpson","bio":"Travel Photographer\r\nwww.taylorgsimpson.com"},{"image":"https://images.unsplash.com/photo-1587245910433-1b9150f9ae03?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max&ixid=eyJhcHBfaWQiOjgwNDd9","description":"Spring flowers in bloom","name":"Cody Fitzgerald","bio":null},{"image":"https://images.unsplash.com/photo-1587101462670-0d50af9af008?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max&ixid=eyJhcHBfaWQiOjgwNDd9","description":"snow covered rocks and green plants","name":"Megan Maria Belford","bio":"Trying to capture what captures me."},{"image":"https://images.unsplash.com/photo-1587082455459-397465b31608?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max&ixid=eyJhcHBfaWQiOjgwNDd9","description":"brown and white striped textile","name":"Melissa Guzzetta","bio":null},{"image":"https://images.unsplash.com/photo-1586263931755-2d15ef418247?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max&ixid=eyJhcHBfaWQiOjgwNDd9","description":"The moon and a couple of leaves ","name":"Andres Perez","bio":"simple guy with camera's eye"},{"image":"https://images.unsplash.com/photo-1586915039812-277dcd0a01ed?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max&ixid=eyJhcHBfaWQiOjgwNDd9","description":"snow covered mountain under cloudy sky during daytime","name":"Megan Maria Belford","bio":"Trying to capture what captures"},{"image":"https://images.unsplash.com/photo-1587022899468-131ed9bc8202?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max&ixid=eyJhcHBfaWQiOjgwNDd9","description":"green trees near lake under cloudy sky during daytime","name":"Kevin Mueller","bio":"Twenty-something year old psychology student, based in Germany & capturing w/ Fujifilm X-Pro1 & X-T3. Prints available: https://kevinmueller.darkroom.tech |  https://paypal.me/kevinmueller23"},{"image":"https://images.unsplash.com/photo-1586984827420-90e0d730476a?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max&ixid=eyJhcHBfaWQiOjgwNDd9","description":"Amber Ledge","name":"Ivan Bandura","bio":null},{"image":"https://images.unsplash.com/photo-1587058680639-ff5f233abe05?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max&ixid=eyJhcHBfaWQiOjgwNDd9","description":"Hiking Tent Ridge in Kananaskis Country Alberta. ","name":"Karl Lee","bio":"Commercial photographer available for hire. \r\nOriginally from Ireland and now based in Calgary Alberta.  You can see more of my work at the link above.   I can be found on Instagram at www.instagram.com/karlleephoto"},{"image":"https://images.unsplash.com/photo-1586964484161-648499ad1a19?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max&ixid=eyJhcHBfaWQiOjgwNDd9","description":"Sunrise from Abbot Pass Hut at Lake O Hara in Yoho National Park, British Columbia.","name":"Karl Lee","bio":"Commercial photographer available for hire. \r\nOriginally from Ireland and now based in Calgary Alberta.  You can see more of my work at the link above.   I can be found on Instagram at www.instagram.com/karlleephoto"},{"image":"https://images.unsplash.com/photo-1586930593478-7546d0394031?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max&ixid=eyJhcHBfaWQiOjgwNDd9","description":"green palm tree under blue sky during daytime","name":"Wengang Zhai","bio":"No bio. Instagram: zhai_wg."},{"image":"https://images.unsplash.com/photo-1554629942-0c17bf68b884?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max&ixid=eyJhcHBfaWQiOjgwNDd9","description":"snow-capped mountains near concrete road","name":"Mads Schmidt Rasmussen","bio":null}]
    """.trimIndent()

    override fun getPhotographs(): Single<List<PhotographDto>> {
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