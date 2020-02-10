package com.bilalandcompany.issbpreparation.extensions

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.GONE
}

fun View.snackBar(message: String) {
    Snackbar.make(this, message, Snackbar.LENGTH_LONG).also { snackbar ->
        snackbar.setAction("Ok") {
            snackbar.dismiss()
        }.show()
    }

}
fun TextView.clear(){
    this.text = ""
}
fun ImageView.makeRound(){
    this.clipToOutline=true
}