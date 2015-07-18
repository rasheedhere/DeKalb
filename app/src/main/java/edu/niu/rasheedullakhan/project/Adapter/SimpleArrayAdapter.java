package edu.niu.rasheedullakhan.project.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import edu.niu.rasheedullakhan.project.DataStructure.TourOld;
import edu.niu.rasheedullakhan.project.R;

/**
 * Created by rasheedullakhan on 4/7/15.
 */
public class SimpleArrayAdapter extends ArrayAdapter<TourOld> {

    TextView name,description;
    ImageView im;
    public SimpleArrayAdapter(Context context, ArrayList<TourOld> tours) {
        super(context, R.layout.item_tour, tours);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        TourOld t = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        //ViewHolder viewHolder; // view lookup cache stored in tag
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_tour, parent, false);
            name = (TextView) convertView.findViewById(R.id.textView);
            description = (TextView) convertView.findViewById(R.id.textView2);
            im=(ImageView)convertView.findViewById(R.id.imageView);

        }
        // Populate the data into the template view using the data object
        name.setText(t.getTour());
        description.setText(t.getDescription());
        if(position==0)
            Picasso.with(getContext()).load(R.drawable.one).into(im);
        else if(position==1)
            Picasso.with(getContext()).load(R.drawable.two).into(im);
        else if(position==2)
            Picasso.with(getContext()).load(R.drawable.three).into(im);
        else if(position==3)
            Picasso.with(getContext()).load(R.drawable.four).into(im);

        // Return the completed view to render on screen
        return convertView;
    }
}
