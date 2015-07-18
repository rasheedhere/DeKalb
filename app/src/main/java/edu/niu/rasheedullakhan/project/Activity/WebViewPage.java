package edu.niu.rasheedullakhan.project.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

import edu.niu.rasheedullakhan.project.R;

/**
 * Created by rasheedullakhan on 5/1/15.
 */
public class WebViewPage extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.webview);
        WebView web=(WebView)findViewById(R.id.webView);
        web.loadUrl("https://www.linkedin.com/pub/rasheedulla-khan/4a/4bb/b1a");



    }
}
