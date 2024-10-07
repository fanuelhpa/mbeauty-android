package com.fandevv.mbeauty

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.fandevv.mbeauty.domain.Schedule

class ScheduleAdapter(private val listSchedule : List<Schedule>?)
    : Adapter<ScheduleAdapter.ScheduleViewHolder>() {

    inner class ScheduleViewHolder(val itemView: View)
        : ViewHolder(itemView){
            val txtName: TextView = itemView.findViewById(R.id.txt_name)
            val txtService: TextView = itemView.findViewById(R.id.txt_service)
            val txtDate: TextView = itemView.findViewById(R.id.txt_date)
            val txtHour: TextView = itemView.findViewById(R.id.txt_hour)
    }
    //Cria a vizualização
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.rv_schedules_item_list, parent, false)

        return ScheduleViewHolder(itemView)
    }
    //Retorna a quantidade de itens que precisam ser criados
    override fun getItemCount(): Int {
            if(listSchedule != null){
                return listSchedule.size
            }
            return 0
    }
    //Vincula os dados em cada item
    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) {

        if(listSchedule != null){
            val schedule = listSchedule[position]
            holder.txtName.text = schedule.user.name
            holder.txtService.text = schedule.service.name
            holder.txtDate.text = schedule.date
            holder.txtHour.text = schedule.hour
        }
    }
}