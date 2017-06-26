package com.example.administrator.taiya.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.administrator.taiya.MainActivity;
import com.example.administrator.taiya.R;
import com.example.administrator.taiya.activity.ChooseActivity;
import com.example.administrator.taiya.activity.ChooseDeviceActivity;
import com.example.administrator.taiya.activity.HelpActivity;
import com.example.administrator.taiya.activity.SettingActivity;

/**
 * 侧边栏
 */
public class LeftFragment extends Fragment implements View.OnClickListener{

    private View view;
    private LinearLayout left_home,left_add,left_Change ,left_Setting,left_Help;
    private Intent intent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_left, null);
        left_home=(LinearLayout)view.findViewById(R.id.left_home);
        left_home.setOnClickListener(this);
        left_add=(LinearLayout)view.findViewById(R.id.left_add);
        left_add.setOnClickListener(this);
        left_Change=(LinearLayout)view.findViewById(R.id.left_Change);
        left_Change.setOnClickListener(this);
        left_Setting=(LinearLayout)view.findViewById(R.id.left_Setting);
        left_Setting.setOnClickListener(this);
        left_Help=(LinearLayout)view.findViewById(R.id.left_Help);
        left_Help.setOnClickListener(this);
        intent=new Intent();
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.left_home:
                //返回首页面
                ((MainActivity) getActivity()).showLeft();
                break;
            case R.id.left_add:
                intent.setClass(getActivity(), ChooseDeviceActivity.class);
                startActivity(intent);
                break;
            case R.id.left_Change:
                intent.setClass(getActivity(), ChooseActivity.class);
                startActivity(intent);
                break;
            case R.id.left_Setting:
                intent.setClass(getActivity(), SettingActivity.class);
                startActivity(intent);
                break;
            case R.id.left_Help:
                intent.setClass(getActivity(), HelpActivity.class);
                startActivity(intent);
                break;

        }
    }

}
