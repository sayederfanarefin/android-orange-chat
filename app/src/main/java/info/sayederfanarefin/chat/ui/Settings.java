package info.sayederfanarefin.chat.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.CompoundButton;

import com.francoisdexemple.materialpreference.MaterialPreferenceActivity;
import com.francoisdexemple.materialpreference.items.MaterialPreferenceOnCheckedChangedListener;
import com.francoisdexemple.materialpreference.items.MaterialPreferenceSwitchItem;
import com.francoisdexemple.materialpreference.model.MaterialPreferenceCard;
import com.francoisdexemple.materialpreference.model.MaterialPreferenceList;

import info.sayederfanarefin.chat.R;

public class Settings extends MaterialPreferenceActivity {

    @Override
    @NonNull
    protected MaterialPreferenceList getMaterialPreferenceList(@NonNull Context context) {

        MaterialPreferenceCard card = new MaterialPreferenceCard.Builder()
                .title("Orange Chat")
                .build();

        return new MaterialPreferenceList.Builder()
                .addCard(card)
                .build(); // This creates an empty screen, add cards with .addCard()
    }

    @Override
    protected CharSequence getActivityTitle() {
        return getString(R.string.mp_title_preference);
    }

}