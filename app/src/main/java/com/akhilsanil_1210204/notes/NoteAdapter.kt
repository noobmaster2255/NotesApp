package com.akhilsanil_1210204.notes

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoteAdapter(private val context: Context, private val notes: List<NoteClass>) :
    RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewNoteTitle: TextView = itemView.findViewById(R.id.textViewNoteTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteAdapter.NoteViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.note_recycler_view_item, parent, false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteAdapter.NoteViewHolder, position: Int) {
        val note = notes[position]
        // change colour if priority is high
        if (note.priority == "high") {
            holder.textViewNoteTitle.setBackgroundColor(Color.parseColor("#eb9f88"))
        }
        holder.textViewNoteTitle.text = note.title
        // On clicking the button note detail page will be loaded and display items
        holder.textViewNoteTitle.setOnClickListener {
            val intent = Intent(context, NoteDetailActivity::class.java)
            intent.putExtra(NOTE_TITLE_KEY, note.title)
            intent.putExtra(NOTE_DESC, note.description)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    companion object {
        const val NOTE_TITLE_KEY = "NOTE_TITLE"
        const val NOTE_DESC = "NOTE_DESC"
    }
}