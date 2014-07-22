package com.androidanimator.animation;

import android.animation.Animator.AnimatorListener;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;

/**
 * @author phutang
 * 
 */
public class FadeAnimation extends Animation {
    ObjectAnimator anim;
    int type;

    public FadeAnimation() {
        anim = new ObjectAnimator();
        type = Constant.OUT;
    }

    /**
     * 
     * @param listener
     * @param duration
     * @param type
     */
    public FadeAnimation(AnimationListener listener, long duration, int type) {
        super(listener, duration);
        anim = new ObjectAnimator();
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public void animate(View v) {

        getAnimatorSet(v).start();
    }

    @Override
    public AnimatorSet getAnimatorSet(View v) {
        if (type == Constant.OUT) {
            anim = ObjectAnimator.ofFloat(v, Constant.ALPHA, v.getAlpha(), 0f);
        } else {
            anim = ObjectAnimator.ofFloat(v, Constant.ALPHA, 0f, 1f);
        }
        anim.setDuration(getDuration());
        if (getListener() != null) {
            anim.addListener(new AnimatorListener() {

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
                    // TODO Auto-generated method stub

                }

                @Override
                public void onAnimationCancel(Animator animation) {
                    getListener().onAnimationEnd(FadeAnimation.this);
                }
            });
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(anim);
        return animatorSet;
    }

}