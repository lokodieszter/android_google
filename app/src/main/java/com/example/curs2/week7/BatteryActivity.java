package com.example.curs2.week7;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.curs2.R;

public class BatteryActivity extends AppCompatActivity {
    ImageView battery;
    private int currentLevel = 1;
    private Button btnMinus;
    private Button btnPlus;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_battery);
        battery = findViewById(R.id.batteryImageView);

        btnMinus = findViewById(R.id.buttonMinus);
        btnPlus = findViewById(R.id.buttonPlus);

        updateBatteryLevel(currentLevel);
    }


    private void updateBatteryLevel(int currentLevel) {
        battery.setImageLevel(currentLevel);
    }

    public void onBatteryChangeMinus(View view) {
        updateBatteryLevel(--currentLevel);
        updateButtonState(currentLevel);
    }

    public void onBatteryChangePlus(View view) {
        updateBatteryLevel(++currentLevel);
        updateButtonState(currentLevel);
    }

    private void updateButtonState(int level){
        btnMinus.setEnabled(level>1);
        btnPlus.setEnabled(level<7);
    }
}
