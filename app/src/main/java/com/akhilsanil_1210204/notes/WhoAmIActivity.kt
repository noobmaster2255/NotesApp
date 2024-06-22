package com.akhilsanil_1210204.notes

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class WhoAmIActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_who_am_i_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.me_detail)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val studentName: TextView = findViewById(R.id.textViewStudNameDetail)
        val studentNumber: TextView = findViewById(R.id.textViewStudNumberDetail)

        studentName.text = "Akhil Sanil"
        studentNumber.text = "1210204"
        val goBackBtn = findViewById<Button>(R.id.goBackBtn)
        goBackBtn.setOnClickListener { finish() }
    }
}