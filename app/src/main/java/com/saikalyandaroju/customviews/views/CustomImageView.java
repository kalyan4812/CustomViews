package com.saikalyandaroju.customviews.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.saikalyandaroju.customviews.R;

public class CustomImageView extends ConstraintLayout {


    private ImageView imageView;
    private TextView textView;
    int width = 150, height = 150;

    public CustomImageView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs, context);
    }

    private void init(AttributeSet attrs, Context context) {
        inflate(context, R.layout.custom_layout, this);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomImageView);
        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView);
        imageView.setImageResource(typedArray.getResourceId(R.styleable.CustomImageView_image_ref, R.drawable.ic_baseline_android_24));
        textView.setText(typedArray.getString(R.styleable.CustomImageView_text));
        textView.setTextSize(typedArray.getDimensionPixelSize(R.styleable.CustomImageView_text_size, 20));
        width = typedArray.getDimensionPixelSize(R.styleable.CustomImageView_image_width, 150);
        height = typedArray.getDimensionPixelSize(R.styleable.CustomImageView_image_height, 150);

        setImageSize(imageView);


        typedArray.recycle();

    }


    public void setImageSize(ImageView imageView) {
        int widthdimensionInDp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, width, getResources().getDisplayMetrics());
        int heightdimensionInDp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, height, getResources().getDisplayMetrics());
        imageView.getLayoutParams().height = heightdimensionInDp;
        imageView.getLayoutParams().width = widthdimensionInDp;
        imageView.requestLayout();
    }

    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
        requestLayout();
    }

    public void setImageResource(int res) {
        imageView.setImageResource(res);
    }

    public void setText(String s) {
        textView.setText(s);
    }


    public String getText() {
        return textView.getText().toString();
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    /*
     * The parent may measure each child once with unspecified dimensions to find out
     * how big they want to be, then call measure() on them again with actual numbers if the sum
     * of all the children's unconstrained sizes is too big or too small (that is, if the children
     * don't agree among themselves as to how much space they each get, the parent will intervene
     * and set the rules on the second pass).
     * https://developer.android.com/guide/topics/ui/how-android-draws.html
     * */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    /*
     * Called by draw to draw the child views. This may be overridden by
     * derived classes to gain control just before its children are drawn
     * (but after its own view has been drawn).
     * */
    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }
      /*
    * The framework uses draw(Canvas) in its draw cycle. This is in the View code:
        Step 1: draw the background, if needed
        Step 2: save the canvas' layers
        Step 3: draw the content --- onDraw() comes here
        Step 4: draw the children
        Step 5: draw the fade effect and restore layers
        Step 6: draw the scrollbars
    * Useful tip
        You can render any view into an offscreen Bitmap you create, and later use this bitmap anywhere:
            Canvas c = new Canvas();
            c.setBitmap(myOffscreenBitmap);
            myView.draw(c);
    *
    * */

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }
    /*
     * For efficiency, layouts do not get their onDraw() method called.
     * To enable it, call setWillNotDrawEnabled(false)
     * https://groups.google.com/g/android-developers/c/oLccWfszuUo
     * */

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
