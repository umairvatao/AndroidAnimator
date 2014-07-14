package com.media2359.animation.libs;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;

public class ScaleAnimation extends Animation {
    AnimatorSet scaleAnimatorSet;

    public ScaleAnimation() {
        scaleAnimatorSet = new AnimatorSet();
    }

    @Override
    public void performAnimation(View v) {
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(v, Constant.SCALE_X, 1f, 0f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(v, Constant.SCALE_Y, 1f, 0f);
        ObjectAnimator alphaA = ObjectAnimator.ofFloat(v, Constant.ALPHA, 1f, 0f);
        AnimatorSet scale = new AnimatorSet();
        scale.playTogether(scaleX, scaleY);
        scaleAnimatorSet.playSequentially(scale, alphaA);
        scaleAnimatorSet.setDuration(getDuration());
        if (getListener() != null) {
            scaleAnimatorSet.addListener(getListener());
        }
        scaleAnimatorSet.start();
    }

    @Override
    public void cancel(View v) {
        scaleAnimatorSet.cancel();
    }

    @Override
    public void reset(View v) {
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(v, Constant.SCALE_X, 1f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(v, Constant.SCALE_Y, 1f);
        ObjectAnimator alphaA = ObjectAnimator.ofFloat(v, Constant.ALPHA, 1f);
        AnimatorSet scale = new AnimatorSet();
        scale.playTogether(scaleX, scaleY, alphaA);
        scale.start();
    }

}