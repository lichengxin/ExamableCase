package com.android.examablecase.widget;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.android.examablecase.R;
import com.android.examablecase.widget.loading.LoadingActivity;
import com.android.examablecase.widget.radiobutton.RadioActivity;
import com.android.examablecase.widget.randomTextView.RandomActivity;

public class WidgetActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mRadioButton;
    private Button mScroll;
    private Button mLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget);
        initView();
    }

    private void initView() {
        mRadioButton = (Button) findViewById(R.id.radioButton);
        mScroll = (Button) findViewById(R.id.scroll);

        mRadioButton.setOnClickListener(this);
        mScroll.setOnClickListener(this);
        mLoading = (Button) findViewById(R.id.loading);
        mLoading.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.radioButton:
                startActivity(new Intent(getApplicationContext(), RadioActivity.class));
                break;
            case R.id.scroll:
                startActivity(new Intent(getApplicationContext(), RandomActivity.class));
                break;
            case R.id.loading:
                startActivity(new Intent(getApplicationContext(), LoadingActivity.class));
                break;
        }
    }
}
