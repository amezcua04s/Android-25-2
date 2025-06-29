package com.example.micomposable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.FlowPreview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Text("Goku")
        }
    }
}

@Composable
fun MessageCard(name: String){
    Text(text = "Hello $name!")
}

@Preview
@Composable
fun PreviewMessageCard(){
    MessageCard("Android")
}