package info.sayederfanarefin.chat.ui.authentication;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import info.sayederfanarefin.chat.R;
import info.sayederfanarefin.chat.commons.Commons;
import info.sayederfanarefin.chat.core.CoreFragment;

/**
 * Created by Sayed Erfan Arefin on 10/5/18.
 */

@EFragment(R.layout.content_authentication_forgot_password)
public class ForgotPasswordFragment extends CoreFragment {

    @ViewById
    EditText editTextForgotPasswordEmail;

    private boolean disableButton = false;
    public ForgotPasswordFragment() {
        //Mandatory default constructor
    }

    @AfterViews
    void afterViews() {

        editTextForgotPasswordEmail.setBackgroundResource(R.drawable.edittexrroundedcorner_gray);
        editTextForgotPasswordEmail.setOnFocusChangeListener(new View.OnFocusChangeListener() {
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
    void buttonSend() {


        boolean flag = false;


        if (TextUtils.isEmpty(editTextForgotPasswordEmail.getText().toString())) {
            editTextForgotPasswordEmail.setError("Enter email address!");
            flag = false;
        } else {

            if (!Commons.validateEmail(editTextForgotPasswordEmail.getText().toString())) {
                editTextForgotPasswordEmail.setError("Enter valid email address!");
                flag = false;
            } else {
                editTextForgotPasswordEmail.setError(null);
                flag = true;
            }
        }

        if (flag){

            if(disableButton){
                showSnachBar("Please wait...");
            }else{
                disableButton = true;
                FirebaseAuth.getInstance().sendPasswordResetEmail("user@example.com")
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    showSnachBar("We have send you an email. Please check...");
                                }else{
                                    showSnachBar("Something went wrong, please try again later.");
                                }
                                disableButton = false;
                            }
                        });
            }

        }else{
            showSnachBar("Check input fields");
        }

    }
}
