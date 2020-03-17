package com.sinways.sinwaysinfo.util;

import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class  MysqlHelper {

    static final String url = "jdbc:mysql://47.112.213.237:3306/companynews?useSSL=FALSE&serverTimezone=UTC";
    static final String USER = "admin";
    static final String PASS = "Fxa@880202";





    public  static Connection getConn(){
        Connection conn = null;
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Class.forName("com.mysql.cj.jdbc.Driver");
            Log.i("hi","class for name");

            conn = DriverManager.getConnection(url,USER,PASS);


        }catch (Exception e){
            e.printStackTrace();

        }

        return conn;



    }


}
