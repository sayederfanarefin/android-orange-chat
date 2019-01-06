package info.sayederfanarefin.chat.ui.authentication;

import android.text.Html;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.codetroopers.betterpickers.calendardatepicker.CalendarDatePickerDialogFragment;
import com.codetroopers.betterpickers.datepicker.DatePickerBuilder;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.Calendar;

import info.sayederfanarefin.chat.R;
import info.sayederfanarefin.chat.core.CoreFirebaseFragment;
import info.sayederfanarefin.chat.core.CoreFragment;

/**
 * Created by Sayed Erfan Arefin on 10/5/18.
 */

@EFragment(R.layout.content_authentication_input_name)
public class SignUpAddNameProfilePictureFragment extends CoreFirebaseFragment implements CalendarDatePickerDialogFragment.OnDateSetListener {

    private static final int GALLERY_INTENT = 2;
    private static final String FRAG_TAG_DATE_PICKER = "fragment_date_picker_name";

    @ViewById
    EditText createProfileName;

    @ViewById
    Button buttonSelectBirthdate;

    @ViewById
    LinearLayout buttonMale;

    @ViewById
    LinearLayout buttonFemale;

    String birthDate = null;
    String gender = null;

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
        selectMale();

    }

    @Click
    void buttonSelectBirthdate(){

        CalendarDatePickerDialogFragment cdp = new CalendarDatePickerDialogFragment()
                .setOnDateSetListener(SignUpAddNameProfilePictureFragment.this)
                .setFirstDayOfWeek(Calendar.SUNDAY)
                .setDoneText("Select")
                .setCancelText("Cancel");

        cdp.show(getActivity().getSupportFragmentManager(), FRAG_TAG_DATE_PICKER);
    }


    @Override
    public void onDateSet(CalendarDatePickerDialogFragment dialog, int year, int monthOfYear, int dayOfMonth) {
        //mResultTextView.setText(getString(R.string.calendar_date_picker_result_values, year, monthOfYear, dayOfMonth));
        birthDate = String.valueOf(dayOfMonth) + "/" + String.valueOf(monthOfYear)+"/" + String.valueOf(year);
        buttonSelectBirthdate.setText(birthDate);
    }

    @Click
    void buttonFemale(){
        selectFemale();
    }

    @Click
    void buttonMale(){
        selectMale();
    }

    @Click
    void buttonGetStarted(){
        if(birthDate == null){
            showSnachBar("Please select Birthdate");
        }else{
            if (gender == null){
                showSnachBar("Please select Gender");
            }else{
                if (TextUtils.isEmpty(createProfileName.getText().toString())){
                    showSnachBar("Please enter your name");
                }else{
                    // save
                }
            }
        }
    }

    private void selectMale(){
        gender = "male";
        buttonFemale.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        buttonMale.setBackgroundColor(getResources().getColor(R.color.colorAccentPrimary));
    }

    private void selectFemale(){
        gender = "female";
        buttonMale.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        buttonFemale.setBackgroundColor(getResources().getColor(R.color.colorAccentPrimary));
    }

}
