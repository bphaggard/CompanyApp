package com.example.companyappcompose.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.companyappcompose.R
import com.example.companyappcompose.ui.theme.BebasFont

@Composable
fun AboutCompany(){
    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally){
        Spacer(modifier = Modifier.size(80.dp))
        Text(
            text = "TESCAN GROUP, a.s.",
            fontFamily = BebasFont,
            fontSize = 30.sp)
        Spacer(modifier = Modifier.size(10.dp))
        Card (modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp)
        ){
            Text(
                text = "ABOUT TESCAN",
                fontFamily = BebasFont,
                fontSize = 20.sp,
                modifier = Modifier.padding(10.dp))
            Text(
                text = "TESCAN enables nanoscale investigation and analysis within the geosciences, materials science, life sciences and semiconductor industries. \n\n" +
                        "The company has a 30-year history of developing innovative electron microscopy, micro-computed tomography, and related software solutions for customers in research and industry worldwide. For example, " +
                        "TESCAN’s TENSOR is the first 4D-scanning transmission electron microscope (4D-STEM) built from the ground up for a totally new level of performance and user experience.\n\n" +
                        "As a result, TESCAN has earned a leading position in micro- and nanotechnology. \n\n" +
                        "TESCAN headquartered in Brno, Czech Republic, employs more than 750 people in 14 sites around the world.",
                modifier = Modifier.padding(10.dp))
        }
        Spacer(modifier = Modifier.size(15.dp))
        Card (modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp)
        ){
            Text(
                text = "HEADQUARTERS",
                fontFamily = BebasFont,
                fontSize = 20.sp,
                modifier = Modifier.padding(10.dp))
            Text(
                text = "Research & Development",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 10.dp))
            Text(
                text = "TESCAN strives to keep improving continuously their products, which creates a competitive advantage for its customers. " +
                        "The TESCAN brand is becoming established thanks to the company’s participation in top research projects and cooperation with the leading companies in the field of electron microscopy and microanalysis. " +
                        "As a result, TESCAN’s instrumentation and innovative solutions have won a leading position in the world of nano- and microtechnology.",
                modifier = Modifier.padding(10.dp))
            Text(
                text = "Manufacturing philosophy",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 10.dp))
            Text(
                text = "We recognize that the highest quality and reliability of our products is the foundation of our business. The advanced information system for resources and company processes optimization, " +
                        "the top level of our technology equipment and quality management system constitute the real preconditions for meeting customer expectations about quality, price and delivery.",
                modifier = Modifier.padding(10.dp))
        }
        Spacer(modifier = Modifier.size(15.dp))
        Card (modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp)
        ){
            Text(
                text = "World wide availability of our products and services",
                fontFamily = BebasFont,
                fontSize = 20.sp,
                modifier = Modifier.padding(10.dp))
            Text(
                text = "Sales & Service",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 10.dp))
            Text(
                text = "More than 3000 SEM installations in more than 80 countries prove the highest technical solution of TESCAN products.\n\n" +
                        "TESCAN sales and service network covers countries all over the world. " +
                        "The team of sales representatives and well-trained service staff is capable to assure fast service and customer support as well as detailed product information.\n",
                modifier = Modifier.padding(5.dp))
            Image(
                painter = painterResource(id = R.drawable.tescan_world),
                contentDescription = "World image",
                modifier = Modifier
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.size(15.dp))
        }
        Spacer(modifier = Modifier.size(15.dp))
        Card (modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp)
        ){
            Text(
                text = "IMPORTANT CONTACTS",
                fontFamily = BebasFont,
                fontSize = 20.sp,
                modifier = Modifier.padding(10.dp))
            Text(
                text = "TESCAN GROUP a.s.",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 10.dp))
            Text(
                text = "Libušina tř. 21 \n" +
                        "623 00 Brno - Kohoutovice \n" +
                        "Czech Republic\n" +
                        "+420 530 353 411\n" +
                        "info@tescan.com\n" +
                        "https://www.tescan.com\n",
                modifier = Modifier.padding(10.dp))
            Text(
                text = "Sales department",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 10.dp))
            Text(
                text = "+420 530 353 411\n" +
                        "sales@tescan.com\n",
                modifier = Modifier.padding(10.dp))
            Text(
                text = "Marketing department",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 10.dp))
            Text(
                text = "+420 530 353 478\n" +
                        "marketing@tescan.com\n",
                modifier = Modifier.padding(10.dp))
            Text(
                text = "Service and support",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 10.dp))
            Text(
                text = "+420 530 353 353\n" +
                        "support@tescan.com",
                modifier = Modifier.padding(10.dp))
        }
        Spacer(modifier = Modifier.size(80.dp))
    }
}

@Preview
@Composable
fun PreviewCompany(){
    AboutCompany()
}