package com.example.medalert

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.io.Serializable

class MedicationsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_medications)

        val addMed_icon: ImageView = findViewById(R.id.addMedicationIcon)
        addMed_icon.setOnClickListener {
            openAddMedicationActivity()
        }
        generateMedicationsList()
    }

    private var medicationsList: List<Medication>? = ArrayList()

    private inline fun <reified T : Any> List<*>.checkItemsAre() =
            if (all { it is T })
                this as List<T>
            else null

    private fun generateMedicationsList() {
        val mutation = intent.getSerializableExtra("medlist") as ArrayList<*>?
        val medicationsList = mutation?.checkItemsAre<Medication>()

        if (medicationsList != null) {
            if (medicationsList.isNotEmpty()) {
                val medNameText: TextView = findViewById(R.id.medName1)
                medNameText.text = medicationsList[0].medName
            }
        }
    }

    private fun openAddMedicationActivity() {
        val intent = Intent(this, AddMedicationActivity::class.java)
        intent.putExtra("MedList", medicationsList as ArrayList<Medication>)
        startActivity(intent)
    }

    data class Medication(val medName: String, val dosage: Int, val dosageMsmt: String, val startDate: String, val endDate: String, val doctor: String, val directions: String) : Serializable
}

