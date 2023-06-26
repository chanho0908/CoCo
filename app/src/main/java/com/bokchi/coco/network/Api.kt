package com.bokchi.coco.network

import com.bokchi.coco.network.model.CurrentPriceList
import retrofit2.http.GET

interface Api {

    // public/ticker/ALL_KRW
    @GET("public/ticker/ALL_KRW")
    suspend fun getCurrentCoinList() : CurrentPriceList

}