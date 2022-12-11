package com.sudip.cvapp.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.TextView
import com.sudip.cvapp.R


import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.sudip.cvapp.constants.ConstantEnum

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var userNameTextView: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews(view)
    }

    private fun initViews(view: View) {
        val floatingAddButton = view.findViewById<FloatingActionButton>(R.id.floating_add_button)
        userNameTextView = view.findViewById(R.id.user_name_text_view)

        floatingAddButton.setOnClickListener {
            Snackbar.make(view, "Add Additional fields on home page", Snackbar.LENGTH_LONG).show()
        }

    }

    private fun initUserData() {
        val sharedPref = requireActivity().getSharedPreferences(ConstantEnum.SHARED_PREF_NAME.value, 0)
        val userName = sharedPref.getString(ConstantEnum.USER_NAME.value, "")
        val userEmail = sharedPref.getString(ConstantEnum.USER_EMAIL.value, "")

        userNameTextView.text = userName

    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}