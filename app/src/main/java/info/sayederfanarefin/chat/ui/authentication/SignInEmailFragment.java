package info.sayederfanarefin.chat.ui.authentication;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import info.sayederfanarefin.chat.R;
import info.sayederfanarefin.chat.core.CoreFragment;
import info.sayederfanarefin.chat.ui.FirstActivity_;

/**
 * Created by Sayed Erfan Arefin on 10/5/18.
 */

@EFragment(R.layout.content_authentication_login_using_email)
public class SignInEmailFragment extends CoreFragment {

    @ViewById
    EditText editTextEmail;
    @ViewById
    EditText editTextPassword;

    private FirebaseAuth auth;

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

        auth = FirebaseAuth.getInstance();


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
            //authenticate user
            auth.signInWithEmailAndPassword(editTextEmail.getText().toString(), editTextPassword.getText().toString())
                    .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            // If sign in fails, display a message to the user. If sign in succeeds
                            // the auth state listener will be notified and logic to handle the
                            // signed in user can be handled in the listener.
//                                progressBar.setVisibility(View.GONE);
                            if (!task.isSuccessful()) {
                                // there was an error

                                showSnachBar("Sign in failed");

                            } else {
                                FirstActivity_.intent(getActivity()).start();

                            }
                        }
                    });
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
