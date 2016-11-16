package service.android.course.draganddraw;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by sheng on 16/10/11.
 */
public class DragAndDrawFragment  extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View v=inflater.inflate(R.layout.fragment_drag_and_draw,container,false);
        return v;
       // return super.onCreateView(inflater, container, savedInstanceState);
    }
}
