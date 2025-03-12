////// MainActivity2.java
////
////package com.example.constraintpractice;
////
////import android.content.Context;
////import android.content.SharedPreferences;
////import android.os.Bundle;
////import android.widget.TextView;
////import androidx.appcompat.app.AppCompatActivity;
////import java.text.SimpleDateFormat;
////import java.util.Date;
////import java.util.Locale;
////
////public class MainActivity2 extends AppCompatActivity {
////    private TextView dinnerTextView;
////
////    @Override
////    protected void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_main2);
////
////        // Get the current date and time
////        String currentDate = new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()).format(new Date());
////        String currentTime = new SimpleDateFormat("hh:mm a", Locale.getDefault()).format(new Date());
////
////        // Find the TextView elements
////        TextView dateTextView = findViewById(R.id.dateTextView);
////        TextView timeTextView = findViewById(R.id.timeTextView);
////        dinnerTextView = findViewById(R.id.dinnerTextView);
////
////        // Set the current date and time
////        dateTextView.setText(currentDate);
////        timeTextView.setText(currentTime);
////
////        // Retrieve and set the meal preference
////        SharedPreferences sharedPreferences = getSharedPreferences("MealPreferences", Context.MODE_PRIVATE);
////        String meal = sharedPreferences.getString("meal", "No Meal Selected");
////        dinnerTextView.setText(meal);
////    }
////}
//
//package com.example.constraintpractice;
//
//import android.content.Context;
//import android.content.SharedPreferences;
//import android.net.Uri;
//import android.os.Bundle;
//import android.widget.TextView;
//import android.widget.VideoView;
//import androidx.appcompat.app.AppCompatActivity;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Locale;
//
//public class MainActivity2 extends AppCompatActivity {
//    private TextView dinnerTextView;
//    private VideoView videoView;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main2);
//
//        // Get the current date and time
//        String currentDate = new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()).format(new Date());
//        String currentTime = new SimpleDateFormat("hh:mm a", Locale.getDefault()).format(new Date());
//
//        // Find the TextView elements
//        TextView dateTextView = findViewById(R.id.dateTextView);
//        TextView timeTextView = findViewById(R.id.timeTextView);
//        dinnerTextView = findViewById(R.id.dinnerTextView);
//
//        // Set the current date and time
//        dateTextView.setText(currentDate);
//        timeTextView.setText(currentTime);
//
//        // Retrieve and set the meal preference
//        SharedPreferences sharedPreferences = getSharedPreferences("MealPreferences", Context.MODE_PRIVATE);
//        String meal = sharedPreferences.getString("meal", "No Meal Selected");
//        dinnerTextView.setText(meal);
//
//        // Set up the VideoView
//        videoView = findViewById(R.id.videoView);
//        Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video);
//        videoView.setVideoURI(videoUri);
//
//        // Start the video and set it to loop
//        videoView.start();
//        videoView.setOnPreparedListener(mp -> mp.setLooping(true));
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        // Resume the video if the activity is resumed
//        videoView.start();
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        // Pause the video if the activity is paused
//        videoView.pause();
//    }
//}

package com.example.constraintpractice;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class MainActivity2 extends AppCompatActivity {
    private TextView dinnerTextView;
    private VideoView videoView;

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
        TextView verificationCodeTextView = findViewById(R.id.verificationCode);

        // Set the current date and time
        dateTextView.setText(currentDate);
        timeTextView.setText(currentTime);

        // Retrieve and set the meal preference
        SharedPreferences sharedPreferences = getSharedPreferences("MealPreferences", Context.MODE_PRIVATE);
        String meal = sharedPreferences.getString("meal", "No Meal Selected");
        dinnerTextView.setText(meal);

        // Generate a random verification ID between 5000000 and 7000000
        int verificationCode = new Random().nextInt(2000000) + 5000000;
        verificationCodeTextView.setText(String.valueOf(verificationCode));

        // Set up the VideoView
        videoView = findViewById(R.id.videoView);
        Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video);
        videoView.setVideoURI(videoUri);

        // Start the video and set it to loop
        videoView.start();
        videoView.setOnPreparedListener(mp -> mp.setLooping(true));
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Resume the video if the activity is resumed
        videoView.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Pause the video if the activity is paused
        videoView.pause();
    }
}