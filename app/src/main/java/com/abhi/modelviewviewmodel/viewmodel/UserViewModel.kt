package com.abhi.modelviewviewmodel.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.abhi.modelviewviewmodel.model.roomdb.AppDatabase
import com.abhi.modelviewviewmodel.model.User
import com.abhi.modelviewviewmodel.model.UserRepository
import kotlinx.coroutines.launch

//The ViewModel class is designed to store and manage UI-related data in a lifecycle conscious way.
// The ViewModel class allows data to survive configuration changes such as screen rotations.


class UserViewModel(application: Application) : AndroidViewModel(application) {
    private val userRepository: UserRepository
    val allUsers: LiveData<List<User>>

    init {
        val userDao = AppDatabase.getDatabase(application).userDao()
        userRepository = UserRepository(userDao)
        allUsers = userRepository.allUsers
    }

    fun refreshUsers() {
        viewModelScope.launch {
            userRepository.refreshUsers()
        }
    }
}
