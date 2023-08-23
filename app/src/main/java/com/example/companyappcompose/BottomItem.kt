package com.example.companyappcompose

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentColor
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController

@Composable
fun RowScope.BottomItem(
    screen: BottomNavigationItem,
    currentDestination: NavDestination?,
    navController: NavHostController,
) {
    NavigationBarItem(
        icon = { Icon(imageVector = screen.selectedIcon, contentDescription = screen.title) },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.screen_route
        } == true,
        onClick = {
            navController.navigate(screen.screen_route)
        }
    )
}