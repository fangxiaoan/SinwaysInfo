package com.sinways.sinwaysinfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.sinways.sinwaysinfo.adapter.MobilePagerAdapter;
import com.sinways.sinwaysinfo.bean.GoodsInfo;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // this is edit at home computer

        ArrayList<GoodsInfo> goodsList = GoodsInfo.getDefault();
        MobilePagerAdapter adapter = new MobilePagerAdapter(getSupportFragmentManager(),goodsList);
        ViewPager vp = findViewById(R.id.vpn_content);
        vp.setAdapter(adapter);
        vp.setCurrentItem(0);

    }
}
