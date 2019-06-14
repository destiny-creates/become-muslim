package com.facebook.drawee.generic;

import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import com.facebook.common.internal.Preconditions;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import java.util.Arrays;
import java.util.List;

public class GenericDraweeHierarchyBuilder {
    public static final ScaleType DEFAULT_ACTUAL_IMAGE_SCALE_TYPE = ScaleType.CENTER_CROP;
    public static final int DEFAULT_FADE_DURATION = 300;
    public static final ScaleType DEFAULT_SCALE_TYPE = ScaleType.CENTER_INSIDE;
    private ColorFilter mActualImageColorFilter;
    private PointF mActualImageFocusPoint;
    private Matrix mActualImageMatrix;
    private ScaleType mActualImageScaleType;
    private Drawable mBackground;
    private float mDesiredAspectRatio;
    private int mFadeDuration;
    private Drawable mFailureImage;
    private ScaleType mFailureImageScaleType;
    private List<Drawable> mOverlays;
    private Drawable mPlaceholderImage;
    private ScaleType mPlaceholderImageScaleType;
    private Drawable mPressedStateOverlay;
    private Drawable mProgressBarImage;
    private ScaleType mProgressBarImageScaleType;
    private Resources mResources;
    private Drawable mRetryImage;
    private ScaleType mRetryImageScaleType;
    private RoundingParams mRoundingParams;

    public GenericDraweeHierarchyBuilder(Resources resources) {
        this.mResources = resources;
        init();
    }

    public static GenericDraweeHierarchyBuilder newInstance(Resources resources) {
        return new GenericDraweeHierarchyBuilder(resources);
    }

    private void init() {
        this.mFadeDuration = 300;
        this.mDesiredAspectRatio = 0.0f;
        this.mPlaceholderImage = null;
        this.mPlaceholderImageScaleType = DEFAULT_SCALE_TYPE;
        this.mRetryImage = null;
        this.mRetryImageScaleType = DEFAULT_SCALE_TYPE;
        this.mFailureImage = null;
        this.mFailureImageScaleType = DEFAULT_SCALE_TYPE;
        this.mProgressBarImage = null;
        this.mProgressBarImageScaleType = DEFAULT_SCALE_TYPE;
        this.mActualImageScaleType = DEFAULT_ACTUAL_IMAGE_SCALE_TYPE;
        this.mActualImageMatrix = null;
        this.mActualImageFocusPoint = null;
        this.mActualImageColorFilter = null;
        this.mBackground = null;
        this.mOverlays = null;
        this.mPressedStateOverlay = null;
        this.mRoundingParams = null;
    }

    public GenericDraweeHierarchyBuilder reset() {
        init();
        return this;
    }

    public Resources getResources() {
        return this.mResources;
    }

    public GenericDraweeHierarchyBuilder setFadeDuration(int i) {
        this.mFadeDuration = i;
        return this;
    }

    public int getFadeDuration() {
        return this.mFadeDuration;
    }

    public GenericDraweeHierarchyBuilder setDesiredAspectRatio(float f) {
        this.mDesiredAspectRatio = f;
        return this;
    }

    public float getDesiredAspectRatio() {
        return this.mDesiredAspectRatio;
    }

    public GenericDraweeHierarchyBuilder setPlaceholderImage(Drawable drawable) {
        this.mPlaceholderImage = drawable;
        return this;
    }

    public GenericDraweeHierarchyBuilder setPlaceholderImage(int i) {
        this.mPlaceholderImage = this.mResources.getDrawable(i);
        return this;
    }

    public Drawable getPlaceholderImage() {
        return this.mPlaceholderImage;
    }

    public GenericDraweeHierarchyBuilder setPlaceholderImageScaleType(ScaleType scaleType) {
        this.mPlaceholderImageScaleType = scaleType;
        return this;
    }

    public ScaleType getPlaceholderImageScaleType() {
        return this.mPlaceholderImageScaleType;
    }

    public GenericDraweeHierarchyBuilder setPlaceholderImage(Drawable drawable, ScaleType scaleType) {
        this.mPlaceholderImage = drawable;
        this.mPlaceholderImageScaleType = scaleType;
        return this;
    }

    public GenericDraweeHierarchyBuilder setPlaceholderImage(int i, ScaleType scaleType) {
        this.mPlaceholderImage = this.mResources.getDrawable(i);
        this.mPlaceholderImageScaleType = scaleType;
        return this;
    }

    public GenericDraweeHierarchyBuilder setRetryImage(Drawable drawable) {
        this.mRetryImage = drawable;
        return this;
    }

    public GenericDraweeHierarchyBuilder setRetryImage(int i) {
        this.mRetryImage = this.mResources.getDrawable(i);
        return this;
    }

    public Drawable getRetryImage() {
        return this.mRetryImage;
    }

    public GenericDraweeHierarchyBuilder setRetryImageScaleType(ScaleType scaleType) {
        this.mRetryImageScaleType = scaleType;
        return this;
    }

    public ScaleType getRetryImageScaleType() {
        return this.mRetryImageScaleType;
    }

    public GenericDraweeHierarchyBuilder setRetryImage(Drawable drawable, ScaleType scaleType) {
        this.mRetryImage = drawable;
        this.mRetryImageScaleType = scaleType;
        return this;
    }

    public GenericDraweeHierarchyBuilder setRetryImage(int i, ScaleType scaleType) {
        this.mRetryImage = this.mResources.getDrawable(i);
        this.mRetryImageScaleType = scaleType;
        return this;
    }

    public GenericDraweeHierarchyBuilder setFailureImage(Drawable drawable) {
        this.mFailureImage = drawable;
        return this;
    }

    public GenericDraweeHierarchyBuilder setFailureImage(int i) {
        this.mFailureImage = this.mResources.getDrawable(i);
        return this;
    }

    public Drawable getFailureImage() {
        return this.mFailureImage;
    }

    public GenericDraweeHierarchyBuilder setFailureImageScaleType(ScaleType scaleType) {
        this.mFailureImageScaleType = scaleType;
        return this;
    }

    public ScaleType getFailureImageScaleType() {
        return this.mFailureImageScaleType;
    }

    public GenericDraweeHierarchyBuilder setFailureImage(Drawable drawable, ScaleType scaleType) {
        this.mFailureImage = drawable;
        this.mFailureImageScaleType = scaleType;
        return this;
    }

    public GenericDraweeHierarchyBuilder setFailureImage(int i, ScaleType scaleType) {
        this.mFailureImage = this.mResources.getDrawable(i);
        this.mFailureImageScaleType = scaleType;
        return this;
    }

    public GenericDraweeHierarchyBuilder setProgressBarImage(Drawable drawable) {
        this.mProgressBarImage = drawable;
        return this;
    }

    public GenericDraweeHierarchyBuilder setProgressBarImage(int i) {
        this.mProgressBarImage = this.mResources.getDrawable(i);
        return this;
    }

    public Drawable getProgressBarImage() {
        return this.mProgressBarImage;
    }

    public GenericDraweeHierarchyBuilder setProgressBarImageScaleType(ScaleType scaleType) {
        this.mProgressBarImageScaleType = scaleType;
        return this;
    }

    public ScaleType getProgressBarImageScaleType() {
        return this.mProgressBarImageScaleType;
    }

    public GenericDraweeHierarchyBuilder setProgressBarImage(Drawable drawable, ScaleType scaleType) {
        this.mProgressBarImage = drawable;
        this.mProgressBarImageScaleType = scaleType;
        return this;
    }

    public GenericDraweeHierarchyBuilder setProgressBarImage(int i, ScaleType scaleType) {
        this.mProgressBarImage = this.mResources.getDrawable(i);
        this.mProgressBarImageScaleType = scaleType;
        return this;
    }

    public GenericDraweeHierarchyBuilder setActualImageScaleType(ScaleType scaleType) {
        this.mActualImageScaleType = scaleType;
        this.mActualImageMatrix = null;
        return this;
    }

    public ScaleType getActualImageScaleType() {
        return this.mActualImageScaleType;
    }

    public GenericDraweeHierarchyBuilder setActualImageFocusPoint(PointF pointF) {
        this.mActualImageFocusPoint = pointF;
        return this;
    }

    public PointF getActualImageFocusPoint() {
        return this.mActualImageFocusPoint;
    }

    public GenericDraweeHierarchyBuilder setActualImageColorFilter(ColorFilter colorFilter) {
        this.mActualImageColorFilter = colorFilter;
        return this;
    }

    public ColorFilter getActualImageColorFilter() {
        return this.mActualImageColorFilter;
    }

    public GenericDraweeHierarchyBuilder setBackground(Drawable drawable) {
        this.mBackground = drawable;
        return this;
    }

    public Drawable getBackground() {
        return this.mBackground;
    }

    public GenericDraweeHierarchyBuilder setOverlays(List<Drawable> list) {
        this.mOverlays = list;
        return this;
    }

    public GenericDraweeHierarchyBuilder setOverlay(Drawable drawable) {
        if (drawable == null) {
            this.mOverlays = null;
        } else {
            this.mOverlays = Arrays.asList(new Drawable[]{drawable});
        }
        return this;
    }

    public List<Drawable> getOverlays() {
        return this.mOverlays;
    }

    public GenericDraweeHierarchyBuilder setPressedStateOverlay(Drawable drawable) {
        if (drawable == null) {
            this.mPressedStateOverlay = null;
        } else {
            Drawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, drawable);
            this.mPressedStateOverlay = stateListDrawable;
        }
        return this;
    }

    public Drawable getPressedStateOverlay() {
        return this.mPressedStateOverlay;
    }

    public GenericDraweeHierarchyBuilder setRoundingParams(RoundingParams roundingParams) {
        this.mRoundingParams = roundingParams;
        return this;
    }

    public RoundingParams getRoundingParams() {
        return this.mRoundingParams;
    }

    private void validate() {
        if (this.mOverlays != null) {
            for (Drawable checkNotNull : this.mOverlays) {
                Preconditions.checkNotNull(checkNotNull);
            }
        }
    }

    public GenericDraweeHierarchy build() {
        validate();
        return new GenericDraweeHierarchy(this);
    }
}
