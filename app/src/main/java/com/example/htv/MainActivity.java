package com.example.htv;

import androidx.appcompat.app.AppCompatActivity;
import java.lang.Math;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Environment;
import android.widget.Toast;
import java.io.File;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    private TextView chalText1;
    private TextView chalText2;
    private TextView chalText3;
    private TextView chalText4;
    private TextView timer;

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;

    private CountDownTimer countDownTimer;
    private long timeLeftInMili = 10000;
    private boolean timerRunning;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chalText1 = findViewById(R.id.txtChal1);
        chalText2 = findViewById(R.id.txtChal2);
        chalText3 = findViewById(R.id.txtChal3);
        chalText4 = findViewById(R.id.txtChal4);
        timer = findViewById(R.id.txtTimer);
        button1 = findViewById(R.id.btn1);
        button2 = findViewById(R.id.btn2);
        button3 = findViewById(R.id.btn3);
        button4 = findViewById(R.id.btn4);

        try {
            setChallenges();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public int random(int min, int max){
        int range = max - min;
        return (int)(Math.random()*range) + min;
    }


    public void setChallenges() throws Exception{
        String [] challenges = new String[15];
        challenges[0] = "Run for 5 minutes";
        challenges[1] = "Do 30 jumping jacks";
        challenges[2] = "Tell someone close how much you care for them";
        challenges[3] = "Do 10 push ups";
        challenges[4] = "prepare a nice meal";
        challenges[5] = "lie down and relax for 10 minutes";
        challenges[6] = "Do a favour for someone";
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
        while(i < 4){
            int x = random(0,challenges.length);
            boolean ableToAdd = true;
            for(int j = 0; j<chosen.length; j++){
                if(challenges[x] == chosen[j])
                    ableToAdd = false;
            }
            if(ableToAdd){
                chosen[i] = challenges[x];
                i++;
            }
        }

        chalText1.setText(chosen[0]);
        chalText2.setText(chosen[1]);
        chalText3.setText(chosen[2]);
        chalText4.setText(chosen[3]);

        View v1 = (View)button1;
        View v2 = (View)button2;
        View v3 = (View)button3;
        View v4 = (View)button4;
        v1.setEnabled(true);
        v2.setEnabled(true);
        v3.setEnabled(true);
        v4.setEnabled(true);
        String s = new String("Press when challenge completed");
        button1.setText(s);
        button2.setText(s);
        button3.setText(s);
        button4.setText(s);
        timer.setVisibility(View.INVISIBLE);

        String fileName = "HTV_saved_data.txt";
        String filePath = "HTV_DataDir";
        String storageState = Environment.getExternalStorageState();
        if(storageState.equals(Environment.MEDIA_MOUNTED)){       //only saves if there is external storage available
            File myDataFile = new File(getExternalFilesDir(filePath), fileName);
            FileOutputStream myData = new FileOutputStream(myDataFile);
            myData.write((chosen[0] + "\n").getBytes());
            myData.write((chosen[1] + "\n").getBytes());
            myData.write((chosen[2] + "\n").getBytes());
            myData.write((chosen[3] + "\n").getBytes());
            Toast.makeText(MainActivity.this, "challenges have been saved", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(MainActivity.this, "Sorry, your challenges could not be saved", Toast.LENGTH_SHORT).show();
        }


    }


    public void clickEvent(View v){
        v.setEnabled(false);
        Button button = (Button)v;
        button.setText("Completed");

        if(!button1.isEnabled() && !button2.isEnabled() && !button3.isEnabled() && !button4.isEnabled()){
            timerRunning = true;
            timer.setVisibility(View.VISIBLE);
            startTimer();
        }
    }

    public void startTimer(){
        countDownTimer = new CountDownTimer(timeLeftInMili, 1000){
            @Override
            public void onTick(long millisUntilFinished) {
                updateTimer();
                timeLeftInMili = millisUntilFinished;
            }

            @Override
            public void onFinish() {
                timerRunning = false;
                try {
                    setChallenges();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                timeLeftInMili = 10000;

            }
        }.start();
    }

    public void updateTimer(){
        int minutes = (int)timeLeftInMili / 60000;
        int seconds = (int)timeLeftInMili % 60000 / 1000;

        String timeLeft = minutes + ":";
        if(seconds<10)
            timeLeft += "0";
        timeLeft += seconds;
        timer.setText("Time left untill new challenges " +timeLeft);

    }
}