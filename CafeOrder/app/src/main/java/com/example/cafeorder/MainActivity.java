package com.example.cafeorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextUserName;
    EditText editTextUserPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initLoginButton();
    }

    void initLoginButton() {
        Button button = findViewById(R.id.create_order_bt);
        editTextUserName = findViewById(R.id.user_name_et);
        editTextUserPassword = findViewById(R.id.user_password_et);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextUserName.getText().length() != 0 && editTextUserPassword.getText().length() != 0) {
                    String userName = editTextUserName.getText().toString().trim();
                    String userPassword = editTextUserPassword.getText().toString().trim();
                    Intent intent = new Intent(getApplicationContext(), OrderActivity.class);
                    intent.putExtra(OrderActivity.KEY_USER_NAME, userName);
                    intent.putExtra(OrderActivity.KEY_USER_PASSWORD, userPassword);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Все поля должны быть заполнены.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}