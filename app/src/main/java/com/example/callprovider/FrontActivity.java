package com.example.callprovider;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FrontActivity extends AppCompatActivity {
    LinearLayout linearLayout;
    ImageView logo;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front);

        linearLayout=findViewById(R.id.layout1);
        logo=findViewById(R.id.imageView);
        title=findViewById(R.id.textView);

        Animation fadeIn= AnimationUtils.loadAnimation(this,R.anim.fade_in);
        title.startAnimation(fadeIn);


        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FrontActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}


