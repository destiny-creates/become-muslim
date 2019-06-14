package com.facebook.drawee.debug;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.drawee.debug.listener.ImageLoadingTimeListener;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;

public class DebugControllerOverlayDrawable extends Drawable implements ImageLoadingTimeListener {
    private static final float IMAGE_SIZE_THRESHOLD_NOT_OK = 0.5f;
    private static final float IMAGE_SIZE_THRESHOLD_OK = 0.1f;
    private static final int MAX_LINE_WIDTH_EM = 7;
    private static final int MAX_NUMBER_OF_LINES = 7;
    private static final int MAX_TEXT_SIZE_PX = 40;
    private static final int MIN_TEXT_SIZE_PX = 12;
    private static final String NO_CONTROLLER_ID = "none";
    private static final int OUTLINE_COLOR = -26624;
    private static final int OUTLINE_STROKE_WIDTH_PX = 2;
    @VisibleForTesting
    static final int OVERLAY_COLOR_IMAGE_ALMOST_OK = 1728026624;
    @VisibleForTesting
    static final int OVERLAY_COLOR_IMAGE_NOT_OK = 1727284022;
    @VisibleForTesting
    static final int OVERLAY_COLOR_IMAGE_OK = 1716301648;
    private static final int TEXT_COLOR = -1;
    private static final int TEXT_LINE_SPACING_PX = 8;
    private static final int TEXT_PADDING_PX = 10;
    private String mControllerId;
    private int mCurrentTextXPx;
    private int mCurrentTextYPx;
    private long mFinalImageTimeMs;
    private int mFrameCount;
    private int mHeightPx;
    private String mImageFormat;
    private String mImageId;
    private int mImageSizeBytes;
    private int mLineIncrementPx;
    private int mLoopCount;
    private final Matrix mMatrix = new Matrix();
    private final Paint mPaint = new Paint(1);
    private final Rect mRect = new Rect();
    private final RectF mRectF = new RectF();
    private ScaleType mScaleType;
    private int mStartTextXPx;
    private int mStartTextYPx;
    private int mTextGravity = 80;
    private int mWidthPx;

    public int getOpacity() {
        return -3;
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public DebugControllerOverlayDrawable() {
        reset();
    }

    public void reset() {
        this.mWidthPx = -1;
        this.mHeightPx = -1;
        this.mImageSizeBytes = -1;
        this.mFrameCount = -1;
        this.mLoopCount = -1;
        this.mImageFormat = null;
        setControllerId(null);
        this.mFinalImageTimeMs = -1;
        invalidateSelf();
    }

    public void setTextGravity(int i) {
        this.mTextGravity = i;
        invalidateSelf();
    }

    public void setControllerId(String str) {
        if (str == null) {
            str = "none";
        }
        this.mControllerId = str;
        invalidateSelf();
    }

    public void setImageId(String str) {
        this.mImageId = str;
        invalidateSelf();
    }

    public void setDimensions(int i, int i2) {
        this.mWidthPx = i;
        this.mHeightPx = i2;
        invalidateSelf();
    }

    public void setAnimationInfo(int i, int i2) {
        this.mFrameCount = i;
        this.mLoopCount = i2;
        invalidateSelf();
    }

    public void setImageSize(int i) {
        this.mImageSizeBytes = i;
    }

    public void setImageFormat(String str) {
        this.mImageFormat = str;
    }

    public void setScaleType(ScaleType scaleType) {
        this.mScaleType = scaleType;
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        prepareDebugTextParameters(rect, 7, 7);
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        this.mPaint.setStyle(Style.STROKE);
        this.mPaint.setStrokeWidth(2.0f);
        this.mPaint.setColor(OUTLINE_COLOR);
        canvas.drawRect((float) bounds.left, (float) bounds.top, (float) bounds.right, (float) bounds.bottom, this.mPaint);
        this.mPaint.setStyle(Style.FILL);
        this.mPaint.setColor(determineOverlayColor(this.mWidthPx, this.mHeightPx, this.mScaleType));
        canvas.drawRect((float) bounds.left, (float) bounds.top, (float) bounds.right, (float) bounds.bottom, this.mPaint);
        this.mPaint.setStyle(Style.FILL);
        this.mPaint.setStrokeWidth(0.0f);
        this.mPaint.setColor(-1);
        this.mCurrentTextXPx = this.mStartTextXPx;
        this.mCurrentTextYPx = this.mStartTextYPx;
        if (this.mImageId != null) {
            addDebugText(canvas, "IDs: %s, %s", this.mControllerId, this.mImageId);
        } else {
            addDebugText(canvas, "ID: %s", this.mControllerId);
        }
        addDebugText(canvas, "D: %dx%d", Integer.valueOf(bounds.width()), Integer.valueOf(bounds.height()));
        addDebugText(canvas, "I: %dx%d", Integer.valueOf(this.mWidthPx), Integer.valueOf(this.mHeightPx));
        addDebugText(canvas, "I: %d KiB", Integer.valueOf(this.mImageSizeBytes / 1024));
        if (this.mImageFormat != null) {
            addDebugText(canvas, "i format: %s", this.mImageFormat);
        }
        if (this.mFrameCount > 0) {
            addDebugText(canvas, "anim: f %d, l %d", Integer.valueOf(this.mFrameCount), Integer.valueOf(this.mLoopCount));
        }
        if (this.mScaleType != null) {
            addDebugText(canvas, "scale: %s", this.mScaleType);
        }
        if (this.mFinalImageTimeMs >= 0) {
            addDebugText(canvas, "t: %d ms", Long.valueOf(this.mFinalImageTimeMs));
        }
    }

    private void prepareDebugTextParameters(Rect rect, int i, int i2) {
        i = Math.min(40, Math.max(12, Math.min(rect.width() / i2, rect.height() / i)));
        this.mPaint.setTextSize((float) i);
        this.mLineIncrementPx = i + 8;
        if (this.mTextGravity == 80) {
            this.mLineIncrementPx *= -1;
        }
        this.mStartTextXPx = rect.left + 10;
        this.mStartTextYPx = this.mTextGravity == 80 ? rect.bottom - 10 : (rect.top + 10) + 12;
    }

    private void addDebugText(Canvas canvas, String str, Object... objArr) {
        if (objArr == null) {
            canvas.drawText(str, (float) this.mCurrentTextXPx, (float) this.mCurrentTextYPx, this.mPaint);
        } else {
            canvas.drawText(String.format(str, objArr), (float) this.mCurrentTextXPx, (float) this.mCurrentTextYPx, this.mPaint);
        }
        this.mCurrentTextYPx += this.mLineIncrementPx;
    }

    @VisibleForTesting
    int determineOverlayColor(int i, int i2, ScaleType scaleType) {
        int width = getBounds().width();
        int height = getBounds().height();
        if (width > 0 && height > 0 && i > 0) {
            if (i2 > 0) {
                if (scaleType != null) {
                    Rect rect = this.mRect;
                    this.mRect.top = 0;
                    rect.left = 0;
                    this.mRect.right = width;
                    this.mRect.bottom = height;
                    this.mMatrix.reset();
                    scaleType.getTransform(this.mMatrix, this.mRect, i, i2, 0.0f, 0.0f);
                    scaleType = this.mRectF;
                    this.mRectF.top = 0.0f;
                    scaleType.left = 0.0f;
                    this.mRectF.right = (float) i;
                    this.mRectF.bottom = (float) i2;
                    this.mMatrix.mapRect(this.mRectF);
                    int height2 = (int) this.mRectF.height();
                    width = Math.min(width, (int) this.mRectF.width());
                    height = Math.min(height, height2);
                }
                scaleType = (float) width;
                float f = scaleType * IMAGE_SIZE_THRESHOLD_OK;
                scaleType *= 1056964608;
                float f2 = (float) height;
                float f3 = IMAGE_SIZE_THRESHOLD_OK * f2;
                f2 *= IMAGE_SIZE_THRESHOLD_NOT_OK;
                i = Math.abs(i - width);
                i2 = Math.abs(i2 - height);
                i = (float) i;
                if (i < f && ((float) i2) < f3) {
                    return OVERLAY_COLOR_IMAGE_OK;
                }
                if (i >= scaleType || ((float) i2) >= f2) {
                    return OVERLAY_COLOR_IMAGE_NOT_OK;
                }
                return OVERLAY_COLOR_IMAGE_ALMOST_OK;
            }
        }
        return OVERLAY_COLOR_IMAGE_NOT_OK;
    }

    public void setFinalImageTimeMs(long j) {
        this.mFinalImageTimeMs = j;
    }

    public void onFinalImageSet(long j) {
        this.mFinalImageTimeMs = j;
        invalidateSelf();
    }
}
