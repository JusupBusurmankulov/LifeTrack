package com.example.lifetrack

import android.app.Dialog
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.PorterDuff
import android.icu.text.SimpleDateFormat
import android.icu.util.Calendar
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import com.example.lifetrack.databinding.FragmentCreateTaskBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.util.*


class CreateTaskFragment : BottomSheetDialogFragment() {
    @RequiresApi(Build.VERSION_CODES.N)
    var cal = Calendar.getInstance()
    lateinit var binding: FragmentCreateTaskBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreateTaskBinding.inflate(layoutInflater)
        return binding.root
    }


    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bottomSheet = view.parent as View
        bottomSheet.backgroundTintMode = PorterDuff.Mode.CLEAR
        bottomSheet.backgroundTintList = ColorStateList.valueOf(Color.TRANSPARENT)
        bottomSheet.setBackgroundColor(Color.TRANSPARENT)
        initClicker()

    }




    @RequiresApi(Build.VERSION_CODES.N)
    private fun initClicker() {
        binding.btnCalendar.setOnClickListener {
            val datePickerFragment = DatePickerFragment()
            requireActivity().supportFragmentManager.setFragmentResultListener(
                "myKey",
                viewLifecycleOwner
            ) { resultKey, bundle ->
                if (resultKey == "myKey") {
                    val date = bundle.getString("key")
                    binding.btnCalendar.text = date

                }
            }
            datePickerFragment.show(requireActivity().supportFragmentManager, "TAG")

        }
        binding.btnRegular.setOnClickListener {
            showRegularDialog()
        }


    }

    private fun showRegularDialog() {
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.regular_dialog)
        dialog.show()

        val inflater = LayoutInflater.from(context)
        val registrationDialog: View = inflater.inflate(R.layout.regular_dialog, null)
        dialog.setContentView(registrationDialog)

        val tvCancel: TextView = registrationDialog.findViewById(R.id.tv_stop)
        tvCancel.setOnClickListener {
            dialog.dismiss()
        }

    }


}







