package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.NinePatchDrawable;

public class RoundedNinePatchDrawable extends RoundedDrawable {
    public RoundedNinePatchDrawable(NinePatchDrawable ninePatchDrawable) {
        super(ninePatchDrawable);
    }

    public void draw(Canvas canvas) {
        if (shouldRound()) {
            updateTransform();
            updatePath();
            canvas.clipPath(this.mPath);
            super.draw(canvas);
            return;
        }
        super.draw(canvas);
    }
}
