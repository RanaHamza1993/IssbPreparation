package com.bilalandcompany.issbpreparation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import com.bilalandcompany.issbpreparation.R
import com.bilalandcompany.issbpreparation.constants.StaticFunctions
import com.bilalandcompany.issbpreparation.databinding.HireInstructorBinding
import com.bilalandcompany.issbpreparation.databinding.ISSBCentresBinding
import com.bilalandcompany.issbpreparation.extensions.makeRound
import com.bilalandcompany.issbpreparation.kotlin.ActivityNavigator
import kotlinx.android.synthetic.main.intro_dialog.view.*
import kotlinx.android.synthetic.main.ping_dialog.view.*

class HireAnInstructor : AppCompatActivity() {
    lateinit var binding: HireInstructorBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hire_an_instructor)
        binding =
            DataBindingUtil.setContentView(
                this,
                R.layout.hire_an_instructor
            )

        setListener()



    }

    private fun setListener() {
        binding.run {
            ping.setOnClickListener{
                showInfo()
            }

        }
    }

    private fun showInfo() {
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.ping_dialog, null)
        val mBuilder = AlertDialog.Builder(this)
            .setView(mDialogView)
        val  mAlertDialog = mBuilder.show()

        mDialogView.bt_ping_close.setOnClickListener {
            mAlertDialog.dismiss()
        }

    }

}
