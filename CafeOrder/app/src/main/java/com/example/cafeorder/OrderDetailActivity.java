package com.example.cafeorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.TextView;

public class OrderDetailActivity extends AppCompatActivity {
    public static final String KEY_FULL_ORDER = "full order";
    private TextView textViewFullOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
        textViewFullOrder = findViewById(R.id.full_order_tv);

        Intent intent = getIntent();
        textViewFullOrder.setText(intent.getStringExtra(KEY_FULL_ORDER));

    }
}