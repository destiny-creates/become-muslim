package com.facebook.react.views.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.UriUtil;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.controller.ForwardingControllerListener;
import com.facebook.drawee.drawable.AutoRotateDrawable;
import com.facebook.drawee.drawable.RoundedColorDrawable;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.generic.RoundingParams.RoundingMethod;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.postprocessors.IterativeBoxBlurPostProcessor;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.request.Postprocessor;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.modules.fresco.ReactNetworkImageRequest;
import com.facebook.react.uimanager.FloatUtil;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.views.imagehelper.ImageSource;
import com.facebook.react.views.imagehelper.MultiSourceHelper;
import com.facebook.react.views.imagehelper.MultiSourceHelper.MultiSourceResult;
import com.facebook.react.views.imagehelper.ResourceDrawableIdHelper;
import com.facebook.yoga.YogaConstants;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ReactImageView extends GenericDraweeView {
    public static final int REMOTE_IMAGE_FADE_DURATION_MS = 300;
    public static final String REMOTE_TRANSPARENT_BITMAP_URI = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAQAAAC1HAwCAAAAC0lEQVR42mNkYAAAAAYAAjCB0C8AAAAASUVORK5CYII=";
    private static float[] sComputedCornerRadii = new float[4];
    private static final Matrix sInverse = new Matrix();
    private static final Matrix sMatrix = new Matrix();
    private static final Matrix sTileMatrix = new Matrix();
    private int mBackgroundColor = null;
    private RoundedColorDrawable mBackgroundImageDrawable;
    private int mBorderColor;
    private float[] mBorderCornerRadii;
    private float mBorderRadius = 1.0E21f;
    private float mBorderWidth;
    private ImageSource mCachedImageSource;
    private final Object mCallerContext;
    private ControllerListener mControllerForTesting;
    private ControllerListener mControllerListener;
    private Drawable mDefaultImageDrawable;
    private final AbstractDraweeControllerBuilder mDraweeControllerBuilder;
    private int mFadeDurationMs = -1;
    private GlobalImageLoadListener mGlobalImageLoadListener;
    private ReadableMap mHeaders;
    private ImageSource mImageSource;
    private boolean mIsDirty;
    private IterativeBoxBlurPostProcessor mIterativeBoxBlurPostProcessor;
    private Drawable mLoadingImageDrawable;
    private int mOverlayColor;
    private boolean mProgressiveRenderingEnabled;
    private ImageResizeMethod mResizeMethod = ImageResizeMethod.AUTO;
    private final RoundedCornerPostprocessor mRoundedCornerPostprocessor;
    private ScaleType mScaleType = ImageResizeMode.defaultValue();
    private final List<ImageSource> mSources;
    private TileMode mTileMode = ImageResizeMode.defaultTileMode();
    private final TilePostprocessor mTilePostprocessor;

    private class RoundedCornerPostprocessor extends BasePostprocessor {
        private RoundedCornerPostprocessor() {
        }

        void getRadii(Bitmap bitmap, float[] fArr, float[] fArr2) {
            ReactImageView.this.mScaleType.getTransform(ReactImageView.sMatrix, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), bitmap.getWidth(), bitmap.getHeight(), 0.0f, 0.0f);
            ReactImageView.sMatrix.invert(ReactImageView.sInverse);
            fArr2[0] = ReactImageView.sInverse.mapRadius(fArr[0]);
            fArr2[1] = fArr2[0];
            fArr2[2] = ReactImageView.sInverse.mapRadius(fArr[1]);
            fArr2[3] = fArr2[2];
            fArr2[4] = ReactImageView.sInverse.mapRadius(fArr[2]);
            fArr2[5] = fArr2[4];
            fArr2[6] = ReactImageView.sInverse.mapRadius(fArr[3]);
            fArr2[7] = fArr2[6];
        }

        public void process(Bitmap bitmap, Bitmap bitmap2) {
            ReactImageView.this.cornerRadii(ReactImageView.sComputedCornerRadii);
            bitmap.setHasAlpha(true);
            if (FloatUtil.floatsEqual(ReactImageView.sComputedCornerRadii[0], 0.0f) && FloatUtil.floatsEqual(ReactImageView.sComputedCornerRadii[1], 0.0f) && FloatUtil.floatsEqual(ReactImageView.sComputedCornerRadii[2], 0.0f) && FloatUtil.floatsEqual(ReactImageView.sComputedCornerRadii[3], 0.0f)) {
                super.process(bitmap, bitmap2);
                return;
            }
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setShader(new BitmapShader(bitmap2, TileMode.CLAMP, TileMode.CLAMP));
            Canvas canvas = new Canvas(bitmap);
            bitmap = new float[8];
            getRadii(bitmap2, ReactImageView.sComputedCornerRadii, bitmap);
            Path path = new Path();
            path.addRoundRect(new RectF(0.0f, 0.0f, (float) bitmap2.getWidth(), (float) bitmap2.getHeight()), bitmap, Direction.CW);
            canvas.drawPath(path, paint);
        }
    }

    private class TilePostprocessor extends BasePostprocessor {
        private TilePostprocessor() {
        }

        public CloseableReference<Bitmap> process(Bitmap bitmap, PlatformBitmapFactory platformBitmapFactory) {
            Rect rect = new Rect(0, 0, ReactImageView.this.getWidth(), ReactImageView.this.getHeight());
            ReactImageView.this.mScaleType.getTransform(ReactImageView.sTileMatrix, rect, bitmap.getWidth(), bitmap.getHeight(), 0.0f, 0.0f);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            Shader bitmapShader = new BitmapShader(bitmap, ReactImageView.this.mTileMode, ReactImageView.this.mTileMode);
            bitmapShader.setLocalMatrix(ReactImageView.sTileMatrix);
            paint.setShader(bitmapShader);
            CloseableReference createBitmap = platformBitmapFactory.createBitmap(ReactImageView.this.getWidth(), ReactImageView.this.getHeight());
            try {
                new Canvas((Bitmap) createBitmap.get()).drawRect(rect, paint);
                platformBitmapFactory = createBitmap.clone();
                return platformBitmapFactory;
            } finally {
                CloseableReference.closeSafely(createBitmap);
            }
        }
    }

    private void warnImageSource(String str) {
    }

    public boolean hasOverlappingRendering() {
        return false;
    }

    private static GenericDraweeHierarchy buildHierarchy(Context context) {
        return new GenericDraweeHierarchyBuilder(context.getResources()).setRoundingParams(RoundingParams.fromCornersRadius(null)).build();
    }

    public ReactImageView(Context context, AbstractDraweeControllerBuilder abstractDraweeControllerBuilder, GlobalImageLoadListener globalImageLoadListener, Object obj) {
        super(context, buildHierarchy(context));
        this.mDraweeControllerBuilder = abstractDraweeControllerBuilder;
        this.mRoundedCornerPostprocessor = new RoundedCornerPostprocessor();
        this.mTilePostprocessor = new TilePostprocessor();
        this.mGlobalImageLoadListener = globalImageLoadListener;
        this.mCallerContext = obj;
        this.mSources = new LinkedList();
    }

    public void setShouldNotifyLoadEvents(boolean z) {
        if (z) {
            z = ((UIManagerModule) ((ReactContext) getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher();
            this.mControllerListener = new BaseControllerListener<ImageInfo>() {
                public void onSubmit(String str, Object obj) {
                    z.dispatchEvent(new ImageLoadEvent(ReactImageView.this.getId(), 4));
                }

                public void onFinalImageSet(String str, ImageInfo imageInfo, Animatable animatable) {
                    if (imageInfo != null) {
                        z.dispatchEvent(new ImageLoadEvent(ReactImageView.this.getId(), 2, ReactImageView.this.mImageSource.getSource(), imageInfo.getWidth(), imageInfo.getHeight()));
                        z.dispatchEvent(new ImageLoadEvent(ReactImageView.this.getId(), 3));
                    }
                }

                public void onFailure(String str, Throwable th) {
                    z.dispatchEvent(new ImageLoadEvent(ReactImageView.this.getId(), 1));
                    z.dispatchEvent(new ImageLoadEvent(ReactImageView.this.getId(), 3));
                }
            };
        } else {
            this.mControllerListener = false;
        }
        this.mIsDirty = true;
    }

    public void setBlurRadius(float f) {
        f = (int) PixelUtil.toPixelFromDIP(f);
        if (f == null) {
            this.mIterativeBoxBlurPostProcessor = 0.0f;
        } else {
            this.mIterativeBoxBlurPostProcessor = new IterativeBoxBlurPostProcessor(f);
        }
        this.mIsDirty = true;
    }

    public void setBackgroundColor(int i) {
        if (this.mBackgroundColor != i) {
            this.mBackgroundColor = i;
            this.mBackgroundImageDrawable = new RoundedColorDrawable(i);
            this.mIsDirty = true;
        }
    }

    public void setBorderColor(int i) {
        this.mBorderColor = i;
        this.mIsDirty = true;
    }

    public void setOverlayColor(int i) {
        this.mOverlayColor = i;
        this.mIsDirty = true;
    }

    public void setBorderWidth(float f) {
        this.mBorderWidth = PixelUtil.toPixelFromDIP(f);
        this.mIsDirty = true;
    }

    public void setBorderRadius(float f) {
        if (!FloatUtil.floatsEqual(this.mBorderRadius, f)) {
            this.mBorderRadius = f;
            this.mIsDirty = true;
        }
    }

    public void setBorderRadius(float f, int i) {
        if (this.mBorderCornerRadii == null) {
            this.mBorderCornerRadii = new float[4];
            Arrays.fill(this.mBorderCornerRadii, 1.0E21f);
        }
        if (!FloatUtil.floatsEqual(this.mBorderCornerRadii[i], f)) {
            this.mBorderCornerRadii[i] = f;
            this.mIsDirty = true;
        }
    }

    public void setScaleType(ScaleType scaleType) {
        this.mScaleType = scaleType;
        this.mIsDirty = true;
    }

    public void setTileMode(TileMode tileMode) {
        this.mTileMode = tileMode;
        this.mIsDirty = true;
    }

    public void setResizeMethod(ImageResizeMethod imageResizeMethod) {
        this.mResizeMethod = imageResizeMethod;
        this.mIsDirty = true;
    }

    public void setSource(ReadableArray readableArray) {
        this.mSources.clear();
        if (readableArray != null) {
            if (readableArray.size() != 0) {
                int i = 0;
                if (readableArray.size() == 1) {
                    readableArray = readableArray.getMap(0).getString("uri");
                    ImageSource imageSource = new ImageSource(getContext(), readableArray);
                    this.mSources.add(imageSource);
                    if (Uri.EMPTY.equals(imageSource.getUri())) {
                        warnImageSource(readableArray);
                    }
                } else {
                    while (i < readableArray.size()) {
                        ReadableMap map = readableArray.getMap(i);
                        String string = map.getString("uri");
                        ImageSource imageSource2 = new ImageSource(getContext(), string, map.getDouble("width"), map.getDouble("height"));
                        this.mSources.add(imageSource2);
                        if (Uri.EMPTY.equals(imageSource2.getUri())) {
                            warnImageSource(string);
                        }
                        i++;
                    }
                }
                this.mIsDirty = true;
            }
        }
        this.mSources.add(new ImageSource(getContext(), REMOTE_TRANSPARENT_BITMAP_URI));
        this.mIsDirty = true;
    }

    public void setDefaultSource(String str) {
        this.mDefaultImageDrawable = ResourceDrawableIdHelper.getInstance().getResourceDrawable(getContext(), str);
        this.mIsDirty = true;
    }

    public void setLoadingIndicatorSource(String str) {
        str = ResourceDrawableIdHelper.getInstance().getResourceDrawable(getContext(), str);
        this.mLoadingImageDrawable = str != null ? new AutoRotateDrawable(str, 1000) : null;
        this.mIsDirty = true;
    }

    public void setProgressiveRenderingEnabled(boolean z) {
        this.mProgressiveRenderingEnabled = z;
    }

    public void setFadeDuration(int i) {
        this.mFadeDurationMs = i;
    }

    private void cornerRadii(float[] fArr) {
        float f = !YogaConstants.isUndefined(this.mBorderRadius) ? this.mBorderRadius : 0.0f;
        float f2 = (this.mBorderCornerRadii == null || YogaConstants.isUndefined(this.mBorderCornerRadii[0])) ? f : this.mBorderCornerRadii[0];
        fArr[0] = f2;
        f2 = (this.mBorderCornerRadii == null || YogaConstants.isUndefined(this.mBorderCornerRadii[1])) ? f : this.mBorderCornerRadii[1];
        fArr[1] = f2;
        f2 = (this.mBorderCornerRadii == null || YogaConstants.isUndefined(this.mBorderCornerRadii[2])) ? f : this.mBorderCornerRadii[2];
        fArr[2] = f2;
        if (!(this.mBorderCornerRadii == null || YogaConstants.isUndefined(this.mBorderCornerRadii[3]))) {
            f = this.mBorderCornerRadii[3];
        }
        fArr[3] = f;
    }

    public void setHeaders(ReadableMap readableMap) {
        this.mHeaders = readableMap;
    }

    public void maybeUpdateView() {
        if (!this.mIsDirty) {
            return;
        }
        if (!hasMultipleSources() || (getWidth() > 0 && getHeight() > 0)) {
            setSourceImage();
            if (this.mImageSource != null) {
                boolean shouldResize = shouldResize(this.mImageSource);
                if (shouldResize && (getWidth() <= 0 || getHeight() <= 0)) {
                    return;
                }
                if (!isTiled() || (getWidth() > 0 && getHeight() > 0)) {
                    GenericDraweeHierarchy genericDraweeHierarchy = (GenericDraweeHierarchy) getHierarchy();
                    genericDraweeHierarchy.setActualImageScaleType(this.mScaleType);
                    if (this.mDefaultImageDrawable != null) {
                        genericDraweeHierarchy.setPlaceholderImage(this.mDefaultImageDrawable, ScaleType.CENTER);
                    }
                    if (this.mLoadingImageDrawable != null) {
                        genericDraweeHierarchy.setPlaceholderImage(this.mLoadingImageDrawable, ScaleType.CENTER);
                    }
                    Object obj = (this.mScaleType == ScaleType.CENTER_CROP || this.mScaleType == ScaleType.FOCUS_CROP) ? null : 1;
                    RoundingParams roundingParams = genericDraweeHierarchy.getRoundingParams();
                    cornerRadii(sComputedCornerRadii);
                    roundingParams.setCornersRadii(sComputedCornerRadii[0], sComputedCornerRadii[1], sComputedCornerRadii[2], sComputedCornerRadii[3]);
                    if (this.mBackgroundImageDrawable != null) {
                        this.mBackgroundImageDrawable.setBorder(this.mBorderColor, this.mBorderWidth);
                        this.mBackgroundImageDrawable.setRadii(roundingParams.getCornersRadii());
                        genericDraweeHierarchy.setBackgroundImage(this.mBackgroundImageDrawable);
                    }
                    if (obj != null) {
                        roundingParams.setCornersRadius(0.0f);
                    }
                    roundingParams.setBorder(this.mBorderColor, this.mBorderWidth);
                    if (this.mOverlayColor != 0) {
                        roundingParams.setOverlayColor(this.mOverlayColor);
                    } else {
                        roundingParams.setRoundingMethod(RoundingMethod.BITMAP_ONLY);
                    }
                    genericDraweeHierarchy.setRoundingParams(roundingParams);
                    int i = this.mFadeDurationMs >= 0 ? this.mFadeDurationMs : this.mImageSource.isResource() ? 0 : 300;
                    genericDraweeHierarchy.setFadeDuration(i);
                    List linkedList = new LinkedList();
                    if (obj != null) {
                        linkedList.add(this.mRoundedCornerPostprocessor);
                    }
                    if (this.mIterativeBoxBlurPostProcessor != null) {
                        linkedList.add(this.mIterativeBoxBlurPostProcessor);
                    }
                    if (isTiled()) {
                        linkedList.add(this.mTilePostprocessor);
                    }
                    Postprocessor from = MultiPostprocessor.from(linkedList);
                    ResizeOptions resizeOptions = shouldResize ? new ResizeOptions(getWidth(), getHeight()) : null;
                    ReactNetworkImageRequest fromBuilderWithHeaders = ReactNetworkImageRequest.fromBuilderWithHeaders(ImageRequestBuilder.newBuilderWithSource(this.mImageSource.getUri()).setPostprocessor(from).setResizeOptions(resizeOptions).setAutoRotateEnabled(true).setProgressiveRenderingEnabled(this.mProgressiveRenderingEnabled), this.mHeaders);
                    if (this.mGlobalImageLoadListener != null) {
                        this.mGlobalImageLoadListener.onLoadAttempt(this.mImageSource.getUri());
                    }
                    this.mDraweeControllerBuilder.reset();
                    this.mDraweeControllerBuilder.setAutoPlayAnimations(true).setCallerContext(this.mCallerContext).setOldController(getController()).setImageRequest(fromBuilderWithHeaders);
                    if (this.mCachedImageSource != null) {
                        this.mDraweeControllerBuilder.setLowResImageRequest(ImageRequestBuilder.newBuilderWithSource(this.mCachedImageSource.getUri()).setPostprocessor(from).setResizeOptions(resizeOptions).setAutoRotateEnabled(true).setProgressiveRenderingEnabled(this.mProgressiveRenderingEnabled).build());
                    }
                    if (this.mControllerListener != null && this.mControllerForTesting != null) {
                        ControllerListener forwardingControllerListener = new ForwardingControllerListener();
                        forwardingControllerListener.addListener(this.mControllerListener);
                        forwardingControllerListener.addListener(this.mControllerForTesting);
                        this.mDraweeControllerBuilder.setControllerListener(forwardingControllerListener);
                    } else if (this.mControllerForTesting != null) {
                        this.mDraweeControllerBuilder.setControllerListener(this.mControllerForTesting);
                    } else if (this.mControllerListener != null) {
                        this.mDraweeControllerBuilder.setControllerListener(this.mControllerListener);
                    }
                    setController(this.mDraweeControllerBuilder.build());
                    this.mIsDirty = false;
                    this.mDraweeControllerBuilder.reset();
                }
            }
        }
    }

    public void setControllerListener(ControllerListener controllerListener) {
        this.mControllerForTesting = controllerListener;
        this.mIsDirty = true;
        maybeUpdateView();
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i > 0 && i2 > 0) {
            if (this.mIsDirty == 0 && hasMultipleSources() == 0) {
                if (isTiled() == 0) {
                    i = 0;
                    this.mIsDirty = i;
                    maybeUpdateView();
                }
            }
            i = 1;
            this.mIsDirty = i;
            maybeUpdateView();
        }
    }

    private boolean hasMultipleSources() {
        return this.mSources.size() > 1;
    }

    private boolean isTiled() {
        return this.mTileMode != TileMode.CLAMP;
    }

    private void setSourceImage() {
        this.mImageSource = null;
        if (this.mSources.isEmpty()) {
            this.mSources.add(new ImageSource(getContext(), REMOTE_TRANSPARENT_BITMAP_URI));
        } else if (hasMultipleSources()) {
            MultiSourceResult bestSourceForSize = MultiSourceHelper.getBestSourceForSize(getWidth(), getHeight(), this.mSources);
            this.mImageSource = bestSourceForSize.getBestResult();
            this.mCachedImageSource = bestSourceForSize.getBestResultInCache();
            return;
        }
        this.mImageSource = (ImageSource) this.mSources.get(0);
    }

    private boolean shouldResize(ImageSource imageSource) {
        boolean z = false;
        if (this.mResizeMethod != ImageResizeMethod.AUTO) {
            return this.mResizeMethod == ImageResizeMethod.RESIZE;
        } else {
            if (UriUtil.isLocalContentUri(imageSource.getUri()) || UriUtil.isLocalFileUri(imageSource.getUri()) != null) {
                z = true;
            }
            return z;
        }
    }
}
