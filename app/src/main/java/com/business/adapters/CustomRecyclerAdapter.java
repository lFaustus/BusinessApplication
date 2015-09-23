package com.business.adapters;

import android.app.Activity;
import android.content.res.Configuration;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.business.R;
import com.business.fragments.AgencyProcesses;
import com.business.fragments.PersonalProcesses;

import java.util.ArrayList;

/**
 * Created by User on 23/09/2015.
 */
public class CustomRecyclerAdapter extends RecyclerView.Adapter<CustomRecyclerAdapter.ViewHolder> {

    private ArrayList<String> mArrayList;
    private Activity mActivity;
    private DisplayMetrics windowMetrics;
    private int mRecyclerItemLayout;
    private String mFragmentTag;


    public CustomRecyclerAdapter(Activity activity, ArrayList<String> arrayList,int recyclerItemLayout,String fragmentTag) {
        windowMetrics = activity.getResources().getDisplayMetrics();
        mActivity = activity;
        mArrayList = arrayList;
        mRecyclerItemLayout = recyclerItemLayout;
        mFragmentTag = fragmentTag;


    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(mRecyclerItemLayout, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Log.e("position", position + "");
        /* TODO */
        if(holder.mDeleteButton != null)
            holder.mDeleteButton.setTag(position);

        if(holder.mUpdateButton != null)
            holder.mUpdateButton.setTag(position);


        if(mActivity.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            ViewGroup.LayoutParams layoutparams = holder.mCard.getLayoutParams();
            layoutparams.height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, windowMetrics.heightPixels, windowMetrics);
            layoutparams.width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 500, windowMetrics);
            holder.mCard.setLayoutParams(layoutparams);
            StaggeredGridLayoutManager.LayoutParams layoutParams1 = ((StaggeredGridLayoutManager.LayoutParams) holder.mCard.getLayoutParams());
            layoutParams1.setFullSpan(true);
        }

        /*if(mFragmentTag == FileManager.FRAGMENT_TAG)
        {
            holder.mProcessName.setText("Sample File " + position);
            if(holder.mStepSourceUri !=null)
            holder.mStepSourceUri.setVisibility(View.GONE);
            if(holder.mAddress !=null)
            holder.mAddress.setVisibility(View.GONE);
            if(holder.mBranch !=null)
            holder.mBranch.setVisibility(View.GONE);
        }
        else if(mFragmentTag == AgencyProcesses.FRAGMENT_TAG)
        {
            holder.mProcessName.setText("Process Sample " + position);
            if(holder.mStepSourceUri !=null)
            holder.mStepSourceUri.setVisibility(View.VISIBLE);
            if(holder.mAddress !=null) {
                holder.mAddress.setVisibility(View.VISIBLE);
                holder.mAddress.setText("Address - " + position);
            }
            if(holder.mBranch !=null) {
                holder.mBranch.setVisibility(View.VISIBLE);
                holder.mBranch.setText("Branch - " + position);
            }
        }*/
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    @Override
    public void onViewAttachedToWindow(ViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        if(mFragmentTag == PersonalProcesses.FRAGMENT_TAG && holder.mBranch!=null && holder.mAddress != null) {
            holder.mBranch.setVisibility(View.GONE);
            holder.mAddress.setVisibility(View.GONE);
        }
        else if(mFragmentTag == AgencyProcesses.FRAGMENT_TAG && holder.mBranch!=null && holder.mAddress != null) {
            holder.mBranch.setVisibility(View.VISIBLE);
            holder.mAddress.setVisibility(View.VISIBLE);
        }
       /* if(mFragmentTag == PersonalProcesses.FRAGMENT_TAG && mFragmentTag!=null) {
            holder.mBranch.setVisibility(View.GONE);
            holder.mAddress.setVisibility(View.GONE);
        }
        else if(mFragmentTag == AgencyProcesses.FRAGMENT_TAG && mFragmentTag != null) {
            holder.mBranch.setVisibility(View.VISIBLE);
            holder.mAddress.setVisibility(View.VISIBLE);
        }*/
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView mProcessName, mScheduleType, mRecurrence, mNo_Recurrence, mDateModified, mDateCreated,
        mStepStatus,mStepsPersonalProcessSource,mRequirementStatus,mStepSourceUri,mBranch,mAddress;
        Button mDeleteButton, mUpdateButton;

        CardView mCard;

        public ViewHolder(View itemView) {

            super(itemView);
            initializeViews((ViewGroup)itemView);





           /* mDeleteButton = (Button) itemView.findViewById(R.id.delete_button);
            mUpdateButton = (Button) itemView.findViewById(R.id.update_button);

            mDeleteButton.setOnClickListener(this);
            mUpdateButton.setOnClickListener(this);

            mProcessName = (TextView) itemView.findViewById(R.id.process_name);
            mScheduleType = (TextView) itemView.findViewById(R.id.schedule_type);
            mRecurrence = (TextView) itemView.findViewById(R.id.recurrence);
            mNo_Recurrence = (TextView) itemView.findViewById(R.id.number_recurrence);
            mDateCreated = (TextView) itemView.findViewById(R.id.date);
            mDateModified = (TextView) itemView.findViewById(R.id.date_modified);*/

            mCard = (CardView)itemView.findViewById(R.id.card_view);

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
    }
}
