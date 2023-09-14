package com.example.companyappcompose.bottombar


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.companyappcompose.screens.AboutCompany
import com.example.companyappcompose.screens.Employees
import com.example.companyappcompose.screens.HomeScreen

@Composable
fun NavigationGraph(navController: NavHostController){
    NavHost(navController, startDestination = BottomNavigationItem.Home.screen_route) {
        composable(BottomNavigationItem.Home.screen_route) {
            HomeScreen()
        }
        composable(BottomNavigationItem.Employees.screen_route) {
            Employees()
        }
        composable(BottomNavigationItem.About.screen_route) {
            AboutCompany()
        }
    }
}