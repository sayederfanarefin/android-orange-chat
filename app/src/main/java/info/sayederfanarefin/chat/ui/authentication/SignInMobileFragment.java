package info.sayederfanarefin.chat.ui.authentication;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.hbb20.CountryCodePicker;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import info.sayederfanarefin.chat.R;
import info.sayederfanarefin.chat.core.CoreFragment;

/**
 * Created by Sayed Erfan Arefin on 10/5/18.
 */

@EFragment(R.layout.content_authentication_login_using_phone)
public class SignInMobileFragment extends CoreFragment {

    @ViewById
    CountryCodePicker countryCodePicker;

    @ViewById
    EditText editTextPhoneNumber;



    public SignInMobileFragment() {
        //Mandatory default constructor
    }

    @AfterViews
    void afterViews() {

        editTextPhoneNumber.setBackgroundResource( R.drawable.edittexrroundedcorner_gray);


        editTextPhoneNumber.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b){

                    view.setBackgroundResource( R.drawable.edittexrroundedcorner_focused);
                }
                else{
                    view.setBackgroundResource( R.drawable.edittexrroundedcorner_gray);
                }
            }
        });

        countryCodePicker.registerCarrierNumberEditText(editTextPhoneNumber);

    }

    @Click
    void buttonLoginUserSend(){

    }
    @Click
    void buttonLoginUsingEmail(){
        ((AuthenticationActivity_)getActivity()).loadChildFragment(SignInEmailFragment_.builder().build());
    }
    @Click
    void textViewSignUp(){
        ((AuthenticationActivity_)getActivity()).loadChildFragment(SignUpEmailFragment_.builder().build());
    }

}
