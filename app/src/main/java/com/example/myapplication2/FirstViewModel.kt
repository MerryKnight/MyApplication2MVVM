package com.example.myapplication2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FirstViewModel : ViewModel() {
    private val _navigateToSecond = MutableLiveData<Boolean>()
    private val _navigateToThird = MutableLiveData<Boolean>()

    val navigateToSecond: LiveData<Boolean> get() = _navigateToSecond
    val navigateToThird: LiveData<Boolean> get() = _navigateToThird

    fun onSecondButtonClicked() {
        _navigateToSecond.value = true
    }

    fun onThirdButtonClicked() {
        _navigateToThird.value = true
    }

    fun resetNavigation() {
        _navigateToSecond.value = false
        _navigateToThird.value = false
    }
}