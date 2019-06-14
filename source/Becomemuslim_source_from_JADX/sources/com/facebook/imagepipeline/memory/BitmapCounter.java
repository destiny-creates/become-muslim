package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.imagepipeline.common.TooManyBitmapsException;
import com.facebook.imagepipeline.nativecode.Bitmaps;
import com.facebook.imageutils.BitmapUtil;
import java.util.ArrayList;
import java.util.List;

public class BitmapCounter {
    private int mCount;
    private final int mMaxCount;
    private final int mMaxSize;
    private long mSize;
    private final ResourceReleaser<Bitmap> mUnpooledBitmapsReleaser;

    /* renamed from: com.facebook.imagepipeline.memory.BitmapCounter$1 */
    class C37521 implements ResourceReleaser<Bitmap> {
        C37521() {
        }

        public void release(Bitmap bitmap) {
            try {
                BitmapCounter.this.decrease(bitmap);
            } finally {
                bitmap.recycle();
            }
        }
    }

    public BitmapCounter(int i, int i2) {
        boolean z = false;
        Preconditions.checkArgument(i > 0);
        if (i2 > 0) {
            z = true;
        }
        Preconditions.checkArgument(z);
        this.mMaxCount = i;
        this.mMaxSize = i2;
        this.mUnpooledBitmapsReleaser = new C37521();
    }

    public synchronized boolean increase(Bitmap bitmap) {
        bitmap = BitmapUtil.getSizeInBytes(bitmap);
        if (this.mCount < this.mMaxCount) {
            long j = (long) bitmap;
            if (this.mSize + j <= ((long) this.mMaxSize)) {
                this.mCount += 1;
                this.mSize += j;
                return true;
            }
        }
        return null;
    }

    public synchronized void decrease(Bitmap bitmap) {
        bitmap = BitmapUtil.getSizeInBytes(bitmap);
        Preconditions.checkArgument(this.mCount > 0, "No bitmaps registered.");
        long j = (long) bitmap;
        Preconditions.checkArgument(j <= this.mSize, "Bitmap size bigger than the total registered size: %d, %d", Integer.valueOf(bitmap), Long.valueOf(this.mSize));
        this.mSize -= j;
        this.mCount -= 1;
    }

    public synchronized int getCount() {
        return this.mCount;
    }

    public synchronized long getSize() {
        return this.mSize;
    }

    public synchronized int getMaxCount() {
        return this.mMaxCount;
    }

    public synchronized int getMaxSize() {
        return this.mMaxSize;
    }

    public ResourceReleaser<Bitmap> getReleaser() {
        return this.mUnpooledBitmapsReleaser;
    }

    public List<CloseableReference<Bitmap>> associateBitmapsWithBitmapCounter(List<Bitmap> list) {
        int i = 0;
        while (i < list.size()) {
            try {
                Bitmap bitmap = (Bitmap) list.get(i);
                if (VERSION.SDK_INT < 21) {
                    Bitmaps.pinBitmap(bitmap);
                }
                if (increase(bitmap)) {
                    i++;
                } else {
                    throw new TooManyBitmapsException();
                }
            } catch (Throwable e) {
                if (list != null) {
                    for (Bitmap bitmap2 : list) {
                        int i2 = i - 1;
                        if (i > 0) {
                            decrease(bitmap2);
                        }
                        bitmap2.recycle();
                        i = i2;
                    }
                }
                throw Throwables.propagate(e);
            }
        }
        List<CloseableReference<Bitmap>> arrayList = new ArrayList(list.size());
        for (Bitmap of : list) {
            arrayList.add(CloseableReference.of(of, this.mUnpooledBitmapsReleaser));
        }
        return arrayList;
    }
}
