package com.example.composehello

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.composeui.ComposeMainUI
import com.example.ux.MainUI
import com.example.viewui.ViewMainUi

class MainActivity : ComponentActivity() {

    lateinit var ui : MainUI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //ui = ComposeMainUI()
        ui = ViewMainUi()
        ui.setContents(this)
    }
}