package com.thenexprojects.firstjetpacksample.model

import java.io.Serializable

data class User(
    var id: Int? = null,
    var username: String,
    var name: String,
    var surname: String,
    var age: Int
) : Serializable
