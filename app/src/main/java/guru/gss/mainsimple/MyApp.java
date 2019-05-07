package guru.gss.mainsimple;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

public class MyApp extends Application {

    @SuppressLint("StaticFieldLeak")
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static Context getContext(){
        return mContext;
    }
}
