package com.business.adapters;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.business.R;
import com.business.Windowpopup;
import com.business.customviews.circularimageview.CircleImageView;
import com.business.model.Tagging;
import com.business.volley.VolleyConnection;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by User on 24/09/2015.
 */
public class BaseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private Activity mActivity;
    private CRUD mCrud;
    protected TextView mProcessName, mScheduleType, mRecurrence, mNo_Recurrence, mDateModified, mDateCreated,
            mStepStatus,mStepsPersonalProcessSource,mRequirementStatus,mStepSourceUri,mBranch,mAddress,mDownloadedfrom,
            mContentLabel,mDownloadedfromLabel, mScheduleTypeLabel,mPlanDescription,mRate,mTotalAmountSubscription,mStartDateSubscription,
            mEndDateSubsciption,mPaypalAccount,mNumberMoYears,mUsername;
    protected Button mDeleteButton, mUpdateButton,mMoreButton,mViewProcessButton;
    protected CardView mCard;
    protected RelativeLayout mButtonPanel;
    protected CircleImageView mContent_icon,mCard_icon,mProfile_pic;

    private AlertDialog.Builder mAlertDialog = null;

    public BaseViewHolder(View itemView,Activity activity,CustomRecyclerAdapter customRecyclerAdapter) {
        super(itemView);
        mActivity = activity;
        mCard = (CardView)itemView.findViewById(R.id.card_view);
        initializeViews((ViewGroup) itemView);
        mCrud = (CRUD)customRecyclerAdapter;
    }



    void initializeViews(ViewGroup rootview)
    {
        for(int i = 0; i< rootview.getChildCount();i++)
        {

            if(rootview.getChildAt(i).getId() == R.id.buttonPanel)
            {
                mButtonPanel = (RelativeLayout) rootview.getChildAt(i);
            }

            if(rootview.getChildAt(i) instanceof ViewGroup)
            {
                initializeViews((ViewGroup) rootview.getChildAt(i));
            }
            else
            {
                if(rootview.getChildAt(i) instanceof Button)
                {

                    //rootview.getChildAt(i).setOnClickListener(this);
                    switch (rootview.getChildAt(i).getId())
                    {
                        case R.id.delete_button:
                            mDeleteButton = (Button) rootview.getChildAt(i);
                            mDeleteButton.setOnClickListener(this);
                            break;
                        case R.id.update_button:
                            mUpdateButton = (Button) rootview.getChildAt(i);
                            mUpdateButton.setOnClickListener(this);
                            break;
                        case R.id.more_button:
                            mMoreButton = (Button) rootview.getChildAt(i);
                            mMoreButton.setOnClickListener(this);
                            break;

                        case R.id.view_process_button:
                            mViewProcessButton =(Button)rootview.getChildAt(i);
                            mViewProcessButton.setOnClickListener(this);
                            break;
                    }
                }
                else if(rootview.getChildAt(i) instanceof CircleImageView)
                {
                        switch(rootview.getChildAt(i).getId())
                        {
                            case R.id.card_icon:
                                mCard_icon = (CircleImageView)rootview.getChildAt(i);
                                break;

                            case R.id.profile_pic:
                                mProfile_pic = (CircleImageView)rootview.getChildAt(i);
                                break;

                            case R.id.content_icon:
                                mContent_icon = (CircleImageView)rootview.getChildAt(i);
                                break;
                        }
                }

                else if(rootview.getChildAt(i) instanceof TextView)
                {
                    //((TextView)rootview.getChildAt(i)).setTypeface(((MainActivity)mActivity).PlayRegularFont());
                    //if( == R.id.)
                    switch (rootview.getChildAt(i).getId())
                    {
                        case R.id.process_name:
                            mProcessName = (TextView)rootview.getChildAt(i);
                            break;
                        case R.id.schedule_type:
                            mScheduleType = (TextView)rootview.getChildAt(i);
                            break;
                        case R.id.schedule_type_label:
                            mScheduleTypeLabel = (TextView)rootview.getChildAt(i);
                            break;
                        case R.id.recurrence:
                            mRecurrence = (TextView)rootview.getChildAt(i);
                            break;

                        case R.id.number_recurrence:
                            mNo_Recurrence = (TextView)rootview.getChildAt(i);
                            break;

                        case R.id.date:
                            mDateCreated = (TextView)rootview.getChildAt(i);
                            break;

                        case R.id.downloaded_from:
                            mDownloadedfrom = (TextView)rootview.getChildAt(i);
                            break;

                        case R.id.downloaded_from_label:
                            mDownloadedfromLabel = (TextView)rootview.getChildAt(i);
                            break;

                        case R.id.date_modified:
                            mDateModified = (TextView)rootview.getChildAt(i);
                            break;

                        case R.id.step_status:
                            mStepStatus = (TextView)rootview.getChildAt(i);
                            break;

                        case R.id.requirements_status:
                            mRequirementStatus = (TextView)rootview.getChildAt(i);
                            break;

                        case R.id.source:
                            mStepSourceUri = (TextView)rootview.getChildAt(i);
                            break;

                        case R.id.branch:
                            mBranch = (TextView)rootview.getChildAt(i);
                            break;

                        case R.id.address:
                            mAddress = (TextView)rootview.getChildAt(i);
                            break;

                        case R.id.content_label:
                            mContentLabel = (TextView) rootview.getChildAt(i);
                            break;

                        case R.id.plan_description:
                            mPlanDescription = (TextView) rootview.getChildAt(i);
                            break;

                        case R.id.number_month_year:
                            mNumberMoYears = (TextView) rootview.getChildAt(i);
                            break;
                        case R.id.rate:
                            mRate = (TextView) rootview.getChildAt(i);
                            break;

                        case R.id.total:
                            mTotalAmountSubscription = (TextView) rootview.getChildAt(i);
                            break;

                        case R.id.paypal_account:
                            mPaypalAccount = (TextView) rootview.getChildAt(i);
                            break;

                        case R.id.start_date:
                            mStartDateSubscription = (TextView) rootview.getChildAt(i);
                            break;

                        case R.id.end_date:
                            mEndDateSubsciption = (TextView) rootview.getChildAt(i);
                            break;

                        case R.id.username:
                            mUsername = (TextView)rootview.getChildAt(i);
                            break;

                    }
                }
            }
        }
    }

    @Override
    public void onClick(View v) {
        RequestQueue mRequestQueue = VolleyConnection.getInstance().getRequestQueue();
        String url="";
        switch (v.getId()) {
            case R.id.delete_button:
                if(v.getTag() == null)
                    return;

                if(this.getClass().equals(ViewHolderProcessManager.class))
                {
                    url = mActivity.getResources().getString(R.string.client_url)+"deleteprocess.php?id="+((Tagging)v.getTag()).getId();
                  StringRequest mRequest = new StringRequest(Request.Method.POST,url, response -> {

                  },error -> {
                        error.printStackTrace();
                  }){
                      @Override
                      protected Map<String, String> getParams() throws AuthFailureError {
                          Map<String, String> params = new HashMap<String, String>();
                          params.put("id", v.getTag().toString());
                          //params.put("pass", mPassword.getText().toString());
                          return params;
                      }
                  };
                    mRequestQueue.add(mRequest);
                }
                mCrud.onDelete(v.getTag());

                break;
            case R.id.update_button:
                if(v.getTag() == null)
                    return;

                Toast.makeText(mActivity, "update " + v.getTag().toString(), Toast.LENGTH_SHORT).show();
                break;

            case R.id.more_button:

                if(mAlertDialog == null)
                {

                    mAlertDialog =  new AlertDialog.Builder(mActivity);
                    mAlertDialog.setTitle("More");
                    mAlertDialog.setPositiveButton("Steps", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            mAlertDialog = null;
                            dialog.dismiss();

                            Intent  mPopup = new Intent(mActivity, Windowpopup.class);
                            mPopup.putExtra("id",String.valueOf(v.getTag()));
                            mPopup.putExtra("page","steps");
                            mActivity.startActivity(mPopup);
                        }
                    });
                    mAlertDialog.setNeutralButton("Requirements",(dialog,which)-> {

                        mAlertDialog = null;
                        Intent  mPopup = new Intent(mActivity, Windowpopup.class);
                        mPopup.putExtra("id", String.valueOf(v.getTag()));
                        mPopup.putExtra("page","requirements");
                        mActivity.startActivity(mPopup);
                        dialog.dismiss();
                    });
                    mAlertDialog.show();
                }
                break;


            case R.id.view_process_button:
                Intent  mPopup = new Intent(mActivity, Windowpopup.class);
                mPopup.putExtra("id",String.valueOf(v.getTag()));
                mPopup.putExtra("page","listprocesstemplate");
                mActivity.startActivity(mPopup);
                break;

        }
    }

    public interface CRUD
    {
        public void onDelete(Object obj);
    }

}
