package com.white.other.ui.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.white.R;
import com.white.other.widget.ScrollListenWebView;

/**
 * Created by A8 on 2016/6/16.
 */
public class WebBuyActivity extends AppCompatActivity {

    private ScrollListenWebView webView;

    private ProgressBar progressBar;

    private ImageView ivBack, ivShare;

    private TextView tvTitle;
    private String url;
    private View titleBg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_webbuy);

        url = getIntent().getStringExtra("url");

        initViews();

        webView.setWebViewClient(viewClient);
        webView.setWebChromeClient(chromeClient);

        WebSettings settings = webView.getSettings();
        //允许运行脚本语言
        settings.setJavaScriptEnabled(true);

        webView.addJavascriptInterface(new KaolaClientApi(), "KaolaClientApi");
        initData();

        initEvents();
    }

    private WebViewClient viewClient = new WebViewClient() {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            progressBar.setVisibility(View.VISIBLE);
            return true;
        }

    };

    private WebChromeClient chromeClient = new WebChromeClient() {

        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            progressBar.setProgress(newProgress);
            if (newProgress >= 100) {
                progressBar.setVisibility(View.INVISIBLE);
            }
        }

        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
            tvTitle.setText(title);
        }
    };

    private void initData() {
        webView.loadUrl(url);
        webView.loadUrl("javascript:wave()");//java代码直接调用js代码

    }

    private void initViews() {
        webView = (ScrollListenWebView) findViewById(R.id.web_buy_content);
        progressBar = (ProgressBar) findViewById(R.id.web_buy_load);
        ivBack = (ImageView) findViewById(R.id.product_back_iv);
        ivShare = (ImageView) findViewById(R.id.web_buy_share_iv);
        tvTitle = (TextView) findViewById(R.id.web_buy_title_tv);
        titleBg = findViewById(R.id.web_buy_title_home_green);
    }

    private void initEvents() {
        ivShare.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//                shareByOneKeyShare();
            }
        });
        ivBack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
            }
        });

        webView.setScrollListener(new ScrollListenWebView.ScrollStateListener() {

            @Override
            public void top() {
                titleBg.setAlpha(0);
            }

            @Override
            public void bottom() {

            }

            @Override
            public void scroll(int y, int oldy) {
                int measuredTitleHeight = titleBg.getMeasuredHeight();
                titleBg.setAlpha((float) y / (measuredTitleHeight * 2));
            }
        });
    }

    @SuppressLint({"javascriptInterface", "SetJavaScriptEnabled"})
    class KaolaClientApi {

        public void refreshTitle(String text) {
            tvTitle.setText(text);
        }

        public void setTitle(final String text) {
            mHandler.post(new Runnable() {

                @Override
                public void run() {
                    tvTitle.setText(text);
                }
            });
        }

    }

    private Handler mHandler = new Handler();

}
