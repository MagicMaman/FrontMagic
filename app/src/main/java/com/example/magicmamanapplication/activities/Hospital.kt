package com.example.magicmamanapplication.activities

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import com.example.magicmamanapplication.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class Hospital : AppCompatActivity() {
    lateinit var mapFragment : SupportMapFragment
    lateinit var googleMap: GoogleMap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hospital)

        mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(OnMapReadyCallback {
            googleMap = it
            /* val location1= LatLng(   34.4739,9.4613)
             googleMap.addMarker(MarkerOptions().position(location1).title("walid Home"))
             googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location1,5f))*/

            val location2= LatLng( 36.8091,10.1606)
            googleMap.addMarker(MarkerOptions().position(location2).title("hopital bachir hamza d'enfant"))
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location2,10f))

            val location3= LatLng( 36.7979,10.1611)
            googleMap.addMarker(MarkerOptions().position(location3).title("Charle Nicole"))
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location3,10f))

            val location4= LatLng( 36.80264,10.15444)
            googleMap.addMarker(MarkerOptions().position(location4).title("Rabta"))
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location4,10f))

            val location5= LatLng( 36.7812, 10.1781)
            googleMap.addMarker(MarkerOptions().position(location5).title("Hopital Millitaire"))
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location5,10f))

            val location6= LatLng( 36.8629, 10.2913)
            googleMap.addMarker(MarkerOptions().position(location6).title("Hôpital Mongi Slim"))
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location6,10f))

            val location7= LatLng( 36.78748992321276, 10.178485290215892)
            googleMap.addMarker(MarkerOptions().position(location7).title("Hôpital Habib Thameur"))
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location7,10f))

            val location8= LatLng(36.79726039865689, 10.16911548422334)
            googleMap.addMarker(MarkerOptions().position(location8).title("Hôpital Aziza Othmana"))
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location8,10f))

            val location9= LatLng(36.80712217994715, 10.158586360939296)
            googleMap.addMarker(MarkerOptions().position(location9).title("Institut Salah Azaiez"))
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location9,10f))

            val location10= LatLng(36.806385004176434, 10.159860976717688)
            googleMap.addMarker(MarkerOptions().position(location10).title("Institut Hedi Raies D'ophtalmologie de Tunis"))
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location10,15f))

            val location11= LatLng(36.80136837856427, 10.158189815343539)
            googleMap.addMarker(MarkerOptions().position(location11).title("Institut National de Neurologie"))
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location11,10f))

            val location12= LatLng(36.8146440589947, 10.10183148082394)
            googleMap.addMarker(MarkerOptions().position(location12).title("Institut Mohamed Kassab d'Orthopédie"))
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location12,10f))

            val location13= LatLng(36.82337724060952, 10.178948342763718)
            googleMap.addMarker(MarkerOptions().position(location13).title("Institut pasteur"))
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location13,10f))

            val location14= LatLng(36.80082748077551, 10.15704767856888)
            googleMap.addMarker(MarkerOptions().position(location14).title("Centre de Maternité et de Neonatologie"))
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location14,10f))

            val location15= LatLng(36.87004252584529, 10.178554036240644)
            googleMap.addMarker(MarkerOptions().position(location15).title("Hôpital de Pneumo-Phtisiologie"))
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location15,10f))

            val location16= LatLng(36.8184971306906, 10.08247531976673)
            googleMap.addMarker(MarkerOptions().position(location16).title("Hôpital Razi"))
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location16,10f))

            val location17= LatLng(36.80578853753597, 10.157096342328233)
            googleMap.addMarker(MarkerOptions().position(location17).title("Institut National de Nutrition et de Technologie Alimentaire"))
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location17,10f))

            val location18= LatLng(35.83730955383108, 10.590545073015308)
            googleMap.addMarker(MarkerOptions().position(location18).title("Hôpital Sahloul"))
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location18,10f))

            val location19= LatLng(35.82981036584676, 10.627706484656462)
            googleMap.addMarker(MarkerOptions().position(location19).title("Hôpital Farhat Hached"))
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location19,10f))

            val location20= LatLng(35.77047108018412, 10.833733213492346)
            googleMap.addMarker(MarkerOptions().position(location20).title("Hôpital Fattouma Bourguiba"))
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location20,10f))

            val location21= LatLng(34.741343994934695, 10.751720228835882)
            googleMap.addMarker(MarkerOptions().position(location21).title("Hôpital Hédi Chaker"))
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location21,10f))

            val location22= LatLng(34.740479292219405, 10.748191242328232)
            googleMap.addMarker(MarkerOptions().position(location22).title("Hôpital Habib Bourguiba"))
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location22,10f))
        })
    }
}