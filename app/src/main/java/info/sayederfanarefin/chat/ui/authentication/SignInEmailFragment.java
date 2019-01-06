package info.sayederfanarefin.chat.ui.authentication;

import android.widget.EditText;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import info.sayederfanarefin.chat.R;
import info.sayederfanarefin.chat.core.CoreFragment;

/**
 * Created by Sayed Erfan Arefin on 10/5/18.
 */

@EFragment(R.layout.content_authentication_login_using_email)
public class SignInEmailFragment extends CoreFragment {

    @ViewById
    EditText editTextEmail;
    @ViewById
    EditText editTextPassword;


    public SignInEmailFragment() {
        //Mandatory default constructor
    }

    @AfterViews
    void afterViews() {

    }

    @Click
    void buttonLogin(){

    }
    @Click
    void buttonLoginUsingPhone(){
        ((AuthenticationActivity_)getActivity()).loadChildFragment(SignInMobileFragment_.builder().build());
    }
    @Click
    void textViewSignUp(){
        ((AuthenticationActivity_)getActivity()).loadChildFragment(SignUpEmailFragment_.builder().build());
    }

}
