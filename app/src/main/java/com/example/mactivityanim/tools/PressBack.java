package com.example.mactivityanim.tools;

import android.view.KeyEvent;

import java.io.IOException;

/**
 * Created by 王宗贤 on 2015/12/10.
 */
public class PressBack {
    /**
     * 转到后退按键
     */
    public static void moveToKeyBack() {
        //              RunTime.exec()这个接口提供了一个很好的直观操作底层操作系统
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("input keyevent " + KeyEvent.KEYCODE_BACK);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
