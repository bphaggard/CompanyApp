package com.example.companyappcompose.bottombar


import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.companyappcompose.EmployeeListViewModel
import com.example.companyappcompose.screens.AboutCompany
import com.example.companyappcompose.screens.Employees
import com.example.companyappcompose.screens.HomeScreen

@Composable
fun NavigationGraph(navController: NavHostController){
    val viewModel: EmployeeListViewModel = hiltViewModel()

    NavHost(navController, startDestination = BottomNavigationItem.Home.screen_route) {
        composable(BottomNavigationItem.Home.screen_route) {
            HomeScreen(viewModel)
        }
        composable(BottomNavigationItem.Employees.screen_route) {
            Employees()
        }
        composable(BottomNavigationItem.About.screen_route) {
            AboutCompany()
        }
    }
}