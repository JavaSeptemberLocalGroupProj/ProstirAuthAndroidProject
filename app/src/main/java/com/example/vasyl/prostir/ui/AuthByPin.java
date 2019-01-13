package com.example.vasyl.prostir.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.vasyl.prostir.R;
import com.example.vasyl.prostir.data.ServiceReference;
import com.goodiebag.pinview.Pinview;

public class AuthByPin extends AppCompatActivity {

    private final static String PASSWORD = ServiceReference.getUserPasswordForApp();
    private static TextView tw;
    private static Pinview pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth_by_pin);
        pw = findViewById(R.id.pinViewForAuth);
        tw = findViewById(R.id.errorMessageText);
        pw.setPinViewEventListener(new Pinview.PinViewEventListener() {
            @Override
            public void onDataEntered(Pinview pinview, boolean b) {
                if (isRightPassword(pinview.getValue())){
                    Intent i = new Intent(AuthByPin.this, AccountsList.class);
                    startActivity(i);
                }
            }
        });
    }

    public boolean isRightPassword(String enteredPassword){
        if(enteredPassword.length() == 4){
            if (enteredPassword.equals(PASSWORD)) {
                tw.setText("You're enter");
                return true;
            }
            else {
                tw.setText("The code is incorrect!");
                pw.setInputType(Pinview.InputType.TEXT);
                pw.setValue("");
                pw.setInputType(Pinview.InputType.NUMBER);
                return false;
            }
        }
        return false;
    }
}
