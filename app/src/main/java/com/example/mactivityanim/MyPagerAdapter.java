package com.example.mactivityanim;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by 王宗贤 on 2015/12/9.
 */
public class MyPagerAdapter extends FragmentPagerAdapter{
    private List<Fragment> mFragments;

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public MyPagerAdapter(FragmentManager fm,List<Fragment> mFragments){
        super(fm);
        this.mFragments=mFragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }
}
