package com.saikalyandaroju.customviews.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.saikalyandaroju.customviews.R;

public class CustomView extends View {

    private Rect rect;
    private Paint paint;
    int color;
    int size;

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
    }
}
