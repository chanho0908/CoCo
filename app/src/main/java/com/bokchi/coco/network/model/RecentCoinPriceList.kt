package com.bokchi.coco.network.model

import com.bokchi.coco.dataModel.RecentPriceData

data class RecentCoinPriceList (
    val status: String,
    val data: List<RecentPriceData>
)