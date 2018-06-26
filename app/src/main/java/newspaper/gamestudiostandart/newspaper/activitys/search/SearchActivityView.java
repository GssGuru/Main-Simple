package newspaper.gamestudiostandart.newspaper.activitys.search;

import com.arellomobile.mvp.MvpView;
import java.util.ArrayList;
import newspaper.gamestudiostandart.newspaper.activitys.model.ResourseModel;

public interface SearchActivityView extends MvpView {
    void setList(ArrayList<ResourseModel> list);

    void listSaved();

    void listSavedFailed(String message);
}
