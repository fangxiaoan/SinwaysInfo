package com.sinways.sinwaysinfo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.sinways.sinwaysinfo.R;

public class StaticFragment extends Fragment implements View.OnClickListener {

    protected View mView;
    protected Context mContext;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // return super.onCreateView(inflater, container, savedInstanceState);
        mContext = getActivity();
        mView = inflater.inflate(R.layout.infofr,container,false);
        TextView tv_adv = mView.findViewById(R.id.tv_adv);
        ImageView iv_adv = mView.findViewById(R.id.iv_adv);
        return mView;
    }

    @Override
    public void onClick(View v) {

    }
}
