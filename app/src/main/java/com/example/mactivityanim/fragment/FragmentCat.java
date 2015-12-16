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
public class FragmentCat extends Fragment {
    private ImageView mImgCat;
    private ImageView mImgActivityCat;
    private ImageView mImgActivityDog;
    private ImageView mImgActivitySun;
    private View viewCat;
    private int mPicture;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewCat=inflater.inflate(R.layout.viewpager_item_cat, null);

        initView();//初始化view
        mPicture=getActivity().getIntent().getIntegerArrayListExtra("pictures").get(2);
        mImgCat.setImageResource(mPicture);

        mImgCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mImgActivitySun.setAlpha(0.0f);
                mImgActivityDog.setAlpha(0.0f);
                mImgActivityCat.setImageResource(mPicture);
                getActivity().finishAfterTransition();
            }
        });
        return viewCat;
    }

    /**
     * 初始化view
     */
    private void initView() {
        mImgCat= (ImageView) viewCat.findViewById(R.id.img_viewpager_cat);
        mImgActivityCat= (ImageView) getActivity().findViewById(R.id.img_second_cat);
        mImgActivityDog= (ImageView) getActivity().findViewById(R.id.img_second_dog);
        mImgActivitySun= (ImageView) getActivity().findViewById(R.id.img_second_sun);
    }
}
