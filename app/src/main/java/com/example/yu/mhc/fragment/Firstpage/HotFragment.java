package com.example.yu.mhc.fragment.Firstpage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yu.mhc.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YU on 2017/6/25.
 */
public class HotFragment extends Fragment {
    private List<Fragment>list=new ArrayList<>();
    private ViewPager vp;
    private Myadapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.hot_item,null);
        vp = (ViewPager)view.findViewById(R.id.viewPager);
        TabLayout tl=(TabLayout)view.findViewById(R.id.tabl);
        tl.addTab(tl.newTab().setText("周一"));
        tl.addTab(tl.newTab().setText("周二"));
        tl.addTab(tl.newTab().setText("周三"));
        tl.addTab(tl.newTab().setText("周四"));
        tl.addTab(tl.newTab().setText("周五"));
        tl.addTab(tl.newTab().setText("周六"));
        tl.addTab(tl.newTab().setText("周日"));
        addData();
        adapter = new Myadapter(getChildFragmentManager());
        vp.setAdapter(adapter);
        tl.setupWithViewPager(vp);
        return view ;
    }

    private void addData() {
        list.add(new one());
        list.add(new Two());
        list.add(new Three());
        list.add(new Four());
        list.add(new Five());
        list.add(new Six());
        list.add(new Seven());
    }

    class Myadapter extends FragmentPagerAdapter{
        private String[] titles = new String[]{"周一", "周二", "周三", "周四", "周五", "周六", "周日"};
        public Myadapter(FragmentManager fm) {
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
        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }

    }

}
