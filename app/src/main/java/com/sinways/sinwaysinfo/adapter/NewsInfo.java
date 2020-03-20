package com.sinways.sinwaysinfo.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.sinways.sinwaysinfo.NewsShow;
import com.sinways.sinwaysinfo.NewsSource;
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
         holer.tv_news_from = convertView.findViewById(R.id.news_from);
         holer.tv_news_date = convertView.findViewById(R.id.news_date);
         //holer.tv_number = convertView.findViewById(R.id.tv_number);
         holer.bt_show_source = convertView.findViewById(R.id.bt_show_source);
         convertView.setTag(holer);
     }else{
         holer = (ViewHolder)convertView.getTag();
     }

     final News news_one = newsList.get(position);
     holer.tv_news.setText(news_one.news_title);
     holer.tv_news_from.setText(news_one.news_from);
     holer.tv_news_date.setText(news_one.news_date);
     //holer.tv_number.setText(Integer.toString(position + 1));
     holer.bt_show_source.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             //Toast.makeText(mContext,news_one.news_link,Toast.LENGTH_LONG).show();
             Intent intent = new Intent(mContext, NewsSource.class);
             intent.putExtra("news_link",news_one.news_link);
             mContext.startActivity(intent);
         }
     });




        return convertView;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public final class ViewHolder{
        public  TextView tv_news;
        public TextView tv_news_from;
        public TextView tv_news_date;
        //public TextView tv_number;
        public Button bt_show_source;
    }
}
