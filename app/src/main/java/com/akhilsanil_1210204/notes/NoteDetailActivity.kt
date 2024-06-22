package com.akhilsanil_1210204.notes

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class NoteDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_note_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.note_detail)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val textViewNoteDetail: TextView = findViewById(R.id.textViewNoteTitleDetail)
        val textViewNoteDescDetail: TextView = findViewById(R.id.textViewNoteDescDetail)
        val noteTitle = intent.getStringExtra(NoteAdapter.NOTE_TITLE_KEY)
        val noteDesc = intent.getStringExtra(NoteAdapter.NOTE_DESC)
        textViewNoteDetail.text = noteTitle
        textViewNoteDescDetail.text = noteDesc

        val backBtn = findViewById<Button>(R.id.goBackBtn)
        backBtn.setOnClickListener { finish() }
    }
}