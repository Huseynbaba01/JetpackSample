package com.thenexprojects.firstjetpacksample.data.local.dao

import androidx.room.*
import com.thenexprojects.firstjetpacksample.model.User

@Dao
interface UsersDao {

    @Query("SELECT * FROM USERS_TABLE")
    fun getAll(): List<User>

    @Query("SELECT * FROM USERS_TABLE WHERE id = :id")
    fun getById(id: Int):User

    @Insert
    fun insert(user: User)

    @Insert
    fun insertAll(users: List<User>)

    @Delete
    fun delete(user: User)

    @Delete
    fun deleteAll(users: List<User>)

    @Update
    fun update(user: User)
}