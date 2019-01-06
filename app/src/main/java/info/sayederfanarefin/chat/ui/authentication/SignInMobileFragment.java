package info.sayederfanarefin.chat.ui.authentication;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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


        if(  !TextUtils.isEmpty(editTextPhoneNumber.getText().toString()) ){

            saveStringInSharedPref("phone_number", countryCodePicker.getFullNumberWithPlus());
            editTextPhoneNumber.setError(null);
            ((AuthenticationActivity_)getActivity()).loadFragment(SignUpReceiveSMSFragment_.builder().build());

        }else{
            showSnachBar("Sign in failed");
            editTextPhoneNumber.setError("Please enter phone number");
        }
    }
    @Click
    void buttonLoginUsingEmail(){
        ((AuthenticationActivity_)getActivity()).loadFragment(SignInEmailFragment_.builder().build());
    }
    @Click
    void textViewSignUp(){
        ((AuthenticationActivity_)getActivity()).loadFragment(SignUpEmailFragment_.builder().build());
    }

}
