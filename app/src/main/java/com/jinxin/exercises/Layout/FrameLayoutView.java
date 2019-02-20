package com.jinxin.exercises.Layout;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

import com.jinxin.exercises.R;

/**
 * Created by Jinxin on 2019/2/20.
 *
 * 自定义主键类
 */

public class FrameLayoutView extends View{
    //定义相关变量，依次是图片显示位置的X,Y坐标
    public float bitmapX;
    public float bitmapY;

    public FrameLayoutView(Context context) {
        super(context);
        //设置图片的起始坐标
        bitmapX = 0;
        bitmapY = 200;
    }

    /**
     * 重写View类的onDraw()方法
     * 实例化一个空的画笔类Paint
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //创建，并且实例化Paint的对象
        Paint paint = new Paint();
        //根据图片生成位图对象
        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.s_jump);
        //绘制图片
        canvas.drawBitmap(bitmap,bitmapX,bitmapY,paint);
        //判断图片是否回收，没有回收强制收回图片
        if (bitmap.isRecycled()) {
            bitmap.recycle();
        }
    }
}
