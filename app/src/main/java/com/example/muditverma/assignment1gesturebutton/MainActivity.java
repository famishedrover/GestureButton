package com.example.muditverma.assignment1gesturebutton;


import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.support.v4.view.GestureDetectorCompat;
import android.view.MotionEvent;

//3 steps ..
// 1. Create A Layout
// 2. Then, Add button container attach to mButton and change text whenever clicked
// 3. Then, Add Gesture Detector

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener{

    private TextView mText;
    private GestureDetectorCompat gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mText = (TextView)findViewById(R.id.mText);

        //Button
        Button mButton = (Button)findViewById(R.id.mButton);

        mButton.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick (View v)
                    {

                        mText.setText(R.string.Bmtext);

                    }
                }
        );



        this.gestureDetector  = new GestureDetectorCompat(this,this);
        gestureDetector.setOnDoubleTapListener(this);
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        mText.setText(R.string.onSingleTapConfirmedmText);
        mText.setTextColor(Color.RED);
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        mText.setText(R.string.onDoubleTapmText);
        mText.setTextColor(Color.BLUE);
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        mText.setText(R.string.onDoubleTapEventmText);
        mText.setTextColor(Color.GREEN);
        return true;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        mText.setText(R.string.onDownmText);
        mText.setTextColor(Color.YELLOW);
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        mText.setText(R.string.onShowPressmText);
        mText.setTextColor(Color.CYAN);
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        mText.setText(R.string.onSingleTapmText);
        mText.setTextColor(Color.DKGRAY);
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        mText.setText(R.string.onScrollmText);
        mText.setTextColor(Color.BLACK);
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        mText.setText(R.string.onLongPressmText);
        mText.setTextColor(Color.MAGENTA);

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        mText.setText(R.string.onFlingmText);
        mText.setTextColor(Color.rgb(10,0,77));
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
}

