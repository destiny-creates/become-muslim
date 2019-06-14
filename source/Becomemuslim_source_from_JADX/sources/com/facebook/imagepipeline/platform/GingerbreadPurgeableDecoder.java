package com.facebook.imagepipeline.platform;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.os.MemoryFile;
import com.facebook.common.internal.ByteStreams;
import com.facebook.common.internal.Closeables;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferInputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.streams.LimitedInputStream;
import com.facebook.common.webp.WebpSupportStatus;
import com.facebook.imagepipeline.image.EncodedImage;
import java.io.Closeable;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

public class GingerbreadPurgeableDecoder extends DalvikPurgeableDecoder {
    private static Method sGetFileDescriptorMethod;

    public /* bridge */ /* synthetic */ CloseableReference decodeFromEncodedImage(EncodedImage encodedImage, Config config, Rect rect) {
        return super.decodeFromEncodedImage(encodedImage, config, rect);
    }

    public /* bridge */ /* synthetic */ CloseableReference decodeJPEGFromEncodedImage(EncodedImage encodedImage, Config config, Rect rect, int i) {
        return super.decodeJPEGFromEncodedImage(encodedImage, config, rect, i);
    }

    public /* bridge */ /* synthetic */ CloseableReference pinBitmap(Bitmap bitmap) {
        return super.pinBitmap(bitmap);
    }

    protected Bitmap decodeByteArrayAsPurgeable(CloseableReference<PooledByteBuffer> closeableReference, Options options) {
        return decodeFileDescriptorAsPurgeable(closeableReference, ((PooledByteBuffer) closeableReference.get()).size(), null, options);
    }

    protected Bitmap decodeJPEGByteArrayAsPurgeable(CloseableReference<PooledByteBuffer> closeableReference, int i, Options options) {
        return decodeFileDescriptorAsPurgeable(closeableReference, i, DalvikPurgeableDecoder.endsWithEOI(closeableReference, i) ? null : EOI, options);
    }

    private static MemoryFile copyToMemoryFile(CloseableReference<PooledByteBuffer> closeableReference, int i, byte[] bArr) {
        InputStream pooledByteBufferInputStream;
        InputStream limitedInputStream;
        Closeable closeable;
        InputStream inputStream = null;
        MemoryFile memoryFile = new MemoryFile(null, (bArr == null ? 0 : bArr.length) + i);
        memoryFile.allowPurging(false);
        try {
            pooledByteBufferInputStream = new PooledByteBufferInputStream((PooledByteBuffer) closeableReference.get());
            try {
                limitedInputStream = new LimitedInputStream(pooledByteBufferInputStream, i);
            } catch (Throwable th) {
                i = th;
                closeable = null;
                CloseableReference.closeSafely((CloseableReference) closeableReference);
                Closeables.closeQuietly(pooledByteBufferInputStream);
                Closeables.closeQuietly(inputStream);
                Closeables.close(closeable, true);
                throw i;
            }
            try {
                closeable = memoryFile.getOutputStream();
                try {
                    ByteStreams.copy(limitedInputStream, closeable);
                    if (bArr != null) {
                        memoryFile.writeBytes(bArr, 0, i, bArr.length);
                    }
                    CloseableReference.closeSafely((CloseableReference) closeableReference);
                    Closeables.closeQuietly(pooledByteBufferInputStream);
                    Closeables.closeQuietly(limitedInputStream);
                    Closeables.close(closeable, true);
                    return memoryFile;
                } catch (Throwable th2) {
                    i = th2;
                    inputStream = limitedInputStream;
                    CloseableReference.closeSafely((CloseableReference) closeableReference);
                    Closeables.closeQuietly(pooledByteBufferInputStream);
                    Closeables.closeQuietly(inputStream);
                    Closeables.close(closeable, true);
                    throw i;
                }
            } catch (Throwable th3) {
                i = th3;
                closeable = null;
                inputStream = limitedInputStream;
                CloseableReference.closeSafely((CloseableReference) closeableReference);
                Closeables.closeQuietly(pooledByteBufferInputStream);
                Closeables.closeQuietly(inputStream);
                Closeables.close(closeable, true);
                throw i;
            }
        } catch (Throwable th4) {
            i = th4;
            pooledByteBufferInputStream = null;
            closeable = pooledByteBufferInputStream;
            CloseableReference.closeSafely((CloseableReference) closeableReference);
            Closeables.closeQuietly(pooledByteBufferInputStream);
            Closeables.closeQuietly(inputStream);
            Closeables.close(closeable, true);
            throw i;
        }
    }

    private synchronized Method getFileDescriptorMethod() {
        if (sGetFileDescriptorMethod == null) {
            try {
                sGetFileDescriptorMethod = MemoryFile.class.getDeclaredMethod("getFileDescriptor", new Class[0]);
            } catch (Throwable e) {
                throw Throwables.propagate(e);
            }
        }
        return sGetFileDescriptorMethod;
    }

    private FileDescriptor getMemoryFileDescriptor(MemoryFile memoryFile) {
        try {
            return (FileDescriptor) getFileDescriptorMethod().invoke(memoryFile, new Object[0]);
        } catch (MemoryFile memoryFile2) {
            throw Throwables.propagate(memoryFile2);
        }
    }

    protected Bitmap decodeFileDescriptorAsPurgeable(CloseableReference<PooledByteBuffer> closeableReference, int i, byte[] bArr, Options options) {
        Rect rect = null;
        try {
            closeableReference = copyToMemoryFile(closeableReference, i, bArr);
            try {
                Bitmap bitmap = (Bitmap) Preconditions.checkNotNull(WebpSupportStatus.sWebpBitmapFactory.decodeFileDescriptor(getMemoryFileDescriptor(closeableReference), null, options), "BitmapFactory returned null");
                if (closeableReference != null) {
                    closeableReference.close();
                }
                return bitmap;
            } catch (IOException e) {
                i = e;
                rect = closeableReference;
                try {
                    throw Throwables.propagate(i);
                } catch (Throwable th) {
                    i = th;
                    closeableReference = rect;
                    if (closeableReference != null) {
                        closeableReference.close();
                    }
                    throw i;
                }
            } catch (Throwable th2) {
                i = th2;
                if (closeableReference != null) {
                    closeableReference.close();
                }
                throw i;
            }
        } catch (IOException e2) {
            i = e2;
            throw Throwables.propagate(i);
        }
    }
}
