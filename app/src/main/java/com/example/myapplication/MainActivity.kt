package com.example.myapplication

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Toast
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
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
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
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import android.app.TimePickerDialog
import android.icu.text.SimpleDateFormat
import android.icu.text.UnicodeSet.SpanCondition
import android.icu.util.Calendar
import android.widget.DatePicker
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.intl.Locale
import java.util.Date
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                        MyScreen(
                            modifier = Modifier.padding(innerPadding)
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

//663380193-6
@Composable
fun MyScreen (modifier: Modifier = Modifier) {

    val contextForToast = LocalContext.current.applicationContext
    var textInformation by rememberSaveable { mutableStateOf("") }

    var username by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var selectedDate by remember { mutableStateOf("DD-MM-YYYY") }
    Column(
        modifier = modifier.verticalScroll(rememberScrollState()).fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,

    ){
        Text(modifier = modifier.padding(10.dp),
            text = "Register Form",
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp
        )
        IdNameContent(username = username, onIDChange = {username=it},
            password = password, onNameChange = {password=it})


        gender = RadioGroupUsage()


        EmailContent (email = email, onEmailChange = {email = it})

        selectedDate = DateContent()


        Spacer(modifier = modifier.height(height = 10.dp))

        Button(
            onClick = {
                Toast.makeText(contextForToast,"This $username - $password - $gender - $email",
                    Toast.LENGTH_LONG).show()
                textInformation ="Register Information :"
                textInformation = "Username: $username\n"+"password: $password\n"+
                        "Gender : $gender\n"+"Credit : $email\n"+
                        "Birthday : $selectedDate"
            }
        ) {
            Text(text = "Register")
        }
        Column(modifier = modifier.width(400.dp).padding(16.dp)
            .wrapContentHeight(unbounded = true)
            .border(
                width = 1.dp,
                color = Color.Black,
                shape = RoundedCornerShape(20.dp)
            )
        )
        {
            Text(
                modifier = modifier.padding(10.dp),
                text = "Register Information: ",
                fontSize = 20.sp
            )
            Text(
                modifier = modifier.padding(5.dp),
                text = textInformation,
                fontSize = 18.sp
            )
        }
    }

}

@Composable
fun MyTest(modifier: Modifier = Modifier){
    val contextForToast = LocalContext.current.applicationContext
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {
                Toast.makeText(
                    contextForToast,
                    "TEST",
                    Toast.LENGTH_LONG
                ).show()
            }
        ){
            Text(text = "Show Toast")
        }
    }
    }

@Composable
fun MyButton(modifier: Modifier = Modifier){
    val contextForToast = LocalContext.current.applicationContext
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(
            space = 16.dp,
            alignment = Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Button(
            onClick = {
                Toast.makeText(contextForToast, "Button", Toast.LENGTH_SHORT).show()
            }
        ) {
            Text(text = "Button", fontSize = 25.sp)
        }

        ElevatedButton(
            onClick = {
                Toast.makeText(contextForToast, "ElevatedButton", Toast.LENGTH_SHORT).show()
            }
        ) {
            Text(text = "ElevatedButton", fontSize = 25.sp)
        }

        FilledTonalButton(
            onClick = {
                Toast.makeText(contextForToast, "FilledTonalButton", Toast.LENGTH_SHORT).show()
            }
        ) {
            Text(text = "FilledTonalButton", fontSize = 25.sp)
        }

        OutlinedButton(
            onClick = {
                Toast.makeText(contextForToast, "OutlinedButton", Toast.LENGTH_SHORT).show()
            }
        ) {
            Text(text = "OutlinedButton", fontSize = 25.sp)
        }

        TextButton(
            onClick = {
                Toast.makeText(contextForToast, "TextButton", Toast.LENGTH_SHORT).show()
            }
        ) {
            Text(text = "TextButton", fontSize = 25.sp)
        }
    }
}

@Composable
fun MyTextField(modifier: Modifier = Modifier){
    var value by remember { mutableStateOf("") }
    Column (
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        TextField(
            value = value,
            onValueChange = {newText ->
                value = newText
            },
            label = {Text(text = "Name")}
        )
        Text(text = "input Text: $value")
    }
}

@Composable
fun IdNameContent(username : String,onIDChange : (String) ->Unit,
                  password : String , onNameChange : (String) -> Unit){
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        OutlinedTextField(
            modifier = Modifier.width(400.dp),
            value = username,
            onValueChange = onIDChange,
            label = {Text("Username") },
        )
        OutlinedTextField(
            modifier = Modifier.width(400.dp),
            value = password,
            onValueChange = onNameChange,
            label = {Text("Password")},
            visualTransformation = PasswordVisualTransformation()
        )
    }
}

@Composable
fun EmailContent(email : String,onEmailChange : (String) ->Unit){
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        OutlinedTextField(
            modifier = Modifier.width(400.dp),
            value = email,
            onValueChange = onEmailChange,
            label = {Text("Email") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            )
        )


    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SubjectDropdown(): String {
    val keyboardController = LocalSoftwareKeyboardController.current
    val subjectList = listOf(
        "Select Subject",
        "SC362907 Mobile Device Programming",
        "SC362904 Web Application Programming",
        "SC362905 Database Analysis and Design"
    )
    var expanded by remember { mutableStateOf(false) }
    var selectSubject by remember { mutableStateOf(subjectList[0]) }

    ExposedDropdownMenuBox(modifier = Modifier.clickable { keyboardController?.hide() },
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        })
    {
        OutlinedTextField(
            modifier = Modifier.width(340.dp).menuAnchor().clickable { keyboardController?.hide() },
            readOnly = true,
            value = selectSubject,
            onValueChange = {},
            label = { Text("Subjects") },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            colors = ExposedDropdownMenuDefaults.textFieldColors(),
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            }
        )
        {
            subjectList.forEach{selectionOption->
                DropdownMenuItem(
                    text = {Text(selectionOption)},
                    onClick = {
                        selectSubject = selectionOption
                        expanded = false
                    },
                    contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
                )
            }
        }
    }
    return selectSubject
}
@Composable
fun TimeContent():Pair<String,String>{
    val mContext = LocalContext.current

    val mCalendar = Calendar.getInstance()
    val mHour = mCalendar[Calendar.HOUR_OF_DAY]
    val mMinute = mCalendar[Calendar.MINUTE]

    var selectedHour by remember { mutableStateOf("00") }
    var selectedMinute by remember { mutableStateOf("00") }

    val mTime = remember { mutableStateOf("") }

    val mTimePickerDialog = TimePickerDialog(
        mContext,3,
        {_,mHour : Int , mMinute : Int ->
            mTime.value = "$mHour:$mMinute"
        selectedHour = if(mHour <10) "0${mHour}" else "$mHour"
        selectedMinute = if(mMinute<10)"0${mMinute} " else "$mMinute"}
            ,mHour,mMinute,true
    )

    Row(modifier = Modifier.fillMaxWidth().padding(start = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        )
    {
        Spacer(modifier =Modifier.height(height = 50.dp))

        FilledIconButton(onClick = {mTimePickerDialog.show() },){
            Icon(modifier = Modifier.size(30.dp),
                imageVector = Icons.Outlined.DateRange,
                contentDescription = "Time Icon")
        }
        Text(text = "Selected Time (HH:MM) = $selectedHour:$selectedMinute")
    }
    return Pair(selectedHour,selectedMinute)
}



@Composable
fun DateContent(): String {
    val mContext = LocalContext.current
    val mCalendar = Calendar.getInstance()
    val mYear = mCalendar[Calendar.YEAR]
    val mMonth = mCalendar[Calendar.MONTH]
    val mDay = mCalendar[Calendar.DAY_OF_MONTH]
    var selectedDate by remember { mutableStateOf("DD-MM-YYYY") }

    val mDatePickerDialog = DatePickerDialog(
        mContext,
        { _, year, month, day ->
            selectedDate = "$day-${getMonthName(month + 1)}-$year"
        },
        mYear,
        mMonth,
        mDay
    )

    Row(modifier = Modifier.fillMaxWidth().padding(start = 10.dp),
        verticalAlignment = Alignment.CenterVertically) {
        Text(text = "Birthday")
        FilledIconButton(onClick = { mDatePickerDialog.show() }) {
            Icon(Icons.Outlined.DateRange, contentDescription = "Date Icon")
        }
        Text(text = selectedDate)
    }
    return selectedDate
}

fun getMonthName(month: Int): String {
    return when (month) {
        1 -> "Jan"
        2 -> "Feb"
        3 -> "Mar"
        4 -> "Apr"
        5 -> "May"
        6 -> "Jun"
        7 -> "Jul"
        8 -> "Aug"
        9 -> "Sep"
        10 -> "Oct"
        11 -> "Nov"
        12 -> "Dec"
        else -> ""
    }
}




@Composable
fun MyRadioGroup(
    mItems: List<String>,
    selected: String,
    setSelected: (selected: String) -> Unit,
) {
    Row() {
        mItems.forEach { item ->
            Row(
                modifier = Modifier.padding(horizontal = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = selected == item,
                    onClick = {
                        setSelected(item)
                    },
                    enabled = true,
                    colors = RadioButtonDefaults.colors(
                        selectedColor = Color.Magenta
                    )
                )
                Text(
                    text = item,
                    modifier = Modifier.padding(start = 1.dp)
                )
            }
        }
    }
}

@Composable
fun RadioGroupUsage():String {
    val kinds = listOf("Male", "Female", "Other")
    val (selected, setSelected) = remember { mutableStateOf("") }

    Column() {
        Spacer(modifier = Modifier.height(height = 30.dp))
        Text(
            text = "Gender : $selected",
            modifier = Modifier
                .padding(start = 10.dp),
        )

        MyRadioGroup(
            mItems = kinds,
            selected = selected,
            setSelected = setSelected
        )
    }
    return selected
}





