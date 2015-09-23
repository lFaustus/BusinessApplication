package com.business.animation;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;

/**
 * Created by flux on 6/22/15.
 */
public class ViewAnimator
{

    private int AnimationDuration;
    private int StartDelay = 500;
    private int Alpha = 1;
    private Interpolator interpolator;
    private View v;
    private ObjectAnimator animator;
    private PropertyValuesHolder pvhTranslationX = PropertyValuesHolder.ofFloat(View.TRANSLATION_X,0);
    private PropertyValuesHolder pvhTranslationY = PropertyValuesHolder.ofFloat(View.TRANSLATION_Y,0);
    private PropertyValuesHolder pvhScaleX = PropertyValuesHolder.ofFloat(View.SCALE_X,1);
    private PropertyValuesHolder pvhScaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y,1);
    private PropertyValuesHolder pvhAlpha = PropertyValuesHolder.ofFloat(View.ALPHA,1);

    public ViewAnimator(View v) {
        this.v = v;
    }

    public ViewAnimator setAnimationDuration(int AnimationDuration)
    {
        this.AnimationDuration = AnimationDuration;
        return this;
    }

    public ViewAnimator setInterpolator(Interpolator interpolator)
    {
        this.interpolator = interpolator;
        return this;
    }

    public ViewAnimator setViewScaleX(int ScaleX)
    {
        this.pvhScaleX = PropertyValuesHolder.ofFloat(View.SCALE_X,ScaleX);
        return this;
    }

    public ViewAnimator setViewScaleY(int ScaleY)
    {
        this.pvhScaleX = PropertyValuesHolder.ofFloat(View.SCALE_Y,ScaleY);
        return this;
    }

    public ViewAnimator setTranslationX(int TranslationX)
    {
        this.pvhTranslationX = PropertyValuesHolder.ofFloat(View.TRANSLATION_X,TranslationX);
        return this;
    }

    public ViewAnimator setTranslationY(int TranslationY)
    {
        this.pvhTranslationY = PropertyValuesHolder.ofFloat(View.TRANSLATION_Y,TranslationY);
        return this;
    }

    public ViewAnimator setStartDelay(int StartDelay)
    {
        this.StartDelay = StartDelay;
        return this;
    }

    public ViewAnimator setAlpha(int Alpha)
    {
        this.pvhAlpha = PropertyValuesHolder.ofFloat(View.ALPHA,Alpha);
        this.Alpha = Alpha;
        return this;
    }

    public ViewAnimator setAnimationListener(Animator.AnimatorListener animatorListener)
    {
        this.animator.addListener(animatorListener);
        return this;
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public ViewAnimator setAnimationPauseListener(Animator.AnimatorPauseListener animatorPauseListener)
    {
        this.animator.addPauseListener(animatorPauseListener);
        return this;
    }

    public ViewAnimator setAnimationUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener)
    {
        this.animator.addUpdateListener(animatorUpdateListener);
        return this;
    }

    public ViewAnimator startAnimation()
    {
        this.animator = ObjectAnimator.ofPropertyValuesHolder(this.v,this.pvhTranslationX,this.pvhTranslationY,this.pvhScaleX,this.pvhScaleY,this.pvhAlpha);
        this.animator.setInterpolator(this.interpolator);
        this.animator.setDuration(this.AnimationDuration);
        this.animator.setStartDelay(this.StartDelay);
        this.animator.start();


        if(this.Alpha == 0)
            this.v.setVisibility(View.GONE);
        else
            this.v.setVisibility(View.VISIBLE);
        return this;
    }

}
