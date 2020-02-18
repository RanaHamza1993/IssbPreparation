package com.bilalandcompany.issbpreparation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.bilalandcompany.issbpreparation.R
import com.bilalandcompany.issbpreparation.constants.StaticFunctions
import com.bilalandcompany.issbpreparation.databinding.FiveDaysBinding
import com.bilalandcompany.issbpreparation.databinding.ISSBCentresBinding
import com.bilalandcompany.issbpreparation.extensions.hide
import com.bilalandcompany.issbpreparation.extensions.makeRound
import com.bilalandcompany.issbpreparation.extensions.show

class FiveDaysSchedule : AppCompatActivity() {
    lateinit var binding: FiveDaysBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_five_days_schedule)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_five_days_schedule)
        setListener()
    }

    private fun makeImagesRound() {
        binding.run {
            dayOneIv.makeRound()
            dayTwoIv.makeRound()
            dayThreeIv.makeRound()
            dayFourIv.makeRound()
            dayFifthIv.makeRound()
        }

    }

    private fun setListener() {
        binding.run {
            StaticFunctions.loadImage(this@FiveDaysSchedule, R.drawable.day_one, dayOneIv)
            StaticFunctions.loadImage(this@FiveDaysSchedule, R.drawable.requirements, dayTwoIv)
            StaticFunctions.loadImage(this@FiveDaysSchedule, R.drawable.day_three, dayThreeIv)
            StaticFunctions.loadImage(this@FiveDaysSchedule, R.drawable.day_four, dayFourIv)
            StaticFunctions.loadImage(this@FiveDaysSchedule, R.drawable.day_five, dayFifthIv)
            makeImagesRound()
            dayOneIv.setOnClickListener {

            }
        }
    }

}
