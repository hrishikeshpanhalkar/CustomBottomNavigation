package com.example.custombottomnavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.tooling.preview.Preview
import com.example.custombottomnavigation.ui.customStuff.CustomBottomNavigation
import com.example.custombottomnavigation.ui.customStuff.Screen
import com.example.custombottomnavigation.ui.theme.CustomBottomNavigationTheme

class MainActivity : ComponentActivity() {
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val currentScreen = mutableStateOf<Screen>(Screen.Home)
            CustomBottomNavigationTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                   Scaffold(
                       bottomBar = {
                           CustomBottomNavigation(
                               currentScreenId = currentScreen.value.id,
                           ){
                               currentScreen.value = it
                           }
                       }
                   ){

                   }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CustomBottomNavigationTheme {

    }
}