package newspaper.gamestudiostandart.newspaper.repository.getfromstorege;



import java.util.ArrayList;

import newspaper.gamestudiostandart.newspaper.model.NewsModel;

public interface DBHelperNewsInteractor {

    interface SetNewsListener {
        void getListFromNewsListner(ArrayList<NewsModel> list);
        void addListToNewsListner(boolean saccess);
    }

    void getTableNews(SetNewsListener listener, String author);
    void setTableNews(SetNewsListener listener, String author, ArrayList<NewsModel> list);
}
