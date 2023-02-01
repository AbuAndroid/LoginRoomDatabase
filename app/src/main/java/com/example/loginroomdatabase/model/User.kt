package com.example.loginroomdatabase.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_details")
data class User(
    @PrimaryKey val Id:Int?,
    @ColumnInfo(name = "userName")val name:String?,
    @ColumnInfo(name ="userPassword") val password:String?
)
