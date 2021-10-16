package com.example.htv;

import androidx.appcompat.app.AppCompatActivity;
import java.lang.Math;
import android.os.Bundle;

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
            if challenges[x]                                           //if challenges[x] is not already in array chosen, add it, if not then get another random number x
        }
    }

    public int random(int min, int max){
        int range = max - min;
        return (int)(Math.random()*range) + min;
    }
}