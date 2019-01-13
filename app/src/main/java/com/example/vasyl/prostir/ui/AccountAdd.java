package com.example.vasyl.prostir.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.vasyl.prostir.R;
import com.example.vasyl.prostir.data.ServiceReference;


public class AccountAdd extends AppCompatActivity {
    EditText description_EditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_add);
        description_EditText = findViewById(R.id.description_EditText);
    }
    public void goToEnterManuallyPage(View view){
        Intent i = new Intent(this, EnterCodeManually.class);
        startActivity(i);
        ServiceReference.setDescription_Temp(description_EditText.getText().toString());

    }
    public void goToQrCodeScannerPage(View view){
        Intent i = new Intent(this, QrCodeScanner.class);
        startActivity(i);
        ServiceReference.setDescription_Temp(description_EditText.getText().toString());
    }
}
