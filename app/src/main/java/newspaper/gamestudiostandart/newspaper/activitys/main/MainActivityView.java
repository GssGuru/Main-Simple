package newspaper.gamestudiostandart.newspaper.activitys.main;

import com.arellomobile.mvp.MvpView;

import java.util.ArrayList;

import newspaper.gamestudiostandart.newspaper.activitys.model.ResourseModel;

public interface MainActivityView extends MvpView {
    void setList(ArrayList<ResourseModel> list);
}
