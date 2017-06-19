package com.m520it.home;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.m520it.home.bean.HomeBean;
import com.m520it.home.bean.ResultApi;
import com.m520it.home.utils.Request;
import com.thoughtworks.xstream.XStream;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView mLv;
    private ArrayList<HomeBean> mDatas;
    private ListViewAdapter mAdapter;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {

            String str = (String) msg.obj;

            mDatas = initDatas(str);

            mAdapter.setMDatas(mDatas);
            mAdapter.notifyDataSetChanged();

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mLv = (ListView) findViewById(R.id.lv);
        mAdapter = new ListViewAdapter(this);
        mLv.setAdapter(mAdapter);

        Request.loadStringByRequest(this, mHandler, "http://f.xmg520.cn:82/LoginDemo/servlet/HomeAction");


    }

    private ArrayList<HomeBean> initDatas(String str) {
        ResultApi resultApi = parseXml(str);
        return resultApi.getDate();
    }
    public ResultApi parseXml(String xml) {
        ResultApi reap = null;
        try {
            // InputStream in = context.getResources().getAssets().open("xiaomage.xml");
            // String xml = StreamUtil.readFromStream(in);
            XStream xStream = new XStream();

            xStream.alias("ResultApi", ResultApi.class);
            xStream.alias("HomeBean", HomeBean.class);

            reap = (ResultApi) xStream.fromXML(xml);
            Log.v("RequestUtils", reap.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reap;
    }
}
