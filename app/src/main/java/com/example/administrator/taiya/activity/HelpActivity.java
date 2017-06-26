package com.example.administrator.taiya.activity;

import android.view.View;

import com.example.administrator.taiya.R;
import com.example.administrator.taiya.base.BaseActivity;

/**
 * Created by Administrator on 2017/6/21.
 */
public class HelpActivity extends BaseActivity {
    @Override
    protected void setView() {
        setContentView(R.layout.activity_help);
    }

    @Override
    protected void initView() {
        setActivityTitle(this,this.getString(R.string.menu_help),false);
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {

    }
}
