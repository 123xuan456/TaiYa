package com.example.administrator.taiya.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.taiya.R;

/**
 * 首页功能页面
 */
public class TpmsFragment extends Fragment {
    public TpmsFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_tpms, null);
        return mView;
    }

}
