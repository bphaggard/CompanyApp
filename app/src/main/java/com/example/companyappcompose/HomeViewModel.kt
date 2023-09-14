package com.example.companyappcompose

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class HomeViewModel: ViewModel() {

    var newText by mutableStateOf("")
    val employeeList = mutableStateListOf<String>()

    fun randomSelect(): String {
        val persons = arrayOf("Igor", "Patrik", "Jan", "Jakub", "Jiří", "Roman", "Martin")
        val randomValue = persons.random()
        newText = randomValue
        return  newText
    }

    fun addEmployee(name: String) {
        employeeList.add(name)
    }

    fun removeEmployee(name: String) {
        employeeList.remove(name)
    }
}