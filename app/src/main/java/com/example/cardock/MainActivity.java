package com.example.cardock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    Animation top_animation,bot_animation;

    public static int time_out = 5000;

    ImageView image;

    TextView text, text_2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        // Create Hooks

        image = findViewById(R.id.imageView);

        text = findViewById(R.id.textView2);

        text_2 = findViewById(R.id.textView3);

        // Apply animations to Page

        top_animation  = AnimationUtils.loadAnimation(this,R.anim.top_animation);

        bot_animation  = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        // Assign animations to elements

        image.setAnimation(top_animation);

        text.setAnimation(bot_animation);

        text_2.setAnimation(bot_animation);

        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                Intent intent = new Intent(MainActivity.this,Login.class);

                startActivity(intent);

                finish();
            }
        },time_out);
    }
}