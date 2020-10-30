package com.example.medalert

import android.content.Context
import android.util.AttributeSet
import java.security.AccessControlContext
import android.view.LayoutInflater
import android.widget.LinearLayout

class CustomView(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs){

    init {

        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val view = inflater.inflate(R.layout.medication_element, this, true)



    }

}


//<LinearLayout
//android:id="@+id/medListInfo"
//android:layout_marginStart="15dp"
//android:layout_width="match_parent"
//android:layout_height="100dp"
//android:layout_marginTop="15dp"
//android:layout_marginRight="15dp"
//android:layout_marginEnd="15dp"
//android:background="@drawable/white_rect_back"
//android:padding="15dp"
//android:elevation="4dp">
//
//<ImageView
//android:layout_width="75dp"
//android:layout_height="wrap_content"
//android:layout_gravity="start"
//android:src="@drawable/currentmeds_icon"/>
//
//<TextView
//android:layout_width="wrap_content"
//android:layout_height="20dp"
//android:text="Medication Name"
//android:textColor="@color/colorAccent"
//android:gravity="center"
///>
//
//</LinearLayout>