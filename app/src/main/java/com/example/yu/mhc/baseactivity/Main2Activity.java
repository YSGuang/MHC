package com.example.yu.mhc.baseactivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.yu.mhc.R;

public class Main2Activity extends AppCompatActivity {
    private  int count=3;
    private Handler hand=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (count>0){
                count--;
                time.setText(count+" 跳过");
                hand.sendEmptyMessageDelayed(0,1000);
            }else {
                startActivity(new Intent(Main2Activity.this,FirstActivity.class));
                finish();
            }
        }
    };
    private TextView time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        time = (TextView)findViewById(R.id.time);
        time.setText("3 跳过");
        hand.sendEmptyMessageDelayed(0,1000);
//        time.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(Main2Activity.this,FirstActivity.class));
//
//            }
//        });
    }
}
