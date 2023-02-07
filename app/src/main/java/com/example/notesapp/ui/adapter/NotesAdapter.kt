package com.example.notesapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.R
import com.example.notesapp.data.local.model.Notes
import com.example.notesapp.databinding.ItemNotesBinding
import com.example.notesapp.ui.fragment.HomeFragmentDirections

class NotesAdapter(val context: Context, val notesList: List<Notes>) :
    RecyclerView.Adapter<NotesAdapter.MyViewHolder>() {

    class MyViewHolder(val itemBinding: ItemNotesBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        val title = itemBinding.title
        val subtitle = itemBinding.subTitle
        val date = itemBinding.date
        val viewPriority = itemBinding.viewPriority

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemBinding =
            ItemNotesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = notesList[position]

        holder.title.text = data.title.toString()
        holder.subtitle.text = data.subtitle.toString()
        holder.date.text = data.date.toString()

        when(data.priority){
            "1" ->  { holder.viewPriority.setBackgroundResource(R.drawable.green_dot)}
            "2" -> {holder.viewPriority.setBackgroundResource(R.drawable.yellow_dot)}
            "3" -> {holder.viewPriority.setBackgroundResource(R.drawable.red_dot)}

        }

        holder.itemBinding.root.setOnClickListener {

            val action = HomeFragmentDirections.actionHomeFragmentToEditNotesFragment(data)

            Navigation.findNavController(it).navigate(action)



        }

    }

    override fun getItemCount(): Int {
        return notesList.size
    }


}