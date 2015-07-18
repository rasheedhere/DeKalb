package edu.niu.rasheedullakhan.project.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import edu.niu.rasheedullakhan.project.R;

/**
 * Created by rasheedullakhan on 4/14/15.
 */


public class ImageAdapterTour extends BaseAdapter {
    private Context mContext;
    int index;
    int[] mThumbIds= {R.drawable.altgeld1,
       R.drawable.altgeld2};





    public ImageAdapterTour(Context c, int index) {
        mContext = c;
        this.index=index;
        if(index==2)
        {
            mThumbIds[0]=R.drawable.mcmurry1;
            mThumbIds[1]=R.drawable.mcmurry2;
        }
        else if(index==3)
        {
            mThumbIds[0]=R.drawable.adamsone;
            mThumbIds[1]=R.drawable.adams2;
        }
        else if(index==4)
        {
            mThumbIds[0]=R.drawable.williston1;
            mThumbIds[1]=R.drawable.williston2;
        }
        else if(index==5)
        {
            mThumbIds[0]=R.drawable.swenparson1;
            mThumbIds[1]=R.drawable.swenparson2;
        }
        else if(index==6)
        {
            mThumbIds[0]=R.drawable.davis1;
            mThumbIds[1]=R.drawable.davis2;
        }





    }

    public int getCount()
    {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(200, 200));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        //imageView.setImageResource(mThumbIds[position]);
        Picasso.with(mContext).load(mThumbIds[position]).into(imageView);
        return imageView;
    }


    // references to our images

}

