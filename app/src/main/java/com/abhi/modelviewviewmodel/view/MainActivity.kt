package com.abhi.modelviewviewmodel.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.abhi.modelviewviewmodel.R
import com.abhi.modelviewviewmodel.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ViewModelProviders is the helper class, whose main purpose is to create new instance of viewmodel if it is not exist, otherwise return existing instance.

        // userViewModel = ViewModelProvider( viewModelStoreOwner, vViewModelFactory ).get(UserViewModel::class.java)

        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        userViewModel.allUsers.observe(this, Observer { users ->
            // Update UI with user data
        })

        userViewModel.refreshUsers()
    }
}