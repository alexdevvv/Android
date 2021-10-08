package com.example.timer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView timerTextView;
    private Button startButton;
    private Button pauseButton;
    private Button resetButton;
    private int second = 0;
    private boolean isRunning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timerTextView = findViewById(R.id.timer_tv);
        if (savedInstanceState != null) {
            second = savedInstanceState.getInt("seconds");
            isRunning = savedInstanceState.getBoolean("isRunning");
        }
        initStartButton();
        initPauseButton();
        initResetButton();
        runTimer();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("seconds", second);
        outState.putBoolean("isRunning", isRunning);
    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        if (second != 0) {
//            isRunning = true;
//        }
//
//    }

    @Override
    protected void onResume() {
        super.onResume();
        if (second != 0) {
            isRunning = true;
        }
    }

    //    @Override
//    protected void onStop() {
//        super.onStop();
//        isRunning = false;
//    }

    @Override
    protected void onPause() {
        super.onPause();
        isRunning = false;
    }

    private void initStartButton() {
        startButton = findViewById(R.id.start_bt);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isRunning = true;

            }
        });
    }

    private void initPauseButton() {
        pauseButton = findViewById(R.id.pause_bt);
        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isRunning = false;
            }
        });
    }

    private void initResetButton() {
        resetButton = findViewById(R.id.reset_bt);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isRunning = false;
                second = 0;
            }
        });
    }

    private void runTimer() {
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = second / 3600;
                int minutes = (second % 3600) / 60;
                int secs = second % 60;

                String time = String.format("%d:%02d:%02d", hours, minutes, secs);
                timerTextView.setText(time);
                if (isRunning) {
                    second++;
                }
                handler.postDelayed(this, 1000);
            }

        });

    }


}