package com.dream.architecturecomponents.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


@Entity(tableName = "launches")
data class Launches(
    @PrimaryKey
    var flight_number: Int = 0,

    var mission_name: String = "Sans titre"

)