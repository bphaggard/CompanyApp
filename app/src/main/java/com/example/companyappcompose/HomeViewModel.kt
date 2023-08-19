package com.example.companyappcompose

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class HomeViewModel: ViewModel() {

    var newText by mutableStateOf("")

    fun randomSelect(): String {
        val persons = arrayOf("Igor", "Patrik", "Jan", "Jakub", "Jiří", "Roman", "Martin")
        val randomValue = persons.random()
        newText = randomValue
        return  newText
    }
}