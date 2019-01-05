package info.ankon.template.ui;

import android.os.Handler;

import com.ankon.template.R;
import info.ankon.template.core.CoreActivity;

import com.ankon.template.ui.FirstActivity_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Fullscreen;

@EActivity(R.layout.content_splash_screen)
@Fullscreen
public class SplashScreenActivity extends CoreActivity {

    @AfterViews
    void afterViews() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                openFirstActivity();
                finish();
            }
        }, 1000);
    }

    private void openFirstActivity() {
        FirstActivity_.intent(this).start();
    }

}
