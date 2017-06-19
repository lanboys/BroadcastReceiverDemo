package com.m520it.threadandservice;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void startNewService(View view) {

        Intent intent = new Intent(this, MyService.class);
        startService(intent);

    }

    public void startNewThread(View view) {
        //启动一个线程,3s打印一次,当外界关闭进程时，线程也将关闭，不再执行
        new Thread(){
            @Override
            public void run() {
                while (true) {

                SystemClock.sleep(3000);
                Log.v("-->520it", "MainActivity.run():25:: ");
                }
            }
        }.start();
    }
}
