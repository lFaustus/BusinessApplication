package com.business.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by User on 23/09/2015.
 */
public class CustomRecyclerAdapter extends RecyclerView.Adapter<CustomRecyclerAdapter.ViewHolder>{

    private ArrayList<?> mArrayList;

    private DisplayMetrics windowMetrics;

    public CustomRecyclerAdapter(Activity activity, ArrayList<?> arrayList) {
        windowMetrics = activity.getResources().getDisplayMetrics();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
