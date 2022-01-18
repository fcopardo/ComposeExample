package com.example.composeui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.ui.tooling.preview.Preview

class NoteList {



    @Composable
    @Preview("Light Theme", widthDp = 360, heightDp = 640)
    fun noteList(text : String = "default", visibility : Boolean = true){

            Column(
                    modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.Start
            ) {
                Text(text)
                Row(
                        modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(),
                        verticalAlignment = Alignment.Top,
                        horizontalArrangement = Arrangement.Start
                ) {
                    Text("Lots of text this is a note lorepipsum blabalblablablablabla")
                    val image: Painter = painterResource(id = android.R.drawable.picture_frame)
                    Image(painter = image,contentDescription = "")
                }
            }


    }

}