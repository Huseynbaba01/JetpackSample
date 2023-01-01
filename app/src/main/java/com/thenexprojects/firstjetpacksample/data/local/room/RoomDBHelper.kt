package com.thenexprojects.firstjetpacksample.data.local.room

import android.content.Context
import androidx.room.Room

object RoomDBHelper {
    private var INSTANCE: MyRoomDatabase? = null
    fun getRoomInstance(context: Context): MyRoomDatabase {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context, MyRoomDatabase::class.java, "my_database")
                .allowMainThreadQueries()
                .build()
        }
        return INSTANCE!!
    }
}