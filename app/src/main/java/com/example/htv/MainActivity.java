package com.example.htv;

import androidx.appcompat.app.AppCompatActivity;
import java.lang.Math;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String [] challenges = new String[15];
        challenges[0] = "Run for 5 minutes";
        challenges[1] = "Do 30 jumping jacks";
        challenges[2] = "Tell one friend or family member how much they mean to you";
        challenges[3] = "Do 10 push ups";
        challenges[4] = "prepare a nice meal";
        challenges[5] = "smile to everyone you met today";
        challenges[6] = "Do not drink any soda";
        challenges[7] = "Enjoy at least an hour of time with your friends";
        challenges[8] = "Draw something";
        challenges[9] = "Plank for 30 seconds";
        challenges[10] = "Talk to someone new";
        challenges[11] = "Play a sport you enjoy";
        challenges[12] = "Write a short story";
        challenges[13] = "Start/continue reading a book";
        challenges[14] = "Plan a trip with some friends";


        int i =0;
        String [] chosen = new String[4];
        while(i <4){
            int x = random(0,challenges.length);
            boolean ableToAdd = true;
            for(int j =0; i<chosen.length; j++){
                if(challenges[x] == chosen[j])
                    ableToAdd = false;
            }
            if(ableToAdd){
                chosen[i] = challenges[x];
                i++;
            }
        }

        TextView chalText1 = findViewById(R.id.txtChal1);
        TextView chalText2 = findViewById(R.id.txtChal2);
        TextView chalText3 = findViewById(R.id.txtChal3);
        TextView chalText4 = findViewById(R.id.txtChal4);
        chalText1.setText(chosen[0]);
        chalText2.setText(chosen[1]);
        chalText3.setText(chosen[2]);
        chalText4.setText(chosen[3]);
    }

    public int random(int min, int max){
        int range = max - min;
        return (int)(Math.random()*range) + min;
    }
}