package newspaper.gamestudiostandart.newspaper.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/*The model is needed for retrofit GsonConverterFactory*/
public class NewsApiModel {

    @SerializedName("articles")
    @Expose
    private ArrayList<NewsModel> list;

    public ArrayList<NewsModel> getArticles() {
        if(list == null){
            list = new ArrayList<>();
        }
        return list;
    }
}
