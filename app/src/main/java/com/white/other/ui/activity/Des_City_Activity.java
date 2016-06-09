package com.white.other.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.white.R;
import com.white.idestination.bean.Des_City_Name1;
import com.white.other.utils.HttpUtil;
import com.white.other.utils.LogUtil;
import com.white.other.utils.QyerTask;
import com.white.other.widget.Des_city_image;

import org.json.JSONException;
import org.json.JSONObject;

public class Des_City_Activity extends AppCompatActivity implements View.OnClickListener {

    private String city;
    private ImageView iv_back, iv_search;
    private TextView tv_title;
    private LinearLayout rootll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_des_city);
        city = getIntent().getStringExtra("city");
        initView();
        initData();
    }

    private void initData() {
        getCityUrl(new QyerTask.IRequestCallback() {

                       @Override
                       public void success(Object obj) {
                           try {
                               JSONObject jo = new JSONObject(obj.toString());
                               String joString = jo.getString("trace_switch");
                               if ("true".equals(joString)) {
                                   JSONObject data = jo.getJSONObject("data");
                                   Des_City_Name1 dcn = Des_City_Name1.objectFromData(data.toString());
                                   LogUtil.d(" Des_City_Name1  dlist  =" + dcn.toString());
                                   tv_title.setText(dcn.getName());
                                   LogUtil.d(" dcn.getName()  =" + dcn.getName());
                                   addCityItem(dcn);
                               }


                           } catch (JSONException e) {
                               e.printStackTrace();
                           }
                       }

                       @Override
                       public void error(String msg) {

                       }
                   }

        );

    }

    private void addCityItem(Des_City_Name1 dcn) {
        Des_city_image des = new Des_city_image(this, dcn);
        rootll.addView(des);
    }

    private void initView() {
        tv_title = (TextView) findViewById(R.id.des_city_title_tv);
        findViewById(R.id.des_city_back_iv).setOnClickListener(this);
        findViewById(R.id.des_city_search_iv).setOnClickListener(this);
        rootll = (LinearLayout) findViewById(R.id.des_city_rootll);

    }


    private void getCityUrl(QyerTask.IRequestCallback callback) {
        QyerTask.IRequest request = new QyerTask.IRequest() {

            @Override
            public Object doRequest() {
                return HttpUtil.doGet(city);
            }
        };
        QyerTask task = new QyerTask(request, callback);
        task.execute();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.des_city_back_iv:
                finish();
                break;
            case R.id.des_city_search_iv:
                //搜索框
                break;
        }
    }
}
