package com.white.my.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.white.R;
import com.white.my.adatper.DialogAdapter;
import com.white.other.base.BaseActivity;

import java.util.ArrayList;

/**
 * Created by Exp on 2016/6/4.
 */
public class RegisterActivity extends BaseActivity {


    private TextView textview;
    private Context context;
    private Dialog dialog;
    public ArrayList<String> list;
    private Button btn;
    private ImageView back_iv;
    private TextView mail_tv;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_register;

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initEvents() {
        textview.setOnClickListener(new View.OnClickListener() {


            private DialogAdapter dialogAdapter;
            private String[] strings;
            private ListView lv;
            @Override
            public void onClick(View v) {
                dialog = new Dialog(RegisterActivity.this, R.style.dialog_version);
                dialog.setContentView(R.layout.dialog_version);
                lv = (ListView) dialog.findViewById(R.id.dialog_lv);
                list=new ArrayList<String>();
                String cities[]=getResources().getStringArray(R.array.smssdk_country_group);
                strings = new String[cities.length];
                for (int i = 0;i<cities.length;i++){
                    String[] split = cities[i].split(",");
                    strings[i]=split[0]+","+"00"+split[1];
                    Log.d("str",strings[i]);
                    list.add(strings[i]);
                }

                dialogAdapter = new DialogAdapter(list, RegisterActivity.this);
                lv.setAdapter(dialogAdapter);
                dialog.getWindow().setLayout(1000,1000);
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String s = list.get(position);
                        String[] split = s.split(","+"00");
                        textview.setText(split[0]+split[1]);
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });


        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(RegisterActivity.this,"请填写手机号",Toast.LENGTH_SHORT).show();
            }
        });

        back_iv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        mail_tv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, MailRegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    protected void initViews() {
        textview = (TextView) findViewById(R.id.register_activity_tv);
        btn = (Button) findViewById(R.id.register_activity_next_btn);
        back_iv = (ImageView) findViewById(R.id.register_activity_back);
        mail_tv = (TextView) findViewById(R.id.register_activity_mail_tv);
    }


}
