package com.m520it.gamer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class PlayE extends BroadcastReceiver {
    public PlayE() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.v("-->520it", "PlayE.onReceive():13:: " + getResultData());
    }
}
