package service.android.course.draganddraw;


import android.app.Fragment;

public class DragAndDrawActivity extends SingleFragmentActivity {


    @Override
    public Fragment createFragment() {
        return new DragAndDrawFragment();
    }
}
