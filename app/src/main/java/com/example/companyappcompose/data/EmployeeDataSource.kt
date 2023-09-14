package com.example.companyappcompose.data

import employeedb.EmployeeEntity
import kotlinx.coroutines.flow.Flow

interface EmployeeDataSource {

    suspend fun getEmployeeById(id: Long): EmployeeEntity?

    fun getAllEmployees(): Flow<List<EmployeeEntity>>

    suspend fun deleteEmployeeById(id: Long)

    suspend fun insertEmployee(fullName: String, id: Long? = null)

    suspend fun chooseRandomEmployee(randomFullName: String)
}