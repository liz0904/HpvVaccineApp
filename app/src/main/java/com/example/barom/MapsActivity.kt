package com.example.barom

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.location.*

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.bottomnavigation.BottomNavigationView


class MapsActivity : AppCompatActivity(), OnMapReadyCallback{

    private lateinit var mMap: GoogleMap
    private lateinit var fusedLocationClient:FusedLocationProviderClient
    private lateinit var locationCallback: LocationCallback

    lateinit var homeBtn: Button
    lateinit var hospitalBtn:Button
    lateinit var infoBtn:Button
    lateinit var questBtn:Button


    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        checkPermission()

        homeBtn = findViewById(R.id.homeBtn4)
        hospitalBtn = findViewById(R.id.hospitalBtn4)
        infoBtn = findViewById(R.id.infoBtn4)
        questBtn = findViewById(R.id.questBtn4)

        homeBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        hospitalBtn.setOnClickListener {
            val intent = Intent(this, MapsActivity::class.java)
            startActivity(intent)
        }
        infoBtn.setOnClickListener {
            val intent = Intent(this, InfoActivity1::class.java)
            startActivity(intent)
        }
        questBtn.setOnClickListener {
            val intent = Intent(this, QuestView::class.java)
            startActivity(intent)
        }
    }

    fun startProcess(){
        setContentView(R.layout.activity_maps)
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment

        mapFragment.getMapAsync(this)
    }

    @SuppressLint("MissingPermission")

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        updateLocation()
    }

    fun updateLocation(){
        val locationRequest = LocationRequest.create()

        locationRequest.run {
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY
            interval = 1000
        }
        locationCallback = object:LocationCallback(){
            override fun onLocationResult(locationResult: LocationResult?){
                locationResult?.let {
                    for ((i,location) in it.locations.withIndex()){
                        //Log.d("Location","$i ${location.latitude},${location.longitude}")
                        setLastLocation(location)
                    }
                }
            }
        }

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return
        }
        fusedLocationClient.requestLocationUpdates(locationRequest,locationCallback, Looper.myLooper())
    }

    fun setLastLocation(lastLocation: Location){
        val LatLNG = LatLng(lastLocation.latitude, lastLocation.longitude)
        val markerOptions = MarkerOptions()
                .position(LatLNG)
                .title("내 위치")
                //.icon(BitmapDescriptorFactory.fromResource(R.drawable.human))

        val PositionCamera = LatLng(37.50183211744794, 126.86197461008186)
        val cameraPosition = CameraPosition.Builder()
                .target(PositionCamera)
                .zoom(14.4f)
                .build()

        mMap.clear()
        mMap.addMarker(markerOptions)

        // 병원
        val hos1 = LatLng(37.50666875322793, 126.86057796190141)
        val hos1Options = MarkerOptions()
            .position(hos1)
            .title("연세사랑모아여성병원")
        mMap.addMarker(hos1Options)

        val hos2 = LatLng(37.49773352441385, 126.85581456212957)
        val hos2Options = MarkerOptions()
            .position(hos2)
            .title("민전산부인과의원")
        mMap.addMarker(hos2Options)

        val hos3 = LatLng(37.499799703816855, 126.86632918285608)
        val hos3Options = MarkerOptions()
            .position(hos3)
            .title("구로성심병원")
        mMap.addMarker(hos3Options)

        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))
    }

    override fun onDestroy() {
        fusedLocationClient.removeLocationUpdates(locationCallback)
        super.onDestroy()
    }

    /* 권한 처리 */
    val permissions = arrayOf(
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION
    )

    val PERM_LOCAIION = 99

    @RequiresApi(Build.VERSION_CODES.M)
    fun checkPermission(){
        var permitted_all = true
        for(permissions in permissions){
            val result = ContextCompat.checkSelfPermission(this,permissions)
            if (result != PackageManager.PERMISSION_GRANTED){
                permitted_all = false
                requestPermission()
                break
            }
        }
        if(permitted_all){
            startProcess()
        }
    }

    fun requestPermission(){
        ActivityCompat.requestPermissions(this,permissions,PERM_LOCAIION)
    }

    fun confirmAgain(){
        AlertDialog.Builder(this)
                .setTitle("권한 승인 확인")
                .setMessage("위치 관련 권한을 모두 승인하셔야 앱을 사용할 수 있습니다. 권한 승인을 다시 하시겠습니까?")
                .setPositiveButton("네",{_,_ ->
                    requestPermission()
                }).setNegativeButton("아니요",{_,_ ->
                    finish()
                }).create()
                .show()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when(requestCode){
            99 -> {
                var granted_all = true
                for(result in grantResults){
                    if(result != PackageManager.PERMISSION_GRANTED){
                        granted_all = false
                        break
                    }

                }
                if (granted_all){
                    startProcess()
                } else{
                    confirmAgain()
                }
            }
        }
    }

}
