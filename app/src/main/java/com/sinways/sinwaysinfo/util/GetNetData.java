package com.sinways.sinwaysinfo.util;

import android.util.Log;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class  GetNetData {

    public  static String getByteData(String path) throws Exception{
        String news_string="";
        URL url = new URL(path);   //将string 类型 构造为url 地址
        Log.i("msg","url地址构造实拍" + path + url);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();  //建立http 链接
        if(conn!=null) {
            Log.i("msg", "打开链接");
        }
        conn.setConnectTimeout(5000);   //设置超时连接为5秒
        Log.i("msg", "设置connectTimout" );
        conn.setRequestMethod("GET");   //设置请求方法为get
        Log.i("msg","the code is " );
        if(conn.getResponseCode()!=200){
            throw new RuntimeException("链接失败");
        }
        Log.i("msg","链接成功");
        InputStream inputStream = conn.getInputStream();    //获得数据流
        //byte[] bt = StreamTool.streamToByteArray(inputStream);   //利用
        news_string = StreamTool.getUnzipStream(inputStream,conn.getHeaderField("Content-Encoding"),"utf-8");
        return news_string;

    }
}
