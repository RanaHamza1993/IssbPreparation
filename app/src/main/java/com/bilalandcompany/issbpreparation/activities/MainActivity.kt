package com.bilalandcompany.issbpreparation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.bilalandcompany.issbpreparation.R
import com.bilalandcompany.issbpreparation.constants.StaticFunctions
import com.bilalandcompany.issbpreparation.databinding.MainActivityBinding
import com.bilalandcompany.issbpreparation.extensions.makeRound
import com.bilalandcompany.issbpreparation.kotlin.ActivityNavigator

class MainActivity : AppCompatActivity() {
    lateinit var binding: MainActivityBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding =
            DataBindingUtil.setContentView(this,
                R.layout.activity_main
            )
        setListener()
    }

    private fun makeImagesRound() {
        binding.run {
            introIv.makeRound()
            requirementsIv.makeRound()
            fiveDaysIv.makeRound()
            notesIv.makeRound()
            physicalIv.makeRound()
            centersIv.makeRound()
            practiceIv.makeRound()
            instructorIv.makeRound()
        }

    }

    private fun setListener(){
        binding.run {
            StaticFunctions.loadImage(this@MainActivity,R.drawable.intro,introIv)
            StaticFunctions.loadImage(this@MainActivity,R.drawable.requirements,requirementsIv)
            StaticFunctions.loadImage(this@MainActivity,R.drawable.fivedays2,fiveDaysIv)
            StaticFunctions.loadImage(this@MainActivity,R.drawable.notes,notesIv)
            StaticFunctions.loadImage(this@MainActivity,R.drawable.physicalassessment,physicalIv)
            StaticFunctions.loadImage(this@MainActivity,R.drawable.map,centersIv)
            StaticFunctions.loadImage(this@MainActivity,R.drawable.practice,practiceIv)
            StaticFunctions.loadImage(this@MainActivity,R.drawable.instructor,instructorIv)
            makeImagesRound()
            instructorIv?.setOnClickListener {
                ActivityNavigator<PostDataActivity>(this@MainActivity,
                    PostDataActivity::class.java)
            }

        }
    }

}
