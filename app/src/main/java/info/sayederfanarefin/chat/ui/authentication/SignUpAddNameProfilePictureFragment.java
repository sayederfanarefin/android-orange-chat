package info.sayederfanarefin.chat.ui.authentication;

import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.codetroopers.betterpickers.calendardatepicker.CalendarDatePickerDialogFragment;
import com.codetroopers.betterpickers.datepicker.DatePickerBuilder;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.Calendar;

import info.sayederfanarefin.chat.R;
import info.sayederfanarefin.chat.core.CoreFragment;

/**
 * Created by Sayed Erfan Arefin on 10/5/18.
 */

@EFragment(R.layout.content_authentication_input_name)
public class SignUpAddNameProfilePictureFragment extends CoreFragment {

    @ViewById
    EditText createProfileName;

    public SignUpAddNameProfilePictureFragment() {
        //Mandatory default constructor
    }

    @AfterViews
    void afterViews() {
        createProfileName.setBackgroundResource(R.drawable.edittexrroundedcorner_gray);
        createProfileName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    view.setBackgroundResource(R.drawable.edittexrroundedcorner_focused);
                } else {
                    view.setBackgroundResource(R.drawable.edittexrroundedcorner_gray);
                }
            }
        });

    }

    @Click
    void buttonSelectBirthdate(){

        DatePickerBuilder dpb = new DatePickerBuilder()
                .setFragmentManager(getActivity().getSupportFragmentManager())
                .setStyleResId(R.style.BetterPickersDialogFragment)
                .setYearOptional(true);
        dpb.show();
    }


}
