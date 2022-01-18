package com.example.viewui


import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import com.example.ux.MainUI

class ViewMainUi : MainUI() {

    lateinit var frame : FrameLayout
    lateinit var title : TextView
    var initialized = false

    override fun draw() {
        if(!initialized){
            frame = FrameLayout(activity).apply {
                layoutParams = FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
                setBackgroundColor(resources.getColor(R.color.design_default_color_background))
                foregroundGravity = Gravity.CENTER
            }
            title = TextView(activity).apply {
                text = "HELLO VIEW"
                gravity = Gravity.CENTER
            }
            frame.addView(title)
            frame.setOnClickListener(View.OnClickListener {
                if(isVisible()){
                    hide()
                }else {
                    show()
                }
            })
            activity.setContentView(title)
            initialized = true
        }
        Toast.makeText(activity, "view drawing", Toast.LENGTH_SHORT).show()
    }

    override fun hide() {
        frame.visibility = View.INVISIBLE
        visible = false
    }

    override fun show() {
        frame.visibility = View.VISIBLE
        visible = true
    }
}