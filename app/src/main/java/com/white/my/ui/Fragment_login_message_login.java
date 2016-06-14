package com.white.my.ui;

import android.app.Dialog;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.white.R;
import com.white.my.adatper.DialogAdapter;

import java.util.ArrayList;

/**
 * Created by Exp on 2016/6/8.
 */
public class Fragment_login_message_login extends RelativeLayout {

    private String[] str=null;
    public ArrayList<String> list;
    private DialogAdapter dialogAdapter;
    private TextView textcon;
    private Button btn;

    public Fragment_login_message_login(final Context context) {
        super(context);
        inflate(context, R.layout.fragment_login_message_login,this);
        textcon = (TextView) findViewById(R.id.login_activity_tvcon_message);
        btn = (Button) findViewById(R.id.fragment_login_message_btn);
        list = new ArrayList<>();


        textcon.setOnClickListener(new OnClickListener() {

            private int width;
            private int height;
            private ListView lv;
            private Dialog dialog;

            @Override
            public void onClick(View v) {
                dialog = new Dialog(getContext(), R.style.dialog_version);
                dialog.setContentView(R.layout.dialog_version);
                lv = (ListView)dialog. findViewById(R.id.dialog_lv);
                String cities[]=getResources().getStringArray(R.array.smssdk_country_group);
                str=new String[cities.length];
                for (int i = 0;i<cities.length;i++){
                    String[] split = cities[i].split(",");
                    str[i]=split[0]+","+"00"+split[1];
                    list.add(str[i]);
                }
                dialogAdapter = new DialogAdapter(list, context);
                lv.setAdapter(dialogAdapter);
                height = getHeight();
                width = getWidth();
                dialog.getWindow().setLayout(width-120,height/2+150);
                android.view.Window window = dialog.getWindow();
                window.setBackgroundDrawableResource(R.drawable.ic_dialog_bc);
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    private String string;

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(getContext(), list.get(position), Toast.LENGTH_SHORT).show();
                        String s = list.get(position);
                        String[] split = s.split(","+"00");
                        textcon.setText(split[1]);
                        dialog.dismiss();
                    }
                });



                dialog.show();
            }
        });
        btn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"手机号不能为空",Toast.LENGTH_SHORT).show();
            }
        });

    }

    public Fragment_login_message_login(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context, R.layout.fragment_login_message_login,this);
        textcon = (TextView) findViewById(R.id.login_activity_tvcon_message);
    }
}
