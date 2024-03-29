package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.memory.PooledByteBufferOutputStream;
import com.facebook.common.references.CloseableReference;

public class NativePooledByteBufferOutputStream extends PooledByteBufferOutputStream {
    private CloseableReference<NativeMemoryChunk> mBufRef;
    private int mCount;
    private final NativeMemoryChunkPool mPool;

    public static class InvalidStreamException extends RuntimeException {
        public InvalidStreamException() {
            super("OutputStream no longer valid");
        }
    }

    public NativePooledByteBufferOutputStream(NativeMemoryChunkPool nativeMemoryChunkPool) {
        this(nativeMemoryChunkPool, nativeMemoryChunkPool.getMinBufferSize());
    }

    public NativePooledByteBufferOutputStream(NativeMemoryChunkPool nativeMemoryChunkPool, int i) {
        Preconditions.checkArgument(i > 0);
        this.mPool = (NativeMemoryChunkPool) Preconditions.checkNotNull(nativeMemoryChunkPool);
        this.mCount = 0;
        this.mBufRef = CloseableReference.of(this.mPool.get(i), this.mPool);
    }

    public NativePooledByteBuffer toByteBuffer() {
        ensureValid();
        return new NativePooledByteBuffer(this.mBufRef, this.mCount);
    }

    public int size() {
        return this.mCount;
    }

    public void write(int i) {
        write(new byte[]{(byte) i});
    }

    public void write(byte[] bArr, int i, int i2) {
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
        ensureValid();
        realloc(this.mCount + i2);
        ((NativeMemoryChunk) this.mBufRef.get()).write(this.mCount, bArr, i, i2);
        this.mCount += i2;
    }

    public void close() {
        CloseableReference.closeSafely(this.mBufRef);
        this.mBufRef = null;
        this.mCount = -1;
        super.close();
    }

    @VisibleForTesting
    void realloc(int i) {
        ensureValid();
        if (i > ((NativeMemoryChunk) this.mBufRef.get()).getSize()) {
            NativeMemoryChunk nativeMemoryChunk = (NativeMemoryChunk) this.mPool.get(i);
            ((NativeMemoryChunk) this.mBufRef.get()).copy(0, nativeMemoryChunk, 0, this.mCount);
            this.mBufRef.close();
            this.mBufRef = CloseableReference.of(nativeMemoryChunk, this.mPool);
        }
    }

    private void ensureValid() {
        if (!CloseableReference.isValid(this.mBufRef)) {
            throw new InvalidStreamException();
        }
    }
}
