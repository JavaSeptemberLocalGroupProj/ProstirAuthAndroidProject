package com.example.vasyl.prostir.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.vasyl.prostir.R;


public class AccountAdd extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_add);
    }
    public void goToEnterManuallyPage(View view){
        Intent i = new Intent(this, EnterCodeManually.class);
        startActivity(i);
    }
    public void goToQrCodeScannerPage(View view){
        Intent i = new Intent(this, QrCodeScanner.class);
        startActivity(i);
    }
}
