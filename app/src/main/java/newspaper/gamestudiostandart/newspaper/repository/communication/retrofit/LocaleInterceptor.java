package newspaper.gamestudiostandart.newspaper.repository.communication.retrofit;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class LocaleInterceptor implements Interceptor {

    private String locale;

    private static final String CULTURE_HEADER_KEY = "culture";

    public LocaleInterceptor(String locale) {
        this.locale = locale;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request newRequest;

        newRequest = request.newBuilder()
                .addHeader(CULTURE_HEADER_KEY, locale)
                .build();

        return chain.proceed(newRequest);
    }

}
