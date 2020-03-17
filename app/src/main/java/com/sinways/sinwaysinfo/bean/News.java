package com.sinways.sinwaysinfo.bean;

import com.sinways.sinwaysinfo.util.GetNetData;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class News {
    public int id;
    public String news_title;
    public String news_link;
    public String news_company;
    public String news_date;
    public String news_time;


    public void News(){
        id = 1;
        news_title = "";
        news_link = "";
        news_company = "";
        news_date = "";
        news_time = "";

    }

    public static ArrayList<News> getNews(){
        ArrayList<News> arrayNews = new ArrayList<News>();
        try {
            String newsData = GetNetData.getByteData("http://47.112.213.237:5903/api/v1/getAllNews");
            //JSONObject jsonObj = null;
            // jsonObj = new JSONObject(newsData);
            JSONArray jsonArr = new JSONArray(newsData);
            for(int i=0;i<jsonArr.length();i++){
                News news = new News();
                JSONObject jsonObj = jsonArr.getJSONObject(i);
                news.news_title = jsonObj.getString("news_title");
                arrayNews.add(news);
            }


        }catch (Exception e){
            e.printStackTrace();
        }


        return arrayNews;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setNews_title(String news_title) {
        this.news_title = news_title;
    }

    public void setNews_link(String news_link) {
        this.news_link = news_link;
    }

    public void setNews_company(String news_company) {
        this.news_company = news_company;
    }

    public void setNews_date(String news_date) {
        this.news_date = news_date;
    }

    public void setNews_time(String news_time) {
        this.news_time = news_time;
    }

    public int getId() {
        return id;
    }

    public String getNews_title() {
        return news_title;
    }

    public String getNews_link() {
        return news_link;
    }

    public String getNews_company() {
        return news_company;
    }

    public String getNews_date() {
        return news_date;
    }

    public String getNews_time() {
        return news_time;
    }
}
