package com.example.yu.mhc.fragment.Firstpage;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.yu.mhc.R;
import com.example.yu.mhc.baseactivity.LoginActivity;

/**
 *
 * Created by YU on 2017/6/25.
 */
public class ConcernFragment extends Fragment {
    private ImageView imag;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.concern_item,null);
        imag=(ImageView)view.findViewById(R.id.login);
        imag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            startActivity(new Intent(getActivity(), LoginActivity.class));
            }
        });
        return view;
    }
}
