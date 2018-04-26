package com.example.wber.baby;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import java.lang.reflect.Field;

public class MainActivity extends Activity {

    public WebView webView ;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    webView.loadUrl("file:///android_asset/header.html");
                    return true;
                case R.id.navigation_baby:
                    webView.loadUrl("file:///android_asset/header.html");
                    return true;
                case R.id.navigation_house:
                    webView.loadUrl("file:///android_asset/header.html");
                    return true;
                case R.id.navigation_me:
                    webView.loadUrl("file:///android_asset/index.html");
                    webView.setWebViewClient(new MyWebViewClient());
                    return true;

            }
            return false;
        }
    };
    //获取整个的NavigationView

    @SuppressLint("JavascriptInterface")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titlebar);
        webView = (WebView)findViewById(R.id.web) ;
        webView.getSettings().setJavaScriptEnabled(true) ;
        webView.addJavascriptInterface(this,"someThing");
        webView.setWebViewClient(new MyWebViewClient());
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        BottomNavigationViewHelper.disableShiftMode(navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if((keyCode==KeyEvent.KEYCODE_BACK)&&(webView.canGoBack())){
            webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    public class MyWebViewClient extends WebViewClient {
        public boolean shouldOverviewUrlLoading(WebView view,String url){
            view.loadUrl(url);
            return true ;
        }
    }
}
