package com.example.luct.marqueedemo.view;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * Created by jiangpp on 2017/2/16.
 */

public class SystemMarqueeTextView extends AppCompatTextView {
    public SystemMarqueeTextView(Context context) {
        super(context);
    }

    public SystemMarqueeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SystemMarqueeTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean isFocused() {
        return true;
    }

    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {

    }
}
