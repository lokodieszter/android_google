package com.example.curs2.week3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.example.curs2.R;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    TextInputLayout emailInputLayout;
    TextInputLayout phoneInputLayout;
    EditText emailEditText;
    EditText phoneEditText;
    CheckBox termsAndConditionsCheck;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         emailInputLayout = findViewById(R.id.til_email);
        phoneInputLayout = findViewById(R.id.til_phone);
        emailEditText = findViewById(R.id.et_email);
        phoneEditText = findViewById(R.id.et_phone);
        termsAndConditionsCheck = findViewById(R.id.cb_terms_conditions);
        submitButton = findViewById(R.id.btn_submit);

        findViewById(R.id.btn_submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
            }
        });

         submitButton.setEnabled(termsAndConditionsCheck.isChecked());
         termsAndConditionsCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                submitButton.setEnabled(isChecked);
            }
        });

    }

    public void validate() {
        boolean isValid = false;
        if(emailEditText.getText().toString().isEmpty()){
            emailInputLayout.setError("Email address cannot be empty");
            isValid = false;
        } else if(isNotValidEmailAddress(emailEditText.getText().toString())){
            isValid = false;
        }

        else {
            clearError(emailInputLayout);
        }

        if(phoneEditText.getText().toString().isEmpty()){
            phoneInputLayout.setError("Phone address cannot be empty");
            isValid = false;
        } else {
            clearError(phoneInputLayout);
        }

        if (isValid) {
            Toast.makeText(this,"", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isNotValidEmailAddress(String text) {
        return false;
    }

    private void clearError(TextInputLayout layout){
        if (layout != null && layout.isErrorEnabled()){
            layout.setError(null);
        }
    }
}