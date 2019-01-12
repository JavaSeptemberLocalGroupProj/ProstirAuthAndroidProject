package com.example.vasyl.prostir.ui;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.vasyl.prostir.R;

public class SelectAuthType extends AppCompatActivity {
    private String userPhoneNumber;
    private Button acceptByCallBtn;
    private Button acceptBySMSlBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_auth_type);

        Bundle bundle = getIntent().getExtras();
        userPhoneNumber = bundle.getString("USER_NUMBER");
        acceptByCallBtn = (Button) findViewById(R.id.acceptByCallBtn);
        acceptBySMSlBtn = (Button) findViewById(R.id.acceptBySMSlBtn);

        ActionBar actionBar = getActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void onAcceptByCallBtnClick (View view) {
        Intent i = new Intent(this, AcceptByCall.class);
        startActivity(i);
    }

    public void onAcceptBySMSBtnClick (View view) {
        Intent i=new Intent(this, AcceptBySms.class);
        startActivity(i);
    }
}
