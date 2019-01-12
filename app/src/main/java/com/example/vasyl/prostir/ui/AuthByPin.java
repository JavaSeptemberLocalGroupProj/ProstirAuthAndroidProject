package com.example.vasyl.prostir.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.vasyl.prostir.R;
import com.goodiebag.pinview.Pinview;

public class AuthByPin extends AppCompatActivity {

    private final static String PASSWORD = "0123";
    static TextView tw;
    static Pinview pw;

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
                    ///////// Переход /////////
                    /*Intent i = new Intent(INSERT PARAMETERS HERE);
                    startActivity(i);*/
                }
            }
        });


    }
    boolean b;
    public boolean isRightPassword(String enteredPassword){
        /*if (enteredPassword.equals(PASSWORD)) {
            tw.setText("You're enter");
            boolean b = true;
            gotoMain();
            return true;
        }
        else {
            tw.setText("The code is incorrect!");
            pw.setInputType(Pinview.InputType.TEXT);
            pw.setValue("");
            pw.setInputType(Pinview.InputType.NUMBER);
            boolean b = false;
            return false;
        }*/
        enteredPassword = pw.getValue();
        if(enteredPassword.length() == 4){
            Intent i = new Intent(this, AccountsList.class);
            startActivity(i);
        }
        return false;
    }
    void gotoMain(){
        if(b){
            Intent i = new Intent(this, AccountsList.class);
            startActivity(i);
        }
        return;
    }

}
