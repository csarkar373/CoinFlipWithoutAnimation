package com.westhillcs.coinanimation;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.SurfaceHolder;

import java.util.Random;

/**
 * Created by Chandan on 8/15/2016.
 */

public class CoinView extends SurfaceView implements SurfaceHolder.Callback {
    SurfaceHolder mHolder;
    Sprite mCoin;
    Bitmap mCoinBitmap, mHeadsBitmap, mTailsBitmap, mCurrentDrawingBitmap;

    public CoinView(Context context) {
        super(context);
        this.init();
    }

    public CoinView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.init();
    }

    public CoinView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.init();
    }



    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        // force a redraw
        this.invalidate();
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2){ /* not used */ }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) { /* not used  */   }

    private void init() {
        mHolder = getHolder();
        mCoinBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.coinsprites);
        mHeadsBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.headsindian);
        mTailsBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.tailsindian);
        mCurrentDrawingBitmap = mHeadsBitmap;
        mCoin = new Sprite(this, mCoinBitmap);

    }

    public MainActivity.Result flip() {
        double _random = Math.random();
        MainActivity.Result _result = (_random < 0.5)?
                MainActivity.Result.HEADS : MainActivity.Result.TAILS;
        mCurrentDrawingBitmap = (_result == MainActivity.Result.HEADS) ?
                mHeadsBitmap : mTailsBitmap;
        Canvas _canvas = this.mHolder.lockCanvas();
        _canvas.drawARGB(255, 200, 200, 255);
        _canvas.drawBitmap(mCurrentDrawingBitmap, 100, 100, null);
        mHolder.unlockCanvasAndPost(_canvas);
        return _result;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }
}
