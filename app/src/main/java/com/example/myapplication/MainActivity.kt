package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    BoxLayout(
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                    RowLayout(
//                        "World","We are Laos Ninja",
//                        Modifier.padding(innerPadding)
//                    )
//                    ConstraintLayoutTest(
//                        Modifier.padding(innerPadding)
//                    )
                    BackGroudBox(
                        Modifier.padding(innerPadding)
                    )

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "EZ $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
        ColumLayoutText()
    }
}
@Composable
fun ColumLayoutText(modifier: Modifier = Modifier){
    Column(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally){
        Text(
            text = "hello Text1",
            style = TextStyle(background = Color.Yellow),
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            modifier = Modifier.padding(10.dp)
        )
        Text(
            text = "hello Text2",
            style = TextStyle(background = Color.Gray),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier.padding(5.dp)
        )
        Text(
            text = "hello Text3",
            fontWeight = FontWeight.Bold,
            fontSize = 10.sp,
            modifier = Modifier.padding(5.dp)
        )
    }
}

@Composable
fun RowLayout(message1 :String , message2 :String, modifier: Modifier = Modifier){
    Row(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = "hello $message1",
            style = TextStyle(background = Color.Yellow),

            fontSize = 30.sp,
            modifier = Modifier.padding(10.dp)
        )
        Text(
            text = "$message2",
            style = TextStyle(background = Color.Gray),
            fontSize = 20.sp,
            modifier = Modifier.padding(5.dp)
        )
        Image(
            painter = painterResource(R.drawable.hqdefault),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier.size(100.dp)
        )
    }
}
@Composable
fun BoxLayout(modifier: Modifier = Modifier){
    Box(modifier = Modifier
        .background(Color(0.447f, 0.878f, 0.933f, 0.749f))
        .fillMaxSize()){
        Text(
        text = "TopStart",
        fontSize = 10.sp,
        modifier = modifier
            .align(Alignment.TopStart)
            .background(Color.Yellow)
            .padding(5.dp)
    )
        Text(
            text = "TopCenter",
            fontSize = 20.sp,
            modifier = Modifier
                .padding(10.dp)
                .align(Alignment.TopCenter)
                .padding(5.dp)
                .background(Color.Yellow)
        )
        Text(
            text = "TopEnd",
            fontSize = 20.sp,
            modifier = Modifier
                .padding(10.dp)
                .align(Alignment.TopEnd)
                .padding(5.dp)
                .background(Color.Yellow)
        )
        Text(
            text = "CenterStart",
            fontSize = 20.sp,
            modifier = Modifier
                .padding(10.dp)
                .align(Alignment.CenterStart)
                .padding(5.dp)
                .background(Color.Yellow)
        )
        Text(
            text = "Center",
            fontSize = 20.sp,
            modifier = Modifier
                .padding(10.dp)
                .align(Alignment.Center)
                .padding(5.dp)
                .background(Color.Green)
        )
        Text(
            text = "CenterEnd",
            fontSize = 20.sp,
            modifier = Modifier
                .padding(10.dp)
                .align(Alignment.CenterEnd)
                .padding(5.dp)
                .background(Color.Green)
        )
        Text(
            text = "BottomStart",
            fontSize = 20.sp,
            modifier = Modifier
                .padding(10.dp)
                .align(Alignment.BottomStart)
                .padding(5.dp)
                .background(Color.Green)
        )
        Text(
            text = "BottomCenter",
            fontSize = 20.sp,
            modifier = Modifier
                .padding(10.dp)
                .align(Alignment.BottomCenter)
                .padding(5.dp)
                .background(Color.Green)
        )
        Text(
            text = "BottomEnd",
            fontSize = 20.sp,
            modifier = Modifier
                .padding(10.dp)
                .align(Alignment.BottomEnd)
                .padding(5.dp)
                .background(Color.Green)
        )
    }
}

@Composable
fun ConstraintLayoutTest(modifier: Modifier = Modifier){
    ConstraintLayout(modifier =Modifier.fillMaxSize()){
    val (firstText,secondText,ninjaImage) = createRefs()
        Text(
        text = "Hello World",
        style = TextStyle(background = Color.Yellow),
        fontSize = 30.sp,
        modifier = modifier.constrainAs(firstText){
            centerHorizontallyTo(parent)
            }
        )
        Text(
            text = "We are ninja!",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            modifier = modifier.constrainAs(secondText){
                top.linkTo(ninjaImage.bottom)
                centerHorizontallyTo(parent)
            }
        )
        Image(
            painter = painterResource(R.drawable.hqdefault),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(300.dp)
                .border(
                    width = 0.8.dp,
                    color = Color.Magenta,
                    shape = RoundedCornerShape(10.dp)
                )
                .constrainAs(ninjaImage) {
                    top.linkTo(firstText.bottom)
                    centerHorizontallyTo(parent)
                }
        )
}
}

@Composable
fun BackGroudBox(modifier: Modifier = Modifier){
    Box(modifier = modifier.fillMaxSize()
    ){
        Image(
            painter = painterResource(R.drawable.background),
            contentScale = ContentScale.Crop,
            contentDescription = null,
            alpha = 0.3F
        )
    }
    Box(
        modifier.fillMaxSize().wrapContentSize(
            unbounded = true,
            align = Alignment.Center
        ).border(
            width = 1.dp,
            color = Color.Green.copy(alpha = 0.5f),
            shape = RoundedCornerShape(50.dp)
        )
    ){
        Image(
            painter = painterResource(R.drawable.hqdefault),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = modifier.size(400.dp)
        )
        Text(
            text = "Happy Ninja!",
            fontSize = 25.sp,
            color = Color.Magenta,
            modifier = modifier.padding(1.dp).align(Alignment.TopCenter)
        )
        Text(
            text = "Merry Ninmas!",
            fontSize = 25.sp,
            color = Color.Magenta,
            modifier = modifier.padding(1.dp).align(Alignment.BottomCenter)
        )
    }
}
