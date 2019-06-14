package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteStreams;
import com.facebook.common.references.CloseableReference;
import java.io.InputStream;

public class NativePooledByteBufferFactory implements PooledByteBufferFactory {
    private final NativeMemoryChunkPool mPool;
    private final PooledByteStreams mPooledByteStreams;

    public NativePooledByteBufferFactory(NativeMemoryChunkPool nativeMemoryChunkPool, PooledByteStreams pooledByteStreams) {
        this.mPool = nativeMemoryChunkPool;
        this.mPooledByteStreams = pooledByteStreams;
    }

    public NativePooledByteBuffer newByteBuffer(int i) {
        Preconditions.checkArgument(i > 0);
        Object obj = this.mPool.get(i);
        NativePooledByteBuffer nativePooledByteBuffer = this.mPool;
        CloseableReference of = CloseableReference.of(obj, nativePooledByteBuffer);
        try {
            nativePooledByteBuffer = new NativePooledByteBuffer(of, i);
            return nativePooledByteBuffer;
        } finally {
            of.close();
        }
    }

    public NativePooledByteBuffer newByteBuffer(InputStream inputStream) {
        NativePooledByteBufferOutputStream nativePooledByteBufferOutputStream = new NativePooledByteBufferOutputStream(this.mPool);
        try {
            inputStream = newByteBuf(inputStream, nativePooledByteBufferOutputStream);
            return inputStream;
        } finally {
            nativePooledByteBufferOutputStream.close();
        }
    }

    public NativePooledByteBuffer newByteBuffer(byte[] bArr) {
        NativePooledByteBufferOutputStream nativePooledByteBufferOutputStream = new NativePooledByteBufferOutputStream(this.mPool, bArr.length);
        try {
            nativePooledByteBufferOutputStream.write(bArr, 0, bArr.length);
            bArr = nativePooledByteBufferOutputStream.toByteBuffer();
            nativePooledByteBufferOutputStream.close();
            return bArr;
        } catch (byte[] bArr2) {
            throw Throwables.propagate(bArr2);
        } catch (Throwable th) {
            nativePooledByteBufferOutputStream.close();
        }
    }

    public NativePooledByteBuffer newByteBuffer(InputStream inputStream, int i) {
        NativePooledByteBufferOutputStream nativePooledByteBufferOutputStream = new NativePooledByteBufferOutputStream(this.mPool, i);
        try {
            inputStream = newByteBuf(inputStream, nativePooledByteBufferOutputStream);
            return inputStream;
        } finally {
            nativePooledByteBufferOutputStream.close();
        }
    }

    @VisibleForTesting
    NativePooledByteBuffer newByteBuf(InputStream inputStream, NativePooledByteBufferOutputStream nativePooledByteBufferOutputStream) {
        this.mPooledByteStreams.copy(inputStream, nativePooledByteBufferOutputStream);
        return nativePooledByteBufferOutputStream.toByteBuffer();
    }

    public NativePooledByteBufferOutputStream newOutputStream() {
        return new NativePooledByteBufferOutputStream(this.mPool);
    }

    public NativePooledByteBufferOutputStream newOutputStream(int i) {
        return new NativePooledByteBufferOutputStream(this.mPool, i);
    }
}
