package com.example.yu.mhc.fragment.Firstpage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.example.yu.mhc.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页的fragment关注和热门联动页面
 * Created by YU on 2017/6/25.
 */
public class FirstFragment extends Fragment{
    List<Fragment>list=new ArrayList<>();
    private ViewPager vp;
    private View view;
    private MyAdapter adapter;
    private RadioGroup rg;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.firstfragment,null);
        initData();
        Listener();
        return view;
    }
    //初始化数据
    private void initData() {
        vp = (ViewPager)view.findViewById(R.id.vp_first);
        list.add(new ConcernFragment());
        list.add(new HotFragment());
        adapter = new MyAdapter(getChildFragmentManager());
        vp.setAdapter(adapter);
        vp.setCurrentItem(1);
        rg = (RadioGroup)view.findViewById(R.id.rg);

    }

    private void Listener() {
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.concern:
                        vp.setCurrentItem(0);
                        break;
                    case R.id.hot:
                        vp.setCurrentItem(1);
                        break;
                }
            }
        });
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        rg.check(R.id.concern);
                        break;
                    case 1:
                        rg.check(R.id.hot);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public class MyAdapter extends FragmentPagerAdapter{

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }
    }
}
