package org.crazyit.image;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Description:
 * <br/>site: <a href="http://www.crazyit.org">crazyit.org</a>
 * <br/>Copyright (C), 2001-2014, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
@SuppressLint("NewApi")
public class FatPo extends Activity {
        int timenum = 1;
        private ImageView animImageView;

        @Override
        public void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.main);
                // Play button
                Button play = (Button) findViewById(R.id.play);
                Button stop = (Button) findViewById(R.id.stop);

                animImageView = (ImageView) findViewById(R.id.anim);
                // Obtain AnimationDrawable
                final AnimationDrawable anim = (AnimationDrawable) animImageView
                                .getBackground();
                play.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                // Start
                                anim.start();
                        }
                });
                stop.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                // Stop
                                anim.stop();
                        }
                });
        }

        public void dazhao(View view) {
                if (animImageView == null) {
                        return;
                }
                AnimationSet animationSet = new AnimationSet(true);
                animationSet.setDuration(600);
                animationSet.setFillAfter(true);

                float translationX = animImageView.getWidth();
                float translationY = -animImageView.getHeight() / 3f;

                TranslateAnimation translateAnimation = new TranslateAnimation(0,
                                translationX, 0, translationY);
                ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.6f, 1.0f,
                                1.6f, Animation.RELATIVE_TO_SELF, 0.5f,
                                Animation.RELATIVE_TO_SELF, 0.5f);

                animationSet.addAnimation(translateAnimation);
                animationSet.addAnimation(scaleAnimation);

                animImageView.startAnimation(animationSet);
        }
}
