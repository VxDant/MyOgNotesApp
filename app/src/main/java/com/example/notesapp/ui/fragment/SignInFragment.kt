package com.example.notesapp.ui.fragment

import android.os.Bundle
import android.text.Spannable
import android.text.Spanned.SPAN_INCLUSIVE_INCLUSIVE
import android.text.style.ForegroundColorSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.example.notesapp.R
import com.example.notesapp.databinding.FragmentSignInBinding
import com.example.notesapp.ui.`interface`.FirebaseInstanceChecker


class SignInFragment : Fragment()  {

    lateinit var binding: FragmentSignInBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = FragmentSignInBinding.inflate(layoutInflater, container, false)

        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Login page"


        binding.tvCreateAccount.setText("Don't have an Account? create account", TextView.BufferType.SPANNABLE)
        val spannableText = binding.tvCreateAccount.text as Spannable
        spannableText.setSpan(
            ForegroundColorSpan(resources.getColor(R.color.primary_button_background_color)),
            22, spannableText.length,
            SPAN_INCLUSIVE_INCLUSIVE
        )

        binding.tvCreateAccount.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_signInFragment_to_createAccountFragment)


        }
        // Inflate the layout for this fragment
        return binding.root
    }

}