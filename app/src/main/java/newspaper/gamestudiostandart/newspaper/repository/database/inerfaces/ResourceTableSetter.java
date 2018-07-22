package newspaper.gamestudiostandart.newspaper.repository.database.inerfaces;

import java.util.ArrayList;

import newspaper.gamestudiostandart.newspaper.utils.model.Category;
import newspaper.gamestudiostandart.newspaper.utils.model.ResourseModel;

public interface ResourceTableSetter {
    void setTableResourses(ResourceTableListener listener, Category category, ArrayList<ResourseModel> list);

}
