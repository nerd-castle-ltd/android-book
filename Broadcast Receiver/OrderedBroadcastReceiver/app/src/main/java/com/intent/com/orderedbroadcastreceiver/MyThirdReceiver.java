package com.intent.com.orderedbroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class MyThirdReceiver extends BroadcastReceiver {
    private static final String TAG= MyThirdReceiver.class.getName();
    @Override
    public void onReceive(Context context, Intent intent) {
        int initCode= getResultCode();
        String initalData= getResultData();
        Bundle initialBundle= getResultExtras(true);
        String title = initialBundle.getString("title");

        Log.d(TAG, "code: "+ initCode+", Data: "+ initalData+ ", title: "+title);
        Log.d(TAG, "My Thired Receiver");
        initialBundle.putString("title","Developer");
        setResult(3,"C#",initialBundle);

    }
}
