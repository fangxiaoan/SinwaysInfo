package com.sinways.sinwaysinfo.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.sinways.sinwaysinfo.bean.GoodsInfo;
import com.sinways.sinwaysinfo.fragment.DynamicFragment;

import java.util.ArrayList;

public class MobilePagerAdapter extends FragmentStatePagerAdapter {

    private ArrayList<GoodsInfo> mGoodsList = new ArrayList<GoodsInfo>();

    public MobilePagerAdapter(FragmentManager fm, ArrayList<GoodsInfo> goodsList){
        super(fm);
        mGoodsList = goodsList;
    }
    @Override
    public int getCount() {
        return mGoodsList.size();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return DynamicFragment.newInstance(position,mGoodsList.get(position).goodPic,mGoodsList.get(position).goodName);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mGoodsList.get(position).goodName;
    }
}
