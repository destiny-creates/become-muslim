package com.facebook.drawee.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import com.facebook.common.internal.VisibleForTesting;
import java.lang.ref.WeakReference;

public class RoundedBitmapDrawable extends RoundedDrawable {
    private final Bitmap mBitmap;
    private final Paint mBorderPaint;
    private WeakReference<Bitmap> mLastBitmap;
    private final Paint mPaint;

    public RoundedBitmapDrawable(Resources resources, Bitmap bitmap, Paint paint) {
        super(new BitmapDrawable(resources, bitmap));
        this.mPaint = new Paint();
        this.mBorderPaint = new Paint(1);
        this.mBitmap = bitmap;
        if (paint != null) {
            this.mPaint.set(paint);
        }
        this.mPaint.setFlags(1);
        this.mBorderPaint.setStyle(Style.STROKE);
    }

    public RoundedBitmapDrawable(Resources resources, Bitmap bitmap) {
        this(resources, bitmap, null);
    }

    public void draw(Canvas canvas) {
        if (shouldRound()) {
            updateTransform();
            updatePath();
            updatePaint();
            int save = canvas.save();
            canvas.concat(this.mInverseParentTransform);
            canvas.drawPath(this.mPath, this.mPaint);
            if (this.mBorderWidth > 0.0f) {
                this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
                this.mBorderPaint.setColor(DrawableUtils.multiplyColorAlpha(this.mBorderColor, this.mPaint.getAlpha()));
                canvas.drawPath(this.mBorderPath, this.mBorderPaint);
            }
            canvas.restoreToCount(save);
            return;
        }
        super.draw(canvas);
    }

    private void updatePaint() {
        if (this.mLastBitmap == null || this.mLastBitmap.get() != this.mBitmap) {
            this.mLastBitmap = new WeakReference(this.mBitmap);
            this.mPaint.setShader(new BitmapShader(this.mBitmap, TileMode.CLAMP, TileMode.CLAMP));
            this.mIsShaderTransformDirty = true;
        }
        if (this.mIsShaderTransformDirty) {
            this.mPaint.getShader().setLocalMatrix(this.mTransform);
            this.mIsShaderTransformDirty = false;
        }
    }

    public static RoundedBitmapDrawable fromBitmapDrawable(Resources resources, BitmapDrawable bitmapDrawable) {
        return new RoundedBitmapDrawable(resources, bitmapDrawable.getBitmap(), bitmapDrawable.getPaint());
    }

    @VisibleForTesting
    boolean shouldRound() {
        return super.shouldRound() && this.mBitmap != null;
    }

    public void setAlpha(int i) {
        super.setAlpha(i);
        if (i != this.mPaint.getAlpha()) {
            this.mPaint.setAlpha(i);
            super.setAlpha(i);
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
        this.mPaint.setColorFilter(colorFilter);
    }

    Paint getPaint() {
        return this.mPaint;
    }
}
