package com.business;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.business.fragments.ControlPanel;
import com.business.fragments.DownloadProcesses;
import com.business.fragments.FileManager;
import com.business.fragments.NavigationDrawerFragment;
import com.business.fragments.Processes;
import com.business.fragments.ProcessesManager;
import com.business.fragments.Subscription;

public class MainActivity extends AppCompatActivity implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    private Toolbar mAppBar;
    private CharSequence mTitle;
    private String[] mFragment_Tags;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAppBar = (Toolbar)findViewById(R.id.app_bar);
        setSupportActionBar(mAppBar);

        mTitle = getTitle();

//        Log.i("tag",mFragment_Tags[0]);
        //if(savedInstanceState == null)
          //  getFragmentManager().beginTransaction().add(R.id.root_view, ControlPanel.newInstance("ControlPanel")).commit();
        NavigationDrawerFragment drawerFragment = (NavigationDrawerFragment)getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        drawerFragment.setUp(R.id.navigation_drawer,(DrawerLayout)findViewById(R.id.drawer_layout),mAppBar);


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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        ControlPanel mControlPanel;
        String mTag = NavigationDrawerFragment.mFragment_Tags[position];
        switch(position)
        {
            case 0:
                mControlPanel = ProcessesManager.newInstance(mTag);
                break;
            case 1:
                mControlPanel = Processes.newInstance(mTag);
                break;
            case 2:
                mControlPanel = FileManager.newInstance(mTag);
                break;
            case 3:
                mControlPanel = Subscription.newInstance(mTag);
                break;

            default:
                mControlPanel= DownloadProcesses.newInstance(mTag);
                break;
        }
        getFragmentManager().beginTransaction()
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
        actionBar.setTitle(mTitle);
    }

}
