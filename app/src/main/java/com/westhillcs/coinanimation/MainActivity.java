package com.westhillcs.coinanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    CoinView mCoinView;
    Button b_flip;
    TextView tv_result;

    public static enum Result {
        HEADS, TAILS, EDGE
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.init();
    }

    private void init() {
        tv_result = (TextView)findViewById(R.id.result_tv);
        mCoinView = (CoinView)findViewById(R.id.view_cv);
        b_flip = (Button) findViewById(R.id.flip_b);
        b_flip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Result _result = mCoinView.flip();
                // update the label on the phone screen to show result
                tv_result.setText(_result.name());
            }
        });
    }
}
