package com.bilalandcompany.issbpreparation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.bilalandcompany.issbpreparation.databinding.PostDataBinding
import com.google.firebase.database.*
import com.google.firebase.database.GenericTypeIndicator
import es.dmoral.toasty.Toasty


class PostDataActivity : AppCompatActivity() {
    var objectsGTypeInd: GenericTypeIndicator<HashMap<String, Any>> =
        object : GenericTypeIndicator<HashMap<String, Any>>() {

        }
    var selectedNote=""

    private var notesDataReference: DatabaseReference? = null
    lateinit var binding:PostDataBinding
    var notesList=ArrayList<Any>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_post_data)
        init()
        setListener()

    }
    private fun init(){
        notesDataReference = FirebaseDatabase.getInstance().reference.child("Notes")
        notesDataReference?.keepSynced(true)
    }
    private fun setListener(){
        binding.run {
            postData?.setOnClickListener {
                val map = HashMap<String, Any>()
                map.put("info",answer?.text.toString() as Any)
                notesDataReference?.child(selectedNote)?.push()?.updateChildren(map)?.
                    addOnCompleteListener{
                        Toasty.success(this@PostDataActivity,"Data posted successfully",Toast.LENGTH_SHORT).show()
                    }
            }
            notesSpinner.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View,
                    position: Int,
                    id: Long
                ) {
                    selectedNote = notesList.get(position) as String
                }

                override fun onNothingSelected(parent: AdapterView<*>) {

                }
            })
        }
        notesDataReference?.addListenerForSingleValueEvent(object :ValueEventListener{
            override fun onCancelled(databaseError: DatabaseError) {

            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val objectHashMap = dataSnapshot.getValue(objectsGTypeInd)
//                val objectArrayList = ArrayList<Any>(objectHashMap.values)
                notesList.addAll(objectHashMap!!.keys)
                populateSpinner(binding.notesSpinner,notesList as ArrayList<String>)
            }

        })

       // populateSpinner(binding.notesSpinner)
    }
    private fun populateSpinner(spinner: Spinner?, array: ArrayList<String>) {
        val adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_spinner_dropdown_item, array
        )
        spinner?.adapter = adapter

    }

}
