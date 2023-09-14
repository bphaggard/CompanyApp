package com.example.companyappcompose.screens

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Done
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.companyappcompose.EmployeeListViewModel
import com.example.companyappcompose.HomeViewModel
import com.example.companyappcompose.ui.theme.BebasFont
import com.example.companyappcompose.ui.theme.TBlue
import employeedb.EmployeeEntity
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Employees(
    viewModel: EmployeeListViewModel = hiltViewModel()
) {

    val employees = viewModel.employees.collectAsState(initial = emptyList()).value
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current

    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.size(80.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp)
                    .size(400.dp)
            ) {
                Text(
                    text = "TESCAN EMPLOYEES",
                    fontFamily = BebasFont,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .align(CenterHorizontally)
                        .padding(top = 10.dp)
                )
                Spacer(modifier = Modifier.size(10.dp))
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(horizontal = 10.dp)
                ){
                    items(employees){employee ->
                        EmployeeItem(
                            modifier = Modifier.fillMaxWidth(),
                            employee = employee,
                            onDeleteClick = {
                                viewModel.deleteEmployee(employee.id)
                            },
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.size(10.dp))
            Card (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp)
            ){
                Column (
                    horizontalAlignment = CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ){
                    Text(
                        text = "NEW EMPLOYEE",
                        fontFamily = BebasFont,
                        fontSize = 20.sp,
                        modifier = Modifier
                            .padding(top = 10.dp)
                    )
                    Spacer(modifier = Modifier.size(10.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(0.9f),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        OutlinedTextField(
                            value = viewModel.fullNameText,
                            onValueChange = viewModel::onFullNameChange,
                            label = { Text(text = "Employee Full Name") },
                            modifier = Modifier.weight(1f)
                        )
                    }
                    Spacer(modifier = Modifier.size(10.dp))
                    Button(
                        onClick = {
                            if (viewModel.fullNameText.isNotBlank()) {
                                viewModel.newEmployeeAdded()
                            } else {
                                coroutineScope.launch {
                                    // Show a toast message when the text field is empty
                                    Toast.makeText(
                                        context,
                                        "Employee name cannot be empty!",
                                        Toast.LENGTH_LONG
                                    ).show()
                                }
                            }
                        },
                        colors = ButtonDefaults.buttonColors(TBlue),
                        elevation = ButtonDefaults.buttonElevation(
                            defaultElevation = 4.dp,
                            pressedElevation = 6.dp,
                            disabledElevation = 0.dp
                        ),
                    ) {
                        Text(
                            text = "Add New Employee"
                        )
                    }
                    Spacer(modifier = Modifier.size(10.dp))
                }
            }
            Spacer(modifier = Modifier.size(95.dp))
        }
    }
}

@Composable
fun EmployeeItem(
    employee: EmployeeEntity,
    onDeleteClick: () -> Unit = {},
    modifier: Modifier = Modifier
){
    Row (
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(
            text = employee.fullName,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )
        IconButton(onClick = onDeleteClick) {
            Icon(
                imageVector = Icons.Outlined.Delete,
                contentDescription = "Delete employee",
                tint = Color.Red)
        }
    }
}

@Preview
@Composable
fun PreviewStaff(){
    Employees()
}