package com.test.draganddrop;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final View.OnTouchListener moving = new View.OnTouchListener() {

            private float downX;
            private float downY;

            private int downLeftMargin;
            private int downTopMargin;

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                // ViewGroup.MarginLayoutParamsでキャストすることで
                // FrameLayoutの子要素であっても同様に扱える。
                final ViewGroup.MarginLayoutParams param =
                        (ViewGroup.MarginLayoutParams)v.getLayoutParams();

                if( event.getAction() == MotionEvent.ACTION_DOWN ){

                    downX = event.getRawX();
                    downY = event.getRawY();

                    downLeftMargin = param.leftMargin;
                    downTopMargin = param.topMargin;

                    return true;
                }
                else if( event.getAction() == MotionEvent.ACTION_MOVE){

                    param.leftMargin = downLeftMargin + (int)(event.getRawX() - downX);
                    param.topMargin = downTopMargin + (int)(event.getRawY() - downY);

                    v.layout(
                            param.leftMargin,
                            param.topMargin,
                            param.leftMargin + v.getWidth(),
                            param.topMargin + v.getHeight());

                    return true;
                }

                return false;
            }
        };

        // 別々のViewに、同じリスナをセットしておく
        findViewById(R.id.myView2).setOnTouchListener(moving);
        findViewById(R.id.myView3).setOnTouchListener(moving);
    }
}

