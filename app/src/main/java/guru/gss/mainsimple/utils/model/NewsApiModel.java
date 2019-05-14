package guru.gss.mainsimple.utils.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/*
ENG: The model is needed for Retrofit GsonConverterFactory
RU: Модель необходима для Retrofit GsonConverterFactory
*/
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
