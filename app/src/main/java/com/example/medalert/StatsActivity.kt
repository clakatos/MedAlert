package com.example.medalert

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import java.io.File

class StatsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stats)

        val addStatIcon : ImageView = findViewById(R.id.addStatIcon)
        addStatIcon.setOnClickListener() {
            openAddStatsActivity()
        }

        val backArrow : ImageView = findViewById(R.id.backArrow)

        backArrow.setOnClickListener() {
            openHome()
        }

        val nameText : TextView = findViewById(R.id.nameText)
        val ageText : TextView = findViewById(R.id.ageText)
        val weightText : TextView = findViewById(R.id.weightText)
        val medText : TextView = findViewById(R.id.medicationsText)

        val medItem1 : View = findViewById(R.id.medicationsIcons1)
        val medItem2 : View = findViewById(R.id.medicationsIcons2)
        val medItem3 : View = findViewById(R.id.medicationsIcons3)

        medItem1.visibility = View.INVISIBLE
        medItem2.visibility = View.INVISIBLE
        medItem3.visibility = View.INVISIBLE
        medText.visibility = View.INVISIBLE

        val medText1 : TextView = findViewById(R.id.medListText1)
        val medText2 : TextView = findViewById(R.id.medListText2)
        val medText3 : TextView = findViewById(R.id.medListText3)

        val statFile = "stats.txt"

        if (File("sdcard/Documents/${statFile}").exists()) {

            var statTextArray = arrayListOf<String>()

            File("sdcard/Documents/stats.txt").forEachLine {
                statTextArray.add(it)
            }

            nameText.text = "Name: " + statTextArray[0]
            ageText.text = "Age: " + statTextArray[1]
            weightText.text = "Weight: " + statTextArray[2]

        }

        var medListTextArray = arrayListOf<String>()

        val fileName = "medList.txt"

        if (File("sdcard/Documents/${fileName}").exists()) {

            if (File("sdcard/Documents/${statFile}").exists()) {

                File("sdcard/Documents/medList.txt").forEachLine {
                    medListTextArray.add(it)
                }

                medText.visibility = View.VISIBLE
                medItem1.visibility = View.VISIBLE
                medText1.text = medListTextArray[0]
                medItem2.visibility = View.VISIBLE
                medText2.text = medListTextArray[7]
                medItem3.visibility = View.VISIBLE
                medText3.text = medListTextArray[14]
            }

        }


    }

    private fun openAddStatsActivity() {
        val intent = Intent(this, AddStatsActivity::class.java )
        startActivity(intent)
    }

    private fun openHome(){
        val intent = Intent(this, MainActivity::class.java )
        startActivity(intent)
    }
}