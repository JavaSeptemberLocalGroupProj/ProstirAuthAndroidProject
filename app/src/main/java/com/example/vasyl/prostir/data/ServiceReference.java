package com.example.vasyl.prostir.data;

import android.bluetooth.BluetoothAdapter;
import android.os.Build;

import com.example.vasyl.prostir.R;
import com.example.vasyl.prostir.models.Device;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class ServiceReference {

    private final String PASSWORD = "0123";
    private final String PHONENUMBER = "6505551212";

    private static String userPhoneNumber;

    private static String Description_Temp;

    private static ArrayList<HashMap<String, String>> arrayListOfAccounts = new ArrayList<>();
    private static ArrayList<Device> deviceList = new ArrayList<Device>();

    public static void initDataBase() {

        HashMap<String, String> map;

        map = new HashMap<>();
        map.put("Name", "Instagram");
        map.put("Token", "495 501-3545");
        arrayListOfAccounts.add(map);

        map = new HashMap<>();
        map.put("Name", "Telegram");
        map.put("Token", "495 241-6845");
        arrayListOfAccounts.add(map);

        map = new HashMap<>();
        map.put("Name", "Facebook");
        map.put("Token", "495 431-5468");
        arrayListOfAccounts.add(map);



        deviceList.add(new Device("Galaxy s8", "29.06.18", R.mipmap.ic_launcher));
        deviceList.add(new Device("Redmi 4x","12.01.19", R.mipmap.ic_launcher));
        deviceList.add(new Device("iPhone 8", "01.01.18", R.mipmap.ic_launcher));
        deviceList.add(new Device("iPad", "02.06.17", R.mipmap.ic_launcher));
        deviceList.add(new Device("iPad X", "08.09.17", R.mipmap.ic_launcher));
        deviceList.add(new Device("iPhone XR", "11.12.18", R.mipmap.ic_launcher));
        deviceList.add(new Device("iPhone XR", "11.12.18", R.mipmap.ic_launcher));
        deviceList.add(new Device("Galaxy s8", "29.06.18", R.mipmap.ic_launcher));
        deviceList.add(new Device("Redmi 4x","12.01.19", R.mipmap.ic_launcher));
        deviceList.add(new Device("iPhone 8", "01.01.18", R.mipmap.ic_launcher));
        deviceList.add(new Device("iPad", "02.03.17", R.mipmap.ic_launcher));
    }

    public static void addPrimaryToDeviceList() {
        BluetoothAdapter myDevice = BluetoothAdapter.getDefaultAdapter();
        String deviceName = Build.MANUFACTURER + " " + Build.MODEL;

        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yy ");
        Date date = new Date();
        String todayDate = dateFormat.format(date);

        try {
            deviceName += " " + myDevice.getName();
        } catch (Exception e) {
            // TODO
        }

        deviceList.add(new Device(deviceName, todayDate, R.mipmap.ic_launcher));
    }

    public static ArrayList<HashMap<String, String>> getArrayListOfAccounts() {

        return arrayListOfAccounts;
    }

    public static void addItemToArrayListOfAccounts(String name, String token) {
        HashMap<String, String> map;

        map = new HashMap<>();
        map.put("Name", name);
        map.put("Token", token);

        arrayListOfAccounts.add(map);
    }

    public static ArrayList<Device> getDeviceList() {

        return deviceList;
    }

    public static String getDescription_Temp() {
        return Description_Temp;
    }

    public static void setDescription_Temp(String value) {
        Description_Temp = value;
    }

}
