package com.bilalandcompany.issbpreparation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import androidx.databinding.DataBindingUtil
import com.bilalandcompany.issbpreparation.R
import com.bilalandcompany.issbpreparation.constants.StaticFunctions
import com.bilalandcompany.issbpreparation.databinding.PhysicalAssessmentBinding
import com.bilalandcompany.issbpreparation.extensions.hide
import com.bilalandcompany.issbpreparation.extensions.makeRound
import com.bilalandcompany.issbpreparation.extensions.show
import kotlinx.android.synthetic.main.activity_physical_assessment.*

class PhysicalAssessment : AppCompatActivity() {
    lateinit var binding: PhysicalAssessmentBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_physical_assessment)

        binding =
            DataBindingUtil.setContentView(
                this,
                R.layout.activity_physical_assessment
            )
        setListeners()


    }

    private fun setListeners() {
        binding.run {
            StaticFunctions.loadImage(this@PhysicalAssessment, R.drawable.bmi_calculator,bmiCalcIv)
            StaticFunctions.loadImage(this@PhysicalAssessment, R.drawable.calculate_age,ageCalcIv)
            makeImagesRound()

            bmiCalcIv.setOnClickListener {
                calculatorsOptions.hide()
                bmiWebview.show()
                ageCalcWebview.hide()
                bmiWebview.loadUrl("https://www.calculatestuff.com/health/bmi-calculator")

            }
            ageCalcIv.setOnClickListener {
                calculatorsOptions.hide()
                ageCalcWebview.show()
                bmiWebview.hide()
                ageCalcWebview.loadUrl("https://www.calculatestuff.com/miscellaneous/age-calculator")

            }

        }

    }

    private fun makeImagesRound() {
        binding.run {
            bmiCalcIv.makeRound()
            ageCalcIv.makeRound()
        }

    }
}
