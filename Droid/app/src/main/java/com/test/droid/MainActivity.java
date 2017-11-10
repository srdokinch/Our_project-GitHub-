package com.test.droid;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class MainActivity extends Activity
        implements OnTouchListener, OnClickListener {

    private FrameLayout frameLayout01;
    private ImageView target;
    private ImageView target1;
    private Button trash;

    public int targetLocalX;
    public int targetLocalY;

    public int targetLocalX1;
    public int targetLocalY1;

    public int screenX;
    public int screenY;

    public int screenX1;
    public int screenY1;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayout01 = (FrameLayout)findViewById(R.id.FrameLayout01);

        target = (ImageView)findViewById(R.id.ImageView01);
        target.setOnTouchListener(this);

        target1 = (ImageView)findViewById(R.id.ImageView02);
        target1.setOnTouchListener(this);

        trash = (Button)findViewById(R.id.trash);
        trash.setOnClickListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        int x = (int)event.getRawX();
        int y = (int)event.getRawY();

        int x1 = (int)event.getRawX();
        int y1 = (int)event.getRawY();

        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:

                targetLocalX = target.getLeft();
                targetLocalY = target.getTop();

                targetLocalX1 = target1.getLeft();
                targetLocalY1 = target1.getTop();

                screenX = x;
                screenY = y;

                screenX1 = x1;
                screenY1 = y1;

                break;

            case MotionEvent.ACTION_MOVE:

                int diffX = screenX - x;
                int diffY = screenY - y;

                int diffX1 = screenX1 - x1;
                int diffY1 = screenY1 - y1;

                targetLocalX -= diffX;
                targetLocalY -= diffY;

                targetLocalX1 -= diffX1;
                targetLocalY1 -= diffY1;

                target.layout(targetLocalX,
                        targetLocalY,
                        targetLocalX + target.getWidth(),
                        targetLocalY + target.getHeight());

                target1.layout(targetLocalX1,
                        targetLocalY1,
                        targetLocalX1 + target1.getWidth(),
                        targetLocalY1 + target1.getHeight());

                screenX = x;
                screenY = y;

                screenX1 = x1;
                screenY1 = y1;

                break;

            case MotionEvent.ACTION_UP:

                int trashLeft    = trash.getLeft() + trash.getWidth()/2;
                int trashTop     = trash.getTop()  + trash.getHeight()/2;

                int targetRight  = target.getLeft() + target.getWidth();
                int targetBottom = target.getTop() + target.getHeight();

                int targetRight1  = target1.getLeft() + target1.getWidth();
                int targetBottom1 = target1.getTop() + target1.getHeight();

                if (targetRight > trashLeft && targetBottom > trashTop) {
                    frameLayout01.removeView(target);
                }

                if (targetRight1 > trashLeft && targetBottom1 > trashTop) {
                    frameLayout01.removeView(target1);
                }
                break;
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        int childCount = frameLayout01.getChildCount();
        if(childCount == 1) {
            frameLayout01.addView(target);
        }
    }
}