package edu.niu.rasheedullakhan.project.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import edu.niu.rasheedullakhan.project.DataStructure.Image;
import edu.niu.rasheedullakhan.project.DataStructure.Place;
import edu.niu.rasheedullakhan.project.DataStructure.Tour;
import edu.niu.rasheedullakhan.project.Activity.PlaceActivity;
import edu.niu.rasheedullakhan.project.Adapter.PlaceAdapter;
import edu.niu.rasheedullakhan.project.R;

/**
 * Created by rasheedullakhan on 4/14/15.
 */
public class PlacesFragment extends Fragment {

    static int tour;
    static ArrayList<Tour> tours;

    public static final PlacesFragment newInstance(int mtour,ArrayList<Tour> mtours) {
        PlacesFragment adf =  new PlacesFragment();
        tour=mtour;
        tours=mtours;
        return adf;
    }

    public PlacesFragment()
    {


    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.placeslayout, container, false);

            ListView li = (ListView) rootView.findViewById(R.id.listView);
            li.setAdapter(new PlaceAdapter(getActivity(), tour, tours));
            li.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent i = new Intent(getActivity(), PlaceActivity.class);
                    Place p=tours.get(tour).getPlace().get(position);
                    i.putExtra("house",p.getHouse());
                    i.putExtra("name",p.getName());
                    i.putExtra("thumb",p.getThumb());
                    i.putExtra("about",p.getAbout());
                    i.putExtra("built",p.getBuilt());
                    i.putExtra("lat",p.getLat());
                    i.putExtra("longi",p.getLongi());
                    ArrayList<Image> images=p.getImageArrayList();
                    Image im=images.get(0);
                    i.putExtra("res",im.getImage());
                    i.putExtra("desc",im.getDescription());



                    startActivity(i);

                }
            });



                return rootView;
    }
}
