package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.net.Uri;
import android.provider.MediaStore.Images.Thumbnails;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imageutils.JfifUtil;
import expo.modules.contacts.EXColumns;
import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.Executor;

public class LocalContentUriThumbnailFetchProducer extends LocalFetchProducer implements ThumbnailProducer<EncodedImage> {
    private static final Rect MICRO_THUMBNAIL_DIMENSIONS = new Rect(0, 0, 96, 96);
    private static final Rect MINI_THUMBNAIL_DIMENSIONS = new Rect(0, 0, 512, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT);
    private static final int NO_THUMBNAIL = 0;
    public static final String PRODUCER_NAME = "LocalContentUriThumbnailFetchProducer";
    private static final String[] PROJECTION = new String[]{EXColumns.ID, "_data"};
    private static final Class<?> TAG = LocalContentUriThumbnailFetchProducer.class;
    private static final String[] THUMBNAIL_PROJECTION = new String[]{"_data"};
    private final ContentResolver mContentResolver;

    protected String getProducerName() {
        return PRODUCER_NAME;
    }

    public LocalContentUriThumbnailFetchProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, ContentResolver contentResolver) {
        super(executor, pooledByteBufferFactory);
        this.mContentResolver = contentResolver;
    }

    public boolean canProvideImageForSize(ResizeOptions resizeOptions) {
        return ThumbnailSizeChecker.isImageBigEnough(MINI_THUMBNAIL_DIMENSIONS.width(), MINI_THUMBNAIL_DIMENSIONS.height(), resizeOptions);
    }

    protected EncodedImage getEncodedImage(ImageRequest imageRequest) {
        Uri sourceUri = imageRequest.getSourceUri();
        if (UriUtil.isLocalCameraUri(sourceUri)) {
            imageRequest = getCameraImage(sourceUri, imageRequest.getResizeOptions());
            if (imageRequest != null) {
                return imageRequest;
            }
        }
        return null;
    }

    private EncodedImage getCameraImage(Uri uri, ResizeOptions resizeOptions) {
        uri = this.mContentResolver.query(uri, PROJECTION, null, null, null);
        if (uri == null) {
            return null;
        }
        try {
            if (uri.getCount() == 0) {
                return null;
            }
            uri.moveToFirst();
            String string = uri.getString(uri.getColumnIndex("_data"));
            if (resizeOptions != null) {
                resizeOptions = getThumbnail(resizeOptions, uri.getInt(uri.getColumnIndex(EXColumns.ID)));
                if (resizeOptions != null) {
                    resizeOptions.setRotationAngle(getRotationAngle(string));
                    uri.close();
                    return resizeOptions;
                }
            }
            uri.close();
            return null;
        } finally {
            uri.close();
        }
    }

    private EncodedImage getThumbnail(ResizeOptions resizeOptions, int i) {
        resizeOptions = getThumbnailKind(resizeOptions);
        if (resizeOptions == null) {
            return null;
        }
        try {
            resizeOptions = Thumbnails.queryMiniThumbnail(this.mContentResolver, (long) i, resizeOptions, THUMBNAIL_PROJECTION);
            if (resizeOptions == null) {
                if (resizeOptions != null) {
                    resizeOptions.close();
                }
                return null;
            }
            try {
                resizeOptions.moveToFirst();
                if (resizeOptions.getCount() > 0) {
                    i = resizeOptions.getString(resizeOptions.getColumnIndex("_data"));
                    if (new File(i).exists()) {
                        i = getEncodedImage(new FileInputStream(i), getLength(i));
                        if (resizeOptions != null) {
                            resizeOptions.close();
                        }
                        return i;
                    }
                }
                if (resizeOptions != null) {
                    resizeOptions.close();
                }
                return null;
            } catch (Throwable th) {
                i = th;
                if (resizeOptions != null) {
                    resizeOptions.close();
                }
                throw i;
            }
        } catch (Throwable th2) {
            i = th2;
            resizeOptions = null;
            if (resizeOptions != null) {
                resizeOptions.close();
            }
            throw i;
        }
    }

    private static int getThumbnailKind(ResizeOptions resizeOptions) {
        if (ThumbnailSizeChecker.isImageBigEnough(MICRO_THUMBNAIL_DIMENSIONS.width(), MICRO_THUMBNAIL_DIMENSIONS.height(), resizeOptions)) {
            return 3;
        }
        return ThumbnailSizeChecker.isImageBigEnough(MINI_THUMBNAIL_DIMENSIONS.width(), MINI_THUMBNAIL_DIMENSIONS.height(), resizeOptions) != null ? 1 : null;
    }

    private static int getLength(String str) {
        return str == null ? -1 : (int) new File(str).length();
    }

    private static int getRotationAngle(String str) {
        if (str != null) {
            try {
                return JfifUtil.getAutoRotateAngleFromOrientation(new ExifInterface(str).getAttributeInt("Orientation", 1));
            } catch (Throwable e) {
                FLog.m5673e(TAG, e, "Unable to retrieve thumbnail rotation for %s", str);
            }
        }
        return 0;
    }
}
