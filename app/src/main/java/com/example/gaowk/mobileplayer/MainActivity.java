package com.example.gaowk.mobileplayer;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import java.util.ArrayList;

import base.BasePager;
import pager.AudioPager;
import pager.NetAudioPager;
import pager.NetVideoPager;
import pager.VideoPager;

/**
 * Created by GaoWK on 2019/1/22.
 */

public class MainActivity extends FragmentActivity {

    private RadioGroup rg_main;
    private ArrayList<BasePager> basePagers;
    private int position;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg_main = findViewById(R.id.rg_main);

        basePagers = new ArrayList<>();
        basePagers.add(new VideoPager(this));//本地视频
        basePagers.add(new AudioPager(this));//本地音频
        basePagers.add(new NetAudioPager(this));//网络视频
        basePagers.add(new NetVideoPager(this));//网络音频

        rg_main.check(R.id.rb_video);
        rg_main.setOnCheckedChangeListener(new MyOnCheckedChangeListener());
    }

    class MyOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {

            switch (checkedId){
                default:
                    position = 0;
                    break;
                case R.id.rb_audio://音频
                    position = 1;
                    break;
                case R.id.rb_net_video://网络视频
                    position = 2;
                    break;
                case R.id.rb_net_audio://网络音频
                    position = 3;
                    break;
            }

            setFragment();


        }
    }

    private void setFragment() {
        FragmentManager fm = getSupportFragmentManager();//得到fragmentManger
        FragmentTransaction ft = fm.beginTransaction();//开启事务
        ft.replace(R.id.lf_main, new Fragment() {
            @Nullable
            public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                                     @Nullable Bundle savedInstanceState) {
                return null;
            }
        });
        ft.commit();//提交
    }

}
