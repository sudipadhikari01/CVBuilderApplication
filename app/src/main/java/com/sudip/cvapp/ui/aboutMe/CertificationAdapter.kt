package com.sudip.cvapp.ui.aboutMe

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sudip.cvapp.R



import com.sudip.cvapp.data.Certification

class CertificationAdapter(
    private val certificationList: MutableList<Certification> = mutableListOf()
) : RecyclerView.Adapter<CertificationAdapter.CertificationViewHolder>(){

    inner class CertificationViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        fun bind(certification: Certification) {
            val nameTextView: TextView = view.findViewById(R.id.certificate_name_text_view)
            val logoImageView: ImageView = view.findViewById(R.id.logo_image_view)

            nameTextView.text = certification.name
            Glide.with(view.context).load(certification.logo).into(logoImageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CertificationViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_certification, parent, false)
        return CertificationViewHolder(view)
    }

    override fun onBindViewHolder(holder: CertificationViewHolder, position: Int) {
        holder.bind(certificationList[position])
    }

    override fun getItemCount(): Int = certificationList.size
}