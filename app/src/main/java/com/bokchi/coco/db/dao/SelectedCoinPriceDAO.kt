package com.bokchi.coco.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bokchi.coco.db.entity.SelectedCoinPriceEntity

@Dao
interface SelectedCoinPriceDAO {

    @Query("SELECT * FROM SELECTED_COIN_PRICE_TABLE")
    fun getAllData(): List<SelectedCoinPriceEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(selectedCoinPriceEntity: SelectedCoinPriceEntity)

    @Query("SELECT * FROM SELECTED_COIN_PRICE_TABLE WHERE coinName = :coinName")
    fun getOneCoinData(coinName: String): List<SelectedCoinPriceEntity>

}