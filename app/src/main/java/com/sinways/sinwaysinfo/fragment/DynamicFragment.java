package com.sinways.sinwaysinfo.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.sinways.sinwaysinfo.NewsShow;
import com.sinways.sinwaysinfo.R;

public class DynamicFragment extends Fragment {

  private static final String TAG = "DynamicFragment";
  protected View mView;
  protected Context mContext;
  private int mPosition;
  private int mImageId;
  private String mDesc;
  private int mCount = 3;


  public static DynamicFragment newInstance(int position,int image_id,String desc){
      DynamicFragment fragment = new DynamicFragment();
      Bundle bundle = new Bundle();
      bundle.putInt("position",position);
      bundle.putInt("image_id",image_id);
      //bundle.putString("desc",desc);
      fragment.setArguments(bundle);
      return fragment;

  }
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        mContext = getActivity();
        if(getArguments() != null){
            mPosition = getArguments().getInt("position",0);
            mImageId = getArguments().getInt("image_id",0);
            //mDesc = getArguments().getString("desc");
        }
        mView = inflater.inflate(R.layout.goodinofr,container,false);
        ImageView iv_pic = mView.findViewById(R.id.iv_pic);
        RadioGroup rg_indicate = mView.findViewById(R.id.rg_indicate);
        Button btn_start = mView.findViewById(R.id.btn_start);
        //TextView tv_desc = mView.findViewById(R.id.tv_desc);
        iv_pic.setImageResource(mImageId);
        //tv_desc.setText(mDesc);

        for(int i=0;i<mCount;i++){
            RadioButton radio = new RadioButton(mContext);
            radio.setLayoutParams(new RadioGroup.LayoutParams(RadioGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
            radio.setButtonDrawable(R.drawable.dot);
            radio.setPadding(10,10,10,10);
            rg_indicate.addView(radio);
        }
        ((RadioButton)rg_indicate.getChildAt(mPosition)).setChecked(true);
        if(mPosition == mCount - 1){
            btn_start.setVisibility(View.VISIBLE);
            btn_start.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, NewsShow.class);
                    startActivity(intent);
                }
            });

        }
        return mView;

    }
}
