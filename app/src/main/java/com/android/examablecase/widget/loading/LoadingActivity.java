package com.android.examablecase.widget.loading;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.android.cuslib.loadstate.LoadingLayout;
import com.android.cuslib.utils.ToastUtils;
import com.android.examablecase.R;

public class LoadingActivity extends AppCompatActivity {

    private LoadingLayout mLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        initView();
    }

    private void initView() {
        mLoading = (LoadingLayout) findViewById(R.id.loading);

        mLoading.setLoadingPage(R.layout.define_loading_page).setOnReloadListener(new LoadingLayout.OnReloadListener() {

            @Override
            public void onReload(View v) {
                Toast.makeText(LoadingActivity.this, "重试", Toast.LENGTH_SHORT).show();
            }
        });
        mLoading.setStatus(LoadingLayout.Loading);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                mLoading.setStatus(LoadingLayout.Empty);
            }
        },2000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                mLoading.setStatus(LoadingLayout.Error);
            }
        },4000);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                mLoading.setStatus(LoadingLayout.No_Network);
            }
        },6000);

//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//
//                mLoading.setStatus(LoadingLayout.Success);
//            }
//        },8000);

//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//
//                mLoading.setStatus(LoadingLayout.Loading);
//            }
//        },10000);

    }
}
