package com.fandevv.mbeauty

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fandevv.mbeauty.api.MbeautyAPI
import com.fandevv.mbeauty.api.RetrofitHelper
import com.fandevv.mbeauty.domain.Schedule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private var returned: Response<List<Schedule>>? = null
    private var schedules: List<Schedule>? = null
    private lateinit var rvSchedules: RecyclerView

    private val retrofit by lazy {
        RetrofitHelper.retrofit
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //execute the function that brings the schedules
        CoroutineScope(Dispatchers.IO).launch {
            findSchedules()
            withContext(Dispatchers.Main){
                rvSchedules = findViewById(R.id.rv_schedules)
                rvSchedules.adapter = ScheduleAdapter(schedules)
                rvSchedules.layoutManager = LinearLayoutManager(this@MainActivity)
            }

        }
        //val lista = listOf("Fanuel","Marly")
    }

    private suspend fun findSchedules(){
        try {
            val mbeautyAPI = retrofit.create(MbeautyAPI::class.java)
            returned = mbeautyAPI.findSchedules()

        }catch(e: Exception){
            e.printStackTrace()
            Log.i("info_schedules", "error at retrieve")
        }

        if (returned != null){
            if(returned!!.isSuccessful){
                schedules = returned!!.body()
                for (item in schedules!!){
                    Log.i("info_schedules", item.user.name)
                }
            }
        }
    }
}