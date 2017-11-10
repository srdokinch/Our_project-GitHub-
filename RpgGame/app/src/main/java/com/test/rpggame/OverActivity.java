package com.test.rpggame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class OverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_over);
    }

    public void onButton3(View v) {
        Intent intent = new Intent(this, PlayActivity.class);
        startActivity(intent);
    }

}
