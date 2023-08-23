package com.example.companyappcompose

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.companyappcompose.ui.theme.BebasFont
import com.example.companyappcompose.ui.theme.TBlue

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(){

    val navController = rememberNavController()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Clean Room",
                        fontFamily = BebasFont
                    )
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = TBlue,
                    //titleContentColor = Color.White
                ),
            )
        },
        bottomBar = {
            NavigationBar {
                CustomBottomNavigation(navController = navController)
            }
        }
    ) {
        NavigationGraph(navController = navController)
    }
}