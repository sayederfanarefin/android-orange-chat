package info.sayederfanarefin.chat.network;

import android.content.Context;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.json.JSONException;
import org.json.JSONObject;

@EBean
public class ResponseHandler {

    @RootContext
    Context context;

//    void onCreateSessionLoaded(Session session) {
//        EventBus.getDefault().post(new LoginEvent(true, session));
//    }

    String parseError(String errorBody) {
        try {
            JSONObject jsonObject = new JSONObject(errorBody);
            if (!jsonObject.isNull("message"))
                return jsonObject.getString("message");
            return "Error occurred during request";
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "Error occurred during request";
    }

}