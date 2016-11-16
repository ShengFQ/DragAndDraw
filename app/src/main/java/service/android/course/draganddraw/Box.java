package service.android.course.draganddraw;

import android.graphics.PointF;

/**
 * Created by sheng on 16/10/11.
 * 一个矩形框的定义数据
 */
public class Box {
    private PointF mOrigin;
    private PointF mCurrent;

    public Box(PointF origin){
       mOrigin=mCurrent=origin;
    }

    public PointF getmOrigin() {
        return mOrigin;
    }

    public void setmOrigin(PointF mOrigin) {
        this.mOrigin = mOrigin;
    }

    public PointF getmCurrent() {
        return mCurrent;
    }

    public void setmCurrent(PointF mCurrent) {
        this.mCurrent = mCurrent;
    }
}
