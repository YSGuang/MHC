package com.example.yu.mhc;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.yu.mhc.baseactivity.Main2Activity;

/**
 * 引导页
 */

public class MainActivity extends AppCompatActivity {
    private Handler hand=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            //跳转
            startActivity(new Intent(MainActivity.this, Main2Activity.class));
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //查找控件
        TextView tv=(TextView)findViewById(R.id.wherecom);
        //延迟3秒发送消息
        hand.sendEmptyMessageDelayed(0,3000);

    }
}
