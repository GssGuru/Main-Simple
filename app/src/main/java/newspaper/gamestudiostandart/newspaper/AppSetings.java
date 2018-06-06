package newspaper.gamestudiostandart.newspaper;

import java.util.ArrayList;

import newspaper.gamestudiostandart.newspaper.model.Category;
import newspaper.gamestudiostandart.newspaper.model.FragmentNewsModel;

/*This class is needed to collect all resources for request*/
public class AppSetings {

    public static final String LOGS = "NewsLogsException";

    public static ArrayList<String> listKeys;

    public static ArrayList<FragmentNewsModel> getList(Category category) {
        switch (category) {
            case GENERAL:
                return addListGeneralNews(new ArrayList<FragmentNewsModel>());
            case TEHNOLOGY:
                return addListTechnologyNews(new ArrayList<FragmentNewsModel>());
            case SPORT:
                return addListSportNews(new ArrayList<FragmentNewsModel>());
            case BUSINESS:
                return addListBusinessNews(new ArrayList<FragmentNewsModel>());
            case POLITICS:
                return addListPoliticsNews(new ArrayList<FragmentNewsModel>());
            case ENTERTAINMENT:
                return addListEntertainmentNews(new ArrayList<FragmentNewsModel>());
            case GAMING:
                return addListGamingNews(new ArrayList<FragmentNewsModel>());
            case NATURE:
                return addListEcienceEndNatureNews(new ArrayList<FragmentNewsModel>());
            case MUSIC:
                return addListMusicNews(new ArrayList<FragmentNewsModel>());
            default:
                break;
        }

        return null;
    }

    /*
    add GENERAL resources
    */
    private static ArrayList<FragmentNewsModel> addListGeneralNews(ArrayList<FragmentNewsModel> mList) {

        mList.add(new FragmentNewsModel("The Washington Post", "the-washington-post", true));
        mList.add(new FragmentNewsModel("The New York Times", "the-new-york-times", true));
        mList.add(new FragmentNewsModel("The Telegraph", "the-telegraph"));
        mList.add(new FragmentNewsModel("CNN", "cnn", true));
        mList.add(new FragmentNewsModel("Time", "time"));
        mList.add(new FragmentNewsModel("BBC News", "bbc-news"));
        mList.add(new FragmentNewsModel("Associated Press", "associated-press"));
        mList.add(new FragmentNewsModel("Independent", "independent"));
        mList.add(new FragmentNewsModel("Reuters", "reuters"));
        mList.add(new FragmentNewsModel("The Guardian (AU)", "the-guardian-au"));
        mList.add(new FragmentNewsModel("USA Today", "usa-today"));
        return mList;
    }

    /*
    add TECHNOLOGY resources
    */
    private static ArrayList<FragmentNewsModel> addListTechnologyNews(ArrayList<FragmentNewsModel> mList) {
        mList.add(new FragmentNewsModel("Ars Technica", "ars-technica"));
        mList.add(new FragmentNewsModel("Engadget", "engadget", true));
        mList.add(new FragmentNewsModel("Gruenderszene", "gruenderszene"));
        mList.add(new FragmentNewsModel("Hacker News", "hacker-news"));
        mList.add(new FragmentNewsModel("Recode", "recode", true));
        mList.add(new FragmentNewsModel("T3n", "t3n"));
        mList.add(new FragmentNewsModel("TechCrunch", "techcrunch"));
        mList.add(new FragmentNewsModel("TechRadar", "techradar", true));
        mList.add(new FragmentNewsModel("The Verge", "the-verge"));
        mList.add(new FragmentNewsModel("Wired.de", "wired-de"));
        return mList;
    }

    /*
    add SPORT resources
    */
    private static ArrayList<FragmentNewsModel> addListSportNews(ArrayList<FragmentNewsModel> mList) {
        mList.add(new FragmentNewsModel("BBC Sport", "bbc-sport", true));
        mList.add(new FragmentNewsModel("Fox Sports", "fox-sports", true));
        mList.add(new FragmentNewsModel("ESPN", "espn", true));
        mList.add(new FragmentNewsModel("Football Italia", "football-italia"));
        mList.add(new FragmentNewsModel("FourFourTwo", "four-four-two"));
        mList.add(new FragmentNewsModel("The Sport Bible", "the-sport-bible"));
        mList.add(new FragmentNewsModel("NFL News", "nfl-news"));
        mList.add(new FragmentNewsModel("TalkSport", "talksport"));
        return mList;
    }

    /*
    add BUSINESS resources
    */
    private static ArrayList<FragmentNewsModel> addListBusinessNews(ArrayList<FragmentNewsModel> mList) {
        mList.add(new FragmentNewsModel("Bloomberg", "bloomberg", true));
        mList.add(new FragmentNewsModel("The Wall Street Journal", "the-wall-street-journal", true));
        mList.add(new FragmentNewsModel("Business Insider", "business-insider", true));
        mList.add(new FragmentNewsModel("Business Insider (UK)", "business-insider-uk"));
        mList.add(new FragmentNewsModel("CNBC", "cnbc"));
        mList.add(new FragmentNewsModel("Fortune", "fortune"));
        mList.add(new FragmentNewsModel("The Economist", "the-economist"));
        mList.add(new FragmentNewsModel("Financial Times", "financial-times"));
        return mList;
    }

    /*
    add POLITICS resources
    */
    private static ArrayList<FragmentNewsModel> addListPoliticsNews(ArrayList<FragmentNewsModel> mList) {
        mList.add(new FragmentNewsModel("Breitbart News", "breitbart-news", true));
        return mList;
    }

    /*
    add ENTERTAINMENT resources
    */
    private static ArrayList<FragmentNewsModel> addListEntertainmentNews(ArrayList<FragmentNewsModel> mList) {
        mList.add(new FragmentNewsModel("Buzzfeed", "buzzfeed", true));
        mList.add(new FragmentNewsModel("Daily Mail", "daily-mail", true));
        mList.add(new FragmentNewsModel("Entertainment Weekly", "entertainment-weekly", true));
        mList.add(new FragmentNewsModel("Mashable", "mashable"));
        mList.add(new FragmentNewsModel("The Lad Bible", "the-lad-bible"));
        return mList;
    }

    /*
    set GAMING resources
    */
    private static ArrayList<FragmentNewsModel> addListGamingNews(ArrayList<FragmentNewsModel> mList) {
        mList.add(new FragmentNewsModel("IGN", "ign", true));
        mList.add(new FragmentNewsModel("Polygon", "polygon", true));
        return mList;
    }

    /*
    add ECIENCE resources
    */
    private static ArrayList<FragmentNewsModel> addListEcienceEndNatureNews(ArrayList<FragmentNewsModel> mList) {
        mList.add(new FragmentNewsModel("National Geographic", "national-geographic", true));
        mList.add(new FragmentNewsModel("New Scientist", "new-scientist", true));
        return mList;
    }

    /*
    add MUSIC resources
    */
    private static ArrayList<FragmentNewsModel> addListMusicNews(ArrayList<FragmentNewsModel> mList) {
        mList.add(new FragmentNewsModel("MTV News", "mtv-news", true));
        mList.add(new FragmentNewsModel("MTV News (UK)", "mtv-news-uk", true));
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
