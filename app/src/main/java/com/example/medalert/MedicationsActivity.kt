package com.example.medalert

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView

class MedicationsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_medications)

        val addedMed = false

        val addMed_icon : ImageView = findViewById(R.id.addMedicationIcon)
        addMed_icon.setOnClickListener {
            !addedMed
            openAddMedicationActivity()
        }


        //Log.d("INFO", findViewById(R.id.medNameEdit))
        //val medNameText : TextView = findViewById(R.id.medNameEdit)
        //val medNameElementBlock : TextView = findViewById(R.id.medNameText)
        //medNameElementBlock.setText(medNameText.text.toString())

    }

    private fun openAddMedicationActivity() {
        val intent = Intent(this, AddMedicationActivity::class.java)
        startActivity(intent)
    }

}