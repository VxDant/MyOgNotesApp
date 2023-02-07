package com.example.notesapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.notesapp.R
import com.example.notesapp.databinding.FragmentIntroductionBinding


class IntroductionFragment : Fragment() {

    lateinit var binding: FragmentIntroductionBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentIntroductionBinding.inflate(layoutInflater, container, false)

        binding.tvGuest.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_introductionFragment_to_homeFragment)
        }
        binding.tvSignIn.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_introductionFragment_to_signInFragment)
        }
        return binding.root
    }

}