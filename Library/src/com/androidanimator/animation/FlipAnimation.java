package com.androidanimator.animation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;

public class FlipAnimation extends Animation {

    AnimatorSet flipSet;
    int oritention;
    int type;

    public FlipAnimation(int type, int oritention, AnimationListener listener, long duration) {
        super(listener, duration);
        flipSet = new AnimatorSet();
        this.oritention = oritention;
        this.type = type;
    }

    public FlipAnimation() {
        super();
        flipSet = new AnimatorSet();
        oritention = Constant.VERTICAL;
        type = Constant.OUT;
    }

    @Override
    public void animate(View v) {
        ObjectAnimator rotate;
        ObjectAnimator scale;
        int fromValueRotate, toValueRotate, fromValueScale, toValueScale;
        if (type == Constant.IN) {
            fromValueRotate = 90;
            toValueRotate = 0;
            fromValueScale = 0;
            toValueScale = 1;
        } else {
            fromValueRotate = 0;
            toValueRotate = 90;
            fromValueScale = 1;
            toValueScale = 0;
        }
        if (oritention == Constant.VERTICAL) {
            rotate = ObjectAnimator.ofFloat(v, View.ROTATION_X, fromValueRotate, toValueRotate);
            scale = ObjectAnimator.ofFloat(v, View.SCALE_Y, fromValueScale, toValueScale);
        } else {
            rotate = ObjectAnimator.ofFloat(v, View.ROTATION_Y, fromValueRotate, toValueRotate);
            scale = ObjectAnimator.ofFloat(v, View.SCALE_X, fromValueScale, toValueScale);

        }
        flipSet.playTogether(rotate, scale);
        flipSet.setDuration(getDuration());
        if (getListener() != null) {
            flipSet.addListener(new AnimatorListener() {

                @Override
                public void onAnimationStart(Animator animation) {
                    // TODO Auto-generated method stub

                }

                @Override
                public void onAnimationRepeat(Animator animation) {
                    // TODO Auto-generated method stub

                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    getListener().onAnimationEnd(FlipAnimation.this);
                }

                @Override
                public void onAnimationCancel(Animator animation) {
                    // TODO Auto-generated method stub

                }
            });
        }
        flipSet.start();
    }

}