package com.example.curs2.week5;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.curs2.R;

public class SecondActivity extends AppCompatActivity {
    private static final String TAG = "SecondActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);

        Log.d(TAG, "onCreate: "+savedInstanceState);
        Intent intent = getIntent();
        int stringRes = 0;
        String stringText = null;
        if( intent != null) {
            stringRes = intent.getIntExtra(ThreeButtonActivity.EXTRA_STRING_RES_LONG, 0);
            stringText = intent.getStringExtra(ThreeButtonActivity.EXTRA_TEXT_LONG);
        }

        TextView textView = findViewById(R.id.tv_recieved_text);
        if (stringRes != 0) {
            textView.setText(stringText);
            Log.d(TAG, "onCreate: stringRes invalid");
        }
//        if (stringText != null) {
//            textView.setText(stringText);
//            Log.d(TAG, "onCreate: stringRes invalid");
//        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }
}
