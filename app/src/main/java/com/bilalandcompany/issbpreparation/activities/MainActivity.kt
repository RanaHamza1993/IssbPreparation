package com.bilalandcompany.issbpreparation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import com.bilalandcompany.issbpreparation.R
import com.bilalandcompany.issbpreparation.constants.StaticFunctions
import com.bilalandcompany.issbpreparation.databinding.MainActivityBinding
import com.bilalandcompany.issbpreparation.extensions.hide
import com.bilalandcompany.issbpreparation.extensions.makeRound
import com.bilalandcompany.issbpreparation.extensions.show
import com.bilalandcompany.issbpreparation.kotlin.ActivityNavigator
import kotlinx.android.synthetic.main.intro_dialog.view.*
import kotlinx.android.synthetic.main.intro_dialog.view.bt_close
import kotlinx.android.synthetic.main.requirements_select_sex.*
import kotlinx.android.synthetic.main.requirements_select_sex.view.*

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
                ActivityNavigator<HireAnInstructor>(this@MainActivity,
                    HireAnInstructor::class.java)
            }
            fiveDaysIv?.setOnClickListener {
                ActivityNavigator<FiveDaysSchedule>(this@MainActivity,
                    FiveDaysSchedule::class.java)
            }
            physicalIv.setOnClickListener {
                ActivityNavigator<PhysicalAssessment>(this@MainActivity,PhysicalAssessment::class.java)
            }
            centersIv.setOnClickListener {
                ActivityNavigator<IssbCentres>(this@MainActivity,IssbCentres::class.java)
            }
            introIv?.setOnClickListener {
                showIntro()
            }

            requirementsIv.setOnClickListener {
                showRequirements()
            }

        }
    }

    private fun showRequirements() {
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.requirements_select_sex, null)
        val mBuilder = AlertDialog.Builder(this)
            .setView(mDialogView)
        val  mAlertDialog = mBuilder.show()

        mDialogView.select_male_tv.setOnClickListener {
            mDialogView.req_layout_for_male.show()
            mDialogView.req_layout_for_female.hide()
            mAlertDialog.layout_select_gender.hide()


        }
        mDialogView.select_female_tv.setOnClickListener {
            mDialogView.req_layout_for_female.show()
            mAlertDialog.layout_select_gender.hide()
            mDialogView.req_layout_for_male.hide()

        }
        mDialogView.bt_close.setOnClickListener {
            mAlertDialog.dismiss()
        }


    }

    private fun showIntro() {
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.intro_dialog, null)
        val mBuilder = AlertDialog.Builder(this)
            .setView(mDialogView)
        val  mAlertDialog = mBuilder.show()

        mDialogView.bt_close.setOnClickListener {
            mAlertDialog.dismiss()
        }

    }

}
