package com.example.companyappcompose.di

import android.app.Application
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.example.companyappcompose.data.EmployeeDataSource
import com.example.companyappcompose.data.EmployeeDataSourceImpl
import com.`package`.companyappcompose.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSqlDriver(app: Application): SqlDriver {
        return AndroidSqliteDriver(
            schema = AppDatabase.Schema,
            context = app,
            name = "employee.db"
        )
    }

    @Provides
    @Singleton
    fun provideEmployeeDataSource(driver: SqlDriver): EmployeeDataSource{
        return EmployeeDataSourceImpl(AppDatabase(driver))
    }
}