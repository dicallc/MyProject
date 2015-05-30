package com.xiaoxin.womenclass;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.xiaoxin.womenclass.Base.Transtion.ActivityTransitionLauncher;
import com.xiaoxin.womenclass.View.CircleButton;
import com.xiaoxin.womenclass.View.shimmer.Shimmer;
import com.xiaoxin.womenclass.View.shimmer.ShimmerTextView;


public class MainActivity extends Activity implements OnClickListener {

    private ShimmerTextView shimmer_tv;
    private Shimmer shimmer;
    private CircleButton shimmer_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        InitData();
    }

    private void initView() {
        shimmer_btn = (CircleButton) findViewById(R.id.shimmer_btn);
        shimmer_tv = (ShimmerTextView) findViewById(R.id.shimmer_tv);
    }

    private void InitData() {
        shimmer = new Shimmer();
        shimmer.start(shimmer_tv);
        shimmer_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.shimmer_btn:
                final Intent intent = new Intent(MainActivity.this,
                        WomenClassifyActivity.class);
                startActivity(intent);
                ActivityTransitionLauncher.with(MainActivity.this).from(v)
                        .launch(intent);
                break;

            default:
                break;
        }
    }
}
