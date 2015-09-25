package com.business.adapters;

import android.app.Activity;
import android.view.View;

/**
 * Created by User on 24/09/2015.
 */
public class ViewHolderSubscriptions extends BaseViewHolder {
    public ViewHolderSubscriptions(View itemView, Activity activity,CustomRecyclerAdapter customRecyclerAdapter) {
        super(itemView, activity,customRecyclerAdapter);
        super.mButtonPanel.setVisibility(View.GONE);
    }
}
