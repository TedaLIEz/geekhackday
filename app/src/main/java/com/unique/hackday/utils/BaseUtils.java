package com.unique.hackday.utils;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;


import com.unique.hackday.R;

import java.util.ArrayList;
import java.util.List;


public class BaseUtils {
    public static int FADE_ANIM = 0;
    public static int APPEAR_ANIM = 1;
    public static String HAS_FINISHED_CALLING_ROLL = "finish";
    public static String FINISHED_UPDATE_DATA = "finished_update_data";
    public static String CALLING_ROLL_BACK = "call_roll_back";

    public static void setToolbar(Toolbar mToolbar, ActionBarActivity activity) {
        activity.setSupportActionBar(mToolbar);
        mToolbar.setTitleTextColor(activity.getResources().getColor(R.color.white));
        mToolbar.setTitle(activity.getTitle());
        activity.setSupportActionBar(mToolbar);
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    public static int getRandomNumber(int allNumber) {
        return (int) (Math.random() * allNumber);
    }

    public static ObjectAnimator scaleAnim(long duration, View view, int from, int to, int type) {
        PropertyValuesHolder propertyValuesHolderX = PropertyValuesHolder.ofFloat("scaleX", from, to);
        PropertyValuesHolder propertyValuesHolderY = PropertyValuesHolder.ofFloat("scaleY", from, to);
        Interpolator interpolator = null;
        if (APPEAR_ANIM == type) {
            interpolator = new OvershootInterpolator();
        } else if (FADE_ANIM == type) {
            interpolator = new AnticipateInterpolator();
        }
        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(view, propertyValuesHolderX, propertyValuesHolderY).setDuration(duration);
        animator.setInterpolator(interpolator);
        return animator;
    }

    public static ObjectAnimator moveAnim(long duration, View view, float from, float to, int type, String s) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, s, from, to);
        Interpolator interpolator = null;
        animator.setDuration(duration);
        if (APPEAR_ANIM == type) {
            interpolator = new OvershootInterpolator();
        } else if (FADE_ANIM == type) {
            interpolator = new AnticipateInterpolator();
        }
        animator.setInterpolator(interpolator);
        return animator;
    }


}
