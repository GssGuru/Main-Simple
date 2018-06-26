package newspaper.gamestudiostandart.newspaper;

import java.util.ArrayList;

import newspaper.gamestudiostandart.newspaper.activitys.model.Category;
import newspaper.gamestudiostandart.newspaper.activitys.model.ResourseModel;

/*This class is needed to collect all resources for request*/
public class AppSetings {

    public static final String LOGS = "NewsLogsException";

    public static ArrayList<String> listKeys;

    public static ArrayList<ResourseModel> getList(Category category) {
        switch (category) {
            case STARRED:
                return addMyFavorite(new ArrayList<ResourseModel>());
            case POPULAR:
                return addListPopularNews(new ArrayList<ResourseModel>());
            case TEHNOLOGY:
                return addListTechnologyNews(new ArrayList<ResourseModel>());
            case SPORT:
                return addListSportNews(new ArrayList<ResourseModel>());
            case BUSINESS:
                return addListBusinessNews(new ArrayList<ResourseModel>());
            case OTHER:
                return addListOther(new ArrayList<ResourseModel>());
            default:
                break;
        }

        return null;
    }


    private static ArrayList<ResourseModel> addMyFavorite(ArrayList<ResourseModel> mList) {
        mList.addAll(addListPopularNews(new ArrayList<ResourseModel>()));
        mList.addAll(addListTechnologyNews(new ArrayList<ResourseModel>()));
        mList.addAll(addListSportNews(new ArrayList<ResourseModel>()));
        mList.addAll(addListBusinessNews(new ArrayList<ResourseModel>()));
        mList.addAll(addListOther(new ArrayList<ResourseModel>()));
        for (int i = 0; i < mList.size();i++){
            mList.get(i).setCheck(i<4);
        }
        return mList;
    }


    /*
    add POPULAR resources
    */
    private static ArrayList<ResourseModel> addListPopularNews(ArrayList<ResourseModel> mList) {

        mList.add(new ResourseModel("The Washington Post", "the-washington-post", true));
        mList.add(new ResourseModel("The New York Times", "the-new-york-times", true));
        mList.add(new ResourseModel("The Telegraph", "the-telegraph"));
        mList.add(new ResourseModel("CNN", "cnn", true));
        mList.add(new ResourseModel("Time", "time"));
        mList.add(new ResourseModel("BBC News", "bbc-news", true));
        mList.add(new ResourseModel("Associated Press", "associated-press"));
        mList.add(new ResourseModel("Independent", "independent"));
        mList.add(new ResourseModel("Reuters", "reuters"));
        mList.add(new ResourseModel("The Guardian (AU)", "the-guardian-au"));
        mList.add(new ResourseModel("USA Today", "usa-today"));
        return mList;
    }

    /*
    add TECHNOLOGY resources
    */
    private static ArrayList<ResourseModel> addListTechnologyNews(ArrayList<ResourseModel> mList) {
        mList.add(new ResourseModel("Ars Technica", "ars-technica"));
        mList.add(new ResourseModel("Engadget", "engadget", true));
        mList.add(new ResourseModel("Gruenderszene", "gruenderszene"));
        mList.add(new ResourseModel("Hacker News", "hacker-news"));
        mList.add(new ResourseModel("Recode", "recode", true));
        mList.add(new ResourseModel("T3n", "t3n"));
        mList.add(new ResourseModel("TechCrunch", "techcrunch"));
        mList.add(new ResourseModel("TechRadar", "techradar", true));
        mList.add(new ResourseModel("The Verge", "the-verge"));
        mList.add(new ResourseModel("Wired.de", "wired-de", true));
        return mList;
    }

    /*
    add SPORT resources
    */
    private static ArrayList<ResourseModel> addListSportNews(ArrayList<ResourseModel> mList) {
        mList.add(new ResourseModel("BBC Sport", "bbc-sport", true));
        mList.add(new ResourseModel("Fox Sports", "fox-sports", true));
        mList.add(new ResourseModel("ESPN", "espn", true));
        mList.add(new ResourseModel("Football Italia", "football-italia", true));
        mList.add(new ResourseModel("FourFourTwo", "four-four-two"));
        mList.add(new ResourseModel("The Sport Bible", "the-sport-bible"));
        mList.add(new ResourseModel("NFL News", "nfl-news"));
        mList.add(new ResourseModel("TalkSport", "talksport"));
        return mList;
    }

    /*
    add BUSINESS resources
    */
    private static ArrayList<ResourseModel> addListBusinessNews(ArrayList<ResourseModel> mList) {
        mList.add(new ResourseModel("Bloomberg", "bloomberg", true));
        mList.add(new ResourseModel("The Wall Street Journal", "the-wall-street-journal", true));
        mList.add(new ResourseModel("Business Insider", "business-insider", true));
        mList.add(new ResourseModel("Business Insider (UK)", "business-insider-uk", true));
        mList.add(new ResourseModel("CNBC", "cnbc"));
        mList.add(new ResourseModel("Fortune", "fortune"));
        mList.add(new ResourseModel("The Economist", "the-economist"));
        mList.add(new ResourseModel("Financial Times", "financial-times"));
        return mList;
    }

    /*
    add OTHER resources
    */
    private static ArrayList<ResourseModel> addListOther(ArrayList<ResourseModel> mList) {
        mList.add(new ResourseModel("Breitbart News", "breitbart-news", true));
        mList.add(new ResourseModel("Buzzfeed", "buzzfeed", true));
        mList.add(new ResourseModel("Daily Mail", "daily-mail"));
        mList.add(new ResourseModel("Entertainment Weekly", "entertainment-weekly", true));
        mList.add(new ResourseModel("Mashable", "mashable"));
        mList.add(new ResourseModel("The Lad Bible", "the-lad-bible"));
        mList.add(new ResourseModel("IGN", "ign", true));
        mList.add(new ResourseModel("Polygon", "polygon"));
        mList.add(new ResourseModel("National Geographic", "national-geographic", true));
        mList.add(new ResourseModel("New Scientist", "new-scientist", true));
        mList.add(new ResourseModel("MTV News", "mtv-news"));
        mList.add(new ResourseModel("MTV News (UK)", "mtv-news-uk", true));
        return mList;
    }

    /*
    set Keys for server
    */
    public static void addListKeys() {
        listKeys = new ArrayList<>();
        listKeys.add("7c4feddaa4b749a48dfa50252ccde419");
        listKeys.add("d192b8870e094398976a7d54801b99d4");
        listKeys.add("ac0fc119593243c38fd77d1699ea0347");
        listKeys.add("9e5d5f981dd14a6aad17154b3f4c74fd");
    }
}
