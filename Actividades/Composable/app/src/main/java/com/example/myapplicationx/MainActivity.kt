package com.example.myapplicationx

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MessageCard("Android")
        }
    }
}

@Composable
fun MessageCard(name: String) {

    Column {
        Row {
            Text(text = "Hello $name!")
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Goodbye $name!")
        }

        Row {
            Text(text = "Hello $name!")
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Goodbye $name!")
        }

        Row(modifier = Modifier.width(IntrinsicSize.Max)) {
            Image(
                painter = painterResource(R.drawable.ic_launcher_background),
                contentDescription = "Contact profile picture"
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Android Studio: $name")

    }
}

@Preview
@Composable
fun PreviewMessageCard() {
    MessageCard("Android")
}

