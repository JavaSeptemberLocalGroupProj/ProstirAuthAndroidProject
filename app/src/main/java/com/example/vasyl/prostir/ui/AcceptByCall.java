package com.example.vasyl.prostir.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vasyl.prostir.R;

public class AcceptByCall extends AppCompatActivity {

    TextView dot1, dot2, dot3;
    TextView[] dots;
    static TextView CallingTextView;
    public static boolean isAcceptByCallActive = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accept_by_call);
        isAcceptByCallActive = true;
        dot1 = findViewById(R.id.dot1);
        dot2 = findViewById(R.id.dot2);
        dot3 = findViewById(R.id.dot3);
        dots = new TextView[] {dot1, dot2, dot3};
        CallingTextView = findViewById(R.id.CallingTextView);
        for (TextView item: dots) {
            item.setVisibility(View.INVISIBLE);
        }
        new CountDownTimer((long)Double.POSITIVE_INFINITY, 1000) {
            int counter;
            @Override
            public void onTick(long millisUntilFinished) {
                if(counter == 3) {
                    counter = 0;
                    for (TextView item: dots) {
                        item.setVisibility(View.INVISIBLE);
                    }
                }
                dots[counter].setVisibility(View.VISIBLE);
                counter++;
            }
            @Override
            public void onFinish() { }
        }.start();
        CallingTextView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                goToNextPage();
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
    }

    public void onRecallBtnClick(View view) {
        Toast toast = Toast.makeText(getApplicationContext(),
                "Recalling...", Toast.LENGTH_SHORT);
        toast.show();

        // TODO
    }
    private void goToNextPage() {
        Intent i = new Intent(this, AccountsList.class);
        isAcceptByCallActive = false;
        startActivity(i);
    }
    public static void setEnterText() {
        CallingTextView.setText("Call Received!");
    }
}