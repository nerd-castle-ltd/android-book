package com.intent.com.startedservice;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class StartedService extends Service {

    private static final String TAG= StartedService.class.getName();
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: Thread name "+ Thread.currentThread().getName());
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: Thread name "+Thread.currentThread().getName());
        int sleepTime = intent.getIntExtra("sleep",0);
        new MyAsyc().execute(sleepTime);
        //Perform short running task because it works main thread
       return super.onStartCommand(intent, flags, startId);
       // return START_STICKY;
       // return START_REDELIVER_INTENT;
       /// return START_NOT_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind: Thread name "+ Thread.currentThread().getName());
        return null;
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy: Thread name "+ Thread.currentThread().getName());
        super.onDestroy();
    }

    class MyAsyc extends AsyncTask<Integer,Void,Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        // Perform long running task
        @Override
        protected Void doInBackground(Integer... voids) {
            int sleep = voids[0];
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }
}
