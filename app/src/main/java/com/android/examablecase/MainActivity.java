package com.android.examablecase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.android.examablecase.design.DesignActivity;
import com.android.examablecase.widget.WidgetActivity;
import com.android.examablecase.widget.radiobutton.RadioActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button design;
    private Button widget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        design = (Button) findViewById(R.id.design);
        design.setOnClickListener(this);

        widget = (Button) findViewById(R.id.widget);
        widget.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.widget:
                startActivity(new Intent(getApplicationContext(), WidgetActivity.class));
                break;
            case R.id.design:
                startActivity(new Intent(getApplicationContext(), DesignActivity.class));
                break;

        }
    }
}
