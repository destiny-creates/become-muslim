package com.facebook.common.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imageutils.JfifUtil;
import java.io.InputStream;

public class PooledByteBufferInputStream extends InputStream {
    @VisibleForTesting
    int mMark = 0;
    @VisibleForTesting
    int mOffset = 0;
    @VisibleForTesting
    final PooledByteBuffer mPooledByteBuffer;

    public boolean markSupported() {
        return true;
    }

    public PooledByteBufferInputStream(PooledByteBuffer pooledByteBuffer) {
        Preconditions.checkArgument(pooledByteBuffer.isClosed() ^ 1);
        this.mPooledByteBuffer = (PooledByteBuffer) Preconditions.checkNotNull(pooledByteBuffer);
    }

    public int available() {
        return this.mPooledByteBuffer.size() - this.mOffset;
    }

    public void mark(int i) {
        this.mMark = this.mOffset;
    }

    public int read() {
        if (available() <= 0) {
            return -1;
        }
        PooledByteBuffer pooledByteBuffer = this.mPooledByteBuffer;
        int i = this.mOffset;
        this.mOffset = i + 1;
        return pooledByteBuffer.read(i) & JfifUtil.MARKER_FIRST_BYTE;
    }

    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) {
        if (i < 0 || i2 < 0 || i + i2 > bArr.length) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("length=");
            stringBuilder.append(bArr.length);
            stringBuilder.append("; regionStart=");
            stringBuilder.append(i);
            stringBuilder.append("; regionLength=");
            stringBuilder.append(i2);
            throw new ArrayIndexOutOfBoundsException(stringBuilder.toString());
        }
        int available = available();
        if (available <= 0) {
            return -1;
        }
        if (i2 <= 0) {
            return null;
        }
        i2 = Math.min(available, i2);
        this.mPooledByteBuffer.read(this.mOffset, bArr, i, i2);
        this.mOffset += i2;
        return i2;
    }

    public void reset() {
        this.mOffset = this.mMark;
    }

    public long skip(long j) {
        Preconditions.checkArgument(j >= 0);
        j = Math.min((int) j, available());
        this.mOffset += j;
        return (long) j;
    }
}
