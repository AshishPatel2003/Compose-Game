package com.example.composegame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composegame.ui.theme.ComposeGameTheme

// Made by Ashish Kumar Patel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeGameTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    GameWindow()
                }
            }
        }
    }
}

@Composable
fun GameWindow() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(id = R.drawable.rock_scissor), contentDescription = null)
        Text(text = "Score", fontSize = 30.sp, modifier = Modifier.absolutePadding(top = 10.dp))
        Text(text = "0 / 4", fontSize = 50.sp, fontWeight = FontWeight.SemiBold)
    }

    Column(modifier = Modifier.fillMaxHeight(0.4f),verticalArrangement = Arrangement.Center) {
        Spacer(modifier = Modifier.height(100.dp))
        Row(horizontalArrangement = Arrangement.Center) {
            Choose(title = "You Choose", result = "Rock", Modifier.fillMaxWidth(0.5f))
            Choose(title = "Android Choose", result = "Paper", Modifier.fillMaxWidth())
        }
    }

    Column(verticalArrangement = Arrangement.Bottom,modifier = Modifier.fillMaxHeight(0.6f)
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
        ){
            Buttons(text = "Rock")
            Buttons(text = "Paper")
            Buttons(text = "Scissors")

        }
        Text(text = "#Jetpack Compose", fontSize = 20.sp, fontFamily = FontFamily.SansSerif, modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp, 16.dp), textAlign = TextAlign.Center)
    }
}


@Composable
fun Choose(title: String, result: String, modifier: Modifier, ){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
    ) {
        Text(text = title, fontSize = 16.sp)
        Text(text = result, fontSize = 32.sp, fontWeight = FontWeight.SemiBold)
    }
}

@Composable
fun Buttons(text : String){
    Button(modifier = Modifier
        .height(140.dp)
        .width(140.dp)
        .fillMaxWidth(0.33f)
        .padding(14.dp, 14.dp),
        shape = RoundedCornerShape(20.dp)
        , onClick = {}) {
        Text(text = text)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeGameTheme {
        GameWindow()
    }
}