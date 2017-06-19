package com.m520it.musicrecevier;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Toast;

public class MyMusicReceiver extends BroadcastReceiver {
    public MyMusicReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        SystemClock.sleep(4*1000);
        Toast.makeText(context, "收到音乐之声发的广播", Toast.LENGTH_SHORT).show();
        Log.v("-->520it", "MyMusicReceiver.onReceive():17:: " + "收到音乐之声发的广播");

    }
}
