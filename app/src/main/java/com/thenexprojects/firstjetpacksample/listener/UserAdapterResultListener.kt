package com.thenexprojects.firstjetpacksample.listener

import com.thenexprojects.firstjetpacksample.model.User
import com.thenexprojects.firstjetpacksample.type.UserDialogOperationType
import java.io.Serializable

fun interface UserAdapterResultListener: Serializable {
    fun onResultsAvailable(user: User, operationType: UserDialogOperationType)
}