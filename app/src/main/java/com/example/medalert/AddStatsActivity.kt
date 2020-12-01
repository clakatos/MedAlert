package com.example.medalert

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add_stats.*
import java.io.File
import java.io.FileWriter

class AddStatsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_stats)

        val saveIcon : ImageView = findViewById(R.id.addStatsIcon)

        saveIcon.setOnClickListener() {

            val userName: EditText = findViewById(R.id.nameText)
            val ageText : EditText = findViewById(R.id.ageText)
            val weightText : EditText = findViewById(R.id.weightText)


            var fileName = "stats.txt"
            var fileWrite : FileWriter
            var file : File = File("sdcard/Documents/${fileName}")

            fileWrite = FileWriter(File("sdcard/Documents/${fileName}"))

            fileWrite.write(userName.text.toString() + "\n")
            fileWrite.write(ageText.text.toString() + "\n")
            fileWrite.write(weightText.text.toString() + "\n")

            fileWrite.close()

            val intent = Intent(this, StatsActivity::class.java)
            startActivity(intent)
        }

    }
}