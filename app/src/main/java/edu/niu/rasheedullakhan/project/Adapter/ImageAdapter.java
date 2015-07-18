package edu.niu.rasheedullakhan.project.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import edu.niu.rasheedullakhan.project.R;

/**
 * Created by rasheedullakhan on 4/14/15.
 */


    public class ImageAdapter extends BaseAdapter {
        private Context mContext;

        public ImageAdapter(Context c) {
            mContext = c;
        }

        public int getCount() {
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
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(R.layout.gridlayout, parent, false);
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
            ImageView imageView=(ImageView)convertView.findViewById(R.id.imageView2);
            imageView.setImageResource(mThumbIds[position]);
            Picasso.with(mContext).load(mThumbIds[position]).into(imageView);
            TextView tv=(TextView)convertView.findViewById(R.id.textView3);
            tv.setText(mTours[position]);
            return convertView;
        }

        // references to our images
        private Integer[] mThumbIds = {
                R.drawable.tour1thumb, R.drawable.tour2thumb,
                R.drawable.tour3thumb, R.drawable.tour4thumb
        };

        private String[] mTours={

                "Huntley Park Historic District Tour","Fifth Ward North Historic District Tour",
                "Northern Illinois University","Northern Original Town Tour"


        };
    }

