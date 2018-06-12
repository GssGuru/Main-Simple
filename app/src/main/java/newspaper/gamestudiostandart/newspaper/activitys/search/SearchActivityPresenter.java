package newspaper.gamestudiostandart.newspaper.activitys.search;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.ArrayList;

import newspaper.gamestudiostandart.newspaper.AppNews;
import newspaper.gamestudiostandart.newspaper.R;
import newspaper.gamestudiostandart.newspaper.model.Category;
import newspaper.gamestudiostandart.newspaper.model.ResourseModel;
import newspaper.gamestudiostandart.newspaper.repository.getfromstorege.DBHelperNews;
import newspaper.gamestudiostandart.newspaper.repository.getfromstorege.DBHelperResoursesInteractor;

@InjectViewState
public class SearchActivityPresenter extends MvpPresenter<SearchActivityView> implements
        DBHelperResoursesInteractor.SetReadableListener, DBHelperResoursesInteractor.SetWritebleListner {

    private DBHelperResoursesInteractor dbHelperResoursesInteractor;
    private Category category;
    private ArrayList<ResourseModel> listResourses;

    SearchActivityPresenter() {
        dbHelperResoursesInteractor = DBHelperNews.getInstance();
    }

    public void getListRresourses(Category category) {
        this.category = category;
        dbHelperResoursesInteractor.getTableResourses(this, category);
    }

    public void save() {
        int countSavedElenents = 0;
        for (int i = 0; i < listResourses.size(); i++) {
            if (listResourses.get(i).isCheck()) {
                countSavedElenents++;
            }
        }
        if (countSavedElenents == 0) {
            getViewState().listSavedFailed(AppNews.getContext().getResources().getString(R.string.text_save_minimum_resources));
        } else {
            dbHelperResoursesInteractor.setTableResourses(this, category, listResourses);
        }
    }

    public ArrayList<ResourseModel> getListResourses() {
        return listResourses;
    }

    @Override
    public void getListFromResourseListner(ArrayList<ResourseModel> list) {
        listResourses = list;
        getViewState().setList(listResourses);
    }

    @Override
    public void addListToResoursesListner(boolean saccess) {
        getViewState().listSaved();
    }
}
