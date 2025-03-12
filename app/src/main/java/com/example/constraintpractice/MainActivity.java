package com.example.constraintpractice;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

public class MainActivity extends AppCompatActivity {
    Button button, button2, button3, button4;
    private int currentButtonId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        View sidebarButton = findViewById(R.id.sidebar_button);
        sidebarButton.setOnClickListener(v -> openFeedbackActivity());
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button.setOnClickListener(v -> scanCode(1));
        button2.setOnClickListener(v -> scanCode(2));
        button3.setOnClickListener(v -> scanCode(3));
        button4.setOnClickListener(v -> scanCode(4));
    }
    private void openFeedbackActivity() {
        Intent intent = new Intent(MainActivity.this, FeedbackActivity.class);
        startActivity(intent);
    }
    private void scanCode(int buttonId) {
        ScanOptions options = new ScanOptions();
        currentButtonId = buttonId;
        options.setPrompt("Volume up to flash on");
        options.setBeepEnabled(true);

        options.setOrientationLocked(true);
        options.setCaptureActivity(CaptureAct.class);
        barLauncher.launch(options);
    }

    ActivityResultLauncher<ScanOptions> barLauncher = registerForActivityResult(new ScanContract(), result -> {
        if (result.getContents() != null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("");
//            String message = "";
            switch (currentButtonId) {
                case 1:
                    saveMealPreference("Breakfast");
                    break;
                case 2:
                    saveMealPreference("Lunch");
                    break;
                case 3:
                    saveMealPreference("Dinner");
                    break;
                case 4:
                    saveMealPreference("Tea");
                    break;
                default:
                  String  message = "Unknown button content: " + result.getContents();
            }
            navigateToMainActivity2();
        }
    });

    private void saveMealPreference(String meal) {
        SharedPreferences sharedPreferences = getSharedPreferences("MealPreferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("meal", meal);
        editor.apply();
    }

    private void navigateToMainActivity2() {
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        startActivity(intent);
    }
}