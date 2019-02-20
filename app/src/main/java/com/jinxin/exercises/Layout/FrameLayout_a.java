package com.jinxin.exercises.Layout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

import com.jinxin.exercises.R;

/**
 * 随手指移动的图片
 *
 * 1:先将main.xml布局设置为空白的FrameLayout,为其设置一个图片背景
 * 2:新建一个继承View类的MeziView自定义组件类,在构造方法中初始化view的初始坐标
 * 3:重写onDraw()方法,实例化一个空的画笔类Paint
 * 4:调用BitmapFactory.decodeResource()生成位图对象
 * 5:调用canvas.drawBitmap()绘制妹子的位图对象
 * 6:判断图片上是否回收,否则强制回收图片
 * 7:在主Java代码中获取帧布局对象,并且实例化一个MeziView类
 * 8:会实例化的mezi对象添加一个触摸事件的监听器,重写onTouch方法,改变mezi的X,Y坐标，调用invalidate()重绘方法
 * 9: 将mezi对象添加到帧布局中
 */
public class FrameLayout_a extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_layout_a);

        FrameLayout fram =(FrameLayout) findViewById(R.id.mylayout);
        //获取帧布局对象,并且实例化一个MeziView类
        final FrameLayoutView view = new FrameLayoutView(FrameLayout_a.this);
        //为图片添加触摸事件监听器,重写onTouch方法,改变mezi的X,Y坐标
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //设置图片显示的位置
                view.bitmapX = event.getX() - 150;//如果不减150 这个坐标就是自定义View的左上角
                view.bitmapY = event.getY() - 150;
                //调用重绘方法
                view.invalidate();
                return false;
            }
        });
        //将mezi对象添加到帧布局中
        fram.addView(view);
    }
}
