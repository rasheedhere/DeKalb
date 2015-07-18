package edu.niu.rasheedullakhan.project.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import edu.niu.rasheedullakhan.project.DataStructure.Tour;
import edu.niu.rasheedullakhan.project.R;

/**
 * Created by rasheedullakhan on 4/14/15.
 */


public class PlaceAdapter extends BaseAdapter {
    private Context mContext;
    ArrayList<Tour> tours;
    int tour;

    public PlaceAdapter(Context c,int tour,ArrayList<Tour> tours) {
        this.tours=new ArrayList<Tour>();
        this.tours=tours;
        this.tour=tour;
        mContext = c;
    }

    public int getCount() {
        return tours.get(tour).getPlace().size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(R.layout.placelist, parent, false);
           /* if (convertView == null) {
                // if it's not recycled, initialize some attributes
                imageView = new ImageView(mContext);
                imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                //imageView.setPadding(8, 8, 8, 8);
                //imageView.set
            } else {
                imageView = (ImageView) convertView;
            }*/
        ImageView imageView=(ImageView)convertView.findViewById(R.id.imageView4);
        String mDrawableName =tours.get(tour).getPlace().get(position).getThumb();
        int resID = this.mContext.getResources().getIdentifier(mDrawableName , "drawable", mContext.getPackageName());
        imageView.setImageResource(resID);
        //Picasso.with(mContext).load(resID).into(imageView);
        TextView tv=(TextView)convertView.findViewById(R.id.textView5);
        tv.setText(tours.get(tour).getPlace().get(position).getHouse());
        TextView tv1=(TextView)convertView.findViewById(R.id.textView6);
        tv1.setText(tours.get(tour).getPlace().get(position).getBuilt());

        return convertView;
    }

    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.photo, R.drawable.photo,
            R.drawable.photo, R.drawable.photo,
            R.drawable.photo, R.drawable.photo,
            R.drawable.photo, R.drawable.photo
    };
}

