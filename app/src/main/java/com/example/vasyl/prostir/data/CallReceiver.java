package com.example.vasyl.prostir.data;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import com.example.vasyl.prostir.models.ITelephony;
import com.example.vasyl.prostir.ui.AcceptByCall;
import com.example.vasyl.prostir.ui.AcceptBySms;

public class CallReceiver extends BroadcastReceiver {
    String phoneNumber;
    String serverPhoneNumber;

    public void onReceive(Context context, Intent intent) {
        if (AcceptByCall.isAcceptByCallActive) {
            if (intent.getAction().equals("android.intent.action.PHONE_STATE")){
                String phone_state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
                if (phone_state.equals(TelephonyManager.EXTRA_STATE_RINGING)) { // Получение входящего номера
                    if (true) { // Добавить проверку на правильность номера
                        phoneNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
                        System.out.println(phoneNumber);
                        AcceptByCall.setEnterText();
                    }
                } else if (phone_state.equals(TelephonyManager.EXTRA_STATE_OFFHOOK)){
                    // Если телефон находится в режиме звонка (набор номера / разговор)
                    // TODO
                } else if (phone_state.equals(TelephonyManager.EXTRA_STATE_IDLE)){
                    //телефон находиться в ждущем режиме. Это событие наступает по окончанию разговора, когда мы уже знаем номер и факт звонка
                    // TODO
                }
            }
        }
    }
}