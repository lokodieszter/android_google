package com.example.curs2.week5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.curs2.R;

public class ChatOneActivity extends AppCompatActivity {

    private TextView recievedMessage;
    private EditText inputField;
    private Button buttonSend;
    private static final int CHAT_ONE_MESSAGE_REQ = 1001;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_chat_one);

        inputField = findViewById(R.id.et_chat_one);
        recievedMessage = findViewById(R.id.tv_chat_one_messages);
        buttonSend = findViewById(R.id.btn_chat_one_send);
        buttonSend.setOnClickListener(view -> {
            sendMessage();
        });
    }

    private void sendMessage() {
        String message = inputField.getText().toString();
        Intent intent = new Intent(this, ChatTwoActivity.class);
        intent.putExtra(ChatTwoActivity.EXTRA_MESSAGE_INPUT, message);
        startActivityForResult(intent, CHAT_ONE_MESSAGE_REQ);

        inputField.setText("");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CHAT_ONE_MESSAGE_REQ && resultCode == RESULT_OK && data != null) {
            String message = data.getStringExtra(ChatTwoActivity.EXTRA_MESSAGE_INPUT);
            if (message != null) {
                recievedMessage.append("\n");
                recievedMessage.append(message);
            }
        }
    }

}
