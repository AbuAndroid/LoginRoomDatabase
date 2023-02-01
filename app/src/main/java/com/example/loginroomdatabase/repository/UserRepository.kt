package com.example.loginroomdatabase.repository

import androidx.lifecycle.LiveData
import com.example.loginroomdatabase.model.User
import com.example.loginroomdatabase.model.UserDao
import kotlinx.coroutines.flow.Flow

class UserRepository(private val userDao: UserDao) {

    val readAlldata : LiveData<List<User>> = userDao.readAllData()

    fun insetUser(user: User){
        userDao.insertUser(user)
    }
}