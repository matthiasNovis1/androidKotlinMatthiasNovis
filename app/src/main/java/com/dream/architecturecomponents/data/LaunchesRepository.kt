package com.dream.architecturecomponents.data

import android.app.Application
import android.util.Log

object LaunchesRepository {
    private lateinit var database: LaunchesDatabase

    private lateinit var launchesDao: LaunchesDao

    fun initialize(application: Application) {
        database = LaunchesDatabase.buildInstance(application)
        launchesDao = database.LaunchesDao()
    }

    fun insertAll(launches: List<Launches>) {
        launches.forEach { launch -> if(launch.flight_number == 0) launch.flight_number = (getAll().maxBy { it.flight_number }?.flight_number ?: 0) + 1 }
        launchesDao.insertAll(launches)
        Log.d("movieRepository","inserting movies: $launches")
    }

    fun insert(movie: Launches) = insertAll(listOf(movie))

    fun delete(launch: Launches) {
        launchesDao.delete(launch)
    }

    fun getById(id: Int): Launches = launchesDao.getById(id)

    fun getAll(): List<Launches> = launchesDao.getAll()
}