package com.sudip.cvapp.ui.aboutMe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.sudip.cvapp.R
import com.sudip.cvapp.data.Certification
import com.sudip.cvapp.data.Education
import com.sudip.cvapp.ui.aboutMe.CertificationAdapter

class AboutMeFragment : Fragment(R.layout.fragment_about_me) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initEducation(view)
        initCertification(view)
    }

    private fun initEducation(view: View) {
        val educationRecyclerView = view.findViewById<RecyclerView>(R.id.education_recycler_view)
        val adapter = EducationAdapter(Education.getEducationList())
        educationRecyclerView.adapter = adapter
    }

    private fun initCertification(view: View) {
        val certificationRecycler = view.findViewById<RecyclerView>(R.id.certification_recycler_view)
        val adapter = CertificationAdapter(Certification.getCertificateList())
        certificationRecycler.adapter = adapter
    }

    companion object {
        @JvmStatic
        fun newInstance() = AboutMeFragment()
    }
}