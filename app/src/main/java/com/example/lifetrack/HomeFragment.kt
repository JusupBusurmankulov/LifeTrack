package com.example.lifetrack

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lifetrack.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
   lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClicker()
    }

    private fun initClicker() {
        with(binding){
            fabAdd.setOnClickListener{
                val dialog = CreateTaskFragment()
                dialog.show(requireActivity().supportFragmentManager, "")
            }


        }
    }


}