package newspaper.gamestudiostandart.newspaper.repository.communication.newslist.interfaces;

import java.util.ArrayList;

import newspaper.gamestudiostandart.newspaper.utils.model.NewsModel;

public interface OnFinishedGetList {
    void onFinishedGetList(ArrayList<NewsModel> list, String author);
}
