package com.example.vasyl.prostir;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;

import com.example.vasyl.prostir.data.ServiceReference;
import com.example.vasyl.prostir.ui.Authorization;
import com.example.vasyl.prostir.ui.CountryPicker;


public class launcher extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ServiceReference.connectToServer();
        ServiceReference.setUserPhoneNumber(requireUserPhoneNumber());

        if (ServiceReference.isRegisteredDevice()) {
            Intent i = new Intent(this, CountryPicker.class);
            startActivity(i);
        } else {
            Intent i = new Intent(this, Authorization.class);
            startActivity(i);
        }
    }


    private String requireUserPhoneNumber() {
        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        String userPhoneNumber = "";
        try {
            userPhoneNumber = telephonyManager.getLine1Number();
        } catch (SecurityException e) {}
        return userPhoneNumber;
    }
}
