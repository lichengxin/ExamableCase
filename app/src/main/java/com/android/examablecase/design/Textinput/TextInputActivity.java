package com.android.examablecase.design.Textinput;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.examablecase.R;

import java.util.regex.Pattern;

/**
 * https://developer.android.google.cn/reference/android/support/design/widget/TextInputLayout.html#setError%28java.lang.CharSequence
 * https://gold.xitu.io/post/587c1637128fe10057f745db
 */

public class TextInputActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mAccount;
    private TextInputLayout mAccountinput;
    private EditText mPassword;
    private TextInputLayout mPasswordinput;
    private Button mAccountSignInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_input);
        initView();
        checkAvalid();

    }

    private void checkAvalid() {
        mPassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == EditorInfo.IME_ACTION_DONE) {
                    InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    //inputMethodManager.showSoftInput(getWindow().getDecorView(),InputMethodManager.SHOW_FORCED);//显示
                    inputMethodManager.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), InputMethodManager.RESULT_UNCHANGED_SHOWN);
                    //attemptLogin();
                    // TODO 去登陆
                    finish();
                    return true;
                }
                return false;
            }
        });

        mPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                btnState();
            }
        });

//        if (TextUtils.isEmpty(mPassword.getText())||!isPasswordValid(mPassword.getText().toString())) {
//            mPasswordinput.setError(getString(R.string.error_invalid_password));
//        }
        mAccount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                btnState();
                if (TextUtils.isEmpty(mAccount.getText().toString()) || !isAccountValid(mAccount.getText().toString())) {
                    if (s.length() != 11) {
                        mAccountinput.setError(getString(R.string.error_invalid_account));
                    } else {
                        mAccountinput.setError(null);
                    }
                }


            }
        });
    }

    private void btnState() {
        if (mAccount.getText().toString().equals("")&&mPassword.getText().toString().equals("")){
            mAccountSignInButton.setClickable(false);
            mAccountSignInButton.setBackgroundColor(getResources().getColor(R.color.canlogin));
        }else{
            mAccountSignInButton.setClickable(true);
            mAccountSignInButton.setBackgroundColor(getResources().getColor(R.color.canNotLogin));
        }
    }

    private boolean isAccountValid(String name) {
        //TODO: Replace this with your own logic
        Pattern pattern = Pattern.compile("^(13[0-9]|14[5|7]|15\\d|17[6|7]|18[\\d])\\d{8}$");
        return pattern.matcher(name).matches();
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 6;
    }

    private void initView() {
        mAccount = (EditText) findViewById(R.id.account);
        mAccountinput = (TextInputLayout) findViewById(R.id.accountinput);
        mPassword = (EditText) findViewById(R.id.password);
        mPasswordinput = (TextInputLayout) findViewById(R.id.passwordinput);
        mAccountSignInButton = (Button) findViewById(R.id.account_sign_in_button);

        mAccountSignInButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.account_sign_in_button:
                submit();
                break;
        }
    }

    private void submit() {
        // validate
        String accountString = mAccount.getText().toString().trim();
        if (TextUtils.isEmpty(accountString)) {
            Toast.makeText(this, "accountString不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String passwordString = mPassword.getText().toString().trim();
        if (TextUtils.isEmpty(passwordString)) {
            Toast.makeText(this, "passwordString不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }
}
