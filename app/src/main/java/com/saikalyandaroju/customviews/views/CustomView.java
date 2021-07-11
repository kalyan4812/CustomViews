package com.saikalyandaroju.customviews.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import com.saikalyandaroju.customviews.R;

public class CustomView extends View {

    private Rect rect;
    private Paint paint;
    int color;
    int size;

    private float circleX, circleY;
    private float radius = 100f;

    public CustomView(Context context) {
        super(context);
        init(null);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }


    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        rect = new Rect();
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        if (attrs != null) {
            TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.CustomView);
            color = typedArray.getColor(R.styleable.CustomView_square_color, Color.BLACK);
            size = typedArray.getDimensionPixelSize(R.styleable.CustomView_square_size, 130);
            paint.setColor(color);
            typedArray.recycle();

        }
    }

    public void changeColor() {
        paint.setColor(paint.getColor() == color ? Color.RED : color);
        // invalidate(); synchrounous.
        postInvalidate(); //aysnchrounous.
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        rect.left = 60;
        rect.top = 60;
        rect.bottom = rect.top + size;
        rect.right = rect.left + size;

        canvas.drawRect(rect, paint);
        if (circleX == 0 || circleY == 0) {
            circleX = getWidth() / 2;
            circleY = getHeight() / 2;
        }
        canvas.drawCircle(circleX, circleY, radius, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        boolean value = super.onTouchEvent(event);
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            float sx = event.getX();
            float sy = event.getY();
            if (rect.left < sx && rect.right > sx && rect.top < sy && rect.bottom > sy) {
                radius = radius + 10f;
                postInvalidate();
                return true;
            }
        } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
            Log.i("check", "ist a move");
            float x = event.getX();
            float y = event.getY();
            // checking whteher user touched coordinate is on/inside the circle or not.
            double dx = Math.pow(x - circleX, 2);
            double dy = Math.pow(y - circleY, 2);
            if (dx + dy < Math.pow(radius, 2)) {
                circleX = x;
                circleY = y;
                postInvalidate();
                return true;
            }

        }

        return value;


    }
}
