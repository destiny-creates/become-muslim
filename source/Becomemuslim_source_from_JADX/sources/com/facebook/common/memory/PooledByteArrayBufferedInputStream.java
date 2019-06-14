package com.facebook.common.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.imageutils.JfifUtil;
import java.io.IOException;
import java.io.InputStream;

public class PooledByteArrayBufferedInputStream extends InputStream {
    private static final String TAG = "PooledByteInputStream";
    private int mBufferOffset = 0;
    private int mBufferedSize = 0;
    private final byte[] mByteArray;
    private boolean mClosed = false;
    private final InputStream mInputStream;
    private final ResourceReleaser<byte[]> mResourceReleaser;

    public PooledByteArrayBufferedInputStream(InputStream inputStream, byte[] bArr, ResourceReleaser<byte[]> resourceReleaser) {
        this.mInputStream = (InputStream) Preconditions.checkNotNull(inputStream);
        this.mByteArray = (byte[]) Preconditions.checkNotNull(bArr);
        this.mResourceReleaser = (ResourceReleaser) Preconditions.checkNotNull(resourceReleaser);
    }

    public int read() {
        Preconditions.checkState(this.mBufferOffset <= this.mBufferedSize);
        ensureNotClosed();
        if (!ensureDataInBuffer()) {
            return -1;
        }
        byte[] bArr = this.mByteArray;
        int i = this.mBufferOffset;
        this.mBufferOffset = i + 1;
        return bArr[i] & JfifUtil.MARKER_FIRST_BYTE;
    }

    public int read(byte[] bArr, int i, int i2) {
        Preconditions.checkState(this.mBufferOffset <= this.mBufferedSize);
        ensureNotClosed();
        if (!ensureDataInBuffer()) {
            return -1;
        }
        i2 = Math.min(this.mBufferedSize - this.mBufferOffset, i2);
        System.arraycopy(this.mByteArray, this.mBufferOffset, bArr, i, i2);
        this.mBufferOffset += i2;
        return i2;
    }

    public int available() {
        Preconditions.checkState(this.mBufferOffset <= this.mBufferedSize);
        ensureNotClosed();
        return (this.mBufferedSize - this.mBufferOffset) + this.mInputStream.available();
    }

    public void close() {
        if (!this.mClosed) {
            this.mClosed = true;
            this.mResourceReleaser.release(this.mByteArray);
            super.close();
        }
    }

    public long skip(long j) {
        Preconditions.checkState(this.mBufferOffset <= this.mBufferedSize);
        ensureNotClosed();
        long j2 = (long) (this.mBufferedSize - this.mBufferOffset);
        if (j2 >= j) {
            this.mBufferOffset = (int) (((long) this.mBufferOffset) + j);
            return j;
        }
        this.mBufferOffset = this.mBufferedSize;
        return j2 + this.mInputStream.skip(j - j2);
    }

    private boolean ensureDataInBuffer() {
        if (this.mBufferOffset < this.mBufferedSize) {
            return true;
        }
        int read = this.mInputStream.read(this.mByteArray);
        if (read <= 0) {
            return false;
        }
        this.mBufferedSize = read;
        this.mBufferOffset = 0;
        return true;
    }

    private void ensureNotClosed() {
        if (this.mClosed) {
            throw new IOException("stream already closed");
        }
    }

    protected void finalize() {
        if (!this.mClosed) {
            FLog.m5674e(TAG, "Finalized without closing");
            close();
        }
        super.finalize();
    }
}
