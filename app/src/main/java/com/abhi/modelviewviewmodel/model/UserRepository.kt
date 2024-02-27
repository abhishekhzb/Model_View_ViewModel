package com.abhi.modelviewviewmodel.model

import androidx.lifecycle.LiveData
import com.abhi.modelviewviewmodel.model.roomdb.UserDao
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserRepository(private val userDao: UserDao) {
    // Retrofit instance for API calls
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.example.com/") // Replace with your API base URL
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    // Service interface for defining API endpoints
    private val userService = retrofit.create(UserService::class.java)

    val allUsers: LiveData<List<User>> = userDao.getAllUsers()

    suspend fun refreshUsers() {
        val users = fetchUsersFromApi()
        userDao.insertUsers(users)
    }

    private suspend fun fetchUsersFromApi(): List<User> {
        // Make API call to fetch users
        val response = userService.getUsers()
        if (response.isSuccessful) {
            return response.body() ?: emptyList()
        } else {
            // Handle API call failure
            throw Exception("Failed to fetch users: ${response.code()}")
        }
    }
}

