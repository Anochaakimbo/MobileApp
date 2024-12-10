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
                    ConstraintLayoutTest(
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
            modifier = Modifier.padding(1.dp)
        )
        Text(
            text = "hello Text3",
            fontWeight = FontWeight.Bold,
            fontSize = 10.sp,
            modifier = Modifier.padding(1.dp)
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
//663380193-6
@Composable
fun ConstraintLayoutTest(modifier: Modifier = Modifier){
    ConstraintLayout(modifier =Modifier.fillMaxSize()){
    val (firstText,secondText,ninjaImage,arnoldImage,arnoldText) = createRefs()
        Image(
            painter = painterResource(R.drawable._407cd7d9b10d751ebdbdd869e5a03dd),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            alpha = 0.3F,
            modifier = Modifier.size(800.dp)
        )
        Text(
        text = "Happy Birthday",
        fontSize = 30.sp,
        color = Color.Black,
        modifier = modifier.constrainAs(firstText){
            centerHorizontallyTo(parent)
            }
        )
        Text(
            text = "TAFLEX!",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = modifier.constrainAs(secondText){
                top.linkTo(ninjaImage.bottom)
                centerHorizontallyTo(parent)
            }
        )
        Image(
            painter = painterResource(R.drawable._62574481_3837605453156079_7435578897054395141_n),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(300.dp)
                .border(
                    width = 0.8.dp,
                    color = Color.Black,
                    shape = RoundedCornerShape(10.dp)
                )
                .constrainAs(ninjaImage) {
                    top.linkTo(firstText.bottom)
                    centerHorizontallyTo(parent)
                }
        )
        Image(
            painter = painterResource(R.drawable._62578313_549867857846624_6671650043103883452_n),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = modifier.constrainAs(arnoldImage){
                top.linkTo(secondText.bottom)
                start.linkTo(secondText.end)
            }.size(120.dp)
        )
        Text(
            text = "From Arnold",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = modifier.constrainAs(arnoldText){
                top.linkTo(arnoldImage.top)
                start.linkTo(arnoldImage.start)
            }
        )

}
}
//663380193-6
@Composable
fun HappyBirthday(modifier: Modifier = Modifier){
    Box(modifier = modifier.fillMaxSize())
    {
        Image(
            painter = painterResource(R.drawable._407cd7d9b10d751ebdbdd869e5a03dd),
            contentScale = ContentScale.Crop,
            contentDescription = null,
            alpha = 0.3F,
            modifier = modifier.size(3000.dp)
        )

    }
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .size(100.dp)
        ) {
            Image(
                painter = painterResource(R.drawable._62578313_549867857846624_6671650043103883452_n),
                contentScale = ContentScale.Fit,
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
            Text(
                text = "FROM ARNOLD",
                fontSize =10.sp,
                color = Color.Black,
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = 5.dp).padding(horizontal = 2.dp)
            )
        }
    }

    Box(
        modifier.fillMaxSize().wrapContentSize(
            unbounded = true,
            align = Alignment.Center
        ).border(
            width = 5.dp,
            color = Color.Green.copy(alpha = 0.5f),
            shape = RoundedCornerShape(50.dp)
        )
    )
    {
        Image(
            painter = painterResource(R.drawable._62574481_3837605453156079_7435578897054395141_n),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = modifier.size(300.dp).align(Alignment.Center)
        )
        Text(
            text = "Happy Birthday!",
            fontSize = 55.sp,
            color = Color.Black,
            modifier = modifier.padding(5.dp).align(Alignment.TopCenter)
        )
        Text(
            text = "TAFLEX NO1 VALORANT!",
            fontSize = 25.sp,
            color = Color.Black,
            modifier = modifier.padding(5.dp).align(Alignment.BottomCenter)
        )
    }
}
