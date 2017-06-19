package com.m520it.telephonetap;

import android.content.Intent;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MediaRecorder mRecorder = null;
    private boolean mIsRecordering = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button listenBtn = (Button) findViewById(R.id.listen_btn);
        Button recoderBtn = (Button) findViewById(R.id.recoder_btn);

        listenBtn.setOnClickListener(this);
        recoderBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.listen_btn://启动窃听服务
                listenBtnOnClick();
                break;
            case R.id.recoder_btn://开始停止录音
                RecorderBtnOnClick();
                break;

        }

    }

    public void listenBtnOnClick() {
        Intent intent = new Intent(this, telephoneTapService.class);
        startService(intent);
    }

    //开始停止录音判断
    public void RecorderBtnOnClick() {
        if (mIsRecordering) {
            stopRecording();
            Toast.makeText(this, "录音结束", Toast.LENGTH_SHORT).show();
            mIsRecordering = false;
            return;
        }
        startRecording(get3GPFilePath("10086"));
        Toast.makeText(this, "开始录音", Toast.LENGTH_SHORT).show();
        mIsRecordering = true;
    }

    //开始录音
    private void startRecording(String fileName) {

        mRecorder = new MediaRecorder();
        //设置声音来源  MIC 麦克风
        mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        //设置输出格式
        mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        //文件输出路径
        mRecorder.setOutputFile(fileName);
        //设置编码格式
        mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        try {
            mRecorder.prepare();
        } catch (IOException e) {
            Log.v("-->520it", "telephoneTapService.startRecording():78:: " + "prepare() failed");
        }

        mRecorder.start();
    }

    //录音结束
    private void stopRecording() {
        mRecorder.stop();
        mRecorder.release();
        mRecorder = null;
    }


    private String get3GPFilePath(String phoneNumber) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd-hh:ss");
        File file = new File(getFilesDir(), phoneNumber + "#" + dateFormat.format(new Date()));
        return file.getAbsolutePath();
    }
}
