// MainActivity2.java

package com.example.constraintpractice;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity2 extends AppCompatActivity {
    private TextView dinnerTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Get the current date and time
        String currentDate = new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()).format(new Date());
        String currentTime = new SimpleDateFormat("hh:mm a", Locale.getDefault()).format(new Date());

        // Find the TextView elements
        TextView dateTextView = findViewById(R.id.dateTextView);
        TextView timeTextView = findViewById(R.id.timeTextView);
        dinnerTextView = findViewById(R.id.dinnerTextView);

        // Set the current date and time
        dateTextView.setText(currentDate);
        timeTextView.setText(currentTime);

        // Retrieve and set the meal preference
        SharedPreferences sharedPreferences = getSharedPreferences("MealPreferences", Context.MODE_PRIVATE);
        String meal = sharedPreferences.getString("meal", "No Meal Selected");
        dinnerTextView.setText(meal);
    }
}