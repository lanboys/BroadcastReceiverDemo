package com.m520it.gamer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class PlayB extends BroadcastReceiver {
    public PlayB() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        //修改数据
        setResultData("傻逼游戏我不玩");
        Log.v("-->520it", "PlayB.onReceive():13:: " + getResultData());
    }
}
