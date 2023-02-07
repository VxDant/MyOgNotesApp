package com.example.notesapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.notesapp.R
import com.example.notesapp.data.local.model.Notes
import com.example.notesapp.databinding.FragmentCreateBinding
import com.example.notesapp.utils.AppConstants
import com.example.notesapp.viewmodels.HomeFragmentViewModel
import java.text.SimpleDateFormat
import java.util.*


class CreateFragment : Fragment() {

    lateinit var binding: FragmentCreateBinding

    val viewModel by viewModels<HomeFragmentViewModel>()

    var priorityColour = AppConstants.lowPriority


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreateBinding.inflate(inflater, container, false)

        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Create Note"

        binding.greenColour.setImageResource(R.drawable.ic_baseline_done_24)

        binding.greenColour.setOnClickListener {

            priorityColour = AppConstants.lowPriority

            binding.greenColour.setImageResource(R.drawable.save_notes)
            binding.yellowColour.setImageResource(0)
            binding.redColour.setImageResource(0)

        }

        binding.yellowColour.setOnClickListener {

            priorityColour = AppConstants.mediumPriority

            binding.yellowColour.setImageResource(R.drawable.ic_baseline_done_24)
            binding.redColour.setImageResource(0)
            binding.greenColour.setImageResource(0)

        }


        binding.redColour.setOnClickListener {

            priorityColour = AppConstants.highPriority

            binding.redColour.setImageResource(R.drawable.save_notes)
            binding.yellowColour.setImageResource(0)
            binding.greenColour.setImageResource(0)

        }



        binding.btnSaveNotes.setOnClickListener {
            createNotes(it)


        }
        // Inflate the layout for this fragment
        return binding.root
    }

    private fun createNotes(it: View?) {

        var title = binding.etTitle.text.toString()
        var subTitle = binding.etSubtitle.text.toString()
        var body = binding.etDescription.text.toString()

        val formatter = SimpleDateFormat("yyyy-MM-dd")
        val date = Date()
        val current = formatter.format(date)

        try {

            viewModel.addNotes(Notes(null, title, subTitle, body, current, priorityColour)).let {
                Toast.makeText(requireContext(), "Notes added Successfully ", Toast.LENGTH_SHORT)
                    .show()

            }

            Navigation.findNavController(it!!).navigate(R.id.action_createFragment_to_homeFragment)


        } catch (e: Exception) {
            Toast.makeText(requireContext(), "cannot add a note $e.toString()", Toast.LENGTH_SHORT)
                .show()
        }


    }

}