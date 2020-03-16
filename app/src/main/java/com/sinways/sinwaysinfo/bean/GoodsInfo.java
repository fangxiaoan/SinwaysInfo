package com.sinways.sinwaysinfo.bean;

import com.sinways.sinwaysinfo.R;

import java.util.ArrayList;

public class GoodsInfo {
    public String goodName;
    public int goodPic;

    GoodsInfo(){
        goodName = "";
        goodPic = 0;
    }
    public static ArrayList<GoodsInfo> getDefault(){
        ArrayList<GoodsInfo> goodList = new ArrayList<GoodsInfo>();

        int[] goodPic = {R.drawable.huawei,R.drawable.xiaomi};
        String[] goodName = {"xiaomi","huawei"};

        for(int i =0; i < goodName.length; i++){
            GoodsInfo goodInfo = new GoodsInfo();
            goodInfo.goodName = goodName[i];
            goodInfo.goodPic = goodPic[i];
            goodList.add(goodInfo);
        }
        return goodList;
    }
}
