package com.example.administrator.taiya.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.example.administrator.taiya.R;
import com.example.administrator.taiya.base.BaseActivity;

/**
 * 绑定新设备
 */
public class ChooseDeviceActivity extends BaseActivity {

    private Button bt_manual,bt_scan;

    @Override
    protected void setView() {
        setContentView(R.layout.activity_choose_device);
    }

    @Override
    protected void initView() {
        setActivityTitle(this,this.getString(R.string.menu_device),false);
        bt_manual=(Button)findViewById(R.id.bt_manual);
        bt_manual.setOnClickListener(this);
        bt_scan=(Button)findViewById(R.id.bt_scan);
        bt_scan.setOnClickListener(this);
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_manual:
                Intent i=new Intent(this,ChooseActivity.class);
                i.putExtra("ChooseDeviceActivity",1);
                startActivity(i);
            break;
            case R.id.bt_scan:
                Intent i1=new Intent(this,ChooseActivity.class);
                i1.putExtra("ChooseDeviceActivity",2);
                startActivity(i1);
                break;

        }
    }
}
