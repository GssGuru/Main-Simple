package newspaper.gamestudiostandart.newspaper.aplication.main;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.ArrayList;

import newspaper.gamestudiostandart.newspaper.utils.model.Category;
import newspaper.gamestudiostandart.newspaper.utils.model.ResourseModel;
import newspaper.gamestudiostandart.newspaper.repository.database.DBHelper;
import newspaper.gamestudiostandart.newspaper.repository.database.DBHelperResourcesInteractor;
import newspaper.gamestudiostandart.newspaper.repository.database.inerfaces.ResourceTableListener;

@InjectViewState
public class MainActivityPresenter extends MvpPresenter<MainActivityView> implements
        ResourceTableListener {

    private DBHelperResourcesInteractor mDBHelperResourcesInteractor;
    private Category mCategory;
    private ArrayList<ResourseModel> mListCheckedModels;

    MainActivityPresenter() {
        mDBHelperResourcesInteractor = DBHelper.getInstance();
        mCategory = Category.STARRED;
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

    @Override
    public void action(boolean saccess) {

    }

    @Override
    public void listFromResource(ArrayList<ResourseModel> list) {
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
}
