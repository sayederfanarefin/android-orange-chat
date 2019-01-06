package info.sayederfanarefin.chat.ui.authentication;

import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import info.sayederfanarefin.chat.R;
import info.sayederfanarefin.chat.core.CoreFragment;

/**
 * Created by Sayed Erfan Arefin on 10/5/18.
 */

@EFragment(R.layout.content_terms_and_condition)
public class DisclaimerPrivacyAndPolicyFragment extends CoreFragment {

    @ViewById
    TextView textViewTc;

    public DisclaimerPrivacyAndPolicyFragment() {
        //Mandatory default constructor
    }

    @AfterViews
    void afterViews() {

        textViewTc.setText(Html.fromHtml(getString(R.string.privacy_policy)));
        textViewTc.setClickable(true);
        textViewTc.setMovementMethod(LinkMovementMethod.getInstance());

    }


}
