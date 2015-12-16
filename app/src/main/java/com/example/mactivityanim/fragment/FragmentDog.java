package com.example.mactivityanim.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.mactivityanim.R;
import com.example.mactivityanim.tools.PressBack;

/**
 * Created by 王宗贤 on 2015/12/10.
 */
public class FragmentDog extends Fragment {
    private ImageView mImgDog;
    private ImageView mImgActivityCat;
    private ImageView mImgActivityDog;
    private ImageView mImgActivitySun;
    private View viewDog;
    private int mPicture;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewDog = inflater.inflate(R.layout.viewpager_item_dog, null);
        initView();//初始化view
        mPicture=getActivity().getIntent().getIntegerArrayListExtra("pictures").get(0);
        mImgDog.setImageResource(mPicture);

        mImgDog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mImgActivitySun.setAlpha(0.0f);
                mImgActivityDog.setImageResource(mPicture);
                mImgActivityCat.setAlpha(0.0f);
                getActivity().finishAfterTransition();
            }
        });
        return viewDog;
    }

    /**
     * 初始化view
     */
    private void initView() {
        mImgDog = (ImageView) viewDog.findViewById(R.id.img_viewpager_dog);
        mImgActivityCat = (ImageView) getActivity().findViewById(R.id.img_second_cat);
        mImgActivityDog = (ImageView) getActivity().findViewById(R.id.img_second_dog);
        mImgActivitySun = (ImageView) getActivity().findViewById(R.id.img_second_sun);
    }
}
