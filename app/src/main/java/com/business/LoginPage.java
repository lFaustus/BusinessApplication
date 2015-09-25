package com.business;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.business.volley.VolleyConnection;

import java.util.HashMap;
import java.util.Map;

public class LoginPage extends AppCompatActivity {

    private EditText mUsername;
    private EditText mPassword;
    private Button mLoginButton;
    private String mLoginURL="http://192.168.1.36/christian-john/enduser/loginmobile.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        mUsername = (EditText)findViewById(R.id.username);
        mPassword = (EditText)findViewById(R.id.password);
        mLoginButton = (Button)findViewById(R.id.loginbutton);
        RequestQueue mRequestQueue = VolleyConnection.getInstance().getRequestQueue();
        mLoginButton.setOnClickListener(v -> {
            StringRequest mLoginRequest = new StringRequest(Request.Method.POST, mLoginURL, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.e("response",response.toString());

                }

        }, error -> {
            error.printStackTrace();
        }){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String,String> params = new HashMap<String,String>();
                    params.put("user",mUsername.getText().toString());
                    params.put("pass",mPassword.getText().toString());
                    return params;
                }
            };
            mRequestQueue.add(mLoginRequest);
    });
        //mRequestQueue.start();

        /*JsonObjectRequest mJsonObjectRequest = new JsonObjectRequest(Request.Method.POST,mLoginURL, response -> {
            Log.e("Aw", mLoginURL);
            try {
                JSONArray mInformation = response.getJSONArray("enduser");
                Log.e("mInformationCount",mInformation.length()+"");
                for(int i = 0; i<mInformation.length();i++)
                {
                    JSONObject mJsonObject = mInformation.getJSONObject(i);

                }
            } catch (JSONException e) {

                e.printStackTrace();
            }
        }, error -> {
            error.printStackTrace();

        });*/

    }
}
