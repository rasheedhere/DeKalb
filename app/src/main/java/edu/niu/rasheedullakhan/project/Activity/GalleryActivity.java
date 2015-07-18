package edu.niu.rasheedullakhan.project.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;


import java.util.ArrayList;

import edu.niu.rasheedullakhan.project.Adapter.ImageAdapter;
import edu.niu.rasheedullakhan.project.DataStructure.Tour;
import edu.niu.rasheedullakhan.project.R;

/**
 * Created by rasheedullakhan on 4/8/15.
 */
public class GalleryActivity extends ActionBarActivity {
    ArrayList<Tour> tours;
    public GridView gridview;

    public GalleryActivity(ArrayList<Tour> tours)
    {
        this.tours=new ArrayList<Tour>();
        this.tours=tours;
    }
    public GalleryActivity()
    {
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.grid);
        gridview = (GridView) findViewById(R.id.gridView);

        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                     //Tour tour=tours.get(position);
                     TourGrid t=new TourGrid();

                     Intent i=new Intent(getApplicationContext(),t.getClass());
                     i.putExtra("position",position);
                     startActivity(i);

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
