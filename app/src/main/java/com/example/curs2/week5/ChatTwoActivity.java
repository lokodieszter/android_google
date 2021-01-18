package com.example.curs2.week5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.curs2.R;

public class ChatTwoActivity extends AppCompatActivity {

    protected static final  String EXTRA_MESSAGE_INPUT = "extra_message_input";

    private TextView receivedMessages;
    private EditText inputField;
    private Button btnSend;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_chat_two);

        receivedMessages = findViewById(R.id.tv_chat_two_messages);
        inputField = findViewById(R.id.et_chat_two);
        btnSend = findViewById(R.id.btn_chat_two_send);
        btnSend.setOnClickListener(view -> sendMessage());

        handleReceivedMessage(getIntent());


    }


    private void sendMessage() {
        String message = inputField.getText().toString();

        Intent intent = new Intent();
        intent.putExtra(ChatTwoActivity.EXTRA_MESSAGE_INPUT, message);

        setResult(Activity.RESULT_OK, intent);
        finish();



    }

    private void handleReceivedMessage(Intent intent) {
        if( intent != null) {
            String message = intent.getStringExtra(EXTRA_MESSAGE_INPUT);
            if (message != null ) {
                receivedMessages.setText(message);
            }
        }
    }


}
