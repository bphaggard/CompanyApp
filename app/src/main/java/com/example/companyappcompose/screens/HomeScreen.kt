package com.example.companyappcompose.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.companyappcompose.HomeViewModel
import com.example.companyappcompose.R
import com.example.companyappcompose.ui.theme.BebasFont
import com.example.companyappcompose.ui.theme.TBlue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(){
    data class BottomNavigationItem(
        val route: String,
        val title: String,
        val selectedIcon: ImageVector,
        val unselectedIcon: ImageVector
    )

    //val context = LocalContext.current // for Toast
    val navController = rememberNavController()
    val viewModel = viewModel<HomeViewModel>()

    NavHost(
        navController = navController,
        startDestination = "home"
    ){
        composable("home"){
            HomeScreen()
        }
        composable("employees"){
            Employees()
        }
        composable("about"){
            AboutCompany()
        }
    }
    val items = listOf(
        BottomNavigationItem(
            route = "home",
            title = "Home",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home
        ),
        BottomNavigationItem(
            route = "employees",
            title = "Employees",
            selectedIcon = Icons.Filled.Person,
            unselectedIcon = Icons.Outlined.Person
        ),
        BottomNavigationItem(
            route = "about",
            title = "About",
            selectedIcon = Icons.Filled.Info,
            unselectedIcon = Icons.Outlined.Info
        )
    )

    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Clean Room",
                        fontFamily = BebasFont)
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = TBlue,
                    //titleContentColor = Color.White
                ),
            )
        }, content = {
            //var newText by remember { mutableStateOf("") }

            Column(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
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
                        disabledElevation = 0.dp),
                )
                {
                    Text(
                        text = "CHOOSE PERSON")
                }
                Box(){
                    Text(
                        text = viewModel.newText,
                        fontSize = 44.sp,
                        fontFamily = BebasFont)
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
                    modifier = Modifier.padding(horizontal = 10.dp)
                )
            }
        },
        bottomBar = {
            NavigationBar (
                //containerColor = Blue
            ){
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = selectedItemIndex == index,
                        onClick = {
                            selectedItemIndex = index
                            navController.navigate(item.route)
                        },
                        label = {
                            Text(text = item.title)
                        },
                        icon = {
                            Icon(
                                imageVector = if (index == selectedItemIndex){
                                    item.selectedIcon
                                } else item.unselectedIcon,
                                contentDescription = item.title)
                        }
                    )
                }
            }
        }
    )
}

@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}