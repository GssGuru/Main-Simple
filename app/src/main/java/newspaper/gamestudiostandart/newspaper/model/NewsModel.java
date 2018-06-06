package newspaper.gamestudiostandart.newspaper.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/*Model for one news*/
public class NewsModel {

    public NewsModel(String title, String description, String url, String urlToImage, String publishedAt) {
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToImage = urlToImage;
        this.publishedAt = publishedAt;
    }

    public NewsModel() {}

    @SerializedName("title")
    @Expose
    private String title = "";
    @SerializedName("description")
    @Expose
    private String description = "";
    @SerializedName("url")
    @Expose
    private String url = "";
    @SerializedName("urlToImage")
    @Expose
    private String urlToImage = "";
    @SerializedName("publishedAt")
    @Expose
    private String publishedAt = "";

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }
}