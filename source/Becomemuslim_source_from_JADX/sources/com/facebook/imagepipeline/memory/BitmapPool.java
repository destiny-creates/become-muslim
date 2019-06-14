package com.facebook.imagepipeline.memory;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.MemoryTrimmableRegistry;

@TargetApi(21)
public class BitmapPool extends BasePool<Bitmap> {
    protected int getBucketedSize(int i) {
        return i;
    }

    protected int getSizeInBytes(int i) {
        return i;
    }

    public BitmapPool(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams, PoolStatsTracker poolStatsTracker) {
        super(memoryTrimmableRegistry, poolParams, poolStatsTracker);
        initialize();
    }

    protected Bitmap alloc(int i) {
        return Bitmap.createBitmap(1, (int) Math.ceil(((double) i) / 2.0d), Config.RGB_565);
    }

    protected void free(Bitmap bitmap) {
        Preconditions.checkNotNull(bitmap);
        bitmap.recycle();
    }

    protected int getBucketedSizeForValue(Bitmap bitmap) {
        Preconditions.checkNotNull(bitmap);
        return bitmap.getAllocationByteCount();
    }

    protected boolean isReusable(Bitmap bitmap) {
        Preconditions.checkNotNull(bitmap);
        return (bitmap.isRecycled() || bitmap.isMutable() == null) ? null : true;
    }
}
