package com.example.vasyl.prostir.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.vasyl.prostir.R;
import com.rilixtech.CountryCodePicker;

public class CountryPicker extends AppCompatActivity {

    CountryCodePicker CountryCodePicker;
    TextView numberTextView;
    EditText phoneNumer;
    Button toNextPageBtn;

    String countryCode;
    String userNumberPhone;
    String userFullNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_picker);
        CountryCodePicker = (CountryCodePicker) findViewById(R.id.countryCodePicker);
        toNextPageBtn = (Button)findViewById(R.id.toNextPageBtn);
        numberTextView = findViewById(R.id.numberTextView);

        phoneNumer = (EditText) findViewById(R.id.numberTextView);
        phoneNumer.addTextChangedListener(new PhoneNumberFormattingTextWatcher());
    }

    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), SelectAuthType.class);
        startActivityForResult(myIntent, 0);
        return true;
    }

    public void getNumber(){
        countryCode = CountryCodePicker.getSelectedCountryCodeWithPlus();
        userFullNumber = countryCode;
        userNumberPhone = numberTextView.getText().toString();
        userFullNumber = userFullNumber + userNumberPhone;
    }

    public void onGoNextBtnClick(View v){
        getNumber();
        Intent i = new Intent(this, SelectAuthType.class);
        i.putExtra("USER_NUMBER", userNumberPhone);
        startActivity(i);
    }
}
