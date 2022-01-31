package com.example.magicmamanapplication.activities
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.magicmamanapplication.MainViewModel
import com.example.magicmamanapplication.MainViewModelFactory
import com.example.magicmamanapplication.R
import com.example.magicmamanapplication.databinding.ActivityTeteBinding
import com.example.magicmamanapplication.fragments.BtnSheetTete
import com.example.magicmamanapplication.fragments.ResumeFragment
import com.example.magicmamanapplication.repository.Repository
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_added_soon.*
import kotlinx.android.synthetic.main.activity_tete.*
import kotlin.math.roundToInt

class Tete : AppCompatActivity()
{
    private lateinit var binding: ActivityTeteBinding
    private var timerStarted = false
    private lateinit var serviceIntent: Intent
    private var time = 0.0
    lateinit var saveTimeTv : TextView
    lateinit var saveNotesTete : TextView
    var a=""
    var b=""

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityTeteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnNextTete.setOnClickListener {




            if(!edtNotes.text.isEmpty()){

                val dialog = BottomSheetDialog(this, R.style.BottomSheetDialogTheme)
                var view = layoutInflater.inflate(R.layout.fragment_btn_sheet_tete, null)
                val close = view.findViewById<ImageView>(R.id.close)
                val btn_update_tete = view.findViewById<ImageView>(R.id.btn_update_tete)
                val btn_submit= view.findViewById<ImageView>(R.id.btn_confirm_tete)

                val sharedPreferences = getSharedPreferences("sharedPrefs2", Context.MODE_PRIVATE)
                val savedString=sharedPreferences.getString("STRING_KEY", null)


                btn_submit.setOnClickListener{
                    val repository = Repository()
                    val viewModelFactory = MainViewModelFactory(repository)
                    var viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
                    // viewModel.getCustomPosts(5,"id", "desc")
                    viewModel.addtete(savedString.toString(),a,b)
                    // Toast.makeText(this,"good",Toast.LENGTH_SHORT).show()
                    //Log.e("jawekbehi",textv2.text.toString())

                    Toast.makeText(this,"check your resume", Toast.LENGTH_SHORT).show()
                    val i= Intent(this, Menu::class.java)
                    startActivity(i)
                }

                btn_update_tete.setOnClickListener {
                    dialog.dismiss()
                }

                close.setOnClickListener{
                    dialog.dismiss()
                }
                dialog.setCancelable(false)
                dialog.setContentView(view)
                dialog.show()

                val time=binding.timeTV.text.toString()
                val note=binding.edtNotes.text.toString()


                saveTimeTv=view.findViewById(R.id.saveTimeTv)
                saveTimeTv.text="$time"//recuperation de données de activity
                a="$time"

                saveNotesTete=view.findViewById(R.id.saveNotesTete)
                saveNotesTete.text="$note"
                b="$note"

                /*btn_submit.setOnClickListener {
                    val repository = Repository()
                    val viewModelFactory = MainViewModelFactory(repository)
                    var viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
                    // viewModel.getCustomPosts(5,"id", "desc")
                    viewModel.addtete("baby","$note","$time",)
                    // Toast.makeText(this,"good",Toast.LENGTH_SHORT).show()
                    //Log.e("jawekbehi",textv2.text.toString())
                    Toast.makeText(this,"goood",Toast.LENGTH_SHORT).show()
                }*/


            }
            else
            {

                //Toast.makeText(applicationContext,"Notes is Empty", Toast.LENGTH_SHORT).show()

                val layout1 : View = layoutInflater.inflate(R.layout.tete_toast, ll_wrapper)
                val toast: Toast = Toast(applicationContext)

                (toast.apply {
                    duration = Toast.LENGTH_SHORT
                    //setGravity(Gravity.BOTTOM,0,0)
                    view = layout1
                    show()
                })
            }

        }
        binding.startStopButton.setOnClickListener { startStopTimer() }
        binding.resetButton.setOnClickListener { resetTimer() }

        serviceIntent = Intent(applicationContext, TimerService::class.java)
        registerReceiver(updateTime, IntentFilter(TimerService.TIMER_UPDATED))
    }

    private fun resetTimer()
    {
        stopTimer()
        time = 0.0
        binding.timeTV.text = getTimeStringFromDouble(time)
    }

    private fun startStopTimer()
    {
        if(timerStarted)
            stopTimer()
        else
            startTimer()
    }

    private fun startTimer()
    {
        serviceIntent.putExtra(TimerService.TIME_EXTRA, time)
        startService(serviceIntent)
        binding.startStopButton.text = "Stop"
        binding.startStopButton.icon = getDrawable(R.drawable.ic_pause)
        timerStarted = true
    }

    private fun stopTimer()
    {
        stopService(serviceIntent)
        binding.startStopButton.text = "Start"
        binding.startStopButton.icon = getDrawable(R.drawable.ic_play)
        timerStarted = false
    }

    private val updateTime: BroadcastReceiver = object : BroadcastReceiver()
    {
        override fun onReceive(context: Context, intent: Intent)
        {
            time = intent.getDoubleExtra(TimerService.TIME_EXTRA, 0.0)
            binding.timeTV.text = getTimeStringFromDouble(time)
        }
    }

    private fun getTimeStringFromDouble(time: Double): String
    {
        val resultInt = time.roundToInt()
        val hours = resultInt % 86400 / 3600
        val minutes = resultInt % 86400 % 3600 / 60
        val seconds = resultInt % 86400 % 3600 % 60

        return makeTimeString(hours, minutes, seconds)
    }

    private fun makeTimeString(hour: Int, min: Int, sec: Int): String = String.format("%02d:%02d:%02d", hour, min, sec)
}