package com.thenexprojects.firstjetpacksample.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.thenexprojects.firstjetpacksample.data.local.dao.UsersDao
import com.thenexprojects.firstjetpacksample.model.User

@Database(entities = [User::class.java], version = 0)
class MyRoomDatabase: RoomDatabase {
    abstract fun usersDao(): UsersDao
}