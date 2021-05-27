package com.example.p

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.project.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng


class MapScreenFragment : Fragment(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
//    private lateinit var currentLocation: Location
//    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
//    private val permissionCode = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        fusedLocationProviderClient =  LocationServices.getFusedLocationProviderClient(this@MainActivity)
//        fetchLocation()
    }
//    private fun fetchLocation() {
//        if (ActivityCompat.checkSelfPermission(
//                        this, Manifest.permission.ACCESS_FINE_LOCATION) !=
//                PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
//                        this, Manifest.permission.ACCESS_COARSE_LOCATION) !=
//                PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(this,
//                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), permissionCode)
//            return
//        }
//        val task = fusedLocationProviderClient.lastLocation
//        task.addOnSuccessListener { location −>
//            if (location != null) {
//                currentLocation = location
//                Toast.makeText(applicationContext, currentLocation.latitude.toString() + "" +
//                        currentLocation.longitude, Toast.LENGTH_SHORT).show()
//            }
//        }
   // }
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_map_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }



   override fun onMapReady(googleMap: GoogleMap?) {
        mMap = googleMap!!
        mMap.uiSettings.isZoomControlsEnabled = true
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(LatLng(55.751244, 37.618423), 10f))
//       val latLng = LatLng(currentLocation.latitude, currentLocation.longitude)
//       val markerOptions = MarkerOptions().position(latLng).title("I am here!")
//       googleMap?.animateCamera(CameraUpdateFactory.newLatLng(latLng))
//       googleMap?.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 5f))
//       googleMap?.addMarker(markerOptions)

    }

//    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String?>,
//                                            grantResults: IntArray) {
//        when (requestCode) {
//            permissionCode −> if (grantResults.isNotEmpty() && grantResults[0] ==
//                    PackageManager.PERMISSION_GRANTED) {
//                fetchLocation()
//            }
//        }
//    }

    private fun makeCurrentFragmentInMainWindow(fragment: Fragment, name: String) {
        fragmentManager?.beginTransaction()?.apply {
            replace(R.id.main_fragmnet, fragment)
            addToBackStack(name.toString())
            commit()
        }
    }
}