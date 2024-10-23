package com.example.myapplication2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SecondViewModel : ViewModel() {
    private val _navigateToFirst = MutableLiveData<Boolean>()
    private val _navigateToThird = MutableLiveData<Boolean>()

    val navigateToFirst: LiveData<Boolean> get() = _navigateToFirst
    val navigateToThird: LiveData<Boolean> get() = _navigateToThird

    fun onFirstButtonClicked() {
        _navigateToFirst.value = true
    }

    fun onThirdButtonClicked() {
        _navigateToThird.value = true
    }

    fun resetNavigation() {
        _navigateToFirst.value = false
        _navigateToThird.value = false
    }
}