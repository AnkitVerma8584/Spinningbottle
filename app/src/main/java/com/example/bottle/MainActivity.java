package com.example.bottle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView bottle;
    private Random random =new Random();
    private int lastDir;
    private boolean spinning;
    boolean t=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottle=findViewById(R.id.bottle);
        bottle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinBottle(v);
            }
        });
    }
    public void spinBottle(View V)
    {
        if(!spinning)
        {
            int newdir=random.nextInt(2000);
            float pivotX=bottle.getWidth()/2;
            float pivotY=bottle.getHeight()/2;

            Animation rotate=new RotateAnimation(lastDir,newdir,pivotX,pivotY);
            rotate.setDuration(3000);
            rotate.setFillAfter(true);
            rotate.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    spinning=true;
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    spinning=false;
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            lastDir=newdir;
            bottle.startAnimation(rotate);
        }
    }

    @Override
    public void onBackPressed() {
        if(t==true)
            finish();
        else
        {
            Toast.makeText(getApplicationContext(),"Press back again to exit",Toast.LENGTH_LONG).show();
            t=true;
        }
    }
}
