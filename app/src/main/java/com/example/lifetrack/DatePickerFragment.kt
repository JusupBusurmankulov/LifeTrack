package com.example.lifetrack

import android.app.DatePickerDialog
import android.content.Context
import android.icu.util.Calendar
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import androidx.annotation.RequiresApi
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.setFragmentResult
import com.example.lifetrack.databinding.FragmentDatePickerBinding

class DatePickerFragment() : DialogFragment() {
    lateinit var binding:FragmentDatePickerBinding

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDatePickerBinding.inflate(layoutInflater)
        return binding.root
       setupCalendar()
    }

    private fun setupCalendar() {
        binding.calendar.setOnDateChangeListener{view, year, month, dayOfMonth->
            val msg =  "" + dayOfMonth + "." + (month + 1) + "." + year
            val bundle = Bundle()
            bundle.putString("key", msg.toString())
            setFragmentResult("myKey", bundle)
        }

    }





}