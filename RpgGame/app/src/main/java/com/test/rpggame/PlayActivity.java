package com.test.rpggame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AnimationUtils;

public class PlayActivity extends AppCompatActivity {

    MySound mySound = new MySound();    // ① 効果音準備

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        // アニメーション開始    //////////////////
        findViewById(R.id.cat).startAnimation(AnimationUtils.loadAnimation(this,R.anim.normal));


        // ② 効果音準備
        int[] mp3s = {
                R.raw.sound,
        };
        mySound.onCreate(this,mp3s); // ③ 効果音初期化
    }


    // クリック処理  /////////////////////////////
    public void onImg(View v){
        mySound.onPlay(0);  // ④ 効果音再生
        v.startAnimation(AnimationUtils.loadAnimation(this,R.anim.click));
    }


    // 終了処理 ///////////////////////////////////
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mySound.onDestroy();    // ⑤ 効果音終了
    }

    public void onButton2(View v) {
        Intent intent = new Intent(this, OverActivity.class);
        startActivity(intent);
    }
}
