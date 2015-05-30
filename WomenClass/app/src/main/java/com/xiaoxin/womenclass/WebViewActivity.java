package com.xiaoxin.womenclass;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;


public class WebViewActivity extends Activity implements View.OnClickListener {
    private String content_str,title_str;
    private   TextView common_title_text;
    private ImageView exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        getData();
        InitView();
        InitData();
    }

    private void InitData() {
        common_title_text.setText(title_str);
        exit.setOnClickListener(this);
    }

    private void InitView() {
        exit= (ImageView) findViewById(R.id.exit);
         common_title_text= (TextView) findViewById(R.id.common_title_text);
        WebView content = (WebView) findViewById(R.id.content);
        loadingWeb(content, content_str);
    }

    private void loadingWeb(WebView web, String content) {
        WebSettings webSettings = web.getSettings();
//        webSettings.setUseWideViewPort(true);
//        webSettings.setLoadWithOverviewMode(true);
        webSettings.setBuiltInZoomControls(true); // 显示放大缩小 controler
        webSettings.setSupportZoom(true); // 可以缩放
        webSettings.setJavaScriptEnabled(true);
        web.loadData(content, "text/html; charset=UTF-8", null);
    }

    private void getData() {
        Intent intent = getIntent();
        content_str = intent.getStringExtra("content");
        title_str = intent.getStringExtra("title");
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.exit:
                finish();
                break;
        }
    }
}
