package com.android.examablecase.widget.radiobutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.examablecase.R;
/*
*现在有这么一个需求，有两个单选按钮，用来选择性别，为了界面美观，要求，选择“男”的时候，
* radiobutton是蓝色的，选择“女”的时候，radiobutton是红色的，而且还有一个要求：单选按钮和文本之间要有13dp的间距！！
* */
public class RadioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);
    }
}
