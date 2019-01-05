package info.ankon.template.app;

import android.provider.Settings;
import android.support.multidex.MultiDexApplication;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.gsonparserfactory.GsonParserFactory;
import com.google.gson.GsonBuilder;
import com.joanzapata.iconify.Iconify;
import com.joanzapata.iconify.fonts.FontAwesomeModule;
import info.ankon.template.config.Config;
import info.ankon.template.log.Tracer;

import org.androidannotations.annotations.EApplication;
import org.androidannotations.annotations.Trace;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

@EApplication
public abstract class CoreApplication extends MultiDexApplication {

    private final String TRACE_TAG = Config.TRACE_TAG + "CoreApplication";

    /**
     * Logical density of this device
     */
    private static float LOGICAL_DENSITY;

    private static CoreApplication sInstance;

    // private AuthCallback digitsAuthCallback;

    public static synchronized CoreApplication getInstance() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        sInstance = this;

        LOGICAL_DENSITY = getResources().getDisplayMetrics().density;

        // TODO: Add Fabric.io all components

        init();

    }

    public static float getLogicalDensity() {
        return LOGICAL_DENSITY;
    }

    @Trace(tag = TRACE_TAG)
    protected void init() {
        configureCalligraphy();
        configureTracer();
        // configureFabric();
        configureIconify();
        configureStetho();
        configureNetworking();
    }

    private void configureNetworking() {
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .connectTimeout(Config.REQUEST_TIMEOUT_MILLIS, TimeUnit.SECONDS)
                .readTimeout(Config.REQUEST_TIMEOUT_MILLIS, TimeUnit.SECONDS)
                .writeTimeout(Config.REQUEST_TIMEOUT_MILLIS, TimeUnit.SECONDS)
                .build();

        AndroidNetworking.initialize(this, okHttpClient);
        AndroidNetworking.setParserFactory(new GsonParserFactory(new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").create()));
    }

    private void configureStetho() {
        //Stetho.initializeWithDefaults(this);
    }

    private void configureIconify() {
        Iconify.with(new FontAwesomeModule());
    }

//    private void configureFabric() {
//        TwitterAuthConfig authConfig = new TwitterAuthConfig(getString(R.string.twitter_key), getString(R.string.twitter_secret));
//        final Fabric fabric = new Fabric.Builder(this)
//                .kits(new Crashlytics(), new TwitterCore(authConfig), new Digits())
//                .debuggable(Config.DEBUG)
//                .build();
//        Fabric.with(fabric);
//
//        digitsAuthCallback = new AuthCallback() {
//            @Override
//            public void success(DigitsSession digitsSession, String phoneNumber) {
//                /*
//                session.getPhoneNumber(); OR, phoneNumber
//                TwitterAuthToken authToken = (TwitterAuthToken) session.getAuthToken();
//                String token = authToken.token;
//                String secret = authToken.secret;
//                session.getId();
//                 */
//            }
//
//            @Override
//            public void failure(DigitsException e) {
//                //
//            }
//        };
//
//    }

//    public AuthCallback getDigitsAuthCallback() {
//        return digitsAuthCallback;
//    }

    private void configureTracer() {
        Tracer.init();
    }

    private void configureCalligraphy() {
//        CalligraphyConfig
//                .initDefault(new CalligraphyConfig.Builder()
//                        .setDefaultFontPath(getString(Config.DEFAULT_FONT_PATH_RES))
//                        .setFontAttrId(R.attr.fontPath)
//                        .build());
    }

    public String getUniqueDeviceId() {
        return Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID);
    }

}