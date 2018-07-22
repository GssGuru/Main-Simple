package newspaper.gamestudiostandart.newspaper.aplication.main;

import com.arellomobile.mvp.MvpView;

import java.util.ArrayList;

import newspaper.gamestudiostandart.newspaper.utils.model.ResourseModel;

public interface MainActivityView extends MvpView {
    void setList(ArrayList<ResourseModel> list);
}
