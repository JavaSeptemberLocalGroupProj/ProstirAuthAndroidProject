package com.example.vasyl.prostir.models;

public class Device {

    private String mDeviceName;
    private String mDeviceNumber;
    private int mImageResourceId;

    public Device(String dName, String dNumber, int imageResourceId)
    {
        mDeviceName = dName;
        mDeviceNumber = dNumber;
        mImageResourceId = imageResourceId;
    }

    public String getDeviceName() {
        return mDeviceName;
    }
    public String getDeviceNumber() {
        return mDeviceNumber;
    }
    public int getImageResourceId() {
        return mImageResourceId;
    }

}
