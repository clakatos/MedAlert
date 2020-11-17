package com.example.medalert

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class AddMedicationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_medication)

        val medImage: LinearLayout = findViewById(R.id.medImage)
        medImage.setOnClickListener {
            dispatchTakePictureIntent()
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

        val medicationsList: ArrayList<MedicationsActivity.Medication> =
                intent.getSerializableExtra("MedList") as ArrayList<MedicationsActivity.Medication>

        saveIcon.setOnClickListener {
            val medicationName: EditText = textView
            val dosage: EditText = findViewById(R.id.dosageEdit)
            val dosageAmt: Spinner = spinner
            val startDate: EditText = findViewById(R.id.startEdit)
            val endDate: EditText = findViewById(R.id.endEdit)
            val doctor: EditText = findViewById(R.id.doctorEdit)
            val directions: EditText = findViewById(R.id.directionsEdit)

            val intent = Intent(this, MedicationsActivity::class.java)

            medicationsList.add(
                    MedicationsActivity.Medication(
                            medicationName.text.toString(),
                            dosage.text.toString().toInt(),
                            dosageAmt.selectedItem.toString(),
                            startDate.text.toString(),
                            endDate.text.toString(),
                            doctor.text.toString(),
                            directions.text.toString()
                    )
            )

            intent.putExtra("medlist", medicationsList)

            startActivity(intent)
        }
    }

    private fun getMedicationInfo(): Unit? {
        return null
    }

    val REQUEST_IMAGE_CAPTURE = 1

    private fun dispatchTakePictureIntent() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        try {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
        } catch (e: ActivityNotFoundException) {
            // display error state to the user
        }
        //createImageFile()
    }

    lateinit var currentPhotoPath: String

    @Throws(IOException::class)
    private fun createImageFile(): File {
        // Create an image file name
        val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val storageDir: File? = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile(
            "JPEG_${timeStamp}_", /* prefix */
            ".jpg", /* suffix */
            storageDir /* directory */
        ).apply {
            // Save a file: path for use with ACTION_VIEW intents
            currentPhotoPath = absolutePath
        }
    }



//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
//            val imageBitmap = data.extras.get("data") as Bitmap
//            ImageView.setImageBitmap(imageBitmap)
//        }
//    }


}
