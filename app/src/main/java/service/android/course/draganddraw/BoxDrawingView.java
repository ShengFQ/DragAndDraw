package service.android.course.draganddraw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.jar.Attributes;

/**
 * Created by sheng on 16/10/11.
 * 目标:在屏幕上绘制矩形,矩形由起点和终点组成,一个矩形框Box类.
 * 1.定义矩形类
 * 2.给矩形类实例化
 * 3.使用onDraw()方法进行图形绘制
 *
 */
public class BoxDrawingView extends View{
    public static final String TAG="BoxDrawingView";
    private Box mCurrentBox;//用户当前画的矩形
    private Paint mBoxPaint;  //Paint决定如何进行绘制操作
    private Paint mBackgroudPaint;
    private ArrayList<Box> mBoxes=new ArrayList<Box>();

    public BoxDrawingView( Context context){
        this(context, null);
    }

    public BoxDrawingView(Context context,AttributeSet attrs){
        super(context,attrs);
        mBoxPaint=new Paint();
        mBoxPaint.setColor(0x22ff0000);//米白色的背景

        mBackgroudPaint=new Paint();
        mBackgroudPaint.setColor(0xfff8efe0);//暗红色的矩形背景
    }

   /* public void setOnTouchListener(View.OnTouchListener listener){

    }*/

    public boolean onTouchEvent(MotionEvent event){
        PointF curr=new PointF(event.getX(),event.getY());
        Log.i(TAG,"received event at x="+ curr.x+" ,y="+curr.y+":");
        switch (event.getAction()){
            //鼠标点击按下
            case MotionEvent.ACTION_DOWN:
                Log.i(TAG," ACTION_DOWN");
                //reset drawing state
                mCurrentBox=new Box(curr);//按下就是起点
                mBoxes.add(mCurrentBox);
                break;
            //鼠标按下后移动
            case MotionEvent.ACTION_MOVE:
                Log.i(TAG," ACTION_MOVE");
                if(mCurrentBox!=null){
                    mCurrentBox.setmCurrent(curr);//移动后,每个点都是当前终点
                    //该方法表示强制重新绘制自己.
                    invalidate();
                }
                break;
            //鼠标点击升起
            case MotionEvent.ACTION_UP:
                Log.i(TAG," ACTION_UP");
                mCurrentBox=null;
                break;
            //取消触摸事件
            case MotionEvent.ACTION_CANCEL:
                Log.i(TAG," ACTION_CANCEL");
                mCurrentBox=null;
                break;
        }
        return true;
    }

    //定义矩形,需要:原始坐标点,当前坐标点


    protected void onDraw(Canvas canvas){
        //canvas具有我们需要的所有绘制操作
        canvas.drawPaint(mBackgroudPaint);
        for (Box box:mBoxes){
            float left=Math.min(box.getmOrigin().x,box.getmCurrent().x);
            float right=Math.max(box.getmOrigin().x,box.getmCurrent().x);
            float top=Math.min(box.getmOrigin().y,box.getmCurrent().y);
            float bottom=Math.max(box.getmOrigin().y,box.getmCurrent().y);
            canvas.drawRect(left,top,right,bottom,mBoxPaint);
        }

    }
}
