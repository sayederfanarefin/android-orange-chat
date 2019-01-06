package info.sayederfanarefin.chat.ui.authentication;

import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import info.sayederfanarefin.chat.R;
import info.sayederfanarefin.chat.core.CoreFragment;

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
        textViewAgreement.setText(Html.fromHtml("I have read and agree to the " +
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


    }


    @Click
    void buttonSignup(){
        if(checkBoxAgreement.isChecked()){

        }
        //((AuthenticationActivity_)getActivity()).loadFragment(SignInEmailFragment_.builder().build());
    }

}
