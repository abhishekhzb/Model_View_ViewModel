package com.abhi.modelviewviewmodel.model

import com.abhi.modelviewviewmodel.model.User
import retrofit2.Response
import retrofit2.http.GET

interface UserService {
    @GET("users") // Specify the endpoint to fetch users
    suspend fun getUsers(): Response<List<User>> // Define a suspend function to fetch users
}
