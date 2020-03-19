package com.sinways.sinwaysinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.sinways.sinwaysinfo.adapter.NewsInfo;
import com.sinways.sinwaysinfo.bean.News;

import java.util.ArrayList;

public class NewsShow extends AppCompatActivity {
    Context mContext;
    TextView tv;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_show);
        mContext = this;
        tv = findViewById(R.id.tv_main_show);
        lv = findViewById(R.id.lv_news);
        new MyAsyncTask().execute();

    }


    public class MyAsyncTask extends AsyncTask<Void,Void, ArrayList<News>> {
        @Override
        protected ArrayList<News> doInBackground(Void... voids) {
            return News.getNews();
        }

        @Override
        protected void onPostExecute(ArrayList<News> news) {


            String show = "";

            for(int i=0;i<news.size();i++){
                News newss = news.get(i);

                show = show + newss.news_title;
            }
            //tv.setText(show);
            //Toast.makeText(NewsShow.this,show,Toast.LENGTH_LONG).show();

            NewsInfo newsAdapter = new NewsInfo(mContext,news);

            lv.setAdapter(newsAdapter);

        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }
    }


}
