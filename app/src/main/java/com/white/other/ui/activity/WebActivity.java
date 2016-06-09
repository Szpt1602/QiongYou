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

/**
 * 浏览器页面
 * <p/>
 * Created by Liu Jianping
 *
 * @date : 16/5/25.
 */
public class WebActivity extends AppCompatActivity {

    private WebView webView;

    private ProgressBar progressBar;

    private ImageView ivBack, ivShare;

    private TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_web);

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
            return true;
        }

    };

    private WebChromeClient chromeClient = new WebChromeClient() {

        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            progressBar.setProgress(newProgress);
            if (newProgress == 100) {
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

        webView.loadUrl("javascript:wave()");//java代码直接调用js代码
    }

    private void initViews() {
        webView = (WebView) findViewById(R.id.web_content);
        progressBar = (ProgressBar) findViewById(R.id.web_pb);
        ivBack = (ImageView) findViewById(R.id.web_back_iv);
        ivShare = (ImageView) findViewById(R.id.web_share_iv);
        tvTitle = (TextView) findViewById(R.id.web_title_tv);
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
    }

//    private void shareByOneKeyShare() {
//        ShareSDK.initSDK(this);
//        OnekeyShare oks = new OnekeyShare();
//        //关闭sso授权
//        oks.disableSSOWhenAuthorize();
//
//        // 分享时Notification的图标和文字  2.5.9以后的版本不调用此方法
//        // oks.setNotification(R.drawable.ic_launcher, getString(R.string.app_name));
//        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
//        oks.setTitle(getString(R.string.share));
//        // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
//        // oks.setTitleUrl("http://sharesdk.cn");
//        // text是分享文本，所有平台都需要这个字段
//        oks.setText("我是分享文本");
//        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
//        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
//        // url仅在微信（包括好友和朋友圈）中使用
//        oks.setUrl("http://sharesdk.cn");
//        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
//        oks.setComment("我是测试评论文本");
//        // site是分享此内容的网站名称，仅在QQ空间使用
//        oks.setSite(getString(R.string.app_name));
//        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
//        oks.setSiteUrl("http://sharesdk.cn");
//
//        // 启动分享GUI
//        oks.show(this);
//    }

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
