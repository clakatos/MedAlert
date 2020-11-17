package com.example.medalert

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
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

        val back_icon : ImageView = findViewById(R.id.backArrow)
        back_icon.setOnClickListener() {
            openHome()
        }

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

                val dosageText : TextView = findViewById(R.id.dosageText1)
                dosageText.text = medicationsList[0].dosage.toString()

                val dosageAmountText : TextView = findViewById(R.id.dosageAmountText1)
                dosageAmountText.text = medicationsList[0].dosageMsmt

                val startDate : TextView = findViewById(R.id.startDateText1)
                startDate.text = medicationsList[0].startDate

                val endDate : TextView = findViewById(R.id.endDateText1)
                endDate.text = medicationsList[0].endDate
            }
        }
    }

    private fun openAddMedicationActivity() {
        val intent = Intent(this, AddMedicationActivity::class.java)
        intent.putExtra("MedList", medicationsList as ArrayList<Medication>)
        startActivity(intent)
    }

    private fun openHome() {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("MedList", medicationsList as ArrayList<Medication>)
        startActivity(intent)
    }

    data class Medication(val medName: String, val dosage: Int, val dosageMsmt: String, val startDate: String, val endDate: String, val doctor: String, val directions: String) : Serializable
}

