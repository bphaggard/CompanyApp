package com.example.companyappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.companyappcompose.screens.HomeScreen
import com.example.companyappcompose.ui.theme.CompanyAppComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CompanyAppComposeTheme {
                // A surface container using the 'background' color from the theme
                HomeScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainPreview() {
    HomeScreen()
}