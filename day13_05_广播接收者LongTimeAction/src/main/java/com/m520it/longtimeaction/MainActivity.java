package com.m520it.longtimeaction;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnOnClick(View view) {
        //显示发送一条耗时广播,程序内部广播可以不需要intent filter
        Intent intent = new Intent(this, MyReceiver.class);
        sendBroadcast(intent);
    }
}
