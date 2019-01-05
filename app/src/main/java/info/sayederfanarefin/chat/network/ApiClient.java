package info.sayederfanarefin.chat.network;

import android.content.Context;

import com.androidnetworking.interfaces.AnalyticsListener;
import info.sayederfanarefin.chat.config.Config;
import info.sayederfanarefin.chat.log.Tracer;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.Trace;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

@EBean
public class ApiClient {

    @RootContext
    Context context;

    private static int counter = 1;

    //Timeout handler
    private OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            . writeTimeout(30, TimeUnit.SECONDS)
            .build();

    private HashMap<String, String> cHeaderMap = new HashMap<String, String>() {{
        put("Content-Type", "application/x-www-form-urlencoded");
        put("Accept", "application/x-www-form-urlencoded");
    }};

    AnalyticsListener analyticsListener = new AnalyticsListener() {
        @Override
        public void onReceived(long timeTakenInMillis, long bytesSent, long bytesReceived, boolean isFromCache) {
            Tracer.i("timeTakenInMillis: " + timeTakenInMillis +
                    "||bytesSent: " + bytesSent +
                    "||bytesReceived: " + bytesReceived +
                    "||isFromCache: " + isFromCache);
        }
    };

    @Trace(tag = Config.LOG_TAG)
    public void login(String username, String password) {
//        Tracer.i("Login API: " + ApiEndPoint.BASE_URL + ApiEndPoint.CREATE_SESSION + "\n" +
//                "" + ApiEndPoint.KEY_CONTENT_TYPE + ": application/x-www-form-urlencoded" + "\n" +
//                "" + ApiEndPoint.KEY_EMAIL + ": " + username + "\n" +
//                "" + ApiEndPoint.KEY_PASSWORD + ": " + password);
//        AndroidNetworking.post(ApiEndPoint.BASE_URL + ApiEndPoint.CREATE_SESSION)
//                .addHeaders(ApiEndPoint.KEY_CONTENT_TYPE, "application/x-www-form-urlencoded")
//                .addUrlEncodeFormBodyParameter(ApiEndPoint.KEY_EMAIL, username)
//                .addUrlEncodeFormBodyParameter(ApiEndPoint.KEY_PASSWORD, password)
//                .setTag(this)
//                .setPriority(Priority.MEDIUM)
//                .build()
//                .setAnalyticsListener(analyticsListener)
//                .getAsOkHttpResponseAndParsed(new TypeToken<Session>() {
//                }, new OkHttpResponseAndParsedRequestListener<Session>() {
//                    @Override
//                    public void onResponse(Response okHttpResponse, Session session) {
//                        Tracer.i("Session:" + session);
//                        ResponseHandler_.getInstance_(context).onCreateSessionLoaded(session);
//                    }
//
//                    @Override
//                    public void onError(ANError anError) {
//                        Tracer.e(anError.getErrorCode() + "\n" + anError.getErrorBody());
//                        ResponseHandler_.getInstance_(context).onCreateSessionError(anError);
//                    }
//                });

    }

}