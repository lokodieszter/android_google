package com.example.curs2.week5;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.curs2.R;

public class ThreeButtonActivity extends AppCompatActivity {

    private static final String TAG = "ThreeButtonActivity";
    protected static final String EXTRA_STRING_RES_LONG = "extra_string_res_long";
    protected static final String EXTRA_TEXT_LONG= "extra_string_res_long";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.three_button_activity);
        findViewById(R.id.btn_first).setOnClickListener(view -> {
            openSecondActivity(R.id.btn_first);
        });

        findViewById(R.id.btn_second).setOnClickListener(view -> {
            openSecondActivity(R.id.btn_second);
        });

        findViewById(R.id.btn_third).setOnClickListener(view -> {
            openSecondActivity(R.id.btn_third);
        });

    }

    private void openSecondActivity(int buttonRes) {
        int stringRes;
        if(buttonRes == R.id.btn_first) {
            stringRes = R.string.first_long_text;

        } else if ( buttonRes == R.id.btn_second) {
            stringRes = R.string.second_long_test;

        }else if(buttonRes == R.id.btn_third) {
            stringRes = R.string.third_long_test;
        } else{
            Log.d(TAG, "openSecondActivity: +buttonRes");
            stringRes = 0;
        }
        String text;
        if(stringRes != 0) {
            text = getString(stringRes);
        } else {
            Log.d(TAG, "openSecondActivity: "+buttonRes+ "Invalid string res");
            return;
        }


        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(EXTRA_STRING_RES_LONG, stringRes);
        intent.putExtra(EXTRA_TEXT_LONG, text);
        startActivity(intent);

    }
}
