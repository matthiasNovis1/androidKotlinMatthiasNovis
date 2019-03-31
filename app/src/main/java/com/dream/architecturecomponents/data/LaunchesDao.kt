package com.dream.architecturecomponents.data
import androidx.room.*

@Dao interface LaunchesDao {
    @Query("SELECT * FROM launches WHERE flight_number = :id")
    fun getById(id: Int): Launches

    @Query("SELECT * FROM launches ORDER BY mission_name")
    fun getAll(): List<Launches>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(movie: Launches)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: List<Launches>)

    @Delete
    fun delete(movie: Launches)
}
