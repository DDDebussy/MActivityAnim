package com.example.mactivityanim.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.mactivityanim.R;

/**
 * Created by 王宗贤 on 2015/12/10.
 */
public class FragmentSun extends Fragment {
    private ImageView mImgSun;
    private ImageView mImgActivityCat;
    private ImageView mImgActivityDog;
    private ImageView mImgActivitySun;
    private View mViewSun;//fragment的布局
    private int mPicture;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mViewSun =inflater.inflate(R.layout.viewpager_item_sun, null);

        initView();//初始化view
        mPicture=getActivity().getIntent().getIntegerArrayListExtra("pictures").get(1);//获得对应点击事件的图片
        mImgSun.setImageResource(mPicture);//设置fragment中img的图片为MainActivity中点击的图片

        mImgSun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mImgActivitySun.setImageResource(mPicture);//将Mian2Activity中的transitionName为sun的控件图片加上，使其能够和MainActivity中的图片连成动画（缩小）
                mImgActivityDog.setAlpha(0.0f);//将透明度设置为0，使它的过度动画为渐变
                mImgActivityCat.setAlpha(0.0f);//将透明度设置为0，使它的过度动画为渐变
                getActivity().finishAfterTransition();//过度动画结束后再销毁活动
            }
        });

        return mViewSun;
    }

    /**
     * 初始化view
     */
    private void initView() {
        mImgSun = (ImageView) mViewSun.findViewById(R.id.img_viewpager_sun);
        mImgActivityCat= (ImageView) getActivity().findViewById(R.id.img_second_cat);//获得Mian2Activity中的控件
        mImgActivityDog= (ImageView) getActivity().findViewById(R.id.img_second_dog);
        mImgActivitySun= (ImageView) getActivity().findViewById(R.id.img_second_sun);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("date", "  sun碎片的状态   destory");
//        getActivity().finishAfterTransition();

    }
}
