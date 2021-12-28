package com.example.magicmamanapplication.activities

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.example.magicmamanapplication.R

private const val PERMISSION_REQUEST = 10

class Sante : AppCompatActivity() {
    lateinit var btnTemperature: ImageView
    lateinit var btnVaccin: ImageView
    lateinit var btnMedicaments: ImageView
    lateinit var btnHopitaux: ImageView
    //to stop the permission
    private var permissions = arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.INTERNET)
    private lateinit var context: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sante)
        btnTemperature=findViewById(R.id.btnTemperature)
        btnVaccin=findViewById(R.id.btnVaccin)
        btnMedicaments=findViewById(R.id.btnMedicaments)
        btnHopitaux=findViewById(R.id.btnHopitaux)
        context = this
        btnTemperature.setOnClickListener {

            val i= Intent(this,Temperature::class.java)
            startActivity(i)
        }
        btnVaccin.setOnClickListener {

            val i= Intent(this,Vaccin::class.java)
            startActivity(i)
        }
        btnMedicaments.setOnClickListener {

            val i= Intent(this,Medicaments::class.java)
            startActivity(i)
        }
        btnHopitaux.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if(checkPermission(context, permissions)){
                    Toast.makeText(context, "Permission are already provided",Toast.LENGTH_SHORT).show()
                }else{

                    requestPermissions(permissions, PERMISSION_REQUEST)
                }
            }else{
                Toast.makeText(this, "Permission Denied",Toast.LENGTH_SHORT).show()
            }
            //val i= Intent(this,Hospital::class.java)
            //startActivity(i)
        }
    }

    fun checkPermission(context: Context, permissionArray: Array<String>): Boolean{
        var allSuccess = true
        for (i in permissionArray.indices){
            if(checkCallingOrSelfPermission(permissionArray[i])==PackageManager.PERMISSION_DENIED)
                allSuccess = false
        }
        val i= Intent(this,Hospital::class.java)
        startActivity(i)
        return allSuccess
        //return true
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSION_REQUEST){
            var allSuccess = true
            for (i in permissions.indices){
                if (grantResults[i] == PackageManager.PERMISSION_DENIED){
                    allSuccess = false
                    var requestAgain = Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && shouldShowRequestPermissionRationale(permissions[i])
                    if(requestAgain){
                        Toast.makeText(context, "Permission Denied",Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(context, "GO To Settings And Enable The Permission",Toast.LENGTH_SHORT).show()
                    }
                }
            }
            if(allSuccess)
            {
                Toast.makeText(context, "Permission Granted",Toast.LENGTH_SHORT).show()

            }
        }
    }
}