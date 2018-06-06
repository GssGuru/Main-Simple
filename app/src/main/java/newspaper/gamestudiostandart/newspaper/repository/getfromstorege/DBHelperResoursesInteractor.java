package newspaper.gamestudiostandart.newspaper.repository.getfromstorege;


import java.util.ArrayList;

import newspaper.gamestudiostandart.newspaper.model.Category;
import newspaper.gamestudiostandart.newspaper.model.FragmentNewsModel;

public interface DBHelperResoursesInteractor {

    interface SetReadableListener {
        void getListFromResourseListner(ArrayList<FragmentNewsModel> list);
    }

    interface SetWritebleListner {
        void addListToResoursesListner(boolean saccess);
    }

    void getTableResourses(SetReadableListener readableListener, Category category);
    void setTableResourses(SetWritebleListner writebleListner, Category category, ArrayList<FragmentNewsModel> list);
}
