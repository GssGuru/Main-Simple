package newspaper.gamestudiostandart.newspaper.activitys.main;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.ArrayList;

import newspaper.gamestudiostandart.newspaper.activitys.model.Category;
import newspaper.gamestudiostandart.newspaper.activitys.model.ResourseModel;
import newspaper.gamestudiostandart.newspaper.repository.database.DBHelper;
import newspaper.gamestudiostandart.newspaper.repository.database.DBHelperResourcesInteractor;

@InjectViewState
public class MainActivityPresenter extends MvpPresenter<MainActivityView> implements
        DBHelperResourcesInteractor.SetReadableListener {

    private DBHelperResourcesInteractor mDBHelperResourcesInteractor;
    private Category mCategory;
    private ArrayList<ResourseModel> mListCheckedModels;

    MainActivityPresenter() {
        mDBHelperResourcesInteractor = DBHelper.getInstance();
        mCategory = Category.STARRED;
    }

    @Override
    public void getListFromResourseListner(ArrayList<ResourseModel> list) {
        if (mListCheckedModels == null) {
            mListCheckedModels = new ArrayList<>();
        }
        mListCheckedModels.clear();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isCheck()) {
                mListCheckedModels.add(list.get(i));
            }
        }
        getViewState().setList(mListCheckedModels);
    }

    public void getListRresourses() {
        mDBHelperResourcesInteractor.getTableResourses(this, mCategory);
    }

    public void getListRresourses(Category category) {
        this.mCategory = category;
        mDBHelperResourcesInteractor.getTableResourses(this, category);
    }

    public Category getCategory() {
        return mCategory;
    }

    public ArrayList<ResourseModel> getChackList() {
        return mListCheckedModels;
    }
}
