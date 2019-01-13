package com.example.vasyl.prostir.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.vasyl.prostir.R;
import com.example.vasyl.prostir.data.ServiceReference;

public class DecryptedMessage extends AppCompatActivity {
    String codeTemp = "BLPONB - 789"; // Code from server
    TextView passwordTextView;
    EditText description_EditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decrypted_message);
        passwordTextView = findViewById(R.id.passwordTextView);
        passwordTextView.setText(codeTemp);
        description_EditText = findViewById(R.id.description_EditText_dm);
        description_EditText.setText(ServiceReference.getDescription_Temp());
    }
    public void onGoNextBtnClick_dm(View v){
        String name = description_EditText.getText().toString();
        String token = codeTemp;
        ServiceReference.addItemToArrayListOfAccounts(name, token);
        Intent i = new Intent(this, Authorization.class);
        startActivity(i);
    }
}
