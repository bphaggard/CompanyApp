package com.example.companyappcompose.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.companyappcompose.EmployeeListViewModel
import com.example.companyappcompose.R
import com.example.companyappcompose.ui.theme.BebasFont
import com.example.companyappcompose.ui.theme.TBlue
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "SuspiciousIndentation")
@Composable
fun HomeScreen(
    viewModel: EmployeeListViewModel = hiltViewModel()
) {
    val coroutineScope = rememberCoroutineScope()

    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.size(80.dp))
            Text(
                modifier = Modifier.padding(top = 10.dp),
                text = "TODAY'S DRINKING SERVICE",
                fontFamily = BebasFont,
                fontSize = 34.sp
            )
            Spacer(modifier = Modifier.size(20.dp))
            Button(
                onClick = { coroutineScope.launch { viewModel.selectRandomEmployee() } },
                colors = ButtonDefaults.buttonColors(TBlue),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 4.dp,
                    pressedElevation = 6.dp,
                    disabledElevation = 0.dp
                ),
            )
            {
                Text(
                    text = "CHOOSE PERSON"
                )
            }
            Spacer(modifier = Modifier.size(10.dp))
            Box() {
                Text(
                    text = viewModel.randomFullName,
                    fontSize = 44.sp,
                    fontFamily = BebasFont
                )
            }
            Spacer(modifier = Modifier.size(10.dp))
            Image(
                painter = painterResource(id = R.drawable.tescan_logo),
                contentDescription = "Company Logo",
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .fillMaxHeight(0.15f)
                //.size(80.dp)
            )
            Spacer(modifier = Modifier.size(10.dp))
            Text(
                text = "Pitný režim na pracovišti je zaměstnavatel povinen zajistit prostřednictvím " +
                        "neomezeného přístupu ke kohoutku s pitnou vodou. Nařizuje mu to zákoník práce, " +
                        "který zaměstnavatele zavazuje, že svým zaměstnancům poskytne " +
                        "bezpečné pracovní prostředí.",
                textAlign = TextAlign.Center,
                fontSize = 14.sp,
                modifier = Modifier.padding(15.dp)
            )
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}