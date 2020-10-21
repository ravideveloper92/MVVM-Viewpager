package com.example.android.myndapplication.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    val message = MutableLiveData<Int>()

    fun sendMessage(text: Int) {
        message.value = text
    }
}