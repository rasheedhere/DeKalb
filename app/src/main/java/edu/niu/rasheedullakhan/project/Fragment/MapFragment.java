package edu.niu.rasheedullakhan.project.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import java.util.ArrayList;

import edu.niu.rasheedullakhan.project.DataStructure.Tour;
import edu.niu.rasheedullakhan.project.R;

/**
 * Created by rasheedullakhan on 4/15/15.
 */
public class MapFragment extends Fragment {
    static int tour;
    private  GoogleMap map;
    MapView mMapView;
    static ArrayList<Tour> tours;
    MarkerOptions marker;
    static ArrayList<LatLng> latLngs;
    public static final MapFragment newInstance(int mtour,ArrayList<Tour> mtours) {
        MapFragment adf =  new MapFragment();
        tours=mtours;
        tour=mtour;
        latLngs=new ArrayList<LatLng>();
        return adf;
    }

    public MapFragment()
    {

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setRetainInstance(true);
        View rootView = inflater.inflate(R.layout.mapfragment, container, false);


        mMapView = (MapView) rootView.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);

        mMapView.onResume();// needed to get the map to display immediately

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        map = mMapView.getMap();
        map.animateCamera(CameraUpdateFactory.zoomTo(16));
        // latitude and longitude

        for(int i=0;i<tours.get(tour).getPlace().size();i++) {
            // create marker
            marker = new MarkerOptions().position(
                    new LatLng(tours.get(tour).getPlace().get(i).getLat(), tours.get(tour).getPlace().get(i).getLongi())).title(tours.get(tour).getPlace().get(i).getHouse());
            marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.redflag)).anchor(0.0f,1.0f);

            map.addMarker(marker.snippet(tours.get(tour).getPlace().get(i).getName()));
            latLngs.add(new LatLng(tours.get(tour).getPlace().get(i).getLat(), tours.get(tour).getPlace().get(i).getLongi()));

            }
        if(tour==3) {

            CameraPosition cameraPosition = new CameraPosition.Builder()
                    .target(new LatLng(tours.get(tour).getPlace().get(3).getLat(), tours.get(tour).getPlace().get(3).getLongi())).zoom(16).build();
            map.animateCamera(CameraUpdateFactory
                    .newCameraPosition(cameraPosition));


        }
        else
        {
            CameraPosition cameraPosition = new CameraPosition.Builder()
                    .target(new LatLng(tours.get(tour).getPlace().get(0).getLat(), tours.get(tour).getPlace().get(0).getLongi())).zoom(16).build();
            map.animateCamera(CameraUpdateFactory
                    .newCameraPosition(cameraPosition));


        }
        //map.addPolyline(new PolylineOptions().geodesic(true).addAll(latLngs).width(5).color(Color.GREEN));
        return rootView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setRetainInstance(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onDestroyView() {

        super.onDestroyView();
    }
}

