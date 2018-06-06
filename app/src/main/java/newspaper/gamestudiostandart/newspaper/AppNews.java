package newspaper.gamestudiostandart.newspaper;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

public class AppNews extends Application {

    @SuppressLint("StaticFieldLeak")
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        AppSetings.addListKeys();
    }

    public static Context getContext(){
        return mContext;
    }
}
