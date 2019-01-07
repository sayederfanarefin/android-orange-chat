package info.sayederfanarefin.chat.ui.authentication;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.concurrent.TimeUnit;

import info.sayederfanarefin.chat.R;
import info.sayederfanarefin.chat.commons.Constants;
import info.sayederfanarefin.chat.commons.SharedPrefs;
import info.sayederfanarefin.chat.core.CoreFragment;

/**
 * Created by Sayed Erfan Arefin on 10/5/18.
 */

@EFragment(R.layout.content_authentication_signup_using_phone_sms_send)
public class SignUpReceiveSMSFragment extends CoreFragment {

    @ViewById
    EditText editTextSmsPin;
    private FirebaseAuth auth;
    private PhoneAuthProvider.ForceResendingToken mResendToken;
    private String mVerificationId;
    private boolean flagVerifyButtonDisable;
    private String phoneNumber;

    public SignUpReceiveSMSFragment() {
        //Mandatory default constructor
    }

    @AfterViews
    void afterViews() {
        SharedPrefs sharedPrefs = new SharedPrefs(getContext());

        phoneNumber = sharedPrefs.getStringFromSharedPref("phone_number", "");
        auth = FirebaseAuth.getInstance();
        sendPin(phoneNumber);
        editTextSmsPin.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {

                    view.setBackgroundResource(R.drawable.edittexrroundedcorner_focused);
                } else {
                    view.setBackgroundResource(R.drawable.edittexrroundedcorner_gray);
                }
            }
        });
    }

    @Click
    void buttonVerifySms() {

        if (!flagVerifyButtonDisable) {

            if (TextUtils.isEmpty(editTextSmsPin.getText().toString())) {
                editTextSmsPin.setError(null);

                signInWithPhoneAuthCredential(editTextSmsPin.getText().toString());

            } else {
                showSnachBar("Please enter pin");
                editTextSmsPin.setError("Please enter pin");
            }
        }

    }

    @Click
    void textViewHaventReceivedCode() {

    }

    @Click
    void textViewResendCode() {

        showSnachBar("Resending SMS ...");
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phoneNumber,        // Phone number to verify
                60,                 // Timeout duration
                TimeUnit.SECONDS,   // Unit of timeout
                getActivity(),               // Activity (for callback binding)
                new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

                    @Override
                    public void onVerificationCompleted(PhoneAuthCredential credential) {
                        onVerificationCallback(credential);
                    }

                    @Override
                    public void onVerificationFailed(FirebaseException e) {
                        if (e instanceof FirebaseAuthInvalidCredentialsException) {
                            showSnachBar("Sign in failed, please try again");
                        } else if (e instanceof FirebaseTooManyRequestsException) {
                            showSnachBar("Too many requests, please try again");

                        }
                    }

                    @Override
                    public void onCodeSent(String verificationId,
                                           PhoneAuthProvider.ForceResendingToken token) {
                        mVerificationId = verificationId;
                        mResendToken = token;
                    }
                }, mResendToken);
    }

    private void sendPin(String phoneNumber) {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phoneNumber,        // Phone number to verify
                Constants.SMS_TIME_OUT,                 // Timeout duration
                TimeUnit.SECONDS,   // Unit of timeout
                getActivity(),               // Activity (for callback binding)
                new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

                    @Override
                    public void onVerificationCompleted(PhoneAuthCredential credential) {
                        onVerificationCallback(credential);
                    }

                    @Override
                    public void onVerificationFailed(FirebaseException e) {
                        // This callback is invoked in an invalid request for verification is made,
                        // for instance if the the phone number format is not valid.

                        if (e instanceof FirebaseAuthInvalidCredentialsException) {

                            showSnachBar("Sign in failed, please try again");
                            // Invalid request
                            // ...
                        } else if (e instanceof FirebaseTooManyRequestsException) {
                            // The SMS quota for the project has been exceeded
                            // ...

                            showSnachBar("Sign in failed, please try again");
                        } else {
                            showSnachBar("Sign in failed, please try using email");
                        }

                        // Show a message and update the UI
                        // ...
                    }

                    @Override
                    public void onCodeSent(String verificationId,
                                           PhoneAuthProvider.ForceResendingToken token) {
                        // The SMS verification code has been sent to the provided phone number, we
                        // now need to ask the user to enter the code and then construct a credential
                        // by combining the code with a verification ID.
                        //Log.d("tag", "onCodeSent:" + verificationId);

                        // Save verification ID and resending token so we can use them later
                        mVerificationId = verificationId;
                        mResendToken = token;

                        // ...
                    }
                });        // OnVerificationStateChangedCallbacks
    }

    private void onVerificationCallback(PhoneAuthCredential credential) {
        editTextSmsPin.setText(credential.getSmsCode());
        flagVerifyButtonDisable = true;
        showSnachBar("Activating...");


    }


    private void signInWithPhoneAuthCredential(String pin) {

//        PhoneAuthCredential credential = new PhoneAuthProvider.getCredential(mVerificationId, pin);
//
//
//        auth.signInWithCredential(credential)
//                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            // Sign in success, update UI with the signed-in user's information
//                            FirebaseUser u = auth.getCurrentUser();
//
//
//                        } else {
//                            showSnachBar("The verification code entered was invalid, try again");
//
//
//                        }
//                    }
//                });
    }


}
