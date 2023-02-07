package com.example.notesapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.example.notesapp.R
import com.example.notesapp.databinding.FragmentHomeBinding
import com.example.notesapp.ui.adapter.NotesAdapter
import com.example.notesapp.utils.AppConstants
import com.example.notesapp.viewmodels.HomeFragmentViewModel


class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding

    val viewModel: HomeFragmentViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Home"
        binding.rcvAllNotes.layoutManager = GridLayoutManager(requireContext(), 2)


        binding.btnAddNotes.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_createFragment)
        }

        viewModel.getNotes().observe(viewLifecycleOwner) {


            binding.rcvAllNotes.adapter = NotesAdapter(context = requireContext(), it)


        }

        binding.highFilter.setOnClickListener {

            viewModel.getFilteredPriorityNotes(AppConstants.highPriority).observe(viewLifecycleOwner) {


                binding.rcvAllNotes.adapter = NotesAdapter(context = requireContext(), it)


            }

        }

        binding.mediumFilter.setOnClickListener {

            viewModel.getFilteredPriorityNotes(AppConstants.mediumPriority).observe(viewLifecycleOwner) {


                binding.rcvAllNotes.adapter = NotesAdapter(context = requireContext(), it)


            }

        }

        binding.lowFilter.setOnClickListener {

            viewModel.getFilteredPriorityNotes(AppConstants.lowPriority).observe(viewLifecycleOwner) {


                binding.rcvAllNotes.adapter = NotesAdapter(context = requireContext(), it)


            }

        }

        binding.allNotesFilter.setOnClickListener {
            viewModel.getNotes().observe(viewLifecycleOwner) {


                binding.rcvAllNotes.adapter = NotesAdapter(context = requireContext(), it)


            }
        }

        // Inflate the layout for this fragment
        return binding.root
    }


}