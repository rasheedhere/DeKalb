package edu.niu.rasheedullakhan.project.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import edu.niu.rasheedullakhan.project.Adapter.ImageAdapterTour;
import edu.niu.rasheedullakhan.project.DataStructure.Tour;
import edu.niu.rasheedullakhan.project.R;

/**
 * Created by rasheedullakhan on 4/14/15.
 */
public class TourGrid extends ActionBarActivity {
    //ArrayList<Tour> tours;
    Tour tour;
    TextView tv;



    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tourgridlayout);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle b=getIntent().getExtras();
        int pos=b.getInt("position");




        if(pos==2) {
            getSupportActionBar().setTitle("Northern Illinois University");

            tv=(TextView) findViewById(R.id.tour1);
            tv.setText("Altgeld Hall");
            GridView gridview = (GridView) findViewById(R.id.tourphotos1);
            gridview.setAdapter(new ImageAdapterTour(this,1));

            gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent i = new Intent(getApplicationContext(), ImageActivity.class);

                    if (position == 0) {
                        i.putExtra("res", "altgeld1");
                        i.putExtra("desc", "Altgeld");
                    }
                    else if (position == 1) {
                        i.putExtra("res", "altgeld2");
                        i.putExtra("desc", "Altgeld");
                    }


                    startActivity(i);

                }
            });

            tv=(TextView) findViewById(R.id.tour2);
            tv.setText("McMurry Hall");
            GridView gridview1 = (GridView) findViewById(R.id.tourphotos2);
            gridview1.setAdapter(new ImageAdapterTour(this,2));

            gridview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent i = new Intent(getApplicationContext(), ImageActivity.class);


                    if(position==0) {
                        i.putExtra("res", "mcmurry1");
                        i.putExtra("desc", "McMurry Hall");
                    }
                    else if(position==1) {
                        i.putExtra("res", "mcmurry2");
                        i.putExtra("desc", "McMurry Hall");
                    }

                    startActivity(i);

                }
            });


            tv=(TextView) findViewById(R.id.tour3);
            tv.setText("Adams Hall");
            GridView gridview2 = (GridView) findViewById(R.id.tourphotos3);
            gridview2.setAdapter(new ImageAdapterTour(this,3));

            gridview2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent i = new Intent(getApplicationContext(), ImageActivity.class);


                    if(position==0) {
                        i.putExtra("res", "adamsone");
                        i.putExtra("desc", "Adams Hall");
                    }
                    else if(position==1) {
                        i.putExtra("res", "adams2");
                        i.putExtra("desc", "Adams Hall");
                    }

                    startActivity(i);

                }
            });


            tv=(TextView) findViewById(R.id.tour4);
            tv.setText("Williston Hall");
            GridView gridview3 = (GridView) findViewById(R.id.tourphotos4);
            gridview3.setAdapter(new ImageAdapterTour(this,4));

            gridview3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent i = new Intent(getApplicationContext(), ImageActivity.class);

                    if(position==0) {
                        i.putExtra("res", "williston1");
                        i.putExtra("desc", "Williston Hall");
                    }
                    else if(position==1) {
                        i.putExtra("res", "williston2");
                        i.putExtra("desc", "Williston Hall");
                    }


                    startActivity(i);

                }
            });


            tv=(TextView) findViewById(R.id.tour5);
            tv.setText("Swen Parson Hall");
            GridView gridview4 = (GridView) findViewById(R.id.tourphotos5);
            gridview4.setAdapter(new ImageAdapterTour(this,5));

            gridview4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent i = new Intent(getApplicationContext(), ImageActivity.class);

                    if(position==0) {
                        i.putExtra("res", "swenparson1");
                        i.putExtra("desc", "Swen Parson");
                    }
                    else if(position==1) {
                        i.putExtra("res", "swenparson2");
                        i.putExtra("desc", "Swen Parson");
                    }

                    startActivity(i);

                }
            });

            tv=(TextView) findViewById(R.id.tour6);
            tv.setText("Davis Hall");
            GridView gridview5 = (GridView) findViewById(R.id.tourphotos6);
            gridview5.setAdapter(new ImageAdapterTour(this,6));

            gridview5.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent i = new Intent(getApplicationContext(), ImageActivity.class);
                    if(position==0) {
                        i.putExtra("res", "davis1");
                        i.putExtra("desc", "Davis Hall");
                    }
                    else if(position==1) {
                        i.putExtra("res", "davis2");
                        i.putExtra("desc", "Davis Hall");
                    }

                    startActivity(i);

                }
            });

        }





    }



}
