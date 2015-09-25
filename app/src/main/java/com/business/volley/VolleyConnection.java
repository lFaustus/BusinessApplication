package com.business.volley;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.HttpClientStack;
import com.android.volley.toolbox.HttpStack;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * Created by User on 25/09/2015.
 */
public class VolleyConnection {
    private static VolleyConnection mInstance = null;
    private ImageLoader mVolleyImageLoader;
    private RequestQueue mRequestQueue;


    private VolleyConnection() {
        DefaultHttpClient httpclient = new DefaultHttpClient();

        CookieStore cookieStore = new BasicCookieStore();
        httpclient.setCookieStore( cookieStore );
        HttpStack httpStack = new HttpClientStack( httpclient );
       /* for(int i=0;i<httpclient.getCookieStore().getCookies().size();i++)
        {
            Log.e("iteration : ",""+i);
            Log.e("cookie",httpclient.getCookieStore().getCookies().get(i).toString());
        }*/
        mRequestQueue = Volley.newRequestQueue(MyApplication.getAppContext(),httpStack);

        //TODO
        mVolleyImageLoader = null;
    }

    public static VolleyConnection getInstance() {

        if(mInstance == null)
            mInstance = new VolleyConnection();

        return mInstance;
    }



    public RequestQueue getRequestQueue()
    {
        return mRequestQueue;
    }
}
