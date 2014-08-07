AndroidAnimator
===============

AndroidAnimator library aims to simplify various animations for any provided view for Android developers in a single JAR file.

Developers are able to easily animate a specific view with a single line of code using either the default parameters or customize them to their own liking.


Usage
=====

*See `sample/` folder for a working implementation of this library.*

  1. For example, if you wanted a view to mimic the bounce animation with the default parameters,
  ```
    new BounceAnimation(yourView).animate();
  ```

  2. If you wanted to use some of your own parameters instead of the default ones,
  ```
    new BounceAnimation(yourView)
      .setBounceDistance(50)
      .setBounces(5)
      .setDuration(500)
      .animate();
  ```

  3. Here's another example of mimicking the explode animation with your own parameters as well as the addition of an animation listener.
  ```
    new ExplodeAnimation(yourView)
      .setExplodeMatrix(ExplodeAnimation.MATRIX_2X2)
      .setDuration(500)
      .setListener(new AnimationListener() {
        @Override
        public void onAnimationEnd(Animation animation) {
          *perform your own functions here when animation ends*
        }
      })
      .animate();
  ```

  4. It is also possible to play several animations in parallel using the `ParallelAnimator` class. The following example scales in a view and flips it horizontally at the same time.
  ```
    new ParallelAnimator()
      .add(new ScaleInAnimation(yourView))
      .add(new FlipHorizontalAnimation(yourView))
      .setDuration(500)
      .animate();
  ```


Including In Your Project
-------------------------

AndroidAnimator library is presented as a standalone JAR file.

You can include this library by downloading the JAR file into the `libs` folder located in your Android project folder.


Developed By
============

 * Umair Vatao
 * Phu Tang - <phu.tanghong@2359media.com.vn>
 * Nee Si Yao - [LinkedIn](http://sg.linkedin.com/pub/si-yao-nee/7a/a62/203/)
