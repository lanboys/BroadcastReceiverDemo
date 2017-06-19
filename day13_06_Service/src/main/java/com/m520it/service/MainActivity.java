package com.m520it.service;

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
    public void startService(View view) {
        //显示启动服务
        Intent intent = new Intent(this, MyService.class);
        startService(intent);
    }
    public void closeService(View view) {
        //关闭服务(服务内部可以kill自己)
        Intent intent = new Intent(this, MyService.class);
        stopService(intent);
    }
}
