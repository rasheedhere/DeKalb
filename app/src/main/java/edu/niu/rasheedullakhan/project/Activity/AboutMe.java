package edu.niu.rasheedullakhan.project.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

import edu.niu.rasheedullakhan.project.R;

/**
 * Created by rasheedullakhan on 5/1/15.
 */
public class AboutMe extends ActionBarActivity {
    public Button mButton;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.aboutme);
        mButton=(Button) findViewById(R.id.linked);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), WebViewPage.class);
                startActivity(i);
            }
        });


    }
}
