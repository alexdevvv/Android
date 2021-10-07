package com.example.colordescriptor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Spinner spinnerColors;
    TextView textViewDescriptionTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initGetDescriptionTempButton();

        spinnerColors = findViewById(R.id.spinner_colors);
        textViewDescriptionTemp = findViewById(R.id.color_description_tv);

    }

   private void initGetDescriptionTempButton() {
       Button getDescriptionTempButton = findViewById(R.id.find_color_description_bt);
       getDescriptionTempButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               textViewDescriptionTemp.setText(getDescriptionByPosition(spinnerColors.getSelectedItemPosition()));
           }
       });

   }

   private String getDescriptionByPosition(int position) {
        String[] descriptions = getResources().getStringArray(R.array.temp_description);
        return  descriptions[position];
   }
}