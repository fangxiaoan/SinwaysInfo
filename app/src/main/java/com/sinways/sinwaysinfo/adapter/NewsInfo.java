package com.sinways.sinwaysinfo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sinways.sinwaysinfo.NewsShow;
import com.sinways.sinwaysinfo.R;
import com.sinways.sinwaysinfo.bean.News;

import java.util.ArrayList;

public class NewsInfo extends BaseAdapter {
     Context mContext;
     ArrayList<News> newsList;
    View mView;

    public NewsInfo(Context context, ArrayList<News> newsList){
        mContext = context;
        this.newsList = newsList;

    }



    @Override
    public int getCount() {
        return newsList.size();
    }

    @Override
    public Object getItem(int position) {
        return newsList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
     ViewHolder holer ;
     if(convertView == null){
         holer = new ViewHolder();
         convertView = LayoutInflater.from(mContext).inflate(R.layout.news,null);
         holer.tv_news = convertView.findViewById(R.id.tv_title);
         convertView.setTag(holer);
     }else{
         holer = (ViewHolder)convertView.getTag();
     }

     News news_one = newsList.get(position);
     holer.tv_news.setText(news_one.news_title);



        return convertView;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public final class ViewHolder{
        public  TextView tv_news;
    }
}
