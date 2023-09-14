package com.example.companyappcompose.data

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import com.`package`.companyappcompose.AppDatabase
import employeedb.EmployeeEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class EmployeeDataSourceImpl(
    db: AppDatabase) : EmployeeDataSource {

    private val queries = db.employeeEntityQueries

    override suspend fun getEmployeeById(id: Long): EmployeeEntity? {
        return withContext(Dispatchers.IO) {
            queries.getEmployeeById(id).executeAsOneOrNull()
        }
    }

    override fun getAllEmployees(): Flow<List<EmployeeEntity>> {
        return queries.getAllEmployees().asFlow().mapToList(Dispatchers.IO)
    }

    override suspend fun deleteEmployeeById(id: Long) {
        withContext(Dispatchers.IO){
            queries.deleteEmployeeById(id)
        }
    }

    override suspend fun insertEmployee(fullName: String, id: Long?) {
        withContext(Dispatchers.IO) {
            queries.insertEmployee(id, fullName)
        }
    }

    override suspend fun chooseRandomEmployee(randomFullName: String) {
        withContext(Dispatchers.IO) {
            queries.insertRandomEmployee().executeAsOneOrNull()
        }
    }
}