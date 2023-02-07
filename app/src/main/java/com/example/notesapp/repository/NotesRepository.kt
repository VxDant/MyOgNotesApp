package com.example.notesapp.repository

import androidx.lifecycle.LiveData
import com.example.notesapp.data.local.dao.NotesDao
import com.example.notesapp.data.local.model.Notes

class NotesRepository(val dao: NotesDao) {

    fun getAllNotes(): LiveData<List<Notes>> {
        return dao.getNotes()
    }

    fun getFilteredPriorityNotes(priorityConstant: String): LiveData<List<Notes>> {
        return dao.getFilteredPriorityNotes(priorityConstant)
    }

    suspend fun insertNotes(notes: Notes) {
        dao.insertNote(notes)
    }

    fun deleteNotes(id: Int) {
        dao.deleteNote(id)
    }

    suspend fun updateNotes(notes: Notes) {
        dao.updateNote(notes)
    }

}