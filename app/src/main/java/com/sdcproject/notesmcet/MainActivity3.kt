package com.sdcproject.notesmcet

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.sdcproject.notesmcet.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {
    private lateinit var binding: ActivityMain3Binding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val nameTextView: TextView = findViewById(R.id.textView2)
        val hyperlinkTextView: TextView = findViewById(R.id.textView6)

        val name = intent.getStringExtra("name")
        val hyperlink = intent.getStringExtra("hyperlink")

        if (name != null) {
            nameTextView.text = name
        }

        if (name != null && hyperlink != null) {
            val text = "Link to $name"
            hyperlinkTextView.text = text
            hyperlinkTextView.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(hyperlink))
                startActivity(intent)
            }
        }


    }
}