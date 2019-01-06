package info.sayederfanarefin.chat.ui.authentication;

import android.support.annotation.NonNull;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

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

@EFragment(R.layout.content_authentication_signup_using_email)
public class SignUpEmailFragment extends CoreFragment {

    @ViewById
    EditText editTextConfirmPassword;

    @ViewById
    EditText editTextPassword;

    @ViewById
    EditText editTextEmail;

    @ViewById
    CheckBox checkBoxAgreement;

    @ViewById
    TextView textViewAgreement;

    public SignUpEmailFragment() {
        //Mandatory default constructor
    }

    @AfterViews
    void afterViews() {

        checkBoxAgreement.setText("");
        textViewAgreement.setText(Html.fromHtml("I agree to the " +
                "<a href='info.sayederfanarefin.chat.ui.authentication.TCActivity://Kode'>TERMS AND CONDITIONS</a>"));
        textViewAgreement.setClickable(true);
        textViewAgreement.setMovementMethod(LinkMovementMethod.getInstance());

        editTextEmail.setBackgroundResource( R.drawable.edittexrroundedcorner_gray);
        editTextPassword.setBackgroundResource( R.drawable.edittexrroundedcorner_gray);
        editTextConfirmPassword.setBackgroundResource( R.drawable.edittexrroundedcorner_gray);

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

        editTextConfirmPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
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
//        checkBoxAgreement.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                if(b){
//                    checkBoxAgreement.setTextColor(getActivity().getColor(R.color.colorPrimary));
//                }else{
//                    checkBoxAgreement.setTextColor(getActivity().getColor(R.color.colorGray));
//                }
//            }
//        });

    }


    @Click
    void buttonSignup(){
        if(checkBoxAgreement.isChecked()){

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

            if (editTextConfirmPassword.getText().toString().equals(editTextPassword.getText().toString())) {
                editTextConfirmPassword.setError("Passwords do not match");
                flag = false;
            }else {
                editTextConfirmPassword.setError(null);
                flag = true;
            }

            if (TextUtils.isEmpty(editTextConfirmPassword.getText().toString())) {
                editTextConfirmPassword.setError("Enter confirm password!");
                flag = false;
            }else {
                editTextConfirmPassword.setError(null);
                flag = true;
            }




            if ( flag ){
                //sign up user

            }else{
                showSnachBar("Sign up failed");
            }
        }else{
            showSnachBar("You have to agree to Terms and Conditions");
        }
        //((AuthenticationActivity_)getActivity()).loadFragment(SignInEmailFragment_.builder().build());
    }


    @Click
    void textViewSignIn(){
        ((AuthenticationActivity_)getActivity()).loadChildFragment(SignInEmailFragment_.builder().build());
    }

}
