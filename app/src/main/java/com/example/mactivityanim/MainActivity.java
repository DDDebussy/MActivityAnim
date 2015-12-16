package com.example.mactivityanim;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends Activity implements View.OnClickListener{
    private ImageView mImgDog;
    private ImageView mImgSun;
    private ImageView mImgCat;
    private View mViewCat;
    private View mViewDog;
    private View mViewSun;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();//初始化view
        setClickItem();//设置点击事件
    }

    /**
     * 添加点击事件
     */
    private void setClickItem() {
        mImgCat.setOnClickListener(this);
        mImgDog.setOnClickListener(this);
        mImgSun.setOnClickListener(this);
    }

    /**
     * 初始化view
     */
    private void initView() {
        mImgDog = (ImageView) findViewById(R.id.img_dog);
        mImgCat= (ImageView) findViewById(R.id.img_cat);
        mImgSun= (ImageView) findViewById(R.id.img_sun);
        mViewCat=findViewById(R.id.img_cat);
        mViewDog=findViewById(R.id.img_dog);
        mViewSun=findViewById(R.id.img_sun);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.img_dog:
                Intent intentDog= new Intent(getApplicationContext(), Main2Activity.class);
                intentDog.putExtra("picture", R.mipmap.erha);
                putPictures(intentDog);
//                设置共享元素添加活动间动画
                startActivity(intentDog, ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, Pair.create(view, "dog"), Pair.create(mViewSun, "sun"), Pair.create(mViewCat, "cat")).toBundle());
                break;
            case R.id.img_sun:
                Intent intentSun= new Intent(getApplicationContext(), Main2Activity.class);
                intentSun.putExtra("picture", R.mipmap.sunshine);
                putPictures(intentSun);
                startActivity(intentSun, ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, Pair.create(view, "sun"), Pair.create(mViewDog, "dog"), Pair.create(mViewCat,"cat")).toBundle());
                break;
            case R.id.img_cat:
                Intent intentCat= new Intent(getApplicationContext(), Main2Activity.class);
                intentCat.putExtra("picture", R.mipmap.cat);
                putPictures(intentCat);
                startActivity(intentCat, ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, Pair.create(view, "cat"),Pair.create(mViewDog,"dog"),Pair.create(mViewSun, "sun")).toBundle());
                break;
        }
    }

    /**
     * 发送全部的图片
     * @param intent 发送图片的意图
     */
    private void putPictures(Intent intent){
        ArrayList<Integer> list=new ArrayList<>();
        list.add(R.mipmap.erha);
        list.add(R.mipmap.sunshine);
        list.add(R.mipmap.cat);
        intent.putIntegerArrayListExtra("pictures", list);
        Log.d("date","    "+list.get(0));
    }
}
