package com.siddharthsinghbaghel.permissionsexample

import android.Manifest.permission_group.CAMERA
import android.content.pm.PackageManager
import android.media.MediaRecorder.VideoSource.CAMERA
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


       btnLocationCameraPermission.setOnClickListener{
           if(ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
               Toast.makeText(this,"Either Camera or Location or both permissions are granted",Toast.LENGTH_LONG).show()

           }
           else{

               ActivityCompat.requestPermissions(this,arrayOf(android.Manifest.permission.CAMERA,
                   android.Manifest.permission.ACCESS_FINE_LOCATION),
                   CAMERA_AND_FINE_LOCATION_PERMISSION_CODE)
           }

       }

        btnCamera.setOnClickListener{
            if(ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this,"You have permission for camera ",Toast.LENGTH_LONG).show()

            }

            else{

                ActivityCompat.requestPermissions(this,arrayOf(android.Manifest.permission.CAMERA),
                    CAMERA_PERMISSION_CODE)
            }

        }

        btnLocation.setOnClickListener{
            if(ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this,"You have permission for Location ",Toast.LENGTH_LONG).show()

            }

            else{

                ActivityCompat.requestPermissions(this,arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                    FINE_LOCATION_PERMISSION_CODE)
            }

        }

    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if(requestCode == CAMERA_PERMISSION_CODE)
        {
            if(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                Toast.makeText(this,"You get permission for camera",Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,"Camera Access Denied",Toast.LENGTH_LONG).show()
            }
        }
        if(requestCode == FINE_LOCATION_PERMISSION_CODE)
        {
            if(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                Toast.makeText(this,"You get permission for Location",Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,"Location Access Denied",Toast.LENGTH_LONG).show()
            }
        }
        if(requestCode == CAMERA_AND_FINE_LOCATION_PERMISSION_CODE)
        {
            if(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                Toast.makeText(this,"You get permission for camera  ",Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,"Camera Access Denied ",Toast.LENGTH_LONG).show()
            }

            if(grantResults.isNotEmpty() && grantResults[1] == PackageManager.PERMISSION_GRANTED)
            {
                Toast.makeText(this,"You get permission for Location ",Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,"Location Access Denied ",Toast.LENGTH_LONG).show()
            }
        }

    }


   companion object{
       private const val CAMERA_PERMISSION_CODE = 1
       private const val FINE_LOCATION_PERMISSION_CODE = 2
       private const val CAMERA_AND_FINE_LOCATION_PERMISSION_CODE = 12
   }
}