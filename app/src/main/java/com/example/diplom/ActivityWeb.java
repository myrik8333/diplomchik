package com.example.diplom;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ActivityWeb extends AppCompatActivity {

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        WebView webView=(WebView)findViewById(R.id.webView);
//        setContentView(webView);
        webView.setWebViewClient(new WebViewClient());
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        //Uri data =getIntent().getData();
        webView.loadUrl(String.valueOf("https://studio.here.com/viewer/?project_id=a41560a9-11c5-41f1-8a78-523328950b52"));
        //webView.setWebViewClient(new WebViewClient());
        //webView.loadUrl(String.valueOf(data));

    }



}
