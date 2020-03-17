package com.sinways.sinwaysinfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.sinways.sinwaysinfo.adapter.MobilePagerAdapter;
import com.sinways.sinwaysinfo.adapter.NewsInfo;
import com.sinways.sinwaysinfo.bean.GoodsInfo;
import com.sinways.sinwaysinfo.bean.News;
import com.sinways.sinwaysinfo.util.HttpReqData;
import com.sinways.sinwaysinfo.util.HttpRequestUtil;
import com.sinways.sinwaysinfo.util.HttpRespData;
import com.sinways.sinwaysinfo.util.MysqlHelper;
import com.sinways.sinwaysinfo.util.StreamTool;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

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

        Button bt = findViewById(R.id.db_test);
        bt.setOnClickListener(this);







    }

    @Override
    public void onClick(View v)  {
        if(v.getId() == R.id.db_test){
            Intent intent = new Intent(this, NewsShow.class);
            startActivity(intent);
        }
    }








}


