package com.example.catgram_admin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;


public class WebActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        WebView browser=findViewById(R.id.webBrowser);
        browser.loadUrl("https://console.firebase.google.com/u/0/project/my-catgram/authentication/users");
    }
}