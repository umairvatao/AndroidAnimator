package com.androidanimator.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * The SlideInUnderneathAnimation causes the view to slide in underneath from
 * the left, right, up or down depending on the parameters provided by the user.
 * 
 * @author SiYao
 * 
 */
public class SlideInUnderneathAnimation extends Animation {
	
	int direction;
	ObjectAnimator slideInAnim;
	
	public SlideInUnderneathAnimation() {
		direction = Constant.DIRECTION_LEFT;
		duration = Constant.DEFAULT_DURATION;
	}
	
	public SlideInUnderneathAnimation(int direction, long duration, AnimationListener listener) {
		this.direction = direction;
		this.duration = duration;
		this.listener = listener;
	}

	@Override
	public void animate(final View view) {
		final ViewGroup parentView = (ViewGroup) view.getParent();
		final FrameLayout slideInFrame = new FrameLayout(view.getContext());
		final int positionView = parentView.indexOfChild(view);
		slideInFrame.setLayoutParams(view.getLayoutParams());
		slideInFrame.setClipChildren(true);
		parentView.removeView(view);
		slideInFrame.addView(view);
		parentView.addView(slideInFrame, positionView);
		
		switch (direction) {
		case Constant.DIRECTION_LEFT:
			slideInAnim = ObjectAnimator.ofFloat(view, View.X, -view.getWidth(), slideInFrame.getX());
			break;
		case Constant.DIRECTION_RIGHT:
			slideInAnim = ObjectAnimator.ofFloat(view, View.X, view.getWidth(), slideInFrame.getX());
			break;
		case Constant.DIRECTION_UP:
			slideInAnim = ObjectAnimator.ofFloat(view, View.Y, -view.getHeight(), slideInFrame.getY());
			break;
		case Constant.DIRECTION_DOWN:
			slideInAnim = ObjectAnimator.ofFloat(view, View.Y, view.getHeight(), slideInFrame.getY());
			break;
		default:
			break;
		}
		view.setVisibility(View.VISIBLE);
		slideInAnim.setDuration(duration);
		slideInAnim.start();
		slideInAnim.addListener(new AnimatorListenerAdapter() {

			@Override
			public void onAnimationEnd(Animator animation) {
				slideInFrame.removeAllViews();
				view.setLayoutParams(slideInFrame.getLayoutParams());
				parentView.addView(view, positionView);
				if (getListener() != null) {
					getListener().onAnimationEnd(SlideInUnderneathAnimation.this);
				}
			}
		});
	}

}