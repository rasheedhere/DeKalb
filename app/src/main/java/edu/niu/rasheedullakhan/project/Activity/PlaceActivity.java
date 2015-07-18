package edu.niu.rasheedullakhan.project.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import edu.niu.rasheedullakhan.project.R;

/**
 * Created by rasheedullakhan on 4/23/15.
 */
public class PlaceActivity extends ActionBarActivity {
    String place, name, about, thumb, built, image, desc;
    TextView placetv, nametv, abouttv, builttv;
    ImageView thumbiv;
    Double lat, longi;
    Button button, navigate;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.placelayout);
        Bundle b = getIntent().getExtras();
        place = b.getString("house");
        name = b.getString("name");
        about = b.getString("about");
        thumb = b.getString("thumb");
        built = b.getString("built");
        image = b.getString("res");
        desc = b.getString("desc");
        lat = b.getDouble("lat");
        longi = b.getDouble("longi");
        getSupportActionBar().setIcon(R.drawable.ic_launcher);
        getSupportActionBar().setTitle(place);
        placetv = (TextView) findViewById(R.id.place);
        nametv = (TextView) findViewById(R.id.address);
        abouttv = (TextView) findViewById(R.id.about);
        builttv = (TextView) findViewById(R.id.built);
        thumbiv = (ImageView) findViewById(R.id.thumb);
        navigate = (Button) findViewById(R.id.navigate);
        button = (Button) findViewById(R.id.button);
        placetv.setText(place);
        nametv.setText(name);
        abouttv.setText(about);
        builttv.setText(built);

        int resID = getResources().getIdentifier(thumb, "drawable", getPackageName());
        thumbiv.setImageResource(resID);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), StreetView.class);
                i.putExtra("lat", lat);
                i.putExtra("longi", longi);
                startActivity(i);

            }
        });

        navigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("google.navigation:q=" + name + ",+DeKalb+IL");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
}

