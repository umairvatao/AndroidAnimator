package com.media2359.animation.libs;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;

public class SizeAnimation extends Animation {
    AnimatorSet sizeAnimatorSet;

    public SizeAnimation() {
        sizeAnimatorSet = new AnimatorSet();
    }

    @Override
    public void performAnimation(View v) {
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(v, Constant.SCALE_X, 1f, 0.5f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(v, Constant.SCALE_Y, 1f, 0.5f);
        ObjectAnimator alphaA = ObjectAnimator.ofFloat(v, Constant.ALPHA, 1f, 0f);
        AnimatorSet scale = new AnimatorSet();
        scale.playTogether(scaleX, scaleY);
        sizeAnimatorSet.playSequentially(scale, alphaA);
        sizeAnimatorSet.setDuration(getDuration());
        if (getListener() != null) {
            sizeAnimatorSet.addListener(getListener());
        }
        v.setPivotX(1f);
        v.setPivotY(1f);
        sizeAnimatorSet.start();
    }

    @Override
    public void cancel(View v) {
        sizeAnimatorSet.cancel();
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