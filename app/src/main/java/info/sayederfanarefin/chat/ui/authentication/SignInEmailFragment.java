package info.sayederfanarefin.chat.ui.authentication;

import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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

        editTextEmail.setOnFocusChangeListener(new View.OnFocusChangeListener() {
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

        editTextPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
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




    }

    @Click
    void buttonLogin(){
        boolean flag = false;

        if (TextUtils.isEmpty(editTextEmail.getText().toString())) {
             editTextEmail.setError("Enter email address!");
            flag = false;
        }else {
            editTextEmail.setError(null);
            flag = true;
        }
        if (TextUtils.isEmpty(editTextPassword.getText().toString())) {
            editTextPassword.setError("Please enter password");
            flag = false;
        }else{
            editTextPassword.setError(null);
            flag = true;
        }
        if ( flag ){
                  //go for login
        }else{
            showSnachBar("Sign in failed");
        }

    }



    @Click
    void buttonLoginUsingPhone(){
        ((AuthenticationActivity_)getActivity()).loadChildFragment(SignInMobileFragment_.builder().build());
    }
    @Click
    void textViewSignUp(){
        ((AuthenticationActivity_)getActivity()).loadFragment(SignUpEmailFragment_.builder().build());
    }

}
