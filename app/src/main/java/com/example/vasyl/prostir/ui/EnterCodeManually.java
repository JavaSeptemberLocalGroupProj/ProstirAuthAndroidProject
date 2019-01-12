package com.example.vasyl.prostir.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.vasyl.prostir.R;

public class EnterCodeManually extends AppCompatActivity {
    String TOKEN = "25";
    Button okayBtn_ecm;
    EditText enterSoftTokenEditText;
    TextView errorSoftTokenTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_code_manually);
        okayBtn_ecm = findViewById(R.id.okayBtn_ecm);
        enterSoftTokenEditText = findViewById(R.id.enterSoftTokenEditText);
        errorSoftTokenTextView = findViewById(R.id.errorSoftTokenTextView);
    }

    public void onOkayBtnEcmClick (View view) {
        String temp = enterSoftTokenEditText.getText().toString();
        if (TOKEN.equals(temp)) {
            errorSoftTokenTextView.setVisibility(View.INVISIBLE);
            gotoDecryptedMessagePage();
        } else {
            errorSoftTokenTextView.setVisibility(View.VISIBLE);
            enterSoftTokenEditText.setText("");
        }
    }

    private void gotoDecryptedMessagePage(){
        Intent i = new Intent(this, DecryptedMessage.class);
        startActivity(i);
    }
}
