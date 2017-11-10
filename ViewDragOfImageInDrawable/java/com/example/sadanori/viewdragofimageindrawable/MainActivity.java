package com.example.sadanori.viewdragofimageindrawable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView dragView = (ImageView) findViewById(R.id.imageView);

        ViewDragListener listener = new ViewDragListener(dragView);
        dragView.setOnTouchListener(listener);

    }
}


