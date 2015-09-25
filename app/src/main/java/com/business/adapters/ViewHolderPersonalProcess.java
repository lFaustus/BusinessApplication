package com.business.adapters;

import android.app.Activity;
import android.view.View;

/**
 * Created by User on 24/09/2015.
 */
public class ViewHolderPersonalProcess extends BaseViewHolder {
    public ViewHolderPersonalProcess(View itemView, Activity activity,CustomRecyclerAdapter customRecyclerAdapter) {
        super(itemView, activity,customRecyclerAdapter);
        super.mBranch.setVisibility(View.GONE);
        super.mAddress.setVisibility(View.GONE);
    }
}
