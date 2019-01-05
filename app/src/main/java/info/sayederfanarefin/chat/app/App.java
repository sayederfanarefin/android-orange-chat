package info.sayederfanarefin.chat.app;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ConnectionQuality;
import com.androidnetworking.interfaces.ConnectionQualityChangeListener;
import info.sayederfanarefin.chat.BuildConfig;
import info.sayederfanarefin.chat.log.Tracer;

import org.androidannotations.annotations.EApplication;

@EApplication
public class App extends CoreApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        try {
            Tracer.i("Application Id: " + BuildConfig.APPLICATION_ID
                    + " || Version code: " + BuildConfig.VERSION_CODE
                    + " || Version name: " + BuildConfig.VERSION_NAME
                    //+ " || Git Sha: " + com.genericslab.droidplate.BuildConfig.GIT_SHA
                    // + " || Build time:  " + com.ankon.sweetitechmileagetracker.BuildConfig.BUILD_TIME
                    + " || Build flavor: " + BuildConfig.FLAVOR
                    + " || Build type: " + BuildConfig.BUILD_TYPE);

        } catch (NullPointerException ne) {
            Tracer.e(ne.toString());
        }

    }

    private void connectivityListener() {
        AndroidNetworking.setConnectionQualityChangeListener(new ConnectionQualityChangeListener() {
            @Override
            public void onChange(ConnectionQuality currentConnectionQuality, int currentBandwidth) {
                Tracer.i("Internet connection quality: " + currentConnectionQuality.name() + " bandwidth: " + currentBandwidth);
            }
        });
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        AndroidNetworking.removeConnectionQualityChangeListener();
    }

}