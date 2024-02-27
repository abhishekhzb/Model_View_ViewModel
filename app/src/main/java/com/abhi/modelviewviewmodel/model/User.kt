package com.abhi.modelviewviewmodel.model

import androidx.room.Entity
import androidx.room.PrimaryKey

// User model
@Entity(tableName = "users")
data class User(
    @PrimaryKey val id: Int,
    val name: String,
    val email: String
)