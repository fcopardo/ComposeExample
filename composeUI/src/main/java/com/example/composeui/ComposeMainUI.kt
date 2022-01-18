package com.example.composeui

import android.app.Activity
import androidx.activity.ComponentActivity
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.example.composeui.theme.*
import com.example.ux.MainUI

open class ComposeMainUI : MainUI() {

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

    override fun hide() {
        visible = false
        draw()
    }

    override fun show() {
        visible = true
        draw()
    }

    @Composable
    @Preview("Light Theme", widthDp = 360, heightDp = 640)
    fun composeUI(text: String = "default", visibility: Boolean = true) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (visibility) {
                title(text)
            }
        }
    }

    @Composable
    @Preview("Light Theme", widthDp = 360, heightDp = 640)
    fun title(text: String = "default") {
        Text(
            text = text,
            modifier = Modifier.padding(12.dp),
            style = MaterialTheme.typography.body1
        )
    }


    @Composable
    fun BasicsCodelabTheme(
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

    override fun draw() {
        getComponentActivity().setContent {
            // A surface container using the 'background' color from the theme
            Surface(
                color = MaterialTheme.colors.background,
                modifier = Modifier.pointerInput(Unit) {
                    detectTapGestures(
                        onPress = {
                            if (isVisible()) {
                                hide()
                            } else {
                                show()
                            }
                        },
                        onDoubleTap = { /* Called on Double Tap */ },
                        onLongPress = { /* Called on Long Press */ },
                        onTap = { /* Called on Tap */ }
                    )
                }) {
                composeUI("Hello View", visible)
            }
        }
    }

    fun getComponentActivity(): ComponentActivity {
        return activity as ComponentActivity
    }

}
