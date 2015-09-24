package com.business.adapters;

import android.app.Activity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.business.R;

/**
 * Created by User on 24/09/2015.
 */
public class BaseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private Activity mActivity;

    protected TextView mProcessName, mScheduleType, mRecurrence, mNo_Recurrence, mDateModified, mDateCreated,
            mStepStatus,mStepsPersonalProcessSource,mRequirementStatus,mStepSourceUri,mBranch,mAddress,mDownloadedfrom;
    protected Button mDeleteButton, mUpdateButton;
    protected CardView mCard;

    public BaseViewHolder(View itemView,Activity activity) {
        super(itemView);
        mActivity = activity;
        mCard = (CardView)itemView.findViewById(R.id.card_view);
        initializeViews((ViewGroup) itemView);
    }

    void initializeViews(ViewGroup rootview)
    {
        for(int i = 0; i< rootview.getChildCount();i++)
        {
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
                    }
                }
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.delete_button:
                if(v.getTag() == null)
                    return;

                Toast.makeText(mActivity, "delete " + v.getTag().toString(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.update_button:
                if(v.getTag() == null)
                    return;

                Toast.makeText(mActivity, "update " + v.getTag().toString(), Toast.LENGTH_SHORT).show();
                break;

        }
    }
}
