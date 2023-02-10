package com.example.notesapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.notesapp.R
import com.example.notesapp.ui.`interface`.FirebaseInstanceChecker

class MainActivity : AppCompatActivity(), FirebaseInstanceChecker {
    var isFlag :  Boolean  = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun isFirebase(isFlag: Boolean) {
        this.isFlag = isFlag
    }
}