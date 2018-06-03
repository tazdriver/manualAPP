package com.example.gera46.assemblyassistant;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.webkit.WebView;
import android.support.v7.app.AppCompatActivity;


public class DescriptionActivity extends AppCompatActivity {

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences prefs = getSharedPreferences("X", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("lastActivity", getClass().getName());
        editor.commit();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        Intent intent = getIntent();
        int curr_id = intent.getIntExtra("title", 0);
        String resName = "s" + curr_id + ".html";
        //int next_id = curr_id + 1;
        //final String resNext = "s" + next_id + ".html";

        final WebView myWebView = findViewById(R.id.webView1);
        //myWebView.setWebViewClient(new myWebClient());
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.getSettings().setBuiltInZoomControls(true);
        myWebView.getSettings().setDisplayZoomControls(false);
        myWebView.loadUrl("file:///android_asset/" + resName);
    }
}