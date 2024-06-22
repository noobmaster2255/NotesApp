package com.akhilsanil_1210204.notes

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var noteTitleText: EditText
    private lateinit var noteDescText: EditText
    private lateinit var notePriorityText: EditText
    private lateinit var recyclerViewNotes: RecyclerView
    private lateinit var addBtn: Button
    private lateinit var whoAmIBtn: Button
    private var noteList = mutableListOf<NoteClass>()
    private lateinit var adapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        noteTitleText = findViewById(R.id.noteTitleText)
        noteDescText = findViewById(R.id.noteDescText)
        notePriorityText = findViewById(R.id.notePriorityText)
        recyclerViewNotes = findViewById(R.id.note_recyclerview)
        addBtn = findViewById(R.id.addNoteBtn)
        whoAmIBtn = findViewById(R.id.whoAmIBtn)

        adapter = NoteAdapter(this, noteList)
        recyclerViewNotes.adapter = adapter
        recyclerViewNotes.layoutManager = LinearLayoutManager(this)

        // show who am i
        whoAmIBtn.setOnClickListener {
            val intent = Intent(this, WhoAmIActivity::class.java)
            startActivity(intent)
        }

        // add notes to the list
        addBtn.setOnClickListener {
            val note = NoteClass()
            note.title = noteTitleText.text.toString()
            note.description = noteDescText.text.toString()
            note.priority = notePriorityText.text.toString()

            if (noteTitleText.text.toString().isNotEmpty() && noteDescText.text.toString()
                    .isNotEmpty() && notePriorityText.text.toString().isNotEmpty()
            ) {
                noteList.add(note)
                adapter.notifyItemInserted(noteList.size - 1)
                noteTitleText.text.clear()
                noteDescText.text.clear()
                notePriorityText.text.clear()
            } else {
                Toast.makeText(this, "All field are required", Toast.LENGTH_SHORT).show()
            }
        }
    }
}