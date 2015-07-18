package edu.niu.rasheedullakhan.project.Activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookDialog;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.share.Sharer;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareButton;
import com.facebook.share.widget.ShareDialog;
import com.squareup.picasso.Picasso;

import edu.niu.rasheedullakhan.project.R;

/**
 * Created by rasheedullakhan on 4/14/15.
 */
public class ImageActivity extends ActionBarActivity {

    String desc,res;

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.image);
        Bundle b=getIntent().getExtras();
        TextView tv = (TextView) findViewById(R.id.imagedesc);
        ImageView imageView=(ImageView)findViewById(R.id.image);
            res=b.getString("res");

                desc = b.getString("desc");

            int resId=getResources().getIdentifier(res,"drawable", getPackageName());
            //imageView.setImageResource(resId);
        Picasso.with(getApplicationContext()).load(resId).into(imageView);
            tv.setText(desc);
        getSupportActionBar().setTitle(desc);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);




    }
}















