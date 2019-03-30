package com.example.t00523108.animation;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.support.animation.FlingAnimation;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    Context context;
    Button playButton;
    Button muteButton;
    AnimationDrawable animation;
    ImageView animImage;
    Animation fadeAnimation, rotateAnimation, rotateCounterAnimation;

    int muteToggle;
    AnimationSet animationSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        mediaPlayer = MediaPlayer.create(context, R.raw.walkingonsunshine);
        animationSet = new AnimationSet(true);







        playButton = findViewById(R.id.playButton);
        muteButton = findViewById(R.id.muteButton);
        animImage = findViewById(R.id.animImage);



        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                playAudio();
                BitmapDrawable frame1 = (BitmapDrawable)getResources().getDrawable(R.drawable.frame01);
                BitmapDrawable frame2 = (BitmapDrawable)getResources().getDrawable(R.drawable.frame02);
                BitmapDrawable frame3 = (BitmapDrawable)getResources().getDrawable(R.drawable.frame03);
                BitmapDrawable frame4 = (BitmapDrawable)getResources().getDrawable(R.drawable.frame04);
                BitmapDrawable frame5 = (BitmapDrawable)getResources().getDrawable(R.drawable.frame05);
                BitmapDrawable frame6 = (BitmapDrawable)getResources().getDrawable(R.drawable.frame06);
                BitmapDrawable frame7 = (BitmapDrawable)getResources().getDrawable(R.drawable.frame07);
                BitmapDrawable frame8 = (BitmapDrawable)getResources().getDrawable(R.drawable.frame08);
                BitmapDrawable frame9 = (BitmapDrawable)getResources().getDrawable(R.drawable.frame09);
                BitmapDrawable frame10 = (BitmapDrawable)getResources().getDrawable(R.drawable.frame10);
                BitmapDrawable frame11 = (BitmapDrawable)getResources().getDrawable(R.drawable.frame11);
                BitmapDrawable frame12 = (BitmapDrawable)getResources().getDrawable(R.drawable.frame12);
                BitmapDrawable frame13 = (BitmapDrawable)getResources().getDrawable(R.drawable.frame13);
                BitmapDrawable frame14 = (BitmapDrawable)getResources().getDrawable(R.drawable.frame14);

                int reasonableDuration = 50;
                animation = new AnimationDrawable();
                animation.addFrame(frame1, reasonableDuration);
                animation.addFrame(frame2, reasonableDuration);
                animation.addFrame(frame3, reasonableDuration);
                animation.addFrame(frame4, reasonableDuration);
                animation.addFrame(frame5, reasonableDuration);
                animation.addFrame(frame6, reasonableDuration);
                animation.addFrame(frame7, reasonableDuration);
                animation.addFrame(frame8, reasonableDuration);
                animation.addFrame(frame9, reasonableDuration);
                animation.addFrame(frame10, reasonableDuration);
                animation.addFrame(frame11, reasonableDuration);
                animation.addFrame(frame12, reasonableDuration);
                animation.addFrame(frame13, reasonableDuration);
                animation.addFrame(frame14, reasonableDuration);

                animationSet = new AnimationSet(true);
                animationSet.setFillEnabled(true);
                animationSet.setInterpolator(new BounceInterpolator());

                fadeAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fadein);
                rotateAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotateclockwise);
                rotateCounterAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotatecounterclockwise);

                animationSet.addAnimation(fadeAnimation);
                animationSet.addAnimation(rotateAnimation);
                animationSet.addAnimation(rotateCounterAnimation);


               animImage.startAnimation(animationSet);


               animImage.setBackground(animation);
               animation.start();
               animation.setOneShot(false);

              // animation2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotateclockwise);
              // animImage.startAnimation(animation2);




                //add more here, do something cool

            }
        });

        muteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                muteAudio();
            }
        });

    }


    public void playAudio(){
        mediaPlayer.start();
        muteToggle = 1;

    }

    public void muteAudio(){
        if(muteToggle == 1){
            mediaPlayer.setVolume(0,0);
            muteToggle = 0;
        }
        else{
            mediaPlayer.setVolume(1, 1);
            muteToggle = 1;
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.pause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mediaPlayer.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.release();
        mediaPlayer = null;
    }
}
