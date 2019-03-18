package com.intent.com.intentservice;

import android.content.Intent;
import android.os.Handler;
import android.os.ResultReceiver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textViewID);
        handler = new Handler();
    }



    public void intentServiceMethod(View view) {
        ResultReceiver resultReceiver = new MyResultReceiver(null);
        Intent intent = new Intent(MainActivity.this,MyIntentService.class);
        intent.putExtra("sleep",20);
        intent.putExtra("receiver",resultReceiver);
        startService(intent);
    }
    private class MyResultReceiver extends ResultReceiver {


        public MyResultReceiver(Handler handler) {
            super(handler);
        }

        @Override
        protected void onReceiveResult(int resultCode, Bundle resultData) {
            super.onReceiveResult(resultCode, resultData);
            if (resultCode == 10 & resultData != null) {
                final String result = resultData.getString("resultData");
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                         textView.setText(result);
                    }
                });
            }
        }
    }

}
