package com.example.odev5

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MonotonicFrameClock
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(modifier: Modifier = Modifier) {
    val tf = remember { mutableStateOf("") }
    val toplam = remember { mutableStateOf(0f) }
    val isFinished = remember { mutableStateOf(false) }
    val islem = remember { mutableStateOf("") }
    Scaffold (topBar = { CenterAlignedTopAppBar(title = { Text(text ="Calculator") })}) { paddingValues ->

       Column(modifier=Modifier.padding(paddingValues)) {
           Column (modifier = Modifier
               .fillMaxSize()
               .padding(10.dp, 20.dp),
               verticalArrangement = Arrangement.Center) {
               Row(modifier= Modifier.fillMaxWidth(),
                   horizontalArrangement = Arrangement.Center) {
                   TextField(value = tf.value, onValueChange = {tf.value = it })
                   TextButton( onClick = {
                       tf.value = ""
                       toplam.value = 0f

                   }) {
                       Text(text = "X", fontSize = 27.sp)
                   }
               }
               Row(modifier = Modifier
                   .fillMaxWidth()
                   .padding(10.dp),
                   horizontalArrangement = Arrangement.Center) {

                   CustomButton(text = "1", isFinished = isFinished, tf = tf)
                   CustomButton(text = "2", isFinished = isFinished, tf = tf)
                   CustomButton(text = "3", isFinished = isFinished, tf = tf)
                   Button(onClick = {
                       isFinished.value = false
                       tf.value +="+"
                       islem.value= "+"

                   },modifier= Modifier.padding(5.dp)) {
                       Text(text = "+", fontSize = 26.sp)
                   }
               }
               Row(modifier = Modifier
                   .fillMaxWidth()
                   .padding(10.dp),
                   horizontalArrangement = Arrangement.Center) {
                   CustomButton(text = "4", isFinished = isFinished, tf = tf)
                   CustomButton(text = "5", isFinished = isFinished, tf = tf)
                   CustomButton(text = "6", isFinished = isFinished, tf = tf)

                   Button(onClick = {
                       isFinished.value = false
                       tf.value +="-"
                       islem.value = "-"

                   },modifier= Modifier.padding(5.dp)) {
                       Text(text = "-", fontSize = 26.sp)
                   }

               }
               Row(modifier = Modifier
                   .fillMaxWidth()
                   .padding(10.dp),
                   horizontalArrangement = Arrangement.Center) {
                   CustomButton(text = "7", isFinished = isFinished, tf = tf)
                   CustomButton(text = "8", isFinished = isFinished, tf = tf)
                   CustomButton(text = "9", isFinished = isFinished, tf = tf)
                   Button(onClick = {
                       isFinished.value = false
                       tf.value +="/"
                       islem.value="/"

                   },modifier= Modifier.padding(5.dp)) {
                       Text(text = "/", fontSize = 26.sp)
                   }
               }
               Row(modifier = Modifier
                   .fillMaxWidth()
                   .padding(10.dp),
                   horizontalArrangement = Arrangement.Center) {
                   Button(onClick = {
                       isFinished.value = false
                       tf.value +="*"
                       islem.value="*"

                   },modifier= Modifier.padding(5.dp)) {
                       Text(text = "*", fontSize = 28.sp)
                   }
                   CustomButton(text = "0", isFinished = isFinished, tf = tf)

                   Button(onClick = {
                       //val sayi1 = tf.value.split("+")[1]
                    //   toplam.value += sayi1.toInt()
                       //tf.value = toplam.value.toString()
                      // toplam.value= 0
                       isFinished.value=true

                       when(islem.value){
                           "+"-> {
                               val sayi1 = tf.value.split("+")[0].toFloat()
                               val sayi2 = tf.value.split("+")[1].toFloat()

                               toplam.value = toplamaIslemi(sayi1,sayi2)
                               tf.value= toplam.value.toString()
                           }
                           "-" -> {
                               val sayi1 = tf.value.split("-")[0].toFloat()
                               val sayi2 = tf.value.split("-")[1].toFloat()

                               toplam.value = cikarmaIslemi(sayi1,sayi2)
                               tf.value= toplam.value.toString()
                           }
                           "*" -> {
                               val sayi1 = tf.value.split("*")[0].toFloat()
                               val sayi2 = tf.value.split("*")[1].toFloat()

                               toplam.value = carpmaIslemi(sayi1,sayi2)
                               tf.value= toplam.value.toString()
                           }
                           "/" -> {
                               val sayi1 = tf.value.split("/")[0].toFloat()
                               val sayi2 = tf.value.split("/")[1].toFloat()

                               toplam.value = bolmeIslemi(sayi1,sayi2)
                               tf.value= toplam.value.toString()
                           }
                       }

                   },modifier= Modifier.padding(5.dp)) {
                       Text(text = "=", fontSize = 26.sp)
                   }
               }

           }
       }
    }
}
fun cikarmaIslemi(sayi1:Float,sayi2:Float): Float{


    return sayi1-sayi2
}
fun toplamaIslemi(sayi1:Float,sayi2:Float): Float{

    return sayi1+sayi2
}
fun carpmaIslemi(sayi1:Float,sayi2:Float): Float{

    return sayi1*sayi2
}
fun bolmeIslemi(sayi1:Float ,sayi2:Float): Float{

    return sayi1/sayi2
}