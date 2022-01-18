package com.example.ux


import android.app.Activity
import android.content.Context

abstract class UI {
    protected lateinit var activity : Activity
    protected var visible: Boolean = true
    fun setContents(activity : Activity){
        this.activity = activity
        draw()
    }
    abstract fun draw()
    abstract fun hide()
    abstract fun show()
    fun isVisible() : Boolean {
        return visible
    }
    fun getContext() : Context {
        return activity
    }
}