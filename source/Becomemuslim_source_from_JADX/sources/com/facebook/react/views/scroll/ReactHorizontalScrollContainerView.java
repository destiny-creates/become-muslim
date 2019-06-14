package com.facebook.react.views.scroll;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import com.facebook.react.modules.i18nmanager.I18nUtil;

public class ReactHorizontalScrollContainerView extends ViewGroup {
    private int mCurrentWidth = null;
    private int mLayoutDirection;

    public ReactHorizontalScrollContainerView(Context context) {
        super(context);
        this.mLayoutDirection = I18nUtil.getInstance().isRTL(context);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.mLayoutDirection) {
            i3 = (i3 - i) + 0;
            setLeft(0);
            setRight(i3);
            HorizontalScrollView horizontalScrollView = (HorizontalScrollView) getParent();
            horizontalScrollView.scrollTo((horizontalScrollView.getScrollX() + getWidth()) - this.mCurrentWidth, horizontalScrollView.getScrollY());
        }
        this.mCurrentWidth = getWidth();
    }
}
