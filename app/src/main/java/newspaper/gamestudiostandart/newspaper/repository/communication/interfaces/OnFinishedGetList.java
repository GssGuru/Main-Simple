package newspaper.gamestudiostandart.newspaper.repository.communication.interfaces;

import java.util.ArrayList;

import newspaper.gamestudiostandart.newspaper.utils.model.NewsModel;

public interface OnFinishedGetList {
    void onFinishedGetList(ArrayList<NewsModel> list, String author);
}
