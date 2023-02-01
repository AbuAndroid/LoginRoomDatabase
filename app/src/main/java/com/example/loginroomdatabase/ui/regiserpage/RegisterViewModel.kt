package com.example.loginroomdatabase.ui.regiserpage

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.loginroomdatabase.model.User
import com.example.loginroomdatabase.repository.UserRepository
import kotlinx.coroutines.launch

class RegisterViewModel(private val repository: UserRepository):ViewModel() {

    val readAllData: LiveData<List<User>> = repository.readAlldata

    fun insert(user: User) = repository.insetUser(user)

}