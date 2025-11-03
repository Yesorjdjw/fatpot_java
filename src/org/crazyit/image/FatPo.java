package org.crazyit.image;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;


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
    public class FatPo extends Activity
    {
    	int timenum=1;
    	
    	@Override
    	
    	public void onCreate(Bundle savedInstanceState)
    	{
    		super.onCreate(savedInstanceState);
    		setContentView(R.layout.main);
    		// ȡť
    		Button play = (Button) findViewById(R.id.play);
    		Button stop = (Button) findViewById(R.id.stop);
    		Button dazhao = (Button) findViewById(R.id.dazhao);
    		
    		final ImageView imageView = (ImageView) findViewById(R.id.anim);
    		// ȡAnimationDrawable
    		final AnimationDrawable anim = (AnimationDrawable) imageView
    				.getBackground();
    		play.setOnClickListener(new OnClickListener()
    		{
    			@Override
    			public void onClick(View v)
    			{
    				// ʼŶ
    				anim.start();
    			}
    		});
    		stop.setOnClickListener(new OnClickListener()
    		{
    			@Override
    			public void onClick(View v)
    			{
    				// ֹͣŶ
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