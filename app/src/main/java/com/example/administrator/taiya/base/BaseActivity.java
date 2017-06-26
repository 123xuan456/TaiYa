package com.example.administrator.taiya.base;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.taiya.R;

/**
 * Created by Administrator on 2017/6/20.
 */
public abstract class BaseActivity extends FragmentActivity implements View.OnClickListener{
    private BluetoothAdapter mBluetoothAdapter;
    private ImageView iv;
    private TextView tv_title_middle;
    private ImageView ib_title_left;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawableResource(R.mipmap.bg_system);
        setView();
        initView();
        setListener();
        initData();



    }

    protected abstract void setView();
    protected abstract void initView();
    protected abstract void setListener();
    protected abstract void initData();

    //跳转acitivity
    protected void openActivity(Class<?> paramClass)
    {
        startActivity(new Intent(this, paramClass));
    }
    /*
      *  activity 当前的
      *  title 标题文字
      *  paramObject 图片路径
     */
    protected void setActivityTitle(final Activity activity, String title, boolean b){
        ib_title_left=(ImageView)activity.findViewById(R.id.ib_title_left);
        iv=(ImageView)activity.findViewById(R.id.btn_title_right);
        tv_title_middle=(TextView)activity.findViewById(R.id.tv_title_middle);
        if (!TextUtils.isEmpty(title)){
            tv_title_middle.setText(title);
        }
        if (b){
            iv.setVisibility(View.VISIBLE);
        }else {
            iv.setVisibility(View.GONE);
        }
        ib_title_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.finish();
            }
        });
    }




}
