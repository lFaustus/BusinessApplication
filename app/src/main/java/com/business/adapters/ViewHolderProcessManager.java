package com.business.adapters;

import android.app.Activity;
import android.view.View;

/**
 * Created by User on 24/09/2015.
 */
public class ViewHolderProcessManager extends BaseViewHolder {

    public ViewHolderProcessManager(View itemView, Activity activity,CustomRecyclerAdapter customRecyclerAdapter) {
        super(itemView, activity,customRecyclerAdapter);
        super.mDownloadedfrom.setVisibility(View.GONE);
        super.mDownloadedfromLabel.setVisibility(View.GONE);
        super.mScheduleType.setVisibility(View.GONE);
        super.mScheduleTypeLabel.setVisibility(View.GONE);
       /* super.mProcessName = (TextView)itemView.findViewById(R.id.process_name);
        super.mScheduleType = (TextView)itemView.findViewById(R.id.schedule_type);
        super.mRecurrence = (TextView)itemView.findViewById(R.id.recurrence);
        super.mDownloadedfrom = (TextView)itemView.findViewById(R.id.downloaded_from);
        super.mDateCreated = (TextView)itemView.findViewById(R.id.date);
        super.mDateModified = (TextView)itemView.findViewById(R.id.date_modified);*/


    }
}
