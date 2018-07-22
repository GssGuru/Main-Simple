package newspaper.gamestudiostandart.newspaper.aplication.search;

import com.arellomobile.mvp.MvpView;
import java.util.ArrayList;
import newspaper.gamestudiostandart.newspaper.utils.model.ResourseModel;

public interface SearchActivityView extends MvpView {
    void setList(ArrayList<ResourseModel> list);

    void listSaved();

    void listSavedFailed(String message);
}
