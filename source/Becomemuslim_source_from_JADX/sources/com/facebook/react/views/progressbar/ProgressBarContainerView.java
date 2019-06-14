package com.facebook.react.views.progressbar;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;

class ProgressBarContainerView extends FrameLayout {
    private static final int MAX_PROGRESS = 1000;
    private boolean mAnimating = true;
    private Integer mColor;
    private boolean mIndeterminate = true;
    private double mProgress;
    private ProgressBar mProgressBar;

    public ProgressBarContainerView(Context context) {
        super(context);
    }

    public void setStyle(String str) {
        this.mProgressBar = ReactProgressBarViewManager.createProgressBar(getContext(), ReactProgressBarViewManager.getStyleFromString(str));
        this.mProgressBar.setMax(1000);
        removeAllViews();
        addView(this.mProgressBar, new LayoutParams(-1, -1));
    }

    public void setColor(Integer num) {
        this.mColor = num;
    }

    public void setIndeterminate(boolean z) {
        this.mIndeterminate = z;
    }

    public void setProgress(double d) {
        this.mProgress = d;
    }

    public void setAnimating(boolean z) {
        this.mAnimating = z;
    }

    public void apply() {
        if (this.mProgressBar != null) {
            this.mProgressBar.setIndeterminate(this.mIndeterminate);
            setColor(this.mProgressBar);
            this.mProgressBar.setProgress((int) (this.mProgress * 1000.0d));
            if (this.mAnimating) {
                this.mProgressBar.setVisibility(0);
                return;
            } else {
                this.mProgressBar.setVisibility(8);
                return;
            }
        }
        throw new JSApplicationIllegalArgumentException("setStyle() not called");
    }

    private void setColor(ProgressBar progressBar) {
        if (progressBar.isIndeterminate()) {
            progressBar = progressBar.getIndeterminateDrawable();
        } else {
            progressBar = progressBar.getProgressDrawable();
        }
        if (progressBar != null) {
            if (this.mColor != null) {
                progressBar.setColorFilter(this.mColor.intValue(), Mode.SRC_IN);
            } else {
                progressBar.clearColorFilter();
            }
        }
    }
}
