package newspaper.gamestudiostandart.newspaper.activitys.search;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.ArrayList;

import newspaper.gamestudiostandart.newspaper.AppNews;
import newspaper.gamestudiostandart.newspaper.R;
import newspaper.gamestudiostandart.newspaper.activitys.model.Category;
import newspaper.gamestudiostandart.newspaper.activitys.model.ResourseModel;
import newspaper.gamestudiostandart.newspaper.repository.database.DBHelper;
import newspaper.gamestudiostandart.newspaper.repository.database.DBHelperResourcesInteractor;

@InjectViewState
public class SearchActivityPresenter extends MvpPresenter<SearchActivityView> implements
        DBHelperResourcesInteractor.SetReadableListener, DBHelperResourcesInteractor.SetWritebleListner {

    private DBHelperResourcesInteractor mDBHelperResourcesInteractor;
    private Category mCategory;
    private ArrayList<ResourseModel> mListResources;

    SearchActivityPresenter() {
        mDBHelperResourcesInteractor = DBHelper.getInstance();
    }

    public void getListRresourses(Category category) {
        this.mCategory = category;
        mDBHelperResourcesInteractor.getTableResourses(this, category);
    }

    public void save() {
        int countSavedElenents = 0;
        for (int i = 0; i < mListResources.size(); i++) {
            if (mListResources.get(i).isCheck()) {
                countSavedElenents++;
            }
        }
        if (countSavedElenents == 0) {
            getViewState().listSavedFailed(AppNews.getContext().getResources().getString(R.string.text_save_minimum_resources));
        } else {
            mDBHelperResourcesInteractor.setTableResourses(this, mCategory, mListResources);
        }
    }

    public ArrayList<ResourseModel> getListResourses() {
        return mListResources;
    }

    @Override
    public void getListFromResourseListner(ArrayList<ResourseModel> list) {
        mListResources = list;
        getViewState().setList(mListResources);
    }

    @Override
    public void addListToResoursesListner(boolean saccess) {
        getViewState().listSaved();
    }
}
