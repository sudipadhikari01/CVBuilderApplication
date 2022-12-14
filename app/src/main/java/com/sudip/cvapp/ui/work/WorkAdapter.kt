package com.sudip.cvapp.ui.work

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sudip.cvapp.R


import com.sudip.cvapp.data.Work

class WorkAdapter(
    private val workList: MutableList<Work> = mutableListOf()
) : RecyclerView.Adapter<WorkAdapter.WorkViewHolder>(){

    inner class WorkViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        fun bind(work: Work) {
            val logoImageView: ImageView = view.findViewById(R.id.logo_image_view)
            val companyNameTextView: TextView = view.findViewById(R.id.company_name_text_view)
            val durationTextView: TextView = view.findViewById(R.id.duration_text_view)
            val locationTextView: TextView = view.findViewById(R.id.location_text_view)
            val rolesTextView: TextView = view.findViewById(R.id.roles_text_view)

            Glide.with(view.context).load(work.logo).into(logoImageView)
            companyNameTextView.text = work.companyName
            durationTextView.text = work.fromDate + " - " + work.toDate
            locationTextView.text = work.location
            rolesTextView.text = work.roles
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_work, parent, false)
        return WorkViewHolder(view)
    }

    override fun onBindViewHolder(holder: WorkViewHolder, position: Int) {
        holder.bind(workList[position])
    }

    override fun getItemCount(): Int = workList.size
}