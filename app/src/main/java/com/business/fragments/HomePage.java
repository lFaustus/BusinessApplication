package com.business.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.RequestQueue;
import com.business.R;
import com.business.RootActivity;

/**
 * Created by User on 25/09/2015.
 */
public class HomePage extends Fragment{

    private Toolbar mAppBar;
    private CharSequence mTitle;
    private RequestQueue mRequestQueue;
    private static String FRAGMENT_KEY ="LoginBoard";
    private static String FRAGMENT_TAG;

    public static HomePage newInstance(String param1) {
        HomePage fragment = new HomePage();
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
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_main,container,false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mAppBar = (Toolbar)getView().findViewById(R.id.app_bar);
        ((RootActivity)getActivity()).setSupportActionBar(mAppBar);
        mTitle = getActivity().getTitle();

        mRequestQueue = ((RootActivity)getActivity()).getRequestQueue();
        NavigationDrawerFragment drawerFragment = (NavigationDrawerFragment) getChildFragmentManager().findFragmentById(R.id.navigation_drawer);
        drawerFragment.setUp(R.id.navigation_drawer, (DrawerLayout) getView().findViewById(R.id.drawer_layout), mAppBar);

    }

   /* @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        getActivity().getMenuInflater().inflate(R.menu.menu_main, menu);
        restoreActionBar();
    }*/

    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar default_button_textcolor_selector clicks here. The action bar will
        // automatically handle clicks on the Home/Up delete_button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
       /* if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/







}
