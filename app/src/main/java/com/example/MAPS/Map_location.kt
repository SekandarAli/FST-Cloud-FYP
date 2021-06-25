package com.example.MAPS

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.fstsignin.R

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.fstsignin.databinding.ActivityMapLocationBinding
import com.google.android.gms.maps.model.BitmapDescriptorFactory

class Map_location : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var Map: GoogleMap
    private lateinit var binding: ActivityMapLocationBinding
    private val LOCATION_PERMISSION_REQUEST = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapLocationBinding.inflate(layoutInflater)
        setContentView(binding.root)



        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    private fun getLocationAccess() {
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            Map.isMyLocationEnabled = true
        }
        else
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), LOCATION_PERMISSION_REQUEST)
    }


    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == LOCATION_PERMISSION_REQUEST) {
            if (grantResults.contains(PackageManager.PERMISSION_GRANTED)) {
                if (ActivityCompat.checkSelfPermission(
                        this,
                        Manifest.permission.ACCESS_FINE_LOCATION
                    ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                        this,
                        Manifest.permission.ACCESS_COARSE_LOCATION
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return
                }
                Map.isMyLocationEnabled = true
            }
            else {
                Toast.makeText(this, "User has not granted location access permission", Toast.LENGTH_LONG).show()
                finish()
            }
        }
    }



    override fun onMapReady(googleMap: GoogleMap) {
        Map = googleMap
        var zoom = 14f
        getLocationAccess()

        // Add a marker and move the camera
        val kalaykhan = LatLng(34.19276314109234, 73.23507846212394)
        val chaiKhana = LatLng(34.19248031429235, 73.2345540127847)
        val usmania = LatLng(34.191487985658306, 73.23467184710346)
        val subway = LatLng(34.19209056771258, 73.2344040504602)
        val saifResturant = LatLng(34.18897386367572, 73.23312282403005)
        val tandooriChaiShai = LatLng(34.19024253017108, 73.23750363762768)

        Map.addMarker(MarkerOptions().position(kalaykhan).title("KalayKhan")
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)))

        Map.addMarker(MarkerOptions().position(chaiKhana).title("ChaiKhana")
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)))

        Map.addMarker(MarkerOptions().position(usmania).title("Usmania")
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)))

        Map.addMarker(MarkerOptions().position(subway).title("Subway")
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)))

        Map.addMarker(MarkerOptions().position(saifResturant).title("Saif Resturant")
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)))

        Map.addMarker(MarkerOptions().position(tandooriChaiShai).title("Tandoori Chai Shai")
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)))

        Map.moveCamera(CameraUpdateFactory.newLatLngZoom(kalaykhan,zoom))
        Map.moveCamera(CameraUpdateFactory.newLatLngZoom(chaiKhana,zoom))
        Map.moveCamera(CameraUpdateFactory.newLatLngZoom(usmania,zoom))
        Map.moveCamera(CameraUpdateFactory.newLatLngZoom(subway,zoom))
        Map.moveCamera(CameraUpdateFactory.newLatLngZoom(saifResturant,zoom))
        Map.moveCamera(CameraUpdateFactory.newLatLngZoom(tandooriChaiShai,zoom))


    }
}