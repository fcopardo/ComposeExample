package com.example.composeui

import androidx.activity.ComponentActivity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.gesture.tapGestureFilter
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
import com.example.composeui.theme.*
import com.example.ux.MainUI

class ComposeMainUI : MainUI() {

    private val DarkColors = darkColors(
        primary = purple200,
        primaryVariant = purple700,
        secondary = teal200
    )

    private val LightColors = lightColors(
        primary = purple500,
        primaryVariant = purple700,
        secondary = teal200
    )

    override fun draw() {
        getComponentActivity().setContent {
            BasicsCodelabTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background, modifier = Modifier.tapGestureFilter {
                    if(isVisible()){
                        hide()
                    } else {
                        show()
                    }
                }) {
                    Column(
                        modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        if (visible) {
                            composeUI("HELLO VIEW")
                        }
                    }
                }3
            }
        }
    }

    override fun hide() {
        visible = false
        draw()
    }

    override fun show() {
        visible = true
        draw()
    }

    @Composable
    protected fun composeUI(text : String){
        Text(text = text,
            modifier = Modifier.padding(12.dp),
            style = MaterialTheme.typography.body1)
    }

    @Composable
    protected fun BasicsCodelabTheme(
        darkTheme: Boolean = isSystemInDarkTheme(),
        content: @Composable () -> Unit
    ) {
        val colors = if (darkTheme) {
            DarkColors
        } else {
            LightColors
        }

        MaterialTheme(colors = colors) {
            content()
        }
    }

    protected fun getComponentActivity() : ComponentActivity {
        return activity as ComponentActivity
    }
}