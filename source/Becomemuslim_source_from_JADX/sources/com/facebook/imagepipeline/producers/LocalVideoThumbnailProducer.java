package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.DocumentsContract;
import android.provider.MediaStore.Video.Media;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import java.util.concurrent.Executor;

public class LocalVideoThumbnailProducer implements Producer<CloseableReference<CloseableImage>> {
    @VisibleForTesting
    static final String CREATED_THUMBNAIL = "createdThumbnail";
    public static final String PRODUCER_NAME = "VideoThumbnailProducer";
    private final ContentResolver mContentResolver;
    private final Executor mExecutor;

    public LocalVideoThumbnailProducer(Executor executor, ContentResolver contentResolver) {
        this.mExecutor = executor;
        this.mContentResolver = contentResolver;
    }

    public void produceResults(Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext) {
        final ProducerListener listener = producerContext.getListener();
        final String id = producerContext.getId();
        final ImageRequest imageRequest = producerContext.getImageRequest();
        final Runnable c46521 = new StatefulProducerRunnable<CloseableReference<CloseableImage>>(consumer, listener, PRODUCER_NAME, id) {
            protected void onSuccess(CloseableReference<CloseableImage> closeableReference) {
                super.onSuccess(closeableReference);
                listener.onUltimateProducerReached(id, LocalVideoThumbnailProducer.PRODUCER_NAME, closeableReference != null ? true : null);
            }

            protected void onFailure(Exception exception) {
                super.onFailure(exception);
                listener.onUltimateProducerReached(id, LocalVideoThumbnailProducer.PRODUCER_NAME, false);
            }

            protected CloseableReference<CloseableImage> getResult() {
                String access$000 = LocalVideoThumbnailProducer.this.getLocalFilePath(imageRequest);
                if (access$000 == null) {
                    return null;
                }
                Bitmap createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(access$000, LocalVideoThumbnailProducer.calculateKind(imageRequest));
                if (createVideoThumbnail == null) {
                    return null;
                }
                return CloseableReference.of(new CloseableStaticBitmap(createVideoThumbnail, SimpleBitmapReleaser.getInstance(), ImmutableQualityInfo.FULL_QUALITY, 0));
            }

            protected Map<String, String> getExtraMapOnSuccess(CloseableReference<CloseableImage> closeableReference) {
                return ImmutableMap.of(LocalVideoThumbnailProducer.CREATED_THUMBNAIL, String.valueOf(closeableReference != null ? true : null));
            }

            protected void disposeResult(CloseableReference<CloseableImage> closeableReference) {
                CloseableReference.closeSafely((CloseableReference) closeableReference);
            }
        };
        producerContext.addCallbacks(new BaseProducerContextCallbacks() {
            public void onCancellationRequested() {
                c46521.cancel();
            }
        });
        this.mExecutor.execute(c46521);
    }

    private static int calculateKind(ImageRequest imageRequest) {
        if (imageRequest.getPreferredWidth() <= 96) {
            if (imageRequest.getPreferredHeight() <= 96) {
                return 3;
            }
        }
        return 1;
    }

    private String getLocalFilePath(ImageRequest imageRequest) {
        Uri sourceUri = imageRequest.getSourceUri();
        if (UriUtil.isLocalFileUri(sourceUri)) {
            return imageRequest.getSourceFile().getPath();
        }
        if (UriUtil.isLocalContentUri(sourceUri) != null) {
            Uri uri;
            String str;
            String[] strArr;
            if (VERSION.SDK_INT < 19 || "com.android.providers.media.documents".equals(sourceUri.getAuthority()) == null) {
                uri = sourceUri;
                str = null;
                strArr = str;
            } else {
                imageRequest = DocumentsContract.getDocumentId(sourceUri);
                uri = Media.EXTERNAL_CONTENT_URI;
                str = "_id=?";
                strArr = new String[]{imageRequest.split(":")[1]};
            }
            imageRequest = this.mContentResolver.query(uri, new String[]{"_data"}, str, strArr, null);
            if (imageRequest != null) {
                try {
                    if (imageRequest.moveToFirst()) {
                        String string = imageRequest.getString(imageRequest.getColumnIndexOrThrow("_data"));
                        return string;
                    }
                } finally {
                    if (imageRequest != null) {
                        imageRequest.close();
                    }
                }
            }
            if (imageRequest != null) {
                imageRequest.close();
            }
        }
        return null;
    }
}
