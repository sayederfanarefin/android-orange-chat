package info.sayederfanarefin.chat.ui.authentication;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import info.sayederfanarefin.chat.R;
import info.sayederfanarefin.chat.core.CoreFragment;

/**
 * Created by Sayed Erfan Arefin on 10/5/18.
 */

@EFragment(R.layout.content_authentication_first_screen)
public class AuthenticationFirstFragment extends CoreFragment {


    public AuthenticationFirstFragment() {
        //Mandatory default constructor
    }

    @AfterViews
    void afterViews() {

    }


    @Click
    void buttonSignIn(){
        ((AuthenticationActivity_)getActivity()).loadChildFragment(SignInEmailFragment_.builder().build());
    }
    @Click
    void buttonSignUp(){
        ((AuthenticationActivity_)getActivity()).loadChildFragment(SignUpEmailFragment_.builder().build());
    }

    @Click
    void fbSignIn(){

    }

    @Click
    void twitterSignIn(){

    }

    @Click
    void googleSignIn(){

    }

    @Click
    void githubSignIn(){

    }

}
