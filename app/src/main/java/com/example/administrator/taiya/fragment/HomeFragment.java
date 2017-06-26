package com.example.administrator.taiya.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.administrator.taiya.MainActivity;
import com.example.administrator.taiya.R;

import java.util.ArrayList;

/**
 * 首页
 */
public class HomeFragment extends Fragment {
    private ImageButton showLeft;
    private MyAdapter mAdapter;
    private ViewPager mPager;
    private ArrayList<Fragment> pagerItemList = new ArrayList<Fragment>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_home, null);
        showLeft = (ImageButton) mView.findViewById(R.id.ib_title_left);
        mPager = (ViewPager) mView.findViewById(R.id.pager);
        TpmsFragment page1 = new TpmsFragment();
        pagerItemList.add(page1);
        mAdapter = new MyAdapter(getFragmentManager());
        mPager.setAdapter(mAdapter);
        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {

                if (myPageChangeListener != null)
                    myPageChangeListener.onPageSelected(position);

            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int position) {
            }
        });

        return mView;
    }

    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        showLeft.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).showLeft();
            }
        });

    }

    public boolean isFirst() {
        if (mPager.getCurrentItem() == 0)
            return true;
        else
            return false;
    }

    public boolean isEnd() {
        if (mPager.getCurrentItem() == pagerItemList.size() - 1)
            return true;
        else
            return false;
    }

    public class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return pagerItemList.size();
        }

        @Override
        public Fragment getItem(int position) {

            Fragment fragment = null;
            if (position < pagerItemList.size())
                fragment = pagerItemList.get(position);
            else
                fragment = pagerItemList.get(0);

            return fragment;

        }
    }

    private MyPageChangeListener myPageChangeListener;

    public void setMyPageChangeListener(MyPageChangeListener l) {
        myPageChangeListener = l;
    }

    public interface MyPageChangeListener {
         void onPageSelected(int position);
    }

}
