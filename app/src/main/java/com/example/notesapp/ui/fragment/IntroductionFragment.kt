package com.example.notesapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.example.notesapp.R
import com.example.notesapp.databinding.FragmentIntroductionBinding
import com.example.notesapp.ui.MainActivity


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

        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Introduction Page"


        binding.tvGuest.setOnClickListener {
            (requireActivity() as MainActivity).isFirebase(false)
            Navigation.findNavController(it).navigate(R.id.action_introductionFragment_to_homeFragment)
        }
        binding.tvSignIn.setOnClickListener {
            (requireActivity() as MainActivity).isFirebase(true)
            Navigation.findNavController(it).navigate(R.id.action_introductionFragment_to_signInFragment)
        }
        return binding.root
    }

}