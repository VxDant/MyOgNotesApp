package com.example.notesapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.notesapp.data.local.database.NotesDatabase
import com.example.notesapp.data.local.model.Notes
import com.example.notesapp.repository.NotesRepository
import kotlinx.coroutines.launch

class HomeFragmentViewModel(application: Application) : AndroidViewModel(application) {

    private val notesDao = NotesDatabase.getDatabase(application.applicationContext).notesDao()

    val repository: NotesRepository

    init {
        val dao = NotesDatabase.getDatabase(application).notesDao()
        repository = NotesRepository(dao)
    }


    fun addNotes(notes: Notes) {
        viewModelScope.launch {

            repository.insertNotes(notes)

        }
    }


    fun getNotes(): LiveData<List<Notes>> = repository.getAllNotes()

    fun getFilteredPriorityNotes(priorityConstant: String): LiveData<List<Notes>> = repository.getFilteredPriorityNotes(priorityConstant)

    fun deleteNotes(id: Int) {
        repository.deleteNotes(id)
    }

    fun updateNotes(notes: Notes) {

        viewModelScope.launch {
            repository.updateNotes(notes)


        }
    }

}