package info.sayederfanarefin.chat.ui.authentication;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import info.sayederfanarefin.chat.R;
import info.sayederfanarefin.chat.core.CoreFirebaseFragment;
import info.sayederfanarefin.chat.core.CoreFragment;

/**
 * Created by Sayed Erfan Arefin on 10/5/18.
 */

@EFragment(R.layout.content_authentication_login_using_phone)
public class AddMobileNumberToAccountFragment extends CoreFirebaseFragment {

    public AddMobileNumberToAccountFragment() {
        //Mandatory default constructor
    }

    @AfterViews
    void afterViews() {

    }

}
