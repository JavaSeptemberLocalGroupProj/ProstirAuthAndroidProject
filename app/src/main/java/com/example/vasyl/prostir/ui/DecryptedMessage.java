package com.example.vasyl.prostir.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.vasyl.prostir.R;

public class DecryptedMessage extends AppCompatActivity {
    String codeTemp = "BLPONB - 789";
    TextView passwordTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decrypted_message);
        passwordTextView = findViewById(R.id.passwordTextView);
        passwordTextView.setText(codeTemp);
    }
    public void onGoNextBtnClick_dm(View v){
        Intent i = new Intent(this, Authorization.class);
        startActivity(i);
    }
}
