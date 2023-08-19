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
fun AboutCompany(){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(TBlue),
        contentAlignment = Alignment.Center){
        Text(text = "About Company", fontSize = 30.sp)
    }
}

@Preview
@Composable
fun PreviewCompany(){
    AboutCompany()
}