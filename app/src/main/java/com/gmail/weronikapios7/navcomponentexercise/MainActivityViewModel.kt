package com.gmail.weronikapios7.navcomponentexercise

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel(): ViewModel() {
    private var _user = MutableLiveData<User>()
    val user: LiveData<User> = _user

    fun newUser(newUser: User){
        _user.value = newUser
    }




}