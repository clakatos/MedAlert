package com.example.medalert

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import java.util.*
import kotlin.collections.ArrayList

class MedicationsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_medications)

        val addMed_icon : ImageView = findViewById(R.id.addMedicationIcon)
        addMed_icon.setOnClickListener {
            openAddMedicationActivity()
        }

        generateMedicationsList()

    }

    var medicationsList : ArrayList<Medication> = ArrayList()

    private fun generateMedicationsList() {



        if (medicationsList.size > 0) {
            medicationsList = intent.getSerializableExtra("medlist") as ArrayList<Medication>
            val medNameText : TextView = findViewById(R.id.medName1)

            medNameText.setText(medicationsList[0].medName)
        }



    }

    private fun openAddMedicationActivity() {

        val intent = Intent(this, AddMedicationActivity::class.java)
        intent.putExtra("MedList", medicationsList)

        startActivity(intent)
    }

    data class Medication (val medName : String, val dosage : Int, val dosageMsmt : String, val startDate : String, val endDate : String, val doctor : String, val directions : String){

    }

}

