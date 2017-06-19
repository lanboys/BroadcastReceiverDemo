package com.m520it.gamer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class PlayC extends BroadcastReceiver {
    public PlayC() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.v("-->520it", "PlayC.onReceive():13:: " + getResultData());
    }
}
