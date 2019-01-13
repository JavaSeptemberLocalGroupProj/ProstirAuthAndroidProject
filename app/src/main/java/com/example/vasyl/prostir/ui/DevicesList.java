package com.example.vasyl.prostir.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;

import com.example.vasyl.prostir.R;
import com.example.vasyl.prostir.data.ServiceReference;
import com.example.vasyl.prostir.models.Device;
import com.example.vasyl.prostir.utils.DeviceAdapter;

import java.util.ArrayList;


public class DevicesList extends AppCompatActivity {

    private Switch allowSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_devices_list);
        ArrayList<Device> device = ServiceReference.getDeviceList();
        DeviceAdapter deviceAdapter = new DeviceAdapter(this, device);
        ListView listView = (ListView) findViewById(R.id.listview_flavor);
        listView.setAdapter(deviceAdapter);
        allowSwitch = findViewById(R.id.allowSwitch);
        allowSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               if (isChecked) {
                    ServiceReference.setAllowMultipleDevices(true);
                   // TODO
               } else {
                   ServiceReference.setAllowMultipleDevices(false);
                   // TODO
               }
            }
        });
    }
}
