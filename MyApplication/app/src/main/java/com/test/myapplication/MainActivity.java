package com.test.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ドラッグ対象Viewとイベント処理クラスを紐付ける
        ImageView dragView = (ImageView) findViewById(R.id.imageView1);
        DragViewListener listener = new DragViewListener(dragView);
        dragView.setOnTouchListener(listener);
    }
}
