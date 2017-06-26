package com.example.administrator.taiya;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.administrator.taiya.base.BaseActivity;

import java.io.InputStream;

//启动页
public class WelcomeActivity extends BaseActivity{

    private RelativeLayout rl_welcome;
    private Handler mHandler = new Handler();

    @Override
    protected void setView() {
        setContentView(R.layout.activity_welcome);
    }

    @Override
    protected void initView() {
        rl_welcome= (RelativeLayout) findViewById(R.id.rl_welcome);
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData() {
        InputStream localInputStream = getResources().openRawResource(R.raw.bg_welcome);
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = false;
        localOptions.inSampleSize = 1;
        Bitmap localBitmap = BitmapFactory.decodeStream(localInputStream, null, localOptions);
        this.rl_welcome.setBackgroundDrawable(new BitmapDrawable(localBitmap));
    }



    @Override
    protected void onResume() {
        super.onResume();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                WelcomeActivity.this.openActivity(MainActivity.class);
                finish();
            }
        },2000);
    }

    @Override
    public void onClick(View v) {

    }
}
