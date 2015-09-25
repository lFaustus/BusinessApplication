package com.business;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.android.volley.RequestQueue;
import com.business.customviews.circularimageview.CircleImageView;
import com.business.fragments.AgencyList;
import com.business.fragments.AgencyProcesses;
import com.business.fragments.ControlPanel;
import com.business.fragments.DownloadProcesses;
import com.business.fragments.FileManager;
import com.business.fragments.LoginBoard;
import com.business.fragments.NavigationDrawerFragment;
import com.business.fragments.PersonalProcesses;
import com.business.fragments.ProcessesManager;
import com.business.fragments.Subscription;
import com.business.loader.ImageLoaderEX;
import com.business.misc.UserCookie;
import com.business.volley.VolleyConnection;

public class RootActivity extends AppCompatActivity implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    private CharSequence mTitle;
    private RequestQueue mRequestQueue;
    private UserCookie mUserCookie;
    private ImageLoaderEX mImageLoaderEX;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rootactivity);
        mTitle = getTitle();
        mImageLoaderEX = new ImageLoaderEX(this);
        mRequestQueue = VolleyConnection.getInstance().getRequestQueue();
        if(savedInstanceState == null)
            getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootview, LoginBoard.newInstance("LoginBoard"))
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        restoreActionBar();
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar default_button_textcolor_selector clicks here. The action bar will
        // automatically handle clicks on the Home/Up delete_button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
       /* if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }

    public void setCookie(String user,String pass)
    {
        mUserCookie = new UserCookie(user,pass);
    }

    public UserCookie getCookie()
    {
        return mUserCookie;
    }

    public void setImage(String URL,String name,CircleImageView mCircleImageView )
    {
        mImageLoaderEX.DisplayImage(URL,name,mCircleImageView);
    }

    public RequestQueue getRequestQueue()
    {
        return mRequestQueue;
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        ControlPanel mControlPanel;
        String mTag = NavigationDrawerFragment.mFragment_Tags[position];
        Log.e("Tag",mTag);
        switch(position)
        {

            case 0:
                mControlPanel = AgencyList.newInstance(mTag);
                break;
            case 1:
                mControlPanel = ProcessesManager.newInstance(mTag);
                break;
            case 2:
                mControlPanel = PersonalProcesses.newInstance(mTag);
                break;
            case 3:
                mControlPanel = AgencyProcesses.newInstance(mTag);
                break;
            case 4:
                mControlPanel = FileManager.newInstance(mTag);
                break;
            case 5:
                mControlPanel = Subscription.newInstance(mTag);
                break;

            default:
                mControlPanel= DownloadProcesses.newInstance(mTag);
                break;
        }
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, mControlPanel)
                .commit();
    }


    public void onSectionAttached(String tag) {
        mTitle = tag;
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setTitle(mTitle);
    }
    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_rootactivity, menu);
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

        return super.onOptionsItemSelected(item);*/

}
