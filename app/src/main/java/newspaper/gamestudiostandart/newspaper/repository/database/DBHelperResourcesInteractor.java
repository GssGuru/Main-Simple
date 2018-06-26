package newspaper.gamestudiostandart.newspaper.repository.database;


import java.util.ArrayList;

import newspaper.gamestudiostandart.newspaper.activitys.model.Category;
import newspaper.gamestudiostandart.newspaper.activitys.model.ResourseModel;

public interface DBHelperResourcesInteractor {

    interface SetReadableListener {
        void getListFromResourseListner(ArrayList<ResourseModel> list);
    }

    interface SetWritebleListner {
        void addListToResoursesListner(boolean saccess);
    }

    void getTableResourses(SetReadableListener readableListener, Category category);
    void setTableResourses(SetWritebleListner writebleListner, Category category, ArrayList<ResourseModel> list);
}
