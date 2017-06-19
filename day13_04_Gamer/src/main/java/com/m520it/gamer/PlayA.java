package com.m520it.gamer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class PlayA extends BroadcastReceiver {
    public PlayA() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.v("-->520it", "PlayA.onReceive():13:: " + getResultData());
    }
}
