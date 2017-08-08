package com.su.androidsample.animation;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.animation.ValueAnimatorCompat;
import android.view.View;

/**
 * It is used to show an animation like loading dialog.
 * <p>
 * Created by Clever Su on 8/1/2017.
 */

public class AnimationLoadingActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public class MyAnimationView extends View implements ValueAnimator.AnimatorUpdateListener {

        public MyAnimationView(Context context) {
            super(context);
        }

        @Override
        public void onAnimationUpdate(ValueAnimator animation) {

        }
    }
}
