package info.sayederfanarefin.chat.adapters;

/**
 * Created by erfanarefin on 22/07/2017.
 */

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import info.sayederfanarefin.chat.R;


/**
 * Created by ramees on 8/16/2016.
 */
public class DrawerListAdapter extends BaseAdapter {
    Activity activity;
    int [] imageId;
    private static LayoutInflater inflater=null;
    ArrayList<String> titles;
    public DrawerListAdapter(Activity activity, ArrayList<String> titles, int[] icons) {

        this.titles = titles;
        this.activity = activity;
        imageId = icons;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {

        return titles.size();
    }

    @Override
    public Object getItem(int position) {

        return position;
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    public class Holder
    {
        TextView tv_title;
        ImageView im_icon;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        Holder holder=new Holder();
        View view;
        view = inflater.inflate(R.layout.layout_drawer_item, null);

        holder.tv_title = (TextView) view.findViewById(R.id.tv_title);
        holder.im_icon = (ImageView) view.findViewById(R.id.im_icon);

        holder.tv_title.setText(titles.get(position));

        Picasso.with(activity.getApplicationContext()).load(imageId[position]).into(holder.im_icon);

        return view;
    }

}