package com.test.test0711;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public void right(View v){
        ((ImageView) findViewById(R.id.back)).setImageResource(R.drawable.shop);
    }

    public void left(View v){
        ((ImageView) findViewById(R.id.back)).setImageResource(R.drawable.warderobe);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
