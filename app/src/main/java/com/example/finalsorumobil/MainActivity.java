package com.example.finalsorumobil;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.finalsorumobil.R;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private EditText text;

    private ProgressBar Pbar;
    private String data;
    private WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.Btn);
        text = findViewById(R.id.LinkGirdi);
        Pbar = findViewById(R.id.progressbar);
        web = findViewById(R.id.webview);
        btn.setVisibility(View.VISIBLE);
        text.setVisibility(View.VISIBLE);


        Pbar.setVisibility(View.GONE);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = text.getText().toString();
                if(data.matches("")){
                    text.setError("abi bi sikim girmedin , yok");
                } else {


                    web.getSettings().setJavaScriptEnabled(true);
                    web.setWebViewClient(new WebViewClient() {


                        @Override
                        public void onPageStarted(WebView view, String url, Bitmap favicon) {
                            super.onPageStarted(view, url, favicon);
                            btn.setVisibility(View.GONE);
                            text.setVisibility(View.GONE);
                            web.setVisibility(View.GONE);
                            Pbar.setVisibility(View.VISIBLE);
                        }


                        @Override
                        public void onPageFinished(WebView view, String url) {
                            super.onPageFinished(view, url);
                            btn.setVisibility(View.GONE);
                            text.setVisibility(View.GONE);
                            web.setVisibility(View.VISIBLE);
                            Pbar.setVisibility(View.GONE);
                        }
                    });


                    web.loadUrl(data);
                }



            }
        });
    }





    @Override
    public void onBackPressed() {

        if (web !=null&& web.canGoBack()){
            web.goBack();


        }
        else{
            super.onBackPressed();
        }
    }
}










