package com.m520it.leader;

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

    public void sendBroadCastClick(View view) {
        Intent intent = new Intent("com.m520it.leader.action.GAMER");
        sendOrderedBroadcast(intent,null,null,null,0,"快乐大本营游戏成员",null);
        //receiverPermission   中央对地方政府发送文件   (省厅才可以)--(市级)  如果不要权限 设置为null
        //resultReceiver   暂定
        //scheduler 处理resultReceiver的信息
        //initialCode 发送广播的时候 对广播做了一个编号
        //initialData 广播的标题
        //initialExtras  Bundle 数据的整体
    }
}
