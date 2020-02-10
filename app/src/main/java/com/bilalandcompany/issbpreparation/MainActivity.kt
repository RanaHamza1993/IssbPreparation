package com.bilalandcompany.issbpreparation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.bilalandcompany.issbpreparation.databinding.MainActivityBinding
import com.bilalandcompany.issbpreparation.extensions.makeRound

class MainActivity : AppCompatActivity() {
    lateinit var binding: MainActivityBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)


        makeImagesRound()
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


}
