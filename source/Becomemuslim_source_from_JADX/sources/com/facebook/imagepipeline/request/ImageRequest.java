package com.facebook.imagepipeline.request;

import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Objects;
import com.facebook.common.media.MediaUtils;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.common.BytesRange;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.listener.RequestListener;
import java.io.File;

public class ImageRequest {
    private final BytesRange mBytesRange;
    private final CacheChoice mCacheChoice;
    private final ImageDecodeOptions mImageDecodeOptions;
    private final boolean mIsDiskCacheEnabled;
    private final boolean mIsMemoryCacheEnabled;
    private final boolean mLocalThumbnailPreviewsEnabled;
    private final RequestLevel mLowestPermittedRequestLevel;
    private final Postprocessor mPostprocessor;
    private final boolean mProgressiveRenderingEnabled;
    private final RequestListener mRequestListener;
    private final Priority mRequestPriority;
    private final ResizeOptions mResizeOptions;
    private final RotationOptions mRotationOptions;
    private File mSourceFile;
    private final Uri mSourceUri;
    private final int mSourceUriType = getSourceUriType(this.mSourceUri);

    public enum CacheChoice {
        SMALL,
        DEFAULT
    }

    public enum RequestLevel {
        FULL_FETCH(1),
        DISK_CACHE(2),
        ENCODED_MEMORY_CACHE(3),
        BITMAP_MEMORY_CACHE(4);
        
        private int mValue;

        private RequestLevel(int i) {
            this.mValue = i;
        }

        public int getValue() {
            return this.mValue;
        }

        public static RequestLevel getMax(RequestLevel requestLevel, RequestLevel requestLevel2) {
            return requestLevel.getValue() > requestLevel2.getValue() ? requestLevel : requestLevel2;
        }
    }

    public static ImageRequest fromFile(File file) {
        return file == null ? null : fromUri(UriUtil.getUriForFile(file));
    }

    public static ImageRequest fromUri(Uri uri) {
        return uri == null ? null : ImageRequestBuilder.newBuilderWithSource(uri).build();
    }

    public static ImageRequest fromUri(String str) {
        if (str != null) {
            if (str.length() != 0) {
                return fromUri(Uri.parse(str));
            }
        }
        return null;
    }

    protected ImageRequest(ImageRequestBuilder imageRequestBuilder) {
        this.mCacheChoice = imageRequestBuilder.getCacheChoice();
        this.mSourceUri = imageRequestBuilder.getSourceUri();
        this.mProgressiveRenderingEnabled = imageRequestBuilder.isProgressiveRenderingEnabled();
        this.mLocalThumbnailPreviewsEnabled = imageRequestBuilder.isLocalThumbnailPreviewsEnabled();
        this.mImageDecodeOptions = imageRequestBuilder.getImageDecodeOptions();
        this.mResizeOptions = imageRequestBuilder.getResizeOptions();
        this.mRotationOptions = imageRequestBuilder.getRotationOptions() == null ? RotationOptions.autoRotate() : imageRequestBuilder.getRotationOptions();
        this.mBytesRange = imageRequestBuilder.getBytesRange();
        this.mRequestPriority = imageRequestBuilder.getRequestPriority();
        this.mLowestPermittedRequestLevel = imageRequestBuilder.getLowestPermittedRequestLevel();
        this.mIsDiskCacheEnabled = imageRequestBuilder.isDiskCacheEnabled();
        this.mIsMemoryCacheEnabled = imageRequestBuilder.isMemoryCacheEnabled();
        this.mPostprocessor = imageRequestBuilder.getPostprocessor();
        this.mRequestListener = imageRequestBuilder.getRequestListener();
    }

    public CacheChoice getCacheChoice() {
        return this.mCacheChoice;
    }

    public Uri getSourceUri() {
        return this.mSourceUri;
    }

    public int getSourceUriType() {
        return this.mSourceUriType;
    }

    public int getPreferredWidth() {
        return this.mResizeOptions != null ? this.mResizeOptions.width : 2048;
    }

    public int getPreferredHeight() {
        return this.mResizeOptions != null ? this.mResizeOptions.height : 2048;
    }

    public ResizeOptions getResizeOptions() {
        return this.mResizeOptions;
    }

    public RotationOptions getRotationOptions() {
        return this.mRotationOptions;
    }

    @Deprecated
    public boolean getAutoRotateEnabled() {
        return this.mRotationOptions.useImageMetadata();
    }

    public BytesRange getBytesRange() {
        return this.mBytesRange;
    }

    public ImageDecodeOptions getImageDecodeOptions() {
        return this.mImageDecodeOptions;
    }

    public boolean getProgressiveRenderingEnabled() {
        return this.mProgressiveRenderingEnabled;
    }

    public boolean getLocalThumbnailPreviewsEnabled() {
        return this.mLocalThumbnailPreviewsEnabled;
    }

    public Priority getPriority() {
        return this.mRequestPriority;
    }

    public RequestLevel getLowestPermittedRequestLevel() {
        return this.mLowestPermittedRequestLevel;
    }

    public boolean isDiskCacheEnabled() {
        return this.mIsDiskCacheEnabled;
    }

    public boolean isMemoryCacheEnabled() {
        return this.mIsMemoryCacheEnabled;
    }

    public synchronized File getSourceFile() {
        if (this.mSourceFile == null) {
            this.mSourceFile = new File(this.mSourceUri.getPath());
        }
        return this.mSourceFile;
    }

    public Postprocessor getPostprocessor() {
        return this.mPostprocessor;
    }

    public RequestListener getRequestListener() {
        return this.mRequestListener;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ImageRequest)) {
            return false;
        }
        ImageRequest imageRequest = (ImageRequest) obj;
        if (Objects.equal(this.mSourceUri, imageRequest.mSourceUri) && Objects.equal(this.mCacheChoice, imageRequest.mCacheChoice) && Objects.equal(this.mSourceFile, imageRequest.mSourceFile) && Objects.equal(this.mBytesRange, imageRequest.mBytesRange) && Objects.equal(this.mImageDecodeOptions, imageRequest.mImageDecodeOptions) && Objects.equal(this.mResizeOptions, imageRequest.mResizeOptions)) {
            if (Objects.equal(this.mRotationOptions, imageRequest.mRotationOptions)) {
                Object obj2 = null;
                Object postprocessorCacheKey = this.mPostprocessor != null ? this.mPostprocessor.getPostprocessorCacheKey() : null;
                if (imageRequest.mPostprocessor != null) {
                    obj2 = imageRequest.mPostprocessor.getPostprocessorCacheKey();
                }
                return Objects.equal(postprocessorCacheKey, obj2);
            }
        }
        return false;
    }

    public int hashCode() {
        CacheKey postprocessorCacheKey = this.mPostprocessor != null ? this.mPostprocessor.getPostprocessorCacheKey() : null;
        return Objects.hashCode(this.mCacheChoice, this.mSourceUri, this.mSourceFile, this.mBytesRange, this.mImageDecodeOptions, this.mResizeOptions, this.mRotationOptions, postprocessorCacheKey);
    }

    public String toString() {
        return Objects.toStringHelper((Object) this).add("uri", this.mSourceUri).add("cacheChoice", this.mCacheChoice).add("decodeOptions", this.mImageDecodeOptions).add("postprocessor", this.mPostprocessor).add("priority", this.mRequestPriority).add("resizeOptions", this.mResizeOptions).add("rotationOptions", this.mRotationOptions).add("bytesRange", this.mBytesRange).toString();
    }

    private static int getSourceUriType(Uri uri) {
        if (uri == null) {
            return -1;
        }
        if (UriUtil.isNetworkUri(uri)) {
            return null;
        }
        if (UriUtil.isLocalFileUri(uri)) {
            return MediaUtils.isVideo(MediaUtils.extractMime(uri.getPath())) != null ? 2 : 3;
        } else {
            if (UriUtil.isLocalContentUri(uri)) {
                return 4;
            }
            if (UriUtil.isLocalAssetUri(uri)) {
                return 5;
            }
            if (UriUtil.isLocalResourceUri(uri)) {
                return 6;
            }
            if (UriUtil.isDataUri(uri)) {
                return 7;
            }
            if (UriUtil.isQualifiedResourceUri(uri) != null) {
                return 8;
            }
            return -1;
        }
    }
}
