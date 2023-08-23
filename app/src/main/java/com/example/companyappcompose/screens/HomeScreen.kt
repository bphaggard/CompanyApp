package com.example.companyappcompose.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.companyappcompose.HomeViewModel
import com.example.companyappcompose.R
import com.example.companyappcompose.ui.theme.BebasFont
import com.example.companyappcompose.ui.theme.TBlue

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {

    val viewModel = viewModel<HomeViewModel>()

            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier.padding(top = 10.dp),
                    text = "TODAY'S DRINKING SERVICE",
                    fontFamily = BebasFont,
                    fontSize = 34.sp
                )
                Button(
                    onClick = { viewModel.randomSelect() },
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
                Box() {
                    Text(
                        text = viewModel.newText,
                        fontSize = 44.sp,
                        fontFamily = BebasFont
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.tescan_logo),
                    contentDescription = "Company Logo",
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(80.dp)
                )
                Text(
                    text = "Pitný režim na pracovišti je zaměstnavatel povinen zajistit prostřednictvím " +
                            "neomezeného přístupu ke kohoutku s pitnou vodou. Nařizuje mu to zákoník práce, " +
                            "který zaměstnavatele zavazuje, že svým zaměstnancům poskytne " +
                            "bezpečné pracovní prostředí.",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(15.dp)
                )
            }
}

@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}