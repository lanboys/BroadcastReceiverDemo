package com.m520it.longtimeaction;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {
    public MyReceiver() {
    }

    @Override
   public void onReceive(Context context, Intent intent) {
        Log.v("-->520it", "MyReceiver.onReceive():13:: ");
        //耗时操作超过5s就会报  ANR 错误 application not responding
        SystemClock.sleep(5*1000);
    }
}
