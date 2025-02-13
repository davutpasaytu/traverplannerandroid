package com.barisemrealanc.travelplanner

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.mapFragment) as SupportMapFragment
        mapFragment.getMapAsync(this)  // Harita hazır olunca çağrılacak
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Haritada gösterilecek konum
        val newYork = LatLng(40.7128, -74.0060)
        mMap.addMarker(MarkerOptions().position(newYork).title("New York"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(newYork, 10f))
    }
}
