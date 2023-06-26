package com.bokchi.coco.repository

import com.bokchi.coco.network.Api
import com.bokchi.coco.network.RetrofitInstance

class NetWorkRepository {

    private val client = RetrofitInstance.getInstance().create(Api::class.java)

    suspend fun getCurrentCoinList() = client.getCurrentCoinList()

}