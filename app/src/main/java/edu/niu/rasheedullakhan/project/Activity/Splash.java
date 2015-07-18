package edu.niu.rasheedullakhan.project.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import edu.niu.rasheedullakhan.project.R;


/**
 * Created by rasheedullakhan on 4/15/15.
 */
public class Splash extends Activity {

ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);

        mImageView=(ImageView)findViewById(R.id.splash);
        Picasso.with(this).load(R.drawable.splash).into(mImageView);
        /****** Create Thread that will sleep for 1.5 second *************/
        Thread background = new Thread() {
            public void run() {

                try {
                    // Thread will sleep for 1 second
                    sleep(1500);

                    // After 1 second redirect to another intent
                    Intent i = new Intent(getBaseContext(), MainActivity.class);
                    startActivity(i);

                    //Remove activity
                    finish();

                } catch (Exception e) {

                }
            }
        };

        // start thread
        background.start();
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();

    }
}
