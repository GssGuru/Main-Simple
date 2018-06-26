package newspaper.gamestudiostandart.newspaper.repository.communication.retrofit;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class TokenInterceptor implements Interceptor {

    private static final String USER_TOKEN_KEY = "token";
    private String token;

    public TokenInterceptor(String token) {
        this.token = token;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request newRequest;
        newRequest = request.newBuilder()
                .addHeader(USER_TOKEN_KEY, token)
                .build();

        return chain.proceed(newRequest);
    }

}
