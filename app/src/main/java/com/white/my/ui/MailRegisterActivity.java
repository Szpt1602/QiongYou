package com.white.my.ui;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.white.R;
import com.white.other.base.BaseActivity;

/**
 * Created by Exp on 2016/6/13.
 */
public class MailRegisterActivity  extends BaseActivity {

    private Button btn;
    private TextView text_phone;
    private View iv_back;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_mali_register;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initEvents() {
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(MailRegisterActivity.this,"请填写完整",Toast.LENGTH_SHORT).show();
            }
        });

        text_phone.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MailRegisterActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });

        iv_back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MailRegisterActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    protected void initViews() {
        btn = (Button) findViewById(R.id.mail_register_activity_zhuce_btn);
        text_phone = (TextView) findViewById(R.id.mail_register_phone_tv);
        iv_back = findViewById(R.id.mali_register_activity_back);
    }
}
