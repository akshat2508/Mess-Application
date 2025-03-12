package com.example.constraintpractice;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class FeedbackActivity extends AppCompatActivity {
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feedback);

        // Find the Submit button in the layout
        submitButton = findViewById(R.id.submitButton);

        // Set OnClickListener for the Submit button
        submitButton.setOnClickListener(v -> {
            // Show AlertDialog with success message
            showSuccessDialog();
        });
    }

    // Method to show the success message in an AlertDialog
    private void showSuccessDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(FeedbackActivity.this);
        builder.setTitle("Success");
        builder.setMessage("Submitted Successfully");

        // Set up the "OK" button to dismiss the dialog
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Close the dialog
                dialog.dismiss();
            }
        });

        // Show the AlertDialog
        builder.show();
    }
}
