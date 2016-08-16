package com.westhillcs.coinanimation;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;

/**
 * Created by Chandan on 8/15/2016.
 */

public class Sprite {

    CoinView mCoinView;
    Bitmap mSelf;
   // int mHeight, mWidth;

    public Sprite(CoinView coinView, Bitmap self) {
        mCoinView = coinView;
        mSelf = self;
        //  mHeight = self.getHeight();
       // mWidth = self.getWidth();
    }

    public void updateAnimation() {

    }

    public void onDraw(Canvas canvas) {
        this.updateAnimation();
        this.onDraw(canvas, mSelf);
    }

    public void onDraw(Canvas canvas, Bitmap bitmap) {
        int _x = canvas.getWidth();
        int _y = canvas.getHeight();
        Rect _src = new Rect(100, 100, bitmap.getWidth(), bitmap.getHeight());
        Rect _dst = new Rect(_x, _y, _x + bitmap.getWidth(), _y + bitmap.getHeight());
        canvas.drawBitmap(bitmap, _src, _dst, null);
    }



}
