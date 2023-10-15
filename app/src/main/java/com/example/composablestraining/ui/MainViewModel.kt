package com.example.composablestraining.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel :  ViewModel(){
    private val _isLoading = MutableStateFlow(false)
    var isLoading : StateFlow<Boolean> = _isLoading.asStateFlow()

    init {
        loadStuff()

    }
    fun loadStuff(){
        viewModelScope.launch {
            _isLoading.value = true
            delay(3000L)
            _isLoading.value = false
        }
    }
}