package com.example.mactivityanim;

import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;

import com.example.mactivityanim.fragment.FragmentCat;
import com.example.mactivityanim.fragment.FragmentDog;
import com.example.mactivityanim.fragment.FragmentSun;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends FragmentActivity {
    private int mPicture;//获得MainActivity传递的信息
    private List<Fragment> mFragments;
    private MyPagerAdapter mPagerAdapter;
    private ViewPager mViewPager;
    private ImageView mImgDog;
    private ImageView mImgCat;
    private ImageView mImgSun;
    private FragmentCat mFragmentCat;
    private FragmentDog mFragmentDog;
    private FragmentSun mFragmentSun;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    mViewPager.setAdapter(mPagerAdapter);
                    break;
                case 1:
                    mViewPager.setAdapter(mPagerAdapter);
                    mViewPager.setCurrentItem(1);
                    break;
                case 2:
                    mViewPager.setAdapter(mPagerAdapter);
                    mViewPager.setCurrentItem(2);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_main2);

        initView();//初始化view
        initViewPager();//初始化适配器
        captureClickMessage();//获得MainActivity中点击事件传递的信息并处理（打开适配器）
    }

    /**
     * 初始化view
     */
    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mImgDog = (ImageView) findViewById(R.id.img_second_dog);
        mImgCat = (ImageView) findViewById(R.id.img_second_cat);
        mImgSun = (ImageView) findViewById(R.id.img_second_sun);
    }

    /**
     * 初始化viewpager
     */
    private void initViewPager() {
        mFragments = new ArrayList<Fragment>();
        mFragmentCat = new FragmentCat();
        mFragmentDog = new FragmentDog();
        mFragmentSun = new FragmentSun();
        mFragments.add(mFragmentDog);
        mFragments.add(mFragmentSun);
        mFragments.add(mFragmentCat);
        mPagerAdapter = new MyPagerAdapter(getSupportFragmentManager(), mFragments);
//        mViewPager.setOffscreenPageLimit(0);//设置预加载数目
    }

    /**
     * 获取MainActivity的信息，设置定时器用于接合Activity的动画和viewpager。
     */
    private void captureClickMessage() {
        mPicture = getIntent().getIntExtra("picture", R.mipmap.ic_launcher);
        switch (mPicture) {
            case R.mipmap.erha:
                mImgDog.setImageResource(R.mipmap.erha);
                Message messageDog = new Message();
                messageDog.what = 0;
                mHandler.sendMessageDelayed(messageDog, 100);
                break;
            case R.mipmap.sunshine:
                mImgSun.setImageResource(R.mipmap.sunshine);
                Message messageSun = new Message();
                messageSun.what = 1;
                mHandler.sendMessageDelayed(messageSun, 100);
                break;
            case R.mipmap.cat:
                mImgCat.setImageResource(R.mipmap.cat);
                Message messageCat = new Message();
                messageCat.what = 2;
                mHandler.sendMessageDelayed(messageCat, 100);
                break;
        }
    }
}
