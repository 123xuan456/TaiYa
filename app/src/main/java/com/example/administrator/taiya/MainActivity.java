package com.example.administrator.taiya;

import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.example.administrator.taiya.base.BaseActivity;
import com.example.administrator.taiya.fragment.HomeFragment;
import com.example.administrator.taiya.fragment.LeftFragment;
import com.example.administrator.taiya.slidingmenu.SlidingMenu;

public class MainActivity extends BaseActivity {
    SlidingMenu mSlidingMenu;
    LeftFragment leftFragment;
    HomeFragment homeFragment;
    @Override
    protected void setView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initView() {
        mSlidingMenu = (SlidingMenu) findViewById(R.id.slidingMenu);
        mSlidingMenu.setLeftView(getLayoutInflater().inflate(
                R.layout.fragment_left, null));
        mSlidingMenu.setCenterView(getLayoutInflater().inflate(
                R.layout.fragment_center, null));
        FragmentTransaction t = this.getSupportFragmentManager()
                .beginTransaction();
        leftFragment = new LeftFragment();
        t.replace(R.id.left_frame, leftFragment);
        homeFragment=new HomeFragment();
        t.replace(R.id.center_frame, homeFragment);
        t.commit();
    }

    @Override
    protected void setListener() {
        homeFragment.setMyPageChangeListener(new HomeFragment.MyPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                if(homeFragment.isFirst()){
                    mSlidingMenu.setCanSliding(true);
                }
                else if(homeFragment.isEnd()){
                    mSlidingMenu.setCanSliding(false);
                }
                else{
                    mSlidingMenu.setCanSliding(false);
                }
            }
        });
    }

    @Override
    protected void initData() {

    }

    public void showLeft() {
        mSlidingMenu.showLeftView();
    }

    @Override
    public void onClick(View v) {

    }
}
