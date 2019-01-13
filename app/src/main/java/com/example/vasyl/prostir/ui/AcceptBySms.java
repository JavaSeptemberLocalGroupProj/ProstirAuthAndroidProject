package com.example.vasyl.prostir.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vasyl.prostir.R;
import com.example.vasyl.prostir.data.ServiceReference;
import com.goodiebag.pinview.Pinview;

public class AcceptBySms extends AppCompatActivity {

    private final static String PASSWORD = ServiceReference.getPassword();
    private final static String PHONENUMBER = ServiceReference.getPhoneNumber();

    private static TextView tw;
    private static Pinview pw;

    public static boolean isAcceptBySmsActive = false;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accept_by_sms);

        isAcceptBySmsActive = true;
        pw = findViewById(R.id.pinView);
        tw = findViewById(R.id.errorMsgTextView);
        pw.setPinViewEventListener(new Pinview.PinViewEventListener() {
            @Override
            public void onDataEntered(Pinview pinview, boolean b) {
                isRightPassword(pinview.getValue());
            }
        });
    }

    public void onSendMsgAgainBtnClick(View view) {
        Toast.makeText(getApplicationContext(),
                "Sending message...",
                Toast.LENGTH_SHORT)
                .show();
        ServiceReference.sendSMSAgain();
    }

    public void isRightPassword (String enteredPassword){
        if (enteredPassword.equals(PASSWORD))  {
            Intent i = new Intent(this, AccountsList.class);
            isAcceptBySmsActive = false;
            ServiceReference.addCurrentToDeviceList();
            startActivity(i);
        }
        else {
            tw.setText("The code is incorrect!");
            pw.setInputType(Pinview.InputType.TEXT);
            pw.setValue("");
            pw.setInputType(Pinview.InputType.NUMBER);
        }
    }

    public static boolean isRightPhone (String PhoneNumber) {
        boolean result = false;
        if (PhoneNumber.equals(PHONENUMBER)) result = true;
        return result;
    }

    public static void setPw (String code) {
        pw.setValue(code);
    }
}

