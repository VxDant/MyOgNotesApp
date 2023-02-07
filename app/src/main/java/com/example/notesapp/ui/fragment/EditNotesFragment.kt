package com.example.notesapp.ui.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.notesapp.R
import com.example.notesapp.data.local.model.Notes
import com.example.notesapp.databinding.FragmentEditNotesBinding
import com.example.notesapp.utils.AppConstants
import com.example.notesapp.viewmodels.HomeFragmentViewModel
import java.text.SimpleDateFormat
import java.util.*

class EditNotesFragment : Fragment() {

    lateinit var binding: FragmentEditNotesBinding

    val args by navArgs<EditNotesFragmentArgs>()

    lateinit var priority: String

    val viewModel: HomeFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentEditNotesBinding.inflate(inflater, container, false)

        setHasOptionsMenu(true)


        val supportActionBar = (requireActivity() as AppCompatActivity).supportActionBar
        supportActionBar?.title = "Edit Note"

        binding.etTitle.setText(args.editNotesData.title)
        binding.etSubtitle.setText(args.editNotesData.subtitle)
        binding.etDescription.setText(args.editNotesData.notesBody)

        when (args.editNotesData.priority) {
            AppConstants.lowPriority -> {
                priority = AppConstants.lowPriority
                binding.greenColour.setImageResource(R.drawable.save_notes)
                binding.yellowColour.setImageResource(0)
                binding.redColour.setImageResource(0)
            }
            AppConstants.mediumPriority -> {
                priority = AppConstants.mediumPriority
                binding.yellowColour.setImageResource(R.drawable.ic_baseline_done_24)
                binding.redColour.setImageResource(0)
                binding.greenColour.setImageResource(0)

            }
            AppConstants.highPriority -> {

                priority = AppConstants.highPriority
                binding.redColour.setImageResource(R.drawable.save_notes)
                binding.yellowColour.setImageResource(0)
                binding.greenColour.setImageResource(0)
            }

        }

        binding.greenColour.setOnClickListener {

            priority = AppConstants.lowPriority

            binding.greenColour.setImageResource(R.drawable.save_notes)
            binding.yellowColour.setImageResource(0)
            binding.redColour.setImageResource(0)

        }

        binding.yellowColour.setOnClickListener {

            priority = AppConstants.mediumPriority

            binding.yellowColour.setImageResource(R.drawable.ic_baseline_done_24)
            binding.redColour.setImageResource(0)
            binding.greenColour.setImageResource(0)

        }


        binding.redColour.setOnClickListener {

            priority = AppConstants.highPriority

            binding.redColour.setImageResource(R.drawable.save_notes)
            binding.yellowColour.setImageResource(0)
            binding.greenColour.setImageResource(0)

        }

        binding.btnSaveNotes.setOnClickListener {
            updateNotes(it)
        }


        return binding.root

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }



    private fun updateNotes(it: View?) {

        var title = binding.etTitle.text.toString()
        var subTitle = binding.etSubtitle.text.toString()
        var body = binding.etDescription.text.toString()

        val formatter = SimpleDateFormat("yyyy-MM-dd")
        val date = Date()
        val current = formatter.format(date)

        try {

            viewModel.updateNotes(
                Notes(
                    args.editNotesData.id,
                    title,
                    subTitle,
                    body,
                    current,
                    priority
                )
            ).let {
                Toast.makeText(requireContext(), "Notes added Successfully ", Toast.LENGTH_SHORT)
                    .show()

            }

            Navigation.findNavController(it!!)
                .navigate(R.id.action_editNotesFragment_to_homeFragment)


        } catch (e: Exception) {
            Toast.makeText(requireContext(), "cannot add a note $e.toString()", Toast.LENGTH_SHORT)
                .show()
        }


    }
}