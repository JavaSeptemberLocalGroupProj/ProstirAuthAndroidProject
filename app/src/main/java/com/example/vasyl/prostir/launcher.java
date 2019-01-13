package com.example.vasyl.prostir;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.vasyl.prostir.data.ServiceReference;
import com.example.vasyl.prostir.ui.Authorization;
import com.example.vasyl.prostir.ui.CountryPicker;

public class launcher extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ServiceReference.initDataBase();
        if (true) {
            Intent i = new Intent(this, CountryPicker.class);
            startActivity(i);
        } else {
            Intent i = new Intent(this, Authorization.class);
            startActivity(i);
        }

    }
}
