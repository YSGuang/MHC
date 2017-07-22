package com.example.yu.mhc.fragment.Firstpage;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.yu.mhc.R;
import com.example.yu.mhc.adapter.Weekadapter;
import com.example.yu.mhc.bean.WeekBean;
import com.example.yu.mhc.url.UrlUtils;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YU on 2017/6/28.
 */
public class one extends Fragment {
    private ListView lv;
    private List<WeekBean.DataBean.ComicsBean>list=new ArrayList<>();
    private View view;
    private String path="http://api.kkmh.com/v1/daily/comic_lists/0?since=0&gender=0&sa_event=eyJwcm9qZWN0Ijoia3VhaWthbl9hcHAiLCJ0aW1lIjoxNDg3ODI4ODU4NjAwLCJwcm9wZXJ0aWVzIjp7IkhvbWVwYWdlVGFiTmFtZSI6IueDremXqCIsIlZDb21tdW5pdHlUYWJOYW1lIjoi54Ot6ZeoIiwiJG9zX3ZlcnNpb24iOiI0LjIuMiIsIkdlbmRlclR5cGUiOiLlpbPniYgiLCJGcm9tSG9tZXBhZ2VUYWJOYW1lIjoi54Ot6ZeoIiwiJGxpYl92ZXJzaW9uIjoiMS42LjM0IiwiJG5ldHdvcmtfdHlwZSI6IldJRkkiLCIkd2lmaSI6dHJ1ZSwiJG1hbnVmYWN0dXJlciI6InNhbXN1bmciLCJGcm9tSG9tZXBhZ2VVcGRhdGVEYXRlIjowLCIkc2NyZWVuX2hlaWdodCI6NTc2LCJIb21lcGFnZVVwZGF0ZURhdGUiOjAsIlByb3BlcnR5RXZlbnQiOiJSZWFkSG9tZVBhZ2UiLCJGaW5kVGFiTmFtZSI6IuaOqOiNkCIsImFidGVzdF9ncm91cCI6NDYsIiRzY3JlZW5fd2lkdGgiOjEwMjQsIiRvcyI6IkFuZHJvaWQiLCJUcmlnZ2VyUGFnZSI6IkhvbWVQYWdlIiwiJGNhcnJpZXIiOiJDTUNDIiwiJG1vZGVsIjoiR1QtUDUyMTAiLCIkYXBwX3ZlcnNpb24iOiIzLjguMSJ9LCJ0eXBlIjoidHJhY2siLCJkaXN0aW5jdF9pZCI6IkE6OTA1MTA0Mjc2Mzc1NTEwOSIsIm9yaWdpbmFsX2lkIjoiQTo5MDUxMDQyNzYzNzU1MTA5IiwiZXZlbnQiOiJSZWFkSG9tZVBhZ2UifQ%3D%3D";
    private Handler hand=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            Gson gson=new Gson();
            WeekBean bean=gson.fromJson(msg.obj.toString(),WeekBean.class);
            list.addAll(bean.getData().getComics());
            weekadapter.notifyDataSetChanged();
        }
    };
    private Weekadapter weekadapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.week_list,null);
        initData();//初始化数据
        loadData();//网络请求
        return view;
    }
    //网络请求
    private void loadData() {
        new Thread(){
            @Override
            public void run() {
                String reulset= UrlUtils.getUrlConnect(path);
                Message msg=Message.obtain();
                msg.obj=reulset;
                msg.what=1;
                hand.sendMessage(msg);
            }
        }.start();
    }

    //初始化数据
    private void initData() {
        lv=(ListView)view.findViewById(R.id.lv);
        weekadapter = new Weekadapter(list, getActivity());
        lv.setAdapter(weekadapter);

    }
}
