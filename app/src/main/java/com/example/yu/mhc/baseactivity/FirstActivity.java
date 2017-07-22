package com.example.yu.mhc.baseactivity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.yu.mhc.R;
import com.example.yu.mhc.fragment.Community_Fragment;
import com.example.yu.mhc.fragment.FindFragment;
import com.example.yu.mhc.fragment.Firstpage.FirstFragment;
import com.example.yu.mhc.fragment.Me_Fragment;
import com.hjm.bottomtabbar.BottomTabBar;

public class FirstActivity extends AppCompatActivity{

    private BottomTabBar bottomTabBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        initData();//初始化数据
        ListenerData();//监听事件方法

    }

    //初始化书
    private void initData() {
        bottomTabBar = (BottomTabBar)findViewById(R.id.bottom_tab_bar);
        bottomTabBar.init(getSupportFragmentManager())
                .setImgSize(18,18)
                .setFontSize(10)
                .setTabPadding(4,6,10)
                .setChangeColor(Color.RED,Color.BLACK)
        .addTabItem("漫画",R.drawable.ic_tabbar_home_normal, FirstFragment.class)
        .addTabItem("发现",R.drawable.ic_tabbar_discover_normal, FindFragment.class)
        .addTabItem("V社区",R.drawable.ic_tabbar_feed_normal, Community_Fragment.class)
        .addTabItem("我的",R.drawable.ic_tabbar_me_normal, Me_Fragment.class)
        .isShowDivider(false);

    }
    //监听事件
    private void ListenerData() {

    }
}
