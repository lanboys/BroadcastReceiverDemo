package com.m520it.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //服务是在主线程执行的
        Log.v("-->520it", "MainActivity.startService():18:: "+Thread.currentThread().getName());

        //Service 可以在自己内部 kill自己
//        stopSelf();


    }

    @Override
    public void onDestroy() {
        Log.v("-->520it", "MainActivity.closeService():26:: "+Thread.currentThread().getName());
        super.onDestroy();
    }
}
