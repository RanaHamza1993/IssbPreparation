package com.bilalandcompany.issbpreparation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.bilalandcompany.issbpreparation.R
import com.bilalandcompany.issbpreparation.constants.StaticFunctions
import com.bilalandcompany.issbpreparation.databinding.ISSBCentresBinding
import com.bilalandcompany.issbpreparation.databinding.MainActivityBinding
import com.bilalandcompany.issbpreparation.extensions.makeRound
import com.bilalandcompany.issbpreparation.kotlin.ActivityNavigator
import kotlinx.android.synthetic.main.activity_issb_centres.*

class IssbCentres : AppCompatActivity() {
    lateinit var binding: ISSBCentresBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_issb_centres)

        binding =
            DataBindingUtil.setContentView(
                this,
                R.layout.activity_issb_centres
            )
        setListener()

    }

    private fun makeImagesRound() {
        binding.run {
            gujranwalaIv.makeRound()
            kohatIv.makeRound()
            malirIv.makeRound()
            quettaIv.makeRound()
        }

    }

    private fun setListener() {
        binding.run {
            StaticFunctions.loadImage(this@IssbCentres, R.drawable.gujranwala, gujranwalaIv)
            StaticFunctions.loadImage(this@IssbCentres, R.drawable.kohat, kohatIv)
            StaticFunctions.loadImage(this@IssbCentres, R.drawable.malir, malirIv)
            StaticFunctions.loadImage(this@IssbCentres, R.drawable.quetta, quettaIv)
            makeImagesRound()
        }
    }


}
