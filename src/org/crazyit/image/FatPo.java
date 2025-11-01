package org.crazyit.image;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
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
                Button ultimate = (Button) findViewById(R.id.ultimate);

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
                                imageView.animate().cancel();
                                imageView.setTranslationX(0f);
                                imageView.setTranslationY(0f);
                                imageView.setScaleX(1f);
                                imageView.setScaleY(1f);
                        }
                });
                ultimate.setOnClickListener(new OnClickListener()
                {
                        @Override
                        public void onClick(View v)
                        {
                                imageView.animate()
                                                .translationXBy(imageView.getWidth())
                                                .translationYBy(-imageView.getHeight() / 3f)
                                                .scaleX(1.6f)
                                                .scaleY(1.6f)
                                                .setDuration(600)
                                                .start();
                        }
                });

        }
}
