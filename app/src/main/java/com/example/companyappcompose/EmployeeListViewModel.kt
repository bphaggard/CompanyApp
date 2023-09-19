package com.example.companyappcompose

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.companyappcompose.data.EmployeeDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EmployeeListViewModel @Inject constructor(
    private val employeeDataSource: EmployeeDataSource
): ViewModel() {

    val employees = employeeDataSource.getAllEmployees()

    var fullNameText by mutableStateOf("")
        private set

    var randomFullNameText by mutableStateOf("")
        private set

    fun newEmployeeAdded(){

        viewModelScope.launch {
            employeeDataSource.insertEmployee(fullNameText)
            fullNameText = ""
        }
    }

    fun deleteEmployee(id: Long){
        viewModelScope.launch {
            employeeDataSource.deleteEmployeeById(id)
        }
    }

    fun onFullNameChange(value: String){
        fullNameText = value
    }

    suspend fun selectRandomEmployee() {
        randomFullNameText = employeeDataSource.chooseRandomEmployee() ?: ""
        Log.d("EmployeeListViewModel", "Random Full Name: $randomFullNameText")
    }
}