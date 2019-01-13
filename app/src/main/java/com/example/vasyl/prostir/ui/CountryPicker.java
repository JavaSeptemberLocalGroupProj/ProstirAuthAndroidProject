package com.example.vasyl.prostir.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputFilter;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.vasyl.prostir.R;
import com.example.vasyl.prostir.data.ServiceReference;
import com.rilixtech.CountryCodePicker;

public class CountryPicker extends AppCompatActivity {

    private CountryCodePicker CountryCodePicker;
    private TextView numberTextView;
    private EditText phoneNumber;
    private Button toNextPageBtn;

    private String countryCode;
    private String userNumberPhone;
    private String userFullNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_picker);
        CountryCodePicker = (CountryCodePicker) findViewById(R.id.countryCodePicker);
        // ADD FUNCTIONALITY TO GET USER PHONE NUMBER
        toNextPageBtn = (Button)findViewById(R.id.toNextPageBtn);
        numberTextView = findViewById(R.id.numberTextView);
        phoneNumber = (EditText) findViewById(R.id.numberTextView);
        InputFilter[] FilterArray = new InputFilter[1];
        FilterArray[0] = new InputFilter.LengthFilter(14);
        /*phoneNumer.setFilters(FilterArray);
        phoneNumer.addTextChangedListener(new PhoneNumberFormattingTextWatcher());*/
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        ServiceReference.setUserPhoneNumber(phoneNumber.getText().toString());
        Intent myIntent = new Intent(getApplicationContext(), SelectAuthType.class);
        startActivityForResult(myIntent, 0);
        return true;
    }

    public void getNumber(){
        countryCode = CountryCodePicker.getSelectedCountryCodeWithPlus();
        userFullNumber = countryCode;
        /*userNumberPhone = numberTextView.getText().toString();
        userFullNumber = userFullNumber + userNumberPhone;*/
    }

    public void onGoNextBtnClick(View v){
        getNumber();
        Intent i = new Intent(this, SelectAuthType.class);
        i.putExtra("USER_NUMBER", userNumberPhone);
        startActivity(i);
    }
}
