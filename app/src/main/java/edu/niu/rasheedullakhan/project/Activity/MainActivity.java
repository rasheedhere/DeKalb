package edu.niu.rasheedullakhan.project.Activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;

import com.facebook.FacebookSdk;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.util.ArrayList;

import edu.niu.rasheedullakhan.project.DataStructure.Image;
import edu.niu.rasheedullakhan.project.DataStructure.Place;
import edu.niu.rasheedullakhan.project.DataStructure.Tour;
import edu.niu.rasheedullakhan.project.Fragment.AboutFragment;
import edu.niu.rasheedullakhan.project.Fragment.MapFragment;
import edu.niu.rasheedullakhan.project.Fragment.NavigationDrawerFragment;
import edu.niu.rasheedullakhan.project.Fragment.PlacesFragment;
import edu.niu.rasheedullakhan.project.R;


public class MainActivity extends ActionBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {
    int mCurrentSelectedPosition,mCurrentTourSelectedPosition=-1;
    boolean mFlag=true;
    String mName,mStreets,mAbout,mBuilt,mThumb,mHouse,mPlaceName,mPlaceAbout,mPlaceThumb,mPlaceBuilt,mImage,mDesc;
    double lat,longi;
    int mtour=0;
    ArrayList<String> keyfacttemp;
    ArrayList<Place> placestemp;
    Place placetemp;
    ArrayList<Tour> tours;
    Tour tourtemp;
    Image imagetemp;
    ArrayList<Image> imagestemp;
    


    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */

    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_main);
        try {
            parsexml();
        }
        catch(XmlPullParserException e)
        {
            Log.d("XML Parsing", e.toString());
        }
        catch(Exception e)
        {
            Log.d("XML Parsing",e.toString());
        }
        //Toast.makeText(getApplicationContext(),tours.size(),Toast.LENGTH_SHORT).show();
        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);


        if(count==0)
        {
            ActionBar.Tab a=actionBar.newTab().setText(" About");
            ActionBar.Tab d=actionBar.newTab().setText(" Places");
            ActionBar.Tab b=actionBar.newTab().setText(" Map");
            FragmentManager fragmentManager=getSupportFragmentManager();


            a.setIcon(R.drawable.info);
            b.setIcon(R.drawable.mapmarker);
            d.setIcon(R.drawable.places);
            a.setTabListener(new MyTabsListener(fragmentManager.findFragmentByTag("first")));
            b.setTabListener(new MyTabsListener(fragmentManager.findFragmentByTag("first")));

            d.setTabListener(new MyTabsListener(fragmentManager.findFragmentByTag("first")));


            actionBar.addTab(a);
            actionBar.addTab(d);
            actionBar.addTab(b);



        }
        count++;



        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));

    }

    @Override
    public void onNavigationDrawerItemSelected(int position, boolean fromSavedInstanceState) {
        // update the main content by replacing fragments


        if (!fromSavedInstanceState) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.container, (FirstFragment.newInstance(position + 1, tours)), "first").commit();

        }

    }

    public void onSectionAttached(int number) {

        switch (number) {
            case 1:
                mTitle = "Huntley Park Historic District";
                mtour=0;
                break;
            case 2:
                mTitle = "Fifth Ward North Historic District";
                mtour=1;
                break;
            case 3:
                mTitle = "Northern Illinois University";
                mtour=2;
                break;
            case 4:
                mTitle = "Northern Original Town";
                mtour=3;
                break;

        }
    }

    public void restoreActionBar() {

        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }

    class MyTabsListener implements ActionBar.TabListener {
        public Fragment fragment;
        public MyTabsListener(Fragment fragment) {
            this.fragment = fragment;


        }

        @Override
        public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
            //Toast.makeText(getApplicationContext(), "Reselected!", Toast.LENGTH_LONG).show();
            //Toast.makeText(getApplicationContext(),""+tab.getPosition(), Toast.LENGTH_LONG).show();

        }

        @Override
        public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {

            int position=tab.getPosition();

            if(mCurrentSelectedPosition==position)
                mFlag=false;
            else
                mFlag=true;
            mCurrentSelectedPosition = position;

            mNavigationDrawerFragment.close();



                if (mtour == 0) {
                    if (tab.getPosition() == 0)
                        ft.replace(R.id.container, (AboutFragment.newInstance(mtour, 0, tours)));
                    if (tab.getPosition() == 1)
                        ft.replace(R.id.container, (PlacesFragment.newInstance(mtour, tours)));
                    if (tab.getPosition() == 2)
                        ft.replace(R.id.container, (MapFragment.newInstance(mtour, tours)));


                } else if (mtour == 1) {
                    //Toast.makeText(getApplicationContext(),""+tab.getPosition(), Toast.LENGTH_LONG).show();
                    if (tab.getPosition() == 0)
                        ft.replace(R.id.container, (AboutFragment.newInstance(mtour, 0, tours)));
                    if (tab.getPosition() == 1)
                        ft.replace(R.id.container, (PlacesFragment.newInstance(mtour, tours)));
                    if (tab.getPosition() == 2)
                        ft.replace(R.id.container, (MapFragment.newInstance(mtour, tours)));


                } else if (mtour == 2) {
                    //Toast.makeText(getApplicationContext(),""+tab.getPosition(), Toast.LENGTH_LONG).show();
                    if (tab.getPosition() == 0)
                        ft.replace(R.id.container, (AboutFragment.newInstance(mtour, 0, tours)));
                    if (tab.getPosition() == 1)
                        ft.replace(R.id.container, (PlacesFragment.newInstance(mtour, tours)));
                    if (tab.getPosition() == 2)
                        ft.replace(R.id.container, (MapFragment.newInstance(mtour, tours)));


                } else if (mtour == 3) {
                    //Toast.makeText(getApplicationContext(),""+tab.getPosition(), Toast.LENGTH_LONG).show();
                    if (tab.getPosition() == 0)
                        ft.replace(R.id.container, (AboutFragment.newInstance(mtour, 0, tours)));
                    if (tab.getPosition() == 1)
                        ft.replace(R.id.container, (PlacesFragment.newInstance(mtour, tours)));
                    if (tab.getPosition() == 2)
                        ft.replace(R.id.container, (MapFragment.newInstance(mtour, tours)));


                }



            }



        @Override
        public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

           // ft.remove(fragment);





        }

    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {


        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
           getMenuInflater().inflate(R.menu.main, menu);
           restoreActionBar();
           return true;
        }
        return super.onCreateOptionsMenu(menu);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();




        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id== R.id.action_example) {
            //Toast.makeText(getActivity(), "Example action.", Toast.LENGTH_SHORT).show();
            GalleryActivity temp=new GalleryActivity(tours);
            Intent i=new Intent(getApplicationContext(),temp.getClass());



            startActivity(i);

            return true;
        }

        if(id== R.id.about_me){

            AboutMe temp=new AboutMe();
            Intent i=new Intent(getApplicationContext(),temp.getClass());
            startActivity(i);
            return true;

        }

        if(id==R.id.nearby) {
            // Create a Uri from an intent string. Use the result to create an Intent.
            Uri gmmIntentUri = Uri.parse("geo:41.9294444,-88.7502778?q=restaurants");

            // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            // Make the Intent explicit by setting the Google Maps package
            mapIntent.setPackage("com.google.android.apps.maps");

            // Attempt to start an activity that can handle the Intent
            startActivity(mapIntent);
            return true;

        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class FirstFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static FirstFragment newInstance(int sectionNumber,ArrayList<Tour> tours) {
            FirstFragment fragment = new FirstFragment();
            Bundle args = new Bundle();

            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            fragment.setRetainInstance(true);
            return fragment;
        }

        public FirstFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.firsttour, container, false);
            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((MainActivity) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));

        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void parsexml() throws XmlPullParserException,IOException {
        tours = new ArrayList<Tour>();
        try {
            // creating instance of XmlPullParserFactory
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);

            XmlPullParser xpp = factory.newPullParser();
            xpp = getResources().getXml(R.xml.data);

            int eventType = xpp.getEventType();// while end of the xml document
            while (eventType != XmlPullParser.END_DOCUMENT) {
                if (eventType == XmlPullParser.START_TAG) {
                    if (xpp.getName().equals("name")) //get title
                    {

                        xpp.next();
                        mName = xpp.getText();
                        Log.d("name", mName);
                    }
                    else if (xpp.getName().equals("streets")) // get artist
                    {
                        xpp.next();
                        mStreets = xpp.getText();
                        Log.d("streets", mStreets);
                    }
                    else if (xpp.getName().equals("about")) // get country
                    {
                        xpp.next();
                        mAbout = xpp.getText();
                        Log.d("about", mAbout);

                    } else if (xpp.getName().equals("built")) //get company
                    {
                        xpp.next();
                        mBuilt = xpp.getText();
                        Log.d("built", mBuilt);
                    } else if (xpp.getName().equals("thumb")) //get price
                    {
                        xpp.next();
                        mThumb = xpp.getText();
                        Log.d("mThumb", mThumb);
                        tourtemp = new Tour(mName, mStreets, mAbout, mBuilt, mThumb);
                        Log.d("Tour Created", tourtemp.getAbout());


                    } else if (xpp.getName().equals("keyfacts")) {
                        keyfacttemp = new ArrayList<String>();



                        Log.d("keyfacts", "skipped");

                    } else if (xpp.getName().equals("keyfact")) {

                        // add keyfacts
                        xpp.next();
                        mThumb = xpp.getText();
                        keyfacttemp.add(mThumb);
                        Log.d("keyfact", mThumb);

                    }
                    else if (xpp.getName().equals("places")) //get price
                    {
                        Log.d("No.of keyfacts", "" + keyfacttemp.size());
                        //tourtemp.setKeyfacts(keyfacttemp);
                        //Log.d("1st keyfact",""+tourtemp.getKeyfacts().get(0));
                        placestemp = new ArrayList<Place>();
                    }
                    else if (xpp.getName().equals("placename")) //get title
                    {
                        xpp.next();
                        mPlaceName = xpp.getText();
                        Log.d("mPlaceName", mName);

                    } else if (xpp.getName().equals("house")) // get artist
                    {
                        xpp.next();
                        mHouse = xpp.getText();
                        Log.d("mHouse", mHouse);
                    } else if (xpp.getName().equals("placeabout")) // get country
                    {
                        xpp.next();
                        mPlaceAbout = xpp.getText();
                        Log.d("mPlaceAbout", mPlaceAbout);

                    } else if (xpp.getName().equals("lat")) //get company
                    {
                        xpp.next();
                        lat = Double.parseDouble(xpp.getText());
                        Log.d("lat", "" + lat);
                    } else if (xpp.getName().equals("long")) //get price
                    {
                        xpp.next();
                        longi = Double.parseDouble(xpp.getText());
                        Log.d("longi", "" + longi);
                    } else if (xpp.getName().equals("placethumb")) //get price
                    {
                        xpp.next();
                        mPlaceThumb = xpp.getText();
                        Log.d("mPlaceThumb", mPlaceThumb);
                    } else if (xpp.getName().equals("placebuilt")) //get price
                    {
                        xpp.next();
                        mPlaceBuilt = xpp.getText();
                        Log.d("mPlaceBuilt", mBuilt);

                    } else if (xpp.getName().equals("images")) //get price
                    {
                        imagestemp = new ArrayList<Image>();

                        Log.d("images", "skipped");
                    } else if (xpp.getName().equals("image")) //get price
                    {
                        xpp.next();
                        mImage = xpp.getText();
                        Log.d("mImage", mImage);
                    } else if (xpp.getName().equals("desc")) //get price
                    {
                        xpp.next();
                        mDesc = xpp.getText();
                        Log.d("mDesc", mDesc);
                        imagetemp = new Image(mImage, mDesc);
                        imagestemp.add(imagetemp);
                    } else if (xpp.getName().equals("imagesdone")) //get price
                    {
                        xpp.next();

                        Log.d("imagesdone", "skipped");
                        placetemp = new Place(mPlaceName, mHouse, mPlaceAbout, lat, longi, mPlaceThumb, mPlaceBuilt, imagestemp);
                        placestemp.add(placetemp);

                    } else if (xpp.getName().equals("done")) //get price
                    {
                        xpp.next();
                        tourtemp.setKeyfacts(keyfacttemp);
                        tourtemp.setPlace(placestemp);
                        tours.add(tourtemp);
                        Log.d("No.of places", "" + tours.get(0).getPlace().size());
                        Log.d("No.of keyfacts", "" + tours.get(0).getKeyfacts().size());
                    }


                }
                eventType = xpp.next();

            }


        } catch (XmlPullParserException e) {
            Log.d("XML Parsing", "Error in Parsing!");
        }
    }






}

