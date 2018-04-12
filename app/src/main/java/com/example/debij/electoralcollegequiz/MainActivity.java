package com.example.debij.electoralcollegequiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


// This app displays and quiz and the score from question responses.

public class MainActivity extends AppCompatActivity {

    int score = 0;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = findViewById(R.id.reset_button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
            }
        });



    /** This method is called when the submit button is clicked.
         */
    public void submit_answers (View view){

        // Gets User entered Name and stores in a String variable

        EditText nameField = (EditText) findViewById(R.id.name_field);
        String name = nameField.getText().toString();

        // Collect correct answers
        // question 1

        CheckBox answer12Checkbox = (CheckBox) findViewById(R.id.answer_1_2);
        boolean hasAnswer12Checkbox = answer12Checkbox.isChecked();

        // question 2

        RadioButton answer23RadioButton;
        answer23RadioButton = findViewById(R.id.answer_2_3);
        boolean hasAnswer23RadioButoon = answer23RadioButton.isChecked();

        // question 3

        CheckBox answer31Checkbox = (CheckBox) findViewById(R.id.answer_3_1);
        boolean hasAnswer31Checkbox = answer31Checkbox.isChecked();

        // question 4

        CheckBox answer43Checkbox = (CheckBox) findViewById(R.id.answer_4_3);
        boolean hasAnswer43Checkbox = answer43Checkbox.isChecked();

        // question 5

        RadioButton answer53RadioButton;
        answer53RadioButton = findViewById(R.id.answer_5_3);
        boolean hasAnswer53RadioButton = answer53RadioButton.isChecked();

        // Display toast message depending on score range

        int score = calculateScore(hasAnswer12Checkbox, hasAnswer23RadioButoon, hasAnswer31Checkbox, hasAnswer43Checkbox, hasAnswer53RadioButton);
        if (score == 0) {
            // Show message based on score
            Toast.makeText(this, "Bummer " + name + "Try Google.", Toast.LENGTH_SHORT).show();
            return;
        }
        if (score <= 3) {
            Toast.makeText(this, "Not bad " + name + "search Electoral College and try again.", Toast.LENGTH_SHORT).show();
            return;
        }
        if (score == 4) {
            Toast.makeText(this, "Good job! " + name + "you are an informed citizen.", Toast.LENGTH_SHORT).show();
            return;
        }
        if (score == 5) {
            Toast.makeText(this, "Congratulations " + name + "you are a Super Citizen!", Toast.LENGTH_SHORT).show();
            return;
        }

    }

    // This method sums correct answers to calculate the quiz score

    private int calculateScore(boolean hasAnswer12Checkbox, boolean hasAnswer23RadioButton, boolean hasAnswer31Checkbox, boolean hasAnswer43Checkbox, boolean hasAnswer53RadioButton){

        if (hasAnswer12Checkbox) {
            score = score + 1;
        }
        if (hasAnswer23RadioButton) {
            score = score +1;
        }
        if (hasAnswer31Checkbox) {
            score = score + 1;
        }
        if (hasAnswer43Checkbox){
            score = score + 1;
        }
        if (hasAnswer53RadioButton) {
            score = score + 1;
        }
        return score;
    }

    /** This method is called when the reset button is clicked

    public void resetAll (View view) {
        resetAll.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                if (v == reset) {
                    startActivity(new Intent(.MainActivity, this, .MainActiviy.class));
                }
            }
        });*/
    }

}
