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
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.icu.util.Calendar
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.clickable

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.PreviewActivity
import androidx.core.content.ContextCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import kotlinx.coroutines.selects.select
import kotlin.math.exp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
//                Surface(modifier = Modifier.fillMaxSize(),
//                    color =MaterialTheme.colorScheme.background
//                ) {
//                    ComposeAllNavigation()
//                }
                MyScaffoldLayout()

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
    }
}



sealed class ScreenRoute(val route:String){
    data object First : ScreenRoute("first_screen")
    data object Second : ScreenRoute("second_screen")
}

@Composable
fun ComposeAllNavigation(){
    val navController  = rememberNavController()
    Column(modifier = Modifier.fillMaxSize().
    border(width = 1.dp,
        color = Color.Black,
        shape = RoundedCornerShape(20.dp)
    ),
        horizontalAlignment =  Alignment.CenterHorizontally,)
    {
        NavHost(navController = navController,startDestination = ScreenRoute.First.route){
            composable(ScreenRoute.First.route) {
                MyPage1(navController)
            }
            composable(ScreenRoute.Second.route) {
                MyPage2(navController)
            }
        }
    }
}

@Composable
fun IdNameAgeContent(id: String, onIDChange: (String) -> Unit,
                     age: String,onAgeChange : (String) -> Unit,
                     name : String,onNameChange : (String) -> Unit)
{
    Column(modifier = Modifier.padding(horizontal = 5.dp,)){
        OutlinedTextField(modifier = Modifier.width(400.dp)
            .padding(bottom = 16.dp),
            value = id,
            onValueChange = onIDChange,
            label ={Text("Student ID")})
        OutlinedTextField(
            modifier = Modifier.width(400.dp).padding(bottom = 16.dp),
            value = name,
            onValueChange = onNameChange,
            label = {Text("Name")},
        )
        OutlinedTextField(
            modifier = Modifier.width(400.dp).padding(bottom = 16.dp),
            value = age,
            onValueChange = onAgeChange,
            label = {Text("Age")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
    }
}

@Composable
fun CheckboxGroup(
    items: List<String>,
    onSelectionChange: (List<String>) -> Unit
) {
    var selectedItems = remember { mutableStateListOf<String>() }

    Row {
        items.forEach { item ->
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = selectedItems.contains(item),  // Check if current item is selected
                    onCheckedChange = { checked ->
                        if (checked) {
                            selectedItems.add(item)
                        } else {
                            selectedItems.remove(item)
                        }
                        onSelectionChange(selectedItems.toList())
                    }
                )
                Text(
                    text = item,
                    fontSize = 15.sp
                )
            }
        }
    }
}


@Composable
fun MyPage1(navHostController: NavHostController) {
    var id by rememberSaveable { mutableStateOf("") }
    var age by rememberSaveable { mutableStateOf("") }
    var name by rememberSaveable { mutableStateOf("") }

    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 16.dp, vertical = 5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Spacer(modifier = Modifier.height(height = 20.dp))
        Text(
            modifier = Modifier.background(
                color = Color.LightGray,
                shape = RoundedCornerShape(20.dp)
            )
                .padding(16.dp),
            text = "Page 1",
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
        )
        Text(
            modifier = Modifier.padding(5.dp),
            text = "Enter Student Information",
            fontSize = 20.sp
        )

        IdNameAgeContent(id = id, onIDChange = { id = it },
            age = age, onAgeChange = { age = it },
            name = name, onNameChange = {name = it})

        val hobbyList = listOf("Reading", "Painting", "Cooking")
        var selectedOut by remember { mutableStateOf("") }
        val selectedItems by remember { mutableStateOf(mutableStateListOf<String>()) }
        Text(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 5.dp),
            text = "Select your hobby:"
        )
        Row {
            CheckboxGroup(items = hobbyList) { newSelectedItems ->
                selectedItems.clear()
                selectedItems.addAll(newSelectedItems)
                selectedOut = selectedItems.toString()
            }
        }
        Spacer(modifier = Modifier.height(height = 8.dp))

        Spacer(modifier = Modifier.height(height = 8.dp))
        Button(
            onClick = {
                navHostController.currentBackStackEntry?.savedStateHandle?.set(
                    "data",
                    Student(id, name, age.toInt(), selectedItems)
                )
                navHostController.navigate(ScreenRoute.Second.route)
            }
        ) {
            Text(text = "Send Information")
        }
        Button(onClick =  {
            val packageName = "com.google.android.youtube"
            startActivitySafe(context,packageName = packageName)
        }
        ){
            Text(text= "Open Youtube")
        }
        Button(onClick =  {
            val packageName = "com.ss.android.ugc.trill"
            startActivitySafe(context,packageName = packageName)
        }
        ){
            Text(text= "Open Tiktok")
        }
    }
}

fun startActivitySafe(context: Context?, packageName : String){
    if(context == null || packageName == null){
        Log.e("startActivitySafe","Context or intent is null!")
        return
    }
    try{
        val intent = Intent(Intent.ACTION_MAIN)
        intent.`package`=packageName
        context.startActivity(intent)
    }catch (e:Exception){
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse("https://play.google.com/store/apps/details?id=$packageName")
        ContextCompat.startActivity(context, i,null)
        Log.e("startActivitySafe","Error")
    }
}

@Composable
fun MyPage2(navHostController: NavHostController){
    val data = navHostController.previousBackStackEntry?.savedStateHandle?.get<Student>("data")
    Student("","",0, listOf())
    val lastIndex = data?.hobby?.size?.minus(1) ?: -1
    var hobbySelect = ""

    if (data != null) {
        data.hobby.forEachIndexed{index,item ->
            hobbySelect += if (index == lastIndex) item else "$item,"

        }
        IconButton(modifier = Modifier.size(100.dp),
            onClick = {
                navHostController.navigateUp()}
        ){
            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "",
                tint = Color.Magenta)
        }
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            horizontalAlignment = Alignment.Start){
            Spacer(modifier = Modifier.height(height = 20.dp))
            Text(
                modifier = Modifier.background(
                    color = Color.LightGray,
                    shape = RoundedCornerShape(20.dp)
                )
                    .padding(16.dp)
                    .align(Alignment.CenterHorizontally),
                text = "Page 2",
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp
            )

            Text(
                modifier = Modifier.padding(16.dp),
                text = "Student ID : ${data.id}" +
                        "\n\nStudent Name : ${data.name}" +
                "\n\nStudent Age :  ${data.age} \n\nHobby: $hobbySelect\n",
                fontSize = 20.sp
            )

            Button(modifier = Modifier.align(Alignment.CenterHorizontally),
                onClick = {
                    navHostController.navigate(ScreenRoute.First.route)
                }) {
                Text(text = "Go to Page1")
            }
        }
    }
}

private fun prepareNavigationDrawerItems():List<NavigationDrawerData>{
    val drawerItemsList = arrayListOf<NavigationDrawerData>()

    drawerItemsList.add(NavigationDrawerData(label = "Home",icon = Icons.Filled.Home))
    drawerItemsList.add(NavigationDrawerData(label = "Profile",icon = Icons.Filled.Person))
    drawerItemsList.add(NavigationDrawerData(label = "Favorite",icon = Icons.Filled.Favorite))
    return drawerItemsList
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(contextForToast: Context) {
    var expanded by remember { mutableStateOf(false) }
    val contextForToast = LocalContext.current.applicationContext
    Column(modifier = Modifier.fillMaxSize()) {
        CenterAlignedTopAppBar(
            title = {
                Text(text = "My Application", color = Color.DarkGray)
            },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = Color.Green.copy(alpha = 0.1f)
            ),
            actions = {
                IconButton(
                    onClick = {
                        Toast.makeText(contextForToast,"Notification",Toast.LENGTH_SHORT).show()
                    }){
                    Icon(Icons.Default.Notifications, contentDescription = null)
                }
                IconButton(
                    onClick = { expanded = true }
                ) {
                    Icon(Icons.Default.MoreVert, contentDescription = "Open Menu")
                }
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    DropdownMenuItem(
                        text = { Text("Setting") },
                        onClick = {
                            Toast.makeText(
                                contextForToast, "Setting",
                                Toast.LENGTH_SHORT
                            ).show()
                            expanded = false
                        },
                        leadingIcon = {
                            Icon(
                                Icons.Outlined.Settings, contentDescription = null
                            )
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Logout") },
                        onClick = {
                            Toast.makeText(contextForToast, "Logout", Toast.LENGTH_SHORT).show()
                            expanded = false
                        },
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.logout),
                                contentDescription = null,
                                modifier = Modifier.size(23.dp)
                            )
                        }
                    )
                }
            }
        )
    }
}





@Composable
fun MyBottomBar(navController: NavHostController,contextForToast: Context) {
    val navigationItem = listOf(
        Screen.Home,
        Screen.Profile,
        Screen.Favorite
    )
    var selectedScreen by remember { mutableStateOf(0) }
    NavigationBar(containerColor = Color.Green.copy(alpha = 0.1f)) {
        navigationItem.forEachIndexed { index, screen ->
            NavigationBarItem(
                icon = { Icon(imageVector = screen.icon, contentDescription = null) },
                label = { Text(text = screen.name) },
                selected = (selectedScreen == index),
                onClick = {
                    selectedScreen = index
                    navController.navigate(screen.route)
                    Toast.makeText(contextForToast, screen.name, Toast.LENGTH_SHORT).show()
                }
            )
        }
    }
}


@Composable
fun MyScaffoldLayout(){
    val contextForToast = LocalContext.current.applicationContext
    val navController = rememberNavController()
    Scaffold (
        topBar = { MyTopAppBar(contextForToast) },
        bottomBar = { MyBottomBar(navController,contextForToast) },
    ){paddingValues ->

        Column(
            modifier = Modifier.padding(paddingValues = paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
        )
        {}
        NavGraph(navController = navController)
    }
}



