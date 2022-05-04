package com.example.terveyssovellusryhm8;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Arrays;

public class MielialakyselyActivity extends AppCompatActivity {
    // The line of code below is taken from our materials
    public static final String EXTRA_MESSAGE = "com.example.terveyssovellusryhm8.MESSAGE";
    int round;
    int[] points = new int[14];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mielialakysely);

        // Android studio suggested to change my original for loop into this
        Arrays.fill(points, -1);

        round = 0;
        printTexts(round);
    }


    public void forwards(View v){
        // The line of code below is taken from our materials
        RadioGroup rg = findViewById(R.id.radioGroup);
        // The line of code below is taken from our materials
        TextView tn = findViewById(R.id.testNumber);
        //
        if (round < 14){

            if (rg.getCheckedRadioButtonId() != -1) {
                tn.setText("");
                // Save the value.
                // Original code from the line below is from our materials, but I changed it a bit.
                points[round] = rg.indexOfChild(findViewById(rg.getCheckedRadioButtonId()));

                //rg.clearCheck();
                rg.clearCheck();
                round++;
                printTexts(round);

            } else {
                // Add code to get out from this mood questionnaire
                tn.setText(R.string.answer);
            }

            if (points[round] != -1){
                setChosen();
            }
        // if it's the last round, go here
        } else{
            // This part of the code is modified code taken from
            // https://developer.android.com/training/basics/firstapp/starting-activity
            points[round] = rg.indexOfChild(findViewById(rg.getCheckedRadioButtonId()));
            Intent intent = new Intent(this, MielialaVastausActivity.class);
            intent.putExtra(EXTRA_MESSAGE, points);

            startActivity(intent);
        }
    }

    // The method that is called when you call the
    // backwards button. It shows the previous question.
    public void backwards(View v){
        if (round != 0) {
            round--;

            // This code chooses the answer the user had
            // previously chosen
            setChosen();

            printTexts(round);

        }
    }

    // This method chooses the answer the user had
    // previously chosen
    public void setChosen(){
        RadioButton rb;

        switch(points[round]){
            case 0:
                rb = findViewById(R.id.option1);
                break;
            case 1:
                rb = findViewById(R.id.option2);
                break;
            case 2:
                rb = findViewById(R.id.option3);
                break;
            case 3:
                rb = findViewById(R.id.option4);
                break;
            case 4:
                rb = findViewById(R.id.option5);
                break;
            default:
                rb = findViewById(R.id.option1);
        }
        rb.setChecked(true);
    }

    // Go home button
    public void goHome(View view){
        finish();
    }


    // Method that changes the texts and buttons.
    // So that a single activity can have all the 14 questions.
    // Integer i is the number of question

    public void printTexts(int i){
        TextView tv = findViewById(R.id.moodQuestion);
        RadioButton rb1 = findViewById(R.id.option1);
        RadioButton rb2 = findViewById(R.id.option2);
        RadioButton rb3 = findViewById(R.id.option3);
        RadioButton rb4 = findViewById(R.id.option4);
        RadioButton rb5 = findViewById(R.id.option5);
        Button next = findViewById(R.id.button2);
        Button previous = findViewById(R.id.button3);
        // Testikoodia, poista lopulliseen
        //TextView tn = findViewById(R.id.testNumber);
        //tn.setText(Integer.toString(mieliala.pointsit));

        switch(i){

            case 0:
                tv.setText(R.string.mood1);
                rb1.setText(R.string.mood1_1);
                rb2.setText(R.string.mood1_2);
                rb3.setText(R.string.mood1_3);
                rb4.setText(R.string.mood1_4);
                rb5.setText(R.string.mood1_5);
                previous.setVisibility(View.GONE);
                break;
            case 1:
                tv.setText(R.string.mood2);
                rb1.setText(R.string.mood2_1);
                rb2.setText(R.string.mood2_2);
                rb3.setText(R.string.mood2_3);
                rb4.setText(R.string.mood2_4);
                rb5.setText(R.string.mood2_5);
                previous.setVisibility(View.VISIBLE);
                break;
            case 2:
                tv.setText(R.string.mood3);
                rb1.setText(R.string.mood3_1);
                rb2.setText(R.string.mood3_2);
                rb3.setText(R.string.mood3_3);
                rb4.setText(R.string.mood3_4);
                rb5.setText(R.string.mood3_5);
                break;

            case 3:
                tv.setText(R.string.mood4);
                rb1.setText(R.string.mood4_1);
                rb2.setText(R.string.mood4_2);
                rb3.setText(R.string.mood4_3);
                rb4.setText(R.string.mood4_4);
                rb5.setText(R.string.mood4_5);
                break;

            case 4:
                tv.setText(R.string.mood5);
                rb1.setText(R.string.mood5_1);
                rb2.setText(R.string.mood5_2);
                rb3.setText(R.string.mood5_3);
                rb4.setText(R.string.mood5_4);
                rb5.setText(R.string.mood5_5);
                break;

            case 5:
                tv.setText(R.string.mood6);
                rb1.setText(R.string.mood6_1);
                rb2.setText(R.string.mood6_2);
                rb3.setText(R.string.mood6_3);
                rb4.setText(R.string.mood6_4);
                rb5.setText(R.string.mood6_5);
                break;

            case 6:
                tv.setText(R.string.mood7);
                rb1.setText(R.string.mood7_1);
                rb2.setText(R.string.mood7_2);
                rb3.setText(R.string.mood7_3);
                rb4.setText(R.string.mood7_4);
                rb5.setText(R.string.mood7_5);
                break;

            case 7:
                tv.setText(R.string.mood8);
                rb1.setText(R.string.mood8_1);
                rb2.setText(R.string.mood8_2);
                rb3.setText(R.string.mood8_3);
                rb4.setText(R.string.mood8_4);
                rb5.setText(R.string.mood8_5);
                break;

            case 8:
                tv.setText(R.string.mood9);
                rb1.setText(R.string.mood9_1);
                rb2.setText(R.string.mood9_2);
                rb3.setText(R.string.mood9_3);
                rb4.setText(R.string.mood9_4);
                rb5.setText(R.string.mood9_5);
                break;

            case 9:
                tv.setText(R.string.mood10);
                rb1.setText(R.string.mood10_1);
                rb2.setText(R.string.mood10_2);
                rb3.setText(R.string.mood10_3);
                rb4.setText(R.string.mood10_4);
                rb5.setText(R.string.mood10_5);
                break;

            case 10:
                tv.setText(R.string.mood11);
                rb1.setText(R.string.mood11_1);
                rb2.setText(R.string.mood11_2);
                rb3.setText(R.string.mood11_3);
                rb4.setText(R.string.mood11_4);
                rb5.setText(R.string.mood11_5);
                break;

            case 11:
                tv.setText(R.string.mood12);
                rb1.setText(R.string.mood12_1);
                rb2.setText(R.string.mood12_2);
                rb3.setText(R.string.mood12_3);
                rb4.setText(R.string.mood12_4);
                rb5.setText(R.string.mood12_5);
                break;

            case 12:
                tv.setText(R.string.mood13);
                rb1.setText(R.string.mood13_1);
                rb2.setText(R.string.mood13_2);
                rb3.setText(R.string.mood13_3);
                rb4.setText(R.string.mood13_4);
                rb5.setText(R.string.mood13_5);
                next.setText(R.string.forwards);
                break;

            case 13:
                tv.setText(R.string.mood14);
                rb1.setText(R.string.mood14_1);
                rb2.setText(R.string.mood14_2);
                rb3.setText(R.string.mood14_3);
                rb4.setText(R.string.mood14_4);
                rb5.setText(R.string.mood14_5);
                next.setText(R.string.end);
                break;
        }
    }
}
