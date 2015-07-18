package edu.niu.rasheedullakhan.project.Activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.google.android.gms.maps.OnStreetViewPanoramaReadyCallback;
import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.StreetViewPanoramaFragment;
import com.google.android.gms.maps.model.LatLng;

import edu.niu.rasheedullakhan.project.R;


/**
 * Created by rasheedullakhan on 4/27/15.
 */
public class StreetView extends FragmentActivity implements OnStreetViewPanoramaReadyCallback {
    Double lat,longi;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.streetview);


        StreetViewPanoramaFragment streetViewPanoramaFragment =
                (StreetViewPanoramaFragment) getFragmentManager()
                        .findFragmentById(R.id.streetviewpanorama);
        streetViewPanoramaFragment.getStreetViewPanoramaAsync(this);
        Bundle b=getIntent().getExtras();
        lat=b.getDouble("lat");
        longi=b.getDouble("longi");
        //Toast.makeText(getApplicationContext(),"lat"+lat+"longi"+longi,Toast.LENGTH_SHORT).show();


    }
    @Override
    public void onStreetViewPanoramaReady(StreetViewPanorama streetViewPanorama) {

        streetViewPanorama.setPosition(new LatLng(lat,longi));


    }
}
