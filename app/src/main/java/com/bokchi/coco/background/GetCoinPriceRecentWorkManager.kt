package com.bokchi.coco.background

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.bokchi.coco.db.entity.SelectedCoinPriceEntity
import com.bokchi.coco.network.model.RecentCoinPriceList
import com.bokchi.coco.repository.DBRepository
import com.bokchi.coco.repository.NetWorkRepository
import java.util.Calendar
import java.util.Date

// 최근 거래된 코인 가격 내역을 가져오는 WorkManager

// 1. 관심있는 코인 리스트 가져옴
// 2. 관심 있는 코인 각각의 가격 변동 정보를 가져와서(New API)
// 3. 관심 있는 코인 각각의 가격 변동 정보 DB 저장
class GetCoinPriceRecentWorkManager(val context: Context, params: WorkerParameters)
    :CoroutineWorker(context, params){

    override suspend fun doWork(): Result {



        return Result.success()
    }

    // 1. 관심있는 코인 리스트 가져옴
    suspend fun getAllInterestSelectedCoinData(){
        val selectedCoinList = DBRepository().getAllInterestSelectedCoinData()

        val timestamp = Calendar.getInstance().time

        for (coinData in selectedCoinList){
            // 2. 관심 있는 코인 각각의 가격 변동 정보를 가져와서(New API)
            val recentCoinPriceList = NetWorkRepository().getInterestCoinPriceList(coinData.coin_name)

            saveSelectedCoinPrice(
                coinData.coin_name,
                recentCoinPriceList,
                timestamp
            )

        }
    }

    fun saveSelectedCoinPrice(
        coinName: String,
        recentCoinPriceList: RecentCoinPriceList,
        timestamp: Date
    ){
        val entity = SelectedCoinPriceEntity(
            0,
            coinName,
            recentCoinPriceList.data[0].transaction_date,
            recentCoinPriceList.data[0].type,
            recentCoinPriceList.data[0].units_traded,
            recentCoinPriceList.data[0].price,
            recentCoinPriceList.data[0].total,
            timestamp
        )

        DBRepository().insertCoinPriceData(entity)
    }

}