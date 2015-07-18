package edu.niu.rasheedullakhan.project.Fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import edu.niu.rasheedullakhan.project.DataStructure.Tour;
import edu.niu.rasheedullakhan.project.R;

/**
 * Created by rasheedullakhan on 4/7/15.
 */
public class AboutFragment extends Fragment {

   static int tour,tab;
    static ArrayList<Tour> tours;

    public static final AboutFragment newInstance(int mtour, int mtab, ArrayList<Tour> mtours) {
        AboutFragment adf =  new AboutFragment();
        tour=mtour;
        tab=mtab;
        tours=mtours;

        return adf;
    }

    public AboutFragment()
    {

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.firsttour, container, false);

        TextView about,facts,streets;
        about = (TextView)rootView.findViewById(R.id.about);
        facts=(TextView)rootView.findViewById(R.id.facts);
        streets=(TextView)rootView.findViewById(R.id.streets);
        about.setText("About");
        facts.setText("Facts");
        streets.setText("Streets");

        about = (TextView)rootView.findViewById(R.id.abouttext);
        facts=(TextView)rootView.findViewById(R.id.factstext);
        streets=(TextView)rootView.findViewById(R.id.streetstext);
        /*Button b=(Button)rootView.findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(),Place.class);
                startActivity(i);
            }
        });*/
        //tv.setText("Tour"+tour+" and it is all about tab "+tab+" arraylist:"+tours.size());
        Tour t=tours.get(tour);
        about.setText(t.getAbout());
        streets.setText(t.getStreets());
        facts.setText(t.getKeyfacts().get(0));

        //facts.setText(keyfacts.size());

        return rootView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
