package com.example.companyappcompose

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavigationItem(
    var title:String,
    var selectedIcon: ImageVector,
    var unselectedIcon: ImageVector,
    var screen_route:String)
{
    object Home : BottomNavigationItem(
        title = "Home",
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Filled.Home,
        screen_route = "home")
    object Employees : BottomNavigationItem(
        title = "Employees",
        selectedIcon = Icons.Filled.Person,
        unselectedIcon = Icons.Filled.Person,
        screen_route = "employees"
    )
    object About : BottomNavigationItem(
        title = "About",
        selectedIcon = Icons.Filled.Info,
        unselectedIcon = Icons.Filled.Info,
        screen_route = "about"
    )
}
