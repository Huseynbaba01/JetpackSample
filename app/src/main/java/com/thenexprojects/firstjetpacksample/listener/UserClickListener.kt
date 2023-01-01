package com.thenexprojects.firstjetpacksample.listener

import com.thenexprojects.firstjetpacksample.model.User

fun interface UserClickListener {
    fun onClick(user: User, isLongClick: Boolean)
}