package com.intent.com.orderedbroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;


public class MyFirstReceiver extends BroadcastReceiver {

    private static final String TAG= MyFirstReceiver.class.getName();
    @Override
    public void onReceive(Context context, Intent intent) {
        int initCode= getResultCode();
        String initalData= getResultData();
       Bundle initialBundle= getResultExtras(true);
       String title = initialBundle.getString("title");

        Log.d(TAG, "code: "+ initCode+", Data: "+ initalData+ ", title: "+title);
        Log.d(TAG, "My First Receiver");

        initialBundle.putString("title","wowDeveloper");
        setResult(2,"IOS",initialBundle);

    }
}
