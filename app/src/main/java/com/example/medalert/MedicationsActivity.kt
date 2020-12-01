package com.example.medalert

import android.content.Intent
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import java.io.File
import java.io.FileWriter
import java.io.IOException
import java.io.Serializable
import java.lang.Exception

class MedicationsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_medications)

//        try {
//            var textFile = File("sdcard/Documents/medList.txt")
//
//            textFile.delete()
//
//        } catch (e : Exception){
//
//        }


        val addMed_icon: ImageView = findViewById(R.id.addMedicationIcon)
        addMed_icon.setOnClickListener {
            openAddMedicationActivity()
        }

        val back_icon: ImageView = findViewById(R.id.backArrow)
        back_icon.setOnClickListener() {
            openHome()
        }

        generateMedicationsList()

        val remove_icon1 : ImageView = findViewById(R.id.removeMedIcon1)
        val remove_icon2 : ImageView = findViewById(R.id.removeMedIcon2)
        val remove_icon3 : ImageView = findViewById(R.id.removeMedIcon3)

        remove_icon1.setOnClickListener() {
            val medListItem1 : View = findViewById(R.id.medItem1)
            medListItem1.visibility = View.INVISIBLE
        }

        remove_icon2.setOnClickListener() {
            val medListItem2 : View = findViewById(R.id.medItem2)
            medListItem2.visibility = View.INVISIBLE
        }

        remove_icon3.setOnClickListener() {
            val medListItem3 : View = findViewById(R.id.medItem3)
            medListItem3.visibility = View.INVISIBLE
        }

    }

    private fun generateMedicationsList() {

        var medTextListArray = arrayListOf<String>()

        val medListItem1 : View = findViewById(R.id.medItem1)
        medListItem1.visibility = View.INVISIBLE
        val medListItem2 : View = findViewById(R.id.medItem2)
        medListItem2.visibility = View.INVISIBLE
        val medListItem3 : View = findViewById(R.id.medItem3)
        medListItem3.visibility = View.INVISIBLE

        if (File("sdcard/Documents/medList.txt").exists()) {

            File("sdcard/Documents/medList.txt").forEachLine {
                medTextListArray.add(it)
            }

            if(medTextListArray.size == 7) {

                medListItem1.visibility = View.VISIBLE

                val medNameText : TextView = findViewById(R.id.medName1)
                medNameText.text = medTextListArray[0]

                val dosageText : TextView = findViewById(R.id.dosageText1)
                dosageText.text = medTextListArray[1].toString()

                val dosageAmountText : TextView = findViewById(R.id.dosageAmountText1)
                dosageAmountText.text = medTextListArray[2]

                val startDate : TextView = findViewById(R.id.startDateText1)
                startDate.text = medTextListArray[3]

                val endDate : TextView = findViewById(R.id.endDateText1)
                endDate.text = medTextListArray[4]

                val doctorText : TextView = findViewById(R.id.doctorText1)
                doctorText.text = medTextListArray[5]

                val directionText : TextView = findViewById(R.id.directionText1)
                directionText.text = medTextListArray[6]

                val remove_icon1 : ImageView = findViewById(R.id.removeMedIcon1)


            } else if(medTextListArray.size == 14) {

                medListItem1.visibility = View.VISIBLE

                val medNameText : TextView = findViewById(R.id.medName1)
                medNameText.text = medTextListArray[0]

                val dosageText : TextView = findViewById(R.id.dosageText1)
                dosageText.text = medTextListArray[1].toString()

                val dosageAmountText : TextView = findViewById(R.id.dosageAmountText1)
                dosageAmountText.text = medTextListArray[2]

                val startDate : TextView = findViewById(R.id.startDateText1)
                startDate.text = medTextListArray[3]

                val endDate : TextView = findViewById(R.id.endDateText1)
                endDate.text = medTextListArray[4]

                val doctorText : TextView = findViewById(R.id.doctorText1)
                doctorText.text = medTextListArray[5]

                val directionText : TextView = findViewById(R.id.directionText1)
                directionText.text = medTextListArray[6]

                medListItem2.visibility = View.VISIBLE

                val medNameText2 : TextView = findViewById(R.id.medName2)
                medNameText2.text = medTextListArray[7]

                val dosageText2 : TextView = findViewById(R.id.dosageText2)
                dosageText2.text = medTextListArray[8].toString()

                val dosageAmountText2 : TextView = findViewById(R.id.dosageAmountText2)
                dosageAmountText2.text = medTextListArray[9]

                val startDate2 : TextView = findViewById(R.id.startDateText2)
                startDate2.text = medTextListArray[10]

                val endDate2 : TextView = findViewById(R.id.endDateText2)
                endDate2.text = medTextListArray[11]

                val doctorText2 : TextView = findViewById(R.id.doctorText2)
                doctorText2.text = medTextListArray[12]

                val directionText2 : TextView = findViewById(R.id.directionText2)
                directionText2.text = medTextListArray[13]

            } else {

                medListItem1.visibility = View.VISIBLE

                val medNameText : TextView = findViewById(R.id.medName1)
                medNameText.text = medTextListArray[0]

                val dosageText : TextView = findViewById(R.id.dosageText1)
                dosageText.text = medTextListArray[1].toString()

                val dosageAmountText : TextView = findViewById(R.id.dosageAmountText1)
                dosageAmountText.text = medTextListArray[2]

                val startDate : TextView = findViewById(R.id.startDateText1)
                startDate.text = medTextListArray[3]

                val endDate : TextView = findViewById(R.id.endDateText1)
                endDate.text = medTextListArray[4]

                val doctorText : TextView = findViewById(R.id.doctorText1)
                doctorText.text = medTextListArray[5]

                val directionText : TextView = findViewById(R.id.directionText1)
                directionText.text = medTextListArray[6]

                medListItem2.visibility = View.VISIBLE

                val medNameText2 : TextView = findViewById(R.id.medName2)
                medNameText2.text = medTextListArray[7]

                val dosageText2 : TextView = findViewById(R.id.dosageText2)
                dosageText2.text = medTextListArray[8].toString()

                val dosageAmountText2 : TextView = findViewById(R.id.dosageAmountText2)
                dosageAmountText2.text = medTextListArray[9]

                val startDate2 : TextView = findViewById(R.id.startDateText2)
                startDate2.text = medTextListArray[10]

                val endDate2 : TextView = findViewById(R.id.endDateText2)
                endDate2.text = medTextListArray[11]

                val doctorText2 : TextView = findViewById(R.id.doctorText2)
                doctorText2.text = medTextListArray[12]

                val directionText2 : TextView = findViewById(R.id.directionText2)
                directionText2.text = medTextListArray[13]

                medListItem3.visibility = View.VISIBLE

                val medNameText3 : TextView = findViewById(R.id.medName3)
                medNameText3.text = medTextListArray[14]

                val dosageText3 : TextView = findViewById(R.id.dosageText3)
                dosageText3.text = medTextListArray[15].toString()

                val dosageAmountText3 : TextView = findViewById(R.id.dosageAmountText3)
                dosageAmountText3.text = medTextListArray[16]

                val startDate3 : TextView = findViewById(R.id.startDateText3)
                startDate3.text = medTextListArray[17]

                val endDate3 : TextView = findViewById(R.id.endDateText3)
                endDate3.text = medTextListArray[18]

                val doctorText3 : TextView = findViewById(R.id.doctorText3)
                doctorText3.text = medTextListArray[19]

                val directionText3 : TextView = findViewById(R.id.directionText3)
                directionText3.text = medTextListArray[20]

            }
        }


        
    }


    private fun openAddMedicationActivity() {
        var intent = Intent(this, AddMedicationActivity::class.java)
        startActivity(intent)
    }

    private fun openHome() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

}



