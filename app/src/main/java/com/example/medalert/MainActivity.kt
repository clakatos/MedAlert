package com.example.medalert

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

}