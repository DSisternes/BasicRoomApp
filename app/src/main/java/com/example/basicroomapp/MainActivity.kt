package com.example.basicroomapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.basicroomapp.database.User

class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        mainViewModel.saveUser(User(
            "Userid0002",
            "Name0002",
            1.74,
            74.3,
            "diego2@gmail.com",
            "password0002"
        ))

        mainViewModel.getUsers()
        //Si es fragment
        //es con viewLifecycleOwner en lugar de this
        mainViewModel.savedUsers.observe(this,{usersList ->
            if (!usersList.isNullOrEmpty()){
                for(user in usersList){
                    Log.d("thesearetheusers", user.user_email)
                }

            }else{
                Log.d("thesearetheusers", "null or empty")
            }
        })

    }
}