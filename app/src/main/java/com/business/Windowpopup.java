package com.business;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebChromeClient;

import im.delight.android.webview.AdvancedWebView;

public class Windowpopup extends AppCompatActivity {

    private String mRetrieveURL = "";
    private String userId;
    private AdvancedWebView mWebView;
    private String page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);

        Intent mIntent = getIntent();
        userId = mIntent.getStringExtra("id");
        page = mIntent.getStringExtra("page");
        //((RootActivity)getParent()).setCookie(userId,null,null);

        mWebView = (AdvancedWebView)findViewById(R.id.webView);
        //mWebView.addJavascriptInterface(((RootActivity)getParent()).getCookie(),"userid");
        if(page.equals("steps"))
            mRetrieveURL = getResources().getString(R.string.client_url) + "liststeps.php?id=" + userId ;
        else if(page.equals("requirements"))
        {
            mRetrieveURL = getResources().getString(R.string.client_url) + "listrequirement.php?id=" + userId ;
        }
        else if (page.equals("listprocesstemplate"))
        {
            mRetrieveURL = getResources().getString(R.string.client_url) + "startrequirements.php?pid=" + userId ;
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_popup, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        super.finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mWebView.setWebChromeClient(new WebChromeClient());
        //mWebView.setWebViewClient(new WebViewClient());
        mWebView.getSettings().setJavaScriptEnabled(true);
        //mWebView.addJavascriptInterface(((RootActivity)getActivity()).getCookie(), "stringGetter");
        mWebView.loadUrl(mRetrieveURL);
    }
}
