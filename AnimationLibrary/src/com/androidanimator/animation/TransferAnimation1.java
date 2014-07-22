package com.androidanimator.animation;

import android.view.View;
import android.view.ViewGroup;

/**
 * The TransferAnimation1 transfers the view to another view provided by the
 * user through scaling and translation.
 * 
 * @author SiYao
 * 
 */
public class TransferAnimation1 extends Animation {

	View destinationView;
	ViewGroup parentView;
	int transX, transY;
	
	public TransferAnimation1(View destinationView) {
		this.destinationView = destinationView;
	}
	
	@Override
	public void animate(final View view) {
		parentView = (ViewGroup) view.getParent();		
		final ViewGroup rootView = (ViewGroup) view.getRootView();
		while (!parentView.equals(rootView)) {
			parentView.setClipChildren(false);
			parentView = (ViewGroup) parentView.getParent();
		}
		rootView.setClipChildren(false);
		
		final float scaleX = (float) destinationView.getWidth() / ((float) view.getWidth()),
				scaleY = (float) destinationView.getHeight() / ((float) view.getHeight());
		int[] locationDest = new int[2], locationView = new int[2];
		view.getLocationOnScreen(locationView);
		destinationView.getLocationOnScreen(locationDest);
		transX = locationDest[0] - locationView[0];
		transY = locationDest[1] - locationView[1];
		transX = transX - view.getWidth()/2 + destinationView.getWidth()/2;
		transY = transY - view.getHeight()/2 + destinationView.getHeight()/2;

		view.animate().scaleX(scaleX).scaleY(scaleY).translationX(transX).translationY(transY).setDuration(duration).withEndAction(new Runnable() {
			
			@Override
			public void run() {
				view.animate().scaleX(1).scaleY(1).translationXBy(-transX).translationYBy(-transY);
			}
		});
	}
}
