package com.dream.architecturecomponents.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database(entities = [Launches::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class)
abstract class LaunchesDatabase: RoomDatabase() {
    abstract fun LaunchesDao(): LaunchesDao


    companion object {

        fun buildInstance(context: Context) = Room
            .databaseBuilder(context, LaunchesDatabase::class.java, "launchesDatabase")
            .build()
    }

}




