package com.fighting.materialmanagementsystem.views;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by laisixiang on 2015/12/28.
 */
public class IconFontView extends TextView {

    public IconFontView(Context context) {
        super(context);
    }

    public IconFontView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public IconFontView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        Typeface iconfont = Typeface.createFromAsset(getContext().getAssets(), "iconfont.ttf");
        this.setTypeface(iconfont);
    }
}
