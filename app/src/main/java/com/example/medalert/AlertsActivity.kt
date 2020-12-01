package com.example.medalert

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global.getString
import android.widget.Button
import android.widget.ImageView
import android.widget.RemoteViews
import android.widget.TextView
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat.getSystemService
import kotlinx.android.synthetic.main.activity_alerts.*
import java.io.File

var medTextListArray = arrayListOf<String>()

class AlertsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alerts)

        val alertIcon1 : ImageView = findViewById(R.id.addAlert1)
        val alertIcon2 : ImageView = findViewById(R.id.addAlert2)
        val alertIcon3 : ImageView = findViewById(R.id.addAlert3)
        val backArrow : ImageView = findViewById(R.id.backArrow)

        backArrow.setOnClickListener() {
            openMain()
        }

        if (File("sdcard/Documents/medList.txt").exists()) {

            File("sdcard/Documents/medList.txt").forEachLine {
                medTextListArray.add(it)
            }

            val medNameText1 : TextView = findViewById(R.id.medName1)
            medNameText1.text = medTextListArray[0]
            val medNameText2 : TextView = findViewById(R.id.medName2)
            medNameText2.text = medTextListArray[7]
            val medNameText3 : TextView = findViewById(R.id.medName3)
            medNameText3.text = medTextListArray[14]
        }

        alertIcon1.setOnClickListener() {

            var builder = NotificationCompat.Builder(this, "CHANNEL_ID")
                .setSmallIcon(R.drawable.currentmeds_icon)
                .setContentTitle("Alert Set!")
                .setContentText("We will alert you when it's time to take " + medTextListArray[0])
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)

            with(NotificationManagerCompat.from(this)) {
                // notificationId is a unique int for each notification that you must define
                notify(250, builder.build())
            }

        }

        alertIcon2.setOnClickListener() {

            var builder = NotificationCompat.Builder(this, "CHANNEL_ID")
                .setSmallIcon(R.drawable.currentmeds_icon)
                .setContentTitle("Alert Set!")
                .setContentText("We will alert you when it's time to take " + medTextListArray[7])
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)

            with(NotificationManagerCompat.from(this)) {
                // notificationId is a unique int for each notification that you must define
                notify(250, builder.build())
            }

        }

        alertIcon3.setOnClickListener() {

            var builder = NotificationCompat.Builder(this, "CHANNEL_ID")
                .setSmallIcon(R.drawable.currentmeds_icon)
                .setContentTitle("Alert Set!")
                .setContentText("We will alert you when it's time to take " + medTextListArray[14])
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)

            with(NotificationManagerCompat.from(this)) {
                // notificationId is a unique int for each notification that you must define
                notify(250, builder.build())
            }

        }


    }

    fun openMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}


