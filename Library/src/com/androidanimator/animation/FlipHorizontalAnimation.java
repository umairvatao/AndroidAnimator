package com.androidanimator.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;

public class FlipHorizontalAnimation extends Animation {

	public static final int PIVOT_CENTER = 0, PIVOT_LEFT = 1, PIVOT_RIGHT = 2;

	float degrees;
	int pivotPosition;
	long duration;
	AnimationListener listener;

	public FlipHorizontalAnimation() {
		degrees = 360;
		pivotPosition = PIVOT_CENTER;
		duration = Animation.DEFAULT_DURATION;
		listener = null;
	}

	@Override
	public void animate(View view) {
		ViewGroup parentView = (ViewGroup) view.getParent(), rootView = (ViewGroup) view
				.getRootView();
		while (parentView != rootView) {
			parentView.setClipChildren(false);
			parentView = (ViewGroup) parentView.getParent();
		}
		rootView.setClipChildren(false);

		float pivotX, pivotY, viewWidth = view.getWidth(), viewHeight = view
				.getHeight();
		switch (pivotPosition) {
		case PIVOT_LEFT:
			pivotX = 0f;
			pivotY = viewHeight / 2;
			break;
		case PIVOT_RIGHT:
			pivotX = viewWidth;
			pivotY = viewHeight / 2;
			break;
		default:
			pivotX = viewWidth / 2;
			pivotY = viewHeight / 2;
			break;
		}
		view.setPivotX(pivotX);
		view.setPivotY(pivotY);

		view.animate().rotationYBy(degrees).setDuration(duration)
				.setListener(new AnimatorListenerAdapter() {

					@Override
					public void onAnimationEnd(Animator animation) {
						if (getListener() != null) {
							getListener().onAnimationEnd(
									FlipHorizontalAnimation.this);
						}
					}
				});
	}

	/**
	 * @return the degrees
	 */
	public float getDegrees() {
		return degrees;
	}

	/**
	 * @param degrees the degrees to set
	 */
	public FlipHorizontalAnimation setDegrees(float degrees) {
		this.degrees = degrees;
		return this;
	}

	/**
	 * @return the pivotPosition
	 */
	public int getPivotPosition() {
		return pivotPosition;
	}

	/**
	 * @param pivotPosition the pivotPosition to set
	 */
	public FlipHorizontalAnimation setPivotPosition(int pivotPosition) {
		this.pivotPosition = pivotPosition;
		return this;
	}

	/**
	 * @return the duration
	 */
	public long getDuration() {
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public FlipHorizontalAnimation setDuration(long duration) {
		this.duration = duration;
		return this;
	}

	/**
	 * @return the listener
	 */
	public AnimationListener getListener() {
		return listener;
	}

	/**
	 * @param listener the listener to set
	 */
	public FlipHorizontalAnimation setListener(AnimationListener listener) {
		this.listener = listener;
		return this;
	}

}
