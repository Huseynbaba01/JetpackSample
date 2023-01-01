package com.thenexprojects.firstjetpacksample.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "users_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    var username: String,
    var name: String,
    var surname: String,
    var age: Int
) : Serializable
