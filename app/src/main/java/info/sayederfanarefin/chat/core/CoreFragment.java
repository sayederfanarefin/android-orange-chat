package info.sayederfanarefin.chat.core;

import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.View;

import info.sayederfanarefin.chat.log.Tracer;

import org.androidannotations.annotations.EFragment;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

@EFragment
public abstract class CoreFragment extends Fragment {

    public CoreFragment() {
        // Required empty public constructor
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        Tracer.d(this.getClass().getSimpleName() + " onStop()");
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void onGenericEvent(Object event) {
        // DO NOT WRITE CODE
    }

    public void showSnachBar(String message){
        final Snackbar sb =  Snackbar.make(getActivity().findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG).setActionTextColor(Color.WHITE).setDuration(5000);
        sb.setAction("Dismiss", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sb.dismiss();
            }
        });
        sb.show();
    }
}
