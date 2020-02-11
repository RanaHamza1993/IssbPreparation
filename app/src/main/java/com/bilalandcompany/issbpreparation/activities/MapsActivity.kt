package com.bilalandcompany.issbpreparation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.bilalandcompany.issbpreparation.R

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_maps.*
import android.content.Intent
import android.net.Uri


class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private var centerName: String?=null
    private lateinit var mMap: GoogleMap
    private  var latitude =0.0
    private var longitude=0.0
    var btn:Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        val intent=intent.getBundleExtra("bundle")
        latitude=intent!!.getDouble("latitude")
        longitude=intent.getDouble("longitude")
        centerName=intent.getString("title")
        mapFragment.getMapAsync(this)
        viewonmap?.setOnClickListener {
            val intent = Intent(
                android.content.Intent.ACTION_VIEW, Uri.parse(
                    //"http://maps.google.com/maps?q=loc:$latitude, $longitude"
                   //"geo:0,0?q=$latitude,$longitude($centerName)"
                    "http://maps.google.com/maps?q=loc:" + latitude + "," + longitude + " (" + centerName + ")"
                )
            )
            //intent.setPackage("com.google.android.apps.maps");

            startActivity(intent)
        }

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val center = LatLng(latitude, longitude)
        val marker=MarkerOptions().position(center).title(centerName)
        mMap.addMarker(marker)
       // mMap.moveCamera(CameraUpdateFactory.newLatLng(center))
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(center, 16f))
        // btn?.performClick()

       // mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }

}
