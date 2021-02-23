package com.example.viewui


import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import com.example.ux.MainUI
import com.google.android.material.color.MaterialColors

class ViewMainUi : MainUI() {

    lateinit var frame : FrameLayout
    lateinit var title : TextView

    override fun draw() {
        frame = FrameLayout(activity).apply {
            layoutParams = FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
            setBackgroundColor(resources.getColor(R.color.design_default_color_background))
            title = TextView(activity).apply {
                text = "HELLO VIEW"
                gravity = Gravity.CENTER
            }
            addView(title)
            setOnClickListener(View.OnClickListener {
                if(isVisible()){
                    hide()
                }else {
                    show()
                }
            })
        }
        activity.setContentView(frame)
    }

    override fun hide() {
        title.visibility = View.INVISIBLE
        visible = false
    }

    override fun show() {
        title.visibility = View.VISIBLE
        visible = true
    }
}