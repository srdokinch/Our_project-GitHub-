package com.example.sadanori.viewdragofimageindrawable;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class ViewDragListener implements View.OnTouchListener {
    // ドラッグ対象のView
    private ImageView viewDrag;
    // ドラッグ中に移動量を取得するための変数
    private int oldx;
    private int oldy;

    public ViewDragListener(ImageView viewDrag) {
        this.viewDrag = viewDrag;
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        //Viewの幅と高さ
        int vw = viewDrag.getWidth();
        int vh = viewDrag.getHeight();

        //ドラッグ開始時点でのViewの位置
        int x_origin =	viewDrag.getLeft() ;
        int y_origin =	viewDrag.getTop() ;

        // ドラッグしているViewの位置取得
        int x = (int) event.getRawX();
        int y = (int) event.getRawY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:

                //ドラッグ動作中のViewの変位
                int xDelta = x - oldx;
                int yDelta = y - oldy;

                // 今回イベントでのView移動先の位置
                int left = x_origin + xDelta;
                int top  = y_origin + yDelta;

                // Viewを移動する
                viewDrag.layout(left, top, left + vw, top + vh);

                break;
        }

        // 今回のドラッグ終了時のView位置を保持
        oldx = x;
        oldy = y;
        // イベント処理完了
        return true;
    }
}