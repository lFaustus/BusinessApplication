package com.business.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.webkit.WebChromeClient;

import com.business.R;
import com.business.RootActivity;

import im.delight.android.webview.AdvancedWebView;

/**
 * Created by User on 23/09/2015.
 */
public class DownloadProcesses extends ControlPanel{
    public static String FRAGMENT_TAG;
    private static final String mRetrieveURL="http://192.168.1.36/christian-john/enduser/listagencies.php";
    private AdvancedWebView mWebView;

    public static ControlPanel newInstance(String param1) {
        DownloadProcesses fragment = new DownloadProcesses();
        Bundle args = new Bundle();
        args.putString(FRAGMENT_KEY, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            FRAGMENT_TAG = getArguments().getString(FRAGMENT_KEY);
            ((RootActivity)(getActivity())).onSectionAttached(FRAGMENT_TAG);
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mWebView = (AdvancedWebView) LayoutInflater.from(getActivity()).inflate(R.layout.webview, null, true);
        super.mContent.addView(mWebView);
        mWebView.setWebChromeClient(new WebChromeClient());
       // mWebView.setWebViewClient(new WebViewClient());
        //mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.loadUrl(mRetrieveURL);
    }
}
