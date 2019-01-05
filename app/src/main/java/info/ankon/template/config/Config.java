package info.ankon.template.config;

import com.ankon.template.R;

public class Config {
    public static final boolean DEBUG = false;

    public static final boolean FILL_DATA = false;

    public static final boolean SECRET_BUILD = false;

    public static final boolean NETWORK_DELAY = false;

    public static final boolean SKIP = false;

    /*
    Configuration
     */
    public static final String DEFAULT_USER_NAME = "Android Studio";
    public static final String DEFAULT_EMAIL = "android.studio@android.com";
    public static final String DEMO_USER_NAME = "01917279377";
    public static final String DEMO_PASSWORD = "qwerty";

    public static final String DEMO_USER_NAME2 = "01776534220";
    public static final String DEMO_PASSWORD2 = "test";

    public static final String ADMIN_USER_NAME_PROD = "01558241551";
    public static final String ADMIN_PASSWORD_PROD = "01558241551";

    public static String ISO_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZ";

    public static final String LOG_TAG = "d-app";
    public static final String TRACE_TAG = "t-app";

    //
    public static final long TASK_TIMEOUT_MILLIS = 10 * 1000;   // 10 seconds

    public static final int REQUEST_TIMEOUT_MILLIS = 5 * 1000; // 5 seconds

    public static final int NETWORK_DELAY_SECONDS = 3;

    public static final String HOME_ACTIVITY = "com.cmedhealth.android.MainActivity_";

    // Calligraphy - custom fonts
    public static final int DEFAULT_FONT_PATH_RES = R.string.fonts_noto_sans_regular;

//    TODO: How frequently log files will be generated, currently for every 1 min, it creates one file

    // Licenses
    public static final String URL_APACHE_LICENSE_2_0 = "http://www.apache.org/licenses/LICENSE-2.0";
}