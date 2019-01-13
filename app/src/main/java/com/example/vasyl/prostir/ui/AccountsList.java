package com.example.vasyl.prostir.ui;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.vasyl.prostir.R;

import java.util.ArrayList;
import java.util.HashMap;


public class AccountsList extends AppCompatActivity{

    private ListView listViewOfAccounts;
    private ArrayList<HashMap<String, String>> arrayListOfAccounts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accounts_list);

        Toolbar toolbarMenu = (Toolbar) findViewById(R.id.toolbarMenu);
        listViewOfAccounts = (ListView) findViewById(R.id.listViewOfAccounts);

        arrayListOfAccounts = new ArrayList<>();
        HashMap<String, String> map;

        map = new HashMap<>();
        map.put("Name", "Instagram");
        map.put("Tel", "495 501-3545");
        arrayListOfAccounts.add(map);

        map = new HashMap<>();
        map.put("Name", "Telegram");
        map.put("Tel", "495 241-6845");
        arrayListOfAccounts.add(map);

        map = new HashMap<>();
        map.put("Name", "Facebook");
        map.put("Tel", "495 431-5468");
        arrayListOfAccounts.add(map);


        listViewOfAccounts.setEnabled(false);
        final SimpleAdapter adapter = new SimpleAdapter(this, arrayListOfAccounts, android.R.layout.simple_list_item_2,
                new String[]{"Name", "Tel"},
                new int[]{android.R.id.text1, android.R.id.text2});
        listViewOfAccounts.setAdapter(adapter);


        listViewOfAccounts.setOnItemClickListener(new AdapterView.OnItemClickListener(){ // DELETE ACCOUNT
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                arrayListOfAccounts.remove(position);
                adapter.notifyDataSetChanged();
                listViewOfAccounts.setBackgroundColor(0);
                listViewOfAccounts.setEnabled(false);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (item.getItemId()){
            case R.id.addNewAccountMenuItem:
            {
                Intent i = new Intent(this, AccountAdd.class);
                startActivity(i);
                return false;
            }
            case R.id.connectedDevicesMenuItem:
            {
                Intent i = new Intent(this, DevicesList.class);
                startActivity(i);
                return false;
            }
            case R.id.deleteAccountMenuItem: {
                listViewOfAccounts.setEnabled(true);
                Toast.makeText(getApplicationContext(),
                        "Click on item to delete it",
                        Toast.LENGTH_SHORT)
                        .show();
                listViewOfAccounts.setBackgroundColor(Color.parseColor("#F6F6F6"));
                return false;
            }
            case R.id.logOutMenuItem: {
                Intent i = new Intent(this, CountryPicker.class);
                startActivity(i);
                return false;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
