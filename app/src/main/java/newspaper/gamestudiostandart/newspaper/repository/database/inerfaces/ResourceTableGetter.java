package newspaper.gamestudiostandart.newspaper.repository.database.inerfaces;

import newspaper.gamestudiostandart.newspaper.utils.model.Category;

public interface ResourceTableGetter {
    void getTableResourses(ResourceTableListener listener, Category category);
}
