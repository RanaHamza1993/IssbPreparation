package com.bilalandcompany.issbpreparation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.bilalandcompany.issbpreparation.R
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
        binding.introIv.makeRound()
        binding.requirementsIv.makeRound()
        binding.fiveDaysIv.makeRound()
        binding.notesIv.makeRound()
        binding.physicalIv.makeRound()
        binding.centersIv.makeRound()
        binding.practiceIv.makeRound()
        binding.instructorIv.makeRound()
    }

    private fun setListener(){
        makeImagesRound()
        binding.run {
            instructorIv?.setOnClickListener {
                ActivityNavigator<PostDataActivity>(this@MainActivity,
                    PostDataActivity::class.java)
            }
        }
    }

}
