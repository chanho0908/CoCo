package com.bokchi.coco.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.bokchi.coco.db.dao.InterestCoinDAO
import com.bokchi.coco.db.dao.SelectedCoinPriceDAO
import com.bokchi.coco.db.entity.DateConverters
import com.bokchi.coco.db.entity.InterestCoinEntity
import com.bokchi.coco.db.entity.SelectedCoinPriceEntity
import java.util.Date


@Database(entities = [InterestCoinEntity::class, SelectedCoinPriceEntity::class], version = 2)
@TypeConverters(DateConverters::class)
abstract class CoinPriceDatabase : RoomDatabase() {

    abstract fun interestCoinDAO() : InterestCoinDAO
    abstract fun SelectedCoinPriceDA0() : SelectedCoinPriceDAO

    companion object {

        @Volatile
        private var INSTANCE : CoinPriceDatabase? = null

        fun getDatabase(
            context : Context
        ) : CoinPriceDatabase {

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CoinPriceDatabase::class.java,
                    "coin_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }


        }

    }


}