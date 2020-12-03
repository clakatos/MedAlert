package com.example.medalert

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import java.io.File


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createNotificationChannel()

        val calendar_icon: LinearLayout = findViewById(R.id.layoutCalendar)
        calendar_icon.setOnClickListener {
            openCalendarActivity()
        }

        val medications_icon: LinearLayout = findViewById(R.id.layoutMedications)
        medications_icon.setOnClickListener {
            openMedicationsActivity()
        }

        val stats_icon: LinearLayout = findViewById(R.id.layoutStats)
        stats_icon.setOnClickListener {
            openStatsActivity()
        }

        val alerts_icon: LinearLayout = findViewById(R.id.layoutAlerts)
        alerts_icon.setOnClickListener {
            openAlertsActivity()
        }

        val username : TextView = findViewById(R.id.textUsername)
        username.visibility = View.INVISIBLE

        val checkListItem1 : CheckBox = findViewById(R.id.checkbox_item1)
        val checkListItem2 : CheckBox = findViewById(R.id.checkbox_item2)
        val checkListItem3 : CheckBox = findViewById(R.id.checkbox_item3)

        checkListItem1.visibility = View.INVISIBLE
        checkListItem2.visibility = View.INVISIBLE
        checkListItem3.visibility = View.INVISIBLE

        val medFile = "medList.txt"

        if (File("sdcard/Documents/${medFile}").exists()) {

            var medTextListArray = arrayListOf<String>()

            File("sdcard/Documents/medList.txt").forEachLine {
                medTextListArray.add(it)
            }

            checkListItem1.text = medTextListArray[0]
            checkListItem1.visibility = View.VISIBLE
            checkListItem2.text = medTextListArray[7]
            checkListItem2.visibility = View.VISIBLE
            checkListItem3.text = medTextListArray[14]
            checkListItem3.visibility = View.VISIBLE

        }

        /////////////Set Greeting//////////////////

        val fileName = "stats.txt"

        var statTextArray = arrayListOf<String>()

        if (File("sdcard/Documents/${fileName}").exists()) {

            File("sdcard/Documents/stats.txt").forEachLine {
                statTextArray.add(it)
            }

            username.visibility = View.VISIBLE
            username.text = ", " + statTextArray[0]

        }

        ///////////////WEBVIEW SEARCH/////////////////

        val searchIcon : ImageView = findViewById(R.id.searchIcon)

        searchIcon.setOnClickListener() {
            val searchBarText : EditText = findViewById(R.id.searchBarText)
            var searchTerm = searchBarText.text.toString()
            Log.d("seatch", searchTerm)
            openWebView(searchTerm)
        }

    }

    private fun openCalendarActivity() {
        val intent = Intent(this, CalendarActivity::class.java)
        startActivity(intent)
    }

    private fun openMedicationsActivity() {
        val intent = Intent(this, MedicationsActivity::class.java)
        startActivity(intent)
    }

    private fun openStatsActivity() {
        val intent = Intent(this, StatsActivity::class.java)
        startActivity(intent)
    }

    private fun openAlertsActivity() {
        val intent = Intent(this, AlertsActivity::class.java)
        startActivity(intent)
    }

    private fun createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Channel Name"
            val descriptionText = "Channel Description"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel("CHANNEL_ID", name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun openWebView(searchTerm: String) {
        val intent = Intent(this, WebviewActivity::class.java)
        intent.putExtra("SearchTerm", searchTerm)
        startActivity(intent)
    }


}