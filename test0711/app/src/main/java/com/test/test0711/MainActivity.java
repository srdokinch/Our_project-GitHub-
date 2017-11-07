package com.test.test0711;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public void b0(View v){
        ((ImageView) findViewById(R.id.back)).setImageResource(R.drawable.b0);
    }

    public void b1(View v){
        ((ImageView) findViewById(R.id.back)).setImageResource(R.drawable.b1);
    }

    public void b2(View v){
        ((ImageView) findViewById(R.id.back)).setImageResource(R.drawable.b2);
    }

    public void right(View v){
        ((ImageView) findViewById(R.id.back)).setImageResource(R.drawable.b5);
    }

    public void left(View v){
        ((ImageView) findViewById(R.id.back)).setImageResource(R.drawable.b4);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
