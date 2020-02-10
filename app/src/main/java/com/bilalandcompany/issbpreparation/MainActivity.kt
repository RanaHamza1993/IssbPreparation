package com.bilalandcompany.issbpreparation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bilalandcompany.issbpreparation.kotlin.ActivityNavigator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigate?.setOnClickListener {
            ActivityNavigator<PostDataActivity>(this,PostDataActivity::class.java)
        }
    }
}
