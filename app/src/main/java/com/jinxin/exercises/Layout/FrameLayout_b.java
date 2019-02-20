package com.jinxin.exercises.Layout;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.jinxin.exercises.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 跑动的图片
 * 1:定义一个空的FrameLayout布局,将前景图像的位置设置为中央位置
 * 2:在Activity中获取到该FrameLayout布局,新建一个Handler对象,重写handlerMessage()方法,调用图像- 更新的方法
 * 3:自定义一个move()方法,通过switch动态设置前景图片显示的位图
 * 4:在onCreate()方法中新建一个计时器对象Timer,重写run方法,每隔170毫秒向handler发送空信息
 */
public class FrameLayout_b extends AppCompatActivity {

    //初始化变量，帧布局
    FrameLayout frame = null;
    //自定义一个用户定时更新UI界面的handler类对象
    Handler handler = new Handler(){
        int i = 0;

        @Override
        public void handleMessage(Message msg) {
            //判断信息是否为本应用发出的
            if (msg.what == 0x123) {
                i++;
                move(i%8);
            }
            super.handleMessage(msg);
        }
    };

    private void move(int i) {
        Drawable a = getResources().getDrawable(R.drawable.s_1);
        Drawable b = getResources().getDrawable(R.drawable.s_2);
        Drawable c = getResources().getDrawable(R.drawable.s_3);
        Drawable d = getResources().getDrawable(R.drawable.s_4);
        Drawable e = getResources().getDrawable(R.drawable.s_5);
        Drawable f = getResources().getDrawable(R.drawable.s_6);
        Drawable g = getResources().getDrawable(R.drawable.s_7);
        Drawable h = getResources().getDrawable(R.drawable.s_8);

        //通过setForeground来设置前景图像
        switch(i)
        {
            case 0:
                frame.setForeground(a);
                break;
            case 1:
                frame.setForeground(b);
                break;
            case 2:
                frame.setForeground(c);
                break;
            case 3:
                frame.setForeground(d);
                break;
            case 4:
                frame.setForeground(e);
                break;
            case 5:
                frame.setForeground(f);
                break;
            case 6:
                frame.setForeground(g);
                break;
            case 7:
                frame.setForeground(h);
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_layout_b);

        frame = (FrameLayout) findViewById(R.id.myframe);
        //定义一个定时器对象，定时发送信息给handler
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                //发送一条空信息来通知系统改变前景图片
                handler.sendEmptyMessage(0x123);
            }
        },0,100);
    }

}
