package com.facebook.imagepipeline.request;

import android.net.Uri;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.common.BytesRange;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.request.ImageRequest.CacheChoice;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;

public class ImageRequestBuilder {
    private BytesRange mBytesRange = null;
    private CacheChoice mCacheChoice = CacheChoice.DEFAULT;
    private boolean mDiskCacheEnabled = true;
    private ImageDecodeOptions mImageDecodeOptions = ImageDecodeOptions.defaults();
    private boolean mLocalThumbnailPreviewsEnabled = false;
    private RequestLevel mLowestPermittedRequestLevel = RequestLevel.FULL_FETCH;
    private boolean mMemoryCacheEnabled = true;
    private Postprocessor mPostprocessor = null;
    private boolean mProgressiveRenderingEnabled = ImagePipelineConfig.getDefaultImageRequestConfig().isProgressiveRenderingEnabled();
    private RequestListener mRequestListener;
    private Priority mRequestPriority = Priority.HIGH;
    private ResizeOptions mResizeOptions = null;
    private RotationOptions mRotationOptions = null;
    private Uri mSourceUri = null;

    public static class BuilderException extends RuntimeException {
        public BuilderException(String str) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid request builder: ");
            stringBuilder.append(str);
            super(stringBuilder.toString());
        }
    }

    public static ImageRequestBuilder newBuilderWithSource(Uri uri) {
        return new ImageRequestBuilder().setSource(uri);
    }

    public static ImageRequestBuilder newBuilderWithResourceId(int i) {
        return newBuilderWithSource(UriUtil.getUriForResourceId(i));
    }

    public static ImageRequestBuilder fromRequest(ImageRequest imageRequest) {
        return newBuilderWithSource(imageRequest.getSourceUri()).setImageDecodeOptions(imageRequest.getImageDecodeOptions()).setBytesRange(imageRequest.getBytesRange()).setCacheChoice(imageRequest.getCacheChoice()).setLocalThumbnailPreviewsEnabled(imageRequest.getLocalThumbnailPreviewsEnabled()).setLowestPermittedRequestLevel(imageRequest.getLowestPermittedRequestLevel()).setPostprocessor(imageRequest.getPostprocessor()).setProgressiveRenderingEnabled(imageRequest.getProgressiveRenderingEnabled()).setRequestPriority(imageRequest.getPriority()).setResizeOptions(imageRequest.getResizeOptions()).setRequestListener(imageRequest.getRequestListener()).setRotationOptions(imageRequest.getRotationOptions());
    }

    private ImageRequestBuilder() {
    }

    public ImageRequestBuilder setSource(Uri uri) {
        Preconditions.checkNotNull(uri);
        this.mSourceUri = uri;
        return this;
    }

    public Uri getSourceUri() {
        return this.mSourceUri;
    }

    public ImageRequestBuilder setLowestPermittedRequestLevel(RequestLevel requestLevel) {
        this.mLowestPermittedRequestLevel = requestLevel;
        return this;
    }

    public RequestLevel getLowestPermittedRequestLevel() {
        return this.mLowestPermittedRequestLevel;
    }

    @Deprecated
    public ImageRequestBuilder setAutoRotateEnabled(boolean z) {
        if (z) {
            return setRotationOptions(RotationOptions.autoRotate());
        }
        return setRotationOptions(RotationOptions.disableRotation());
    }

    public ImageRequestBuilder setResizeOptions(ResizeOptions resizeOptions) {
        this.mResizeOptions = resizeOptions;
        return this;
    }

    public ResizeOptions getResizeOptions() {
        return this.mResizeOptions;
    }

    public ImageRequestBuilder setRotationOptions(RotationOptions rotationOptions) {
        this.mRotationOptions = rotationOptions;
        return this;
    }

    public RotationOptions getRotationOptions() {
        return this.mRotationOptions;
    }

    public ImageRequestBuilder setBytesRange(BytesRange bytesRange) {
        this.mBytesRange = bytesRange;
        return this;
    }

    public BytesRange getBytesRange() {
        return this.mBytesRange;
    }

    public ImageRequestBuilder setImageDecodeOptions(ImageDecodeOptions imageDecodeOptions) {
        this.mImageDecodeOptions = imageDecodeOptions;
        return this;
    }

    public ImageDecodeOptions getImageDecodeOptions() {
        return this.mImageDecodeOptions;
    }

    public ImageRequestBuilder setCacheChoice(CacheChoice cacheChoice) {
        this.mCacheChoice = cacheChoice;
        return this;
    }

    public CacheChoice getCacheChoice() {
        return this.mCacheChoice;
    }

    public ImageRequestBuilder setProgressiveRenderingEnabled(boolean z) {
        this.mProgressiveRenderingEnabled = z;
        return this;
    }

    public boolean isProgressiveRenderingEnabled() {
        return this.mProgressiveRenderingEnabled;
    }

    public ImageRequestBuilder setLocalThumbnailPreviewsEnabled(boolean z) {
        this.mLocalThumbnailPreviewsEnabled = z;
        return this;
    }

    public boolean isLocalThumbnailPreviewsEnabled() {
        return this.mLocalThumbnailPreviewsEnabled;
    }

    public ImageRequestBuilder disableDiskCache() {
        this.mDiskCacheEnabled = false;
        return this;
    }

    public boolean isDiskCacheEnabled() {
        return this.mDiskCacheEnabled && UriUtil.isNetworkUri(this.mSourceUri);
    }

    public ImageRequestBuilder disableMemoryCache() {
        this.mMemoryCacheEnabled = false;
        return this;
    }

    public boolean isMemoryCacheEnabled() {
        return this.mMemoryCacheEnabled;
    }

    public ImageRequestBuilder setRequestPriority(Priority priority) {
        this.mRequestPriority = priority;
        return this;
    }

    public Priority getRequestPriority() {
        return this.mRequestPriority;
    }

    public ImageRequestBuilder setPostprocessor(Postprocessor postprocessor) {
        this.mPostprocessor = postprocessor;
        return this;
    }

    public Postprocessor getPostprocessor() {
        return this.mPostprocessor;
    }

    public ImageRequestBuilder setRequestListener(RequestListener requestListener) {
        this.mRequestListener = requestListener;
        return this;
    }

    public RequestListener getRequestListener() {
        return this.mRequestListener;
    }

    public ImageRequest build() {
        validate();
        return new ImageRequest(this);
    }

    protected void validate() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r2 = this;
        r0 = r2.mSourceUri;
        if (r0 == 0) goto L_0x0061;
    L_0x0004:
        r0 = r2.mSourceUri;
        r0 = com.facebook.common.util.UriUtil.isLocalResourceUri(r0);
        if (r0 == 0) goto L_0x0047;
    L_0x000c:
        r0 = r2.mSourceUri;
        r0 = r0.isAbsolute();
        if (r0 == 0) goto L_0x003f;
    L_0x0014:
        r0 = r2.mSourceUri;
        r0 = r0.getPath();
        r0 = r0.isEmpty();
        if (r0 != 0) goto L_0x0037;
    L_0x0020:
        r0 = r2.mSourceUri;	 Catch:{ NumberFormatException -> 0x002f }
        r0 = r0.getPath();	 Catch:{ NumberFormatException -> 0x002f }
        r1 = 1;	 Catch:{ NumberFormatException -> 0x002f }
        r0 = r0.substring(r1);	 Catch:{ NumberFormatException -> 0x002f }
        java.lang.Integer.parseInt(r0);	 Catch:{ NumberFormatException -> 0x002f }
        goto L_0x0047;
    L_0x002f:
        r0 = new com.facebook.imagepipeline.request.ImageRequestBuilder$BuilderException;
        r1 = "Resource URI path must be a resource id.";
        r0.<init>(r1);
        throw r0;
    L_0x0037:
        r0 = new com.facebook.imagepipeline.request.ImageRequestBuilder$BuilderException;
        r1 = "Resource URI must not be empty";
        r0.<init>(r1);
        throw r0;
    L_0x003f:
        r0 = new com.facebook.imagepipeline.request.ImageRequestBuilder$BuilderException;
        r1 = "Resource URI path must be absolute.";
        r0.<init>(r1);
        throw r0;
    L_0x0047:
        r0 = r2.mSourceUri;
        r0 = com.facebook.common.util.UriUtil.isLocalAssetUri(r0);
        if (r0 == 0) goto L_0x0060;
    L_0x004f:
        r0 = r2.mSourceUri;
        r0 = r0.isAbsolute();
        if (r0 == 0) goto L_0x0058;
    L_0x0057:
        goto L_0x0060;
    L_0x0058:
        r0 = new com.facebook.imagepipeline.request.ImageRequestBuilder$BuilderException;
        r1 = "Asset URI path must be absolute.";
        r0.<init>(r1);
        throw r0;
    L_0x0060:
        return;
    L_0x0061:
        r0 = new com.facebook.imagepipeline.request.ImageRequestBuilder$BuilderException;
        r1 = "Source must be set!";
        r0.<init>(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.request.ImageRequestBuilder.validate():void");
    }
}
