package com.android.examablecase.design;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.cuslib.base.BaseActivity;
import com.android.examablecase.R;
import com.android.examablecase.design.StateBar.StatusbarActivity;
import com.android.examablecase.design.Textinput.TextInputActivity;

public class DesignActivity extends BaseActivity implements View.OnClickListener {

    private Button mStatusbar;
    private Button mTextinput;

    @Override
    public void widgetClick(View v) {
        switch (v.getId()) {
            case R.id.statusbar:
                startActivity(StatusbarActivity.class);
                break;
            case R.id.textinput:
                startActivity(TextInputActivity.class);
                break;
        }
    }


    @Override
    public void initParms(Bundle parms) {

    }

    @Override
    public View bindView() {
        return null;
    }

    @Override
    public int bindLayout() {
        return R.layout.activity_design;
    }

    @Override
    public void initView(View view) {
        mStatusbar = $(R.id.statusbar);
        mTextinput = $(R.id.textinput);
    }

    @Override
    public void setListener() {
        mStatusbar.setOnClickListener(this);
        mTextinput.setOnClickListener(this);
    }

    @Override
    public void doBusiness(Context mContext) {

    }
}
