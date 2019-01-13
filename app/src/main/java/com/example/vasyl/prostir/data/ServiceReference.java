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


    // This final variables must to be changed to non-final when server will work.

    private final static String PASSWORD = "0123"; // Password from server
    private final static String PHONENUMBER = "6505551212"; // Phone from server
    private final static String TOKEN = "25"; // Token from server
    private final static String codeForAccount = "BLPONB - 789"; // Code for Account from Server

    private static String userPhoneNumber; // User phone number
    private static String Description_Temp; // Temp variable for Description of Account
    private static String userPasswordForApp = PASSWORD; // Password for enter to app (CHANGE)
    private static boolean AllowMultipleDevices; // Allow mupltiple devices variablwe to server

    private static ArrayList<HashMap<String, String>> arrayListOfAccounts = new ArrayList<>(); // List of Accounts
    private static ArrayList<Device> deviceList = new ArrayList<Device>(); // List of Devices

    public static void initDataBase() { // First initialization of Data

        // Accounts
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


        // Devices
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


    public static void addCurrentToDeviceList() { // This method adds current Device to Device List
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

    public static void sendSMSAgain() {
        // TODO
    }

    public static void makeCallAgain() {
        // TODO
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

    public static String getUserPhoneNumber() {

        return userPhoneNumber;
    }

    public static void setUserPhoneNumber(String value) {

        userPhoneNumber = value;
    }

    public static String getPassword() {

        return PASSWORD;
    }

    public static String getPhoneNumber() {

        return PHONENUMBER;
    }

    public static String getToken() {

        return TOKEN;
    }

    public static boolean isAllowMultipleDevices() {

        return AllowMultipleDevices;
    }

    public static void setAllowMultipleDevices(boolean value) {


        AllowMultipleDevices = value;
    }

    public static String getCodeForAccount() {

        return codeForAccount;
    }

    public static String getUserPasswordForApp() {

        return userPasswordForApp;
    }

    public static void setUserPasswordForApp() {
        // TODO
    }

}
