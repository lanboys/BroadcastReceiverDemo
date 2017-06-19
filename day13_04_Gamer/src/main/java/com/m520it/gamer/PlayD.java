package com.m520it.gamer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class PlayD extends BroadcastReceiver {
    public PlayD() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.v("-->520it", "PlayD.onReceive():13:: " + getResultData()+"----我要终止游戏");
        //终止广播
        abortBroadcast();
    }
}
