package com.bokchi.coco.repository

import com.bokchi.coco.App
import com.bokchi.coco.db.CoinPriceDatabase
import com.bokchi.coco.db.entity.InterestCoinEntity
import com.bokchi.coco.db.entity.SelectedCoinPriceEntity

class DBRepository {

    val context = App.context()
    val db = CoinPriceDatabase.getDatabase(context)

    // InterestCoin

    // 전체 코인 데이터 가져오기
    fun getAllInterestCoinData() = db.interestCoinDAO().getAllData()

    // 코인 데이터 넣기
    fun insertInterestCoinData(interestCoinEntity: InterestCoinEntity) = db.interestCoinDAO().insert(interestCoinEntity)

    // 코인 데이터 업데이트
    fun updateInterestCoinData(interestCoinEntity: InterestCoinEntity) = db.interestCoinDAO().update(interestCoinEntity)

    // 사용자가 관심있어한 코인만 가져오기
    fun getAllInterestSelectedCoinData() = db.interestCoinDAO().getSelectedData()

    // CoinPrice
    fun getAllCoinPriceData() = db.SelectedCoinPriceDA0().getAllData()

    fun insertCoinPriceData(selectedCoinPriceEntity: SelectedCoinPriceEntity) = db.SelectedCoinPriceDA0().insert(selectedCoinPriceEntity)

    fun getOneSelectedCoinData(coinName: String) = db.SelectedCoinPriceDA0().getOneCoinData(coinName)

}