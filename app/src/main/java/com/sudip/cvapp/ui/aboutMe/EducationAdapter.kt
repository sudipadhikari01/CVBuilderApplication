package com.sudip.cvapp.ui.aboutMe

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sudip.cvapp.R
import com.sudip.cvapp.data.Education

class EducationAdapter(
    private val educationList: MutableList<Education> = mutableListOf()
) : RecyclerView.Adapter<EducationAdapter.EducationViewHolder>(){

    inner class EducationViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        fun bind(education: Education) {
            val collegeNameTxt: TextView = view.findViewById(R.id.college_name_text_view)
            val programNameTxt: TextView = view.findViewById(R.id.program_name_text_view)
            val logo: ImageView = view.findViewById(R.id.logo_image_view)

            collegeNameTxt.text = education.collegeName
            programNameTxt.text = education.program

            Glide.with(view.context).load(education.logo).into(logo)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EducationViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_education, parent, false)
        return EducationViewHolder(view)
    }

    override fun onBindViewHolder(holder: EducationViewHolder, position: Int) {
        holder.bind(educationList[position])
    }

    override fun getItemCount(): Int = educationList.size
}