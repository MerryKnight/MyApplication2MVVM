package com.example.myapplication2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ThirdViewModel : ViewModel() {
    private val _navigateToFirst = MutableLiveData<Boolean>()
    private val _navigateToSecond = MutableLiveData<Boolean>()

    val navigateToFirst: LiveData<Boolean> get() = _navigateToFirst
    val navigateToSecond: LiveData<Boolean> get() = _navigateToSecond

    fun onFirstButtonClicked() {
        _navigateToFirst.value = true
    }

    fun onSecondButtonClicked() {
        _navigateToSecond.value = true
    }

    fun resetNavigation() {
        _navigateToFirst.value = false
        _navigateToSecond.value = false
    }
}