package com.business.customviews.circularimageview;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by User on 24/09/2015.
 */
public class customTextView extends TextView {

    Typeface mTypeface;

    public customTextView(Context context) {
        super(context);
        init(context);
    }

    public customTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public customTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public customTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    void init(Context context)
    {
        mTypeface = Typeface.createFromAsset(context.getAssets(),"Play-Regular.ttf");
        setTypeface(mTypeface);
    }
}
