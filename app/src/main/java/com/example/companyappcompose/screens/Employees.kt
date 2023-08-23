package com.example.companyappcompose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.companyappcompose.ui.theme.TBlue

@Composable
fun Employees(){
    Box (modifier = Modifier
        .fillMaxSize(),
        contentAlignment = Alignment.Center) {
        Text(text = "List of all employees", fontSize = 30.sp)
    }
}

@Preview
@Composable
fun PreviewStaff(){
    Employees()
}