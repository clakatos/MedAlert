package com.example.medalert

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.io.File
import java.util.*

class CalendarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)

        var medTextListArray = arrayListOf<String>()

        if (File("sdcard/Documents/medList.txt").exists()) {

            File("sdcard/Documents/medList.txt").forEachLine {
                medTextListArray.add(it)
            }
        }

        val medName1 : TextView = findViewById(R.id.medName1)
        val startDate1 : TextView = findViewById(R.id.startDateText1)
        val endDate1 : TextView = findViewById(R.id.endDateText1)

        val medName2 : TextView = findViewById(R.id.medName2)
        val startDate2 : TextView = findViewById(R.id.startDateText2)
        val endDate2 : TextView = findViewById(R.id.endDateText2)

        val medName3 : TextView = findViewById(R.id.medName3)
        val startDate3 : TextView = findViewById(R.id.startDateText3)
        val endDate3 : TextView = findViewById(R.id.endDateText3)

        medName1.text = medTextListArray[0]
        startDate1.text = medTextListArray[3] + "   -"
        endDate1.text = medTextListArray[4]
        medName2.text = medTextListArray[7]
        startDate2.text = medTextListArray[10] + "   -"
        endDate2.text = medTextListArray[11]
        medName3.text = medTextListArray[14]
        startDate3.text = medTextListArray[17] + "   -"
        endDate3.text = medTextListArray[18]
    }
}
