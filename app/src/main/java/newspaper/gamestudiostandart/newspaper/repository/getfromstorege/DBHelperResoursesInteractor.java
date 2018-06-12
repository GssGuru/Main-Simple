package newspaper.gamestudiostandart.newspaper.repository.getfromstorege;


import java.util.ArrayList;

import newspaper.gamestudiostandart.newspaper.model.Category;
import newspaper.gamestudiostandart.newspaper.model.ResourseModel;

public interface DBHelperResoursesInteractor {

    interface SetReadableListener {
        void getListFromResourseListner(ArrayList<ResourseModel> list);
    }

    interface SetWritebleListner {
        void addListToResoursesListner(boolean saccess);
    }

    void getTableResourses(SetReadableListener readableListener, Category category);
    void setTableResourses(SetWritebleListner writebleListner, Category category, ArrayList<ResourseModel> list);
}
