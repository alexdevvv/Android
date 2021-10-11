package com.example.cafeorder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class OrderActivity extends AppCompatActivity {

    public static final String KEY_USER_NAME = "user name";
    public static final String KEY_USER_PASSWORD = "user_password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
    }
}