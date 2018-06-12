package newspaper.gamestudiostandart.newspaper.repository.getfromstorege;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Handler;
import android.util.Log;

import java.util.ArrayList;

import newspaper.gamestudiostandart.newspaper.AppNews;
import newspaper.gamestudiostandart.newspaper.AppSetings;
import newspaper.gamestudiostandart.newspaper.model.Category;
import newspaper.gamestudiostandart.newspaper.model.ResourseModel;
import newspaper.gamestudiostandart.newspaper.model.NewsModel;

public class DBHelperNews extends SQLiteOpenHelper implements DBHelperResoursesInteractor, DBHelperNewsInteractor {

    private static DBHelperNews dbh = null;
    private static SQLiteDatabase DB = null;

    private DBHelperNews(Context context) {
        super(context, "MyDb", null, 1);
    }

    public static synchronized DBHelperNews getInstance() {
        if (dbh == null)
            dbh = new DBHelperNews(AppNews.getContext());
        return dbh;
    }

    private SQLiteDatabase getDB() {
        if (DB != null)
            return DB;
        return this.getWritableDatabase();
    }


    @Override
    public void getTableNews(final SetNewsListener listener, final String author) {
        final Handler myHandler = new Handler();
        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                final ArrayList<NewsModel> list = isTableExists(getSavedName(author))?readFromTableNews(author):new ArrayList<NewsModel>();
                myHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        listener.getListFromNewsListner(list);
                    }
                });
            }
        });
        myThread.start();

    }

    @Override
    public void setTableNews(final SetNewsListener listener, final String author, final ArrayList<NewsModel> list) {
        final Handler myHandler = new Handler();
        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                if (!isTableExists(author)) {
                    createNewsTable(author);
                } else {
                    getDB().delete(getSavedName(author), null, null);
                }
                writeToTableNews(list, author);
                myHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        listener.addListToNewsListner(true);
                    }
                });
            }
        });
        myThread.start();
    }

    private synchronized ArrayList<NewsModel> readFromTableNews(String author) {
        ArrayList<NewsModel> list = new ArrayList<>();
        Cursor c = getDB().query(getSavedName(author), null, null, null, null, null, null);
        if (c.moveToFirst()) {
            int indextitte = c.getColumnIndex("title");
            int indexdescription = c.getColumnIndex("description");
            int indexurl = c.getColumnIndex("url");
            int indexurlToImage = c.getColumnIndex("urlToImage");
            int indexpublishedAt = c.getColumnIndex("publishedAt");
            do {
                Log.d("dbHalper", "+ rows");
                list.add(new NewsModel(c.getString(indextitte), c.getString(indexdescription), c.getString(indexurl), c.getString(indexurlToImage), c.getString(indexpublishedAt)));
            } while (c.moveToNext());
        } else {
            Log.d("dbHalper", "0 rows");
        }
        c.close();
        return list;
    }

    private synchronized void writeToTableNews(ArrayList<NewsModel> list, String tableName) {
        try {
            for (int i = 0; i < list.size(); i++) {
                ContentValues values = new ContentValues();
                values.put("title", list.get(i).getTitle());
                values.put("description", list.get(i).getDescription());
                values.put("url", list.get(i).getUrl());
                values.put("urlToImage", list.get(i).getUrlToImage());
                values.put("publishedAt", list.get(i).getPublishedAt());
                getDB().insert(getSavedName(tableName), null, values);
                Log.d("dbHalper", "getDB().insert(getSavedName(tableName) " + i);
            }
        } catch (Exception e) {
            Log.d(AppSetings.LOGS, getClass().getSimpleName() + " - " + e.getMessage());
        }
    }

    private synchronized void createNewsTable(String tablename) {
        SQLiteDatabase db = getDB();
        try {
            String stmt = "CREATE TABLE " + getSavedName(tablename) + " ("
                    + "title text,"
                    + "description text,"
                    + "url text,"
                    + "urlToImage text,"
                    + "publishedAt text" + ");";
            db.execSQL(stmt);
        } catch (Exception e) {
            Log.d(AppSetings.LOGS, getClass().getSimpleName() + " - " + e.getMessage());
        }
    }

    @Override
    public void getTableResourses(final SetReadableListener readableListener, final Category category) {
        final Handler myHandler = new Handler();
        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                if (!isTableExists(String.valueOf(category))) {
                    createResousreTable(String.valueOf(category));
                    writeToTableResourses(AppSetings.getList(category), String.valueOf(category));
                }

                final ArrayList<ResourseModel> list = readFromTableResourse(category);
                myHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        readableListener.getListFromResourseListner(list);
                    }
                });
            }
        });
        myThread.start();
    }

    @Override
    public void setTableResourses(final SetWritebleListner writebleListner, final Category category, final ArrayList<ResourseModel> list) {
        final Handler myHandler = new Handler();
        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                if (!isTableExists(String.valueOf(category))) {
                    createResousreTable(String.valueOf(category));
                } else {
                    getDB().delete(getSavedName(String.valueOf(category)), null, null);
                }
                writeToTableResourses(list, String.valueOf(category));
                myHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        writebleListner.addListToResoursesListner(true);
                    }
                });
            }
        });
        myThread.start();
    }

    private synchronized ArrayList<ResourseModel> readFromTableResourse(Category category) {
        final ArrayList<ResourseModel> list = new ArrayList<>();
        try {
            Cursor c = getDB().query(getSavedName(String.valueOf(category)), null, null, null, null, null, null);
            if (c.moveToFirst()) {
                int indextitte = c.getColumnIndex("name");
                int indexdescription = c.getColumnIndex("url");
                int indexurl = c.getColumnIndex("ischeck");
                do {
                    list.add(new ResourseModel(c.getString(indextitte), c.getString(indexdescription), c.getString(indexurl).equals("1")));
                } while (c.moveToNext());
            }
            c.close();
        } catch (Exception e) {
            Log.d(AppSetings.LOGS, getClass().getSimpleName() + " - " + e.getMessage());
        }
        return list;
    }

    private synchronized void writeToTableResourses(ArrayList<ResourseModel> list, String tableName) {
        try {
            for (int i = 0; i < list.size(); i++) {
                ContentValues values = new ContentValues();
                values.put("name", list.get(i).getName());
                values.put("url", list.get(i).getUrl());
                values.put("ischeck", list.get(i).isCheck() ? "1" : "0");
                getDB().insert(getSavedName(tableName), null, values);
            }
        } catch (Exception e) {
            Log.d(AppSetings.LOGS, getClass().getSimpleName() + " - " + e.getMessage());
        }
    }

    private synchronized void createResousreTable(String tablename) {
        try {
            String stmt = "CREATE TABLE " + getSavedName(tablename) + " ("
                    + "name text,"
                    + "url text,"
                    + "ischeck text"
                    + ");";
            getDB().execSQL(stmt);
        } catch (Exception e) {
            Log.d(AppSetings.LOGS, getClass().getSimpleName() + " - " + e.getMessage());
        }
    }




    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

    private synchronized static String getSavedName(String text) {
        String result;
        try {
            result = text.replaceAll("-", "");
        } catch (Exception e) {
            result = text;
        }
        return result;
    }

    private synchronized boolean isTableExists(String tableName) {
        boolean isExist = false;
        try {
            Cursor cursor = getDB().rawQuery("select DISTINCT tbl_name from sqlite_master where tbl_name = '" + getSavedName(tableName) + "'", null);
            if (cursor != null) {
                if (cursor.getCount() > 0) {
                    isExist = true;
                }
                cursor.close();
            }
        } catch (Exception e) {
            Log.d(AppSetings.LOGS, getClass().getSimpleName() + " - " + e.getMessage());
        }
        return isExist;
    }
}
