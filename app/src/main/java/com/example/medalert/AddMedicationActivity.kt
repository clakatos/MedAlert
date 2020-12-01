package com.example.medalert

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.io.File
import java.io.FileWriter
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class AddMedicationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_medication)

        val medImage: LinearLayout = findViewById(R.id.medImage)
        medImage.setOnClickListener {
            //dispatchTakePictureIntent()
        }

        ////////DOSAGE SPINNER////////////
        val spinner: Spinner = findViewById(R.id.dosageSpinner)
        ArrayAdapter.createFromResource(
            this,
            R.array.dosage_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }
        /////////////////////////////////

        /////////TEXT AUTOCOMPLETE FOR MEDICATIONS//////////////////////

        // Get a reference to the AutoCompleteTextView in the layout
        val textView = findViewById<AutoCompleteTextView>(R.id.medNameEdit)
        // Get the string array
        val dosages: Array<out String> = resources.getStringArray(R.array.medications_array)
        // Create the adapter and set it to the AutoCompleteTextView
        ArrayAdapter(this, android.R.layout.simple_list_item_1, dosages).also { adapter ->
            textView.setAdapter(adapter)
        }

        /////////////////////////////////////////////////////////////////

        val saveIcon: ImageView = findViewById(R.id.addMedicationIcon)

        saveIcon.setOnClickListener {
            val medicationName: EditText = textView
            val dosage: EditText = findViewById(R.id.dosageEdit)
            val dosageAmt: Spinner = spinner
            val startDate: EditText = findViewById(R.id.startEdit)
            val endDate: EditText = findViewById(R.id.endEdit)
            val doctor: EditText = findViewById(R.id.doctorEdit)
            val directions: EditText = findViewById(R.id.directionsEdit)

            var fileName = "medList.txt"
            var fileWrite : FileWriter
            var file : File = File("sdcard/Documents/${fileName}")


            if (File("sdcard/Documents/${fileName}").exists()) {

                file.appendText(medicationName.text.toString() + "\n")
                file.appendText(dosage.text.toString() + "\n")
                file.appendText(dosageAmt.selectedItem.toString() + "\n")
                file.appendText(startDate.text.toString() + "\n")
                file.appendText(endDate.text.toString() + "\n")
                file.appendText(doctor.text.toString() + "\n")
                file.appendText(directions.text.toString() + "\n")

            } else {

                fileWrite = FileWriter(File("sdcard/Documents/${fileName}"))

                fileWrite.write(medicationName.text.toString() + "\n")
                fileWrite.write(dosage.text.toString() + "\n")
                fileWrite.write(dosageAmt.selectedItem.toString() + "\n")
                fileWrite.write(startDate.text.toString() + "\n")
                fileWrite.write(endDate.text.toString() + "\n")
                fileWrite.write(doctor.text.toString() + "\n")
                fileWrite.write(directions.text.toString() + "\n")

                fileWrite.close()
            }

            val intent = Intent(this, MedicationsActivity::class.java)
            startActivity(intent)
        }
    }

}
