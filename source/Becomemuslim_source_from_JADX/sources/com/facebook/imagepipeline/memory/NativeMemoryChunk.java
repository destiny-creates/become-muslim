package com.facebook.imagepipeline.memory;

import android.util.Log;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.nativecode.ImagePipelineNativeLoader;
import java.io.Closeable;

@DoNotStrip
public class NativeMemoryChunk implements Closeable {
    private static final String TAG = "NativeMemoryChunk";
    private boolean mClosed;
    private final long mNativePtr;
    private final int mSize;

    @DoNotStrip
    private static native long nativeAllocate(int i);

    @DoNotStrip
    private static native void nativeCopyFromByteArray(long j, byte[] bArr, int i, int i2);

    @DoNotStrip
    private static native void nativeCopyToByteArray(long j, byte[] bArr, int i, int i2);

    @DoNotStrip
    private static native void nativeFree(long j);

    @DoNotStrip
    private static native void nativeMemcpy(long j, long j2, int i);

    @DoNotStrip
    private static native byte nativeReadByte(long j);

    static {
        ImagePipelineNativeLoader.load();
    }

    public NativeMemoryChunk(int i) {
        Preconditions.checkArgument(i > 0);
        this.mSize = i;
        this.mNativePtr = nativeAllocate(this.mSize);
        this.mClosed = false;
    }

    @VisibleForTesting
    public NativeMemoryChunk() {
        this.mSize = 0;
        this.mNativePtr = 0;
        this.mClosed = true;
    }

    public synchronized void close() {
        if (!this.mClosed) {
            this.mClosed = true;
            nativeFree(this.mNativePtr);
        }
    }

    public synchronized boolean isClosed() {
        return this.mClosed;
    }

    public int getSize() {
        return this.mSize;
    }

    public synchronized int write(int i, byte[] bArr, int i2, int i3) {
        Preconditions.checkNotNull(bArr);
        Preconditions.checkState(isClosed() ^ 1);
        i3 = adjustByteCount(i, i3);
        checkBounds(i, bArr.length, i2, i3);
        nativeCopyFromByteArray(this.mNativePtr + ((long) i), bArr, i2, i3);
        return i3;
    }

    public synchronized int read(int i, byte[] bArr, int i2, int i3) {
        Preconditions.checkNotNull(bArr);
        Preconditions.checkState(isClosed() ^ 1);
        i3 = adjustByteCount(i, i3);
        checkBounds(i, bArr.length, i2, i3);
        nativeCopyToByteArray(this.mNativePtr + ((long) i), bArr, i2, i3);
        return i3;
    }

    public synchronized byte read(int i) {
        Preconditions.checkState(isClosed() ^ true);
        boolean z = false;
        Preconditions.checkArgument(i >= 0);
        if (i < this.mSize) {
            z = true;
        }
        Preconditions.checkArgument(z);
        return nativeReadByte(this.mNativePtr + ((long) i));
    }

    public void copy(int i, NativeMemoryChunk nativeMemoryChunk, int i2, int i3) {
        Preconditions.checkNotNull(nativeMemoryChunk);
        if (nativeMemoryChunk.mNativePtr == this.mNativePtr) {
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Copying from NativeMemoryChunk ");
            stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
            stringBuilder.append(" to NativeMemoryChunk ");
            stringBuilder.append(Integer.toHexString(System.identityHashCode(nativeMemoryChunk)));
            stringBuilder.append(" which share the same address ");
            stringBuilder.append(Long.toHexString(this.mNativePtr));
            Log.w(str, stringBuilder.toString());
            Preconditions.checkArgument(false);
        }
        if (nativeMemoryChunk.mNativePtr < this.mNativePtr) {
            synchronized (nativeMemoryChunk) {
                synchronized (this) {
                    doCopy(i, nativeMemoryChunk, i2, i3);
                }
            }
            return;
        }
        synchronized (this) {
            synchronized (nativeMemoryChunk) {
                doCopy(i, nativeMemoryChunk, i2, i3);
            }
        }
    }

    public long getNativePtr() {
        return this.mNativePtr;
    }

    private void doCopy(int i, NativeMemoryChunk nativeMemoryChunk, int i2, int i3) {
        Preconditions.checkState(isClosed() ^ 1);
        Preconditions.checkState(nativeMemoryChunk.isClosed() ^ 1);
        checkBounds(i, nativeMemoryChunk.mSize, i2, i3);
        nativeMemcpy(nativeMemoryChunk.mNativePtr + ((long) i2), this.mNativePtr + ((long) i), i3);
    }

    protected void finalize() {
        if (!isClosed()) {
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("finalize: Chunk ");
            stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
            stringBuilder.append(" still active. Underlying address = ");
            stringBuilder.append(Long.toHexString(this.mNativePtr));
            Log.w(str, stringBuilder.toString());
            try {
                close();
            } finally {
                super.finalize();
            }
        }
    }

    private int adjustByteCount(int i, int i2) {
        return Math.min(Math.max(0, this.mSize - i), i2);
    }

    private void checkBounds(int i, int i2, int i3, int i4) {
        boolean z = false;
        Preconditions.checkArgument(i4 >= 0);
        Preconditions.checkArgument(i >= 0);
        Preconditions.checkArgument(i3 >= 0);
        Preconditions.checkArgument(i + i4 <= this.mSize ? 1 : 0);
        if (i3 + i4 <= i2) {
            z = true;
        }
        Preconditions.checkArgument(z);
    }
}
