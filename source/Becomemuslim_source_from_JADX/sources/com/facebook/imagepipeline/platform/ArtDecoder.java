package com.facebook.imagepipeline.platform;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.support.v4.util.Pools.C4463b;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.streams.LimitedInputStream;
import com.facebook.common.streams.TailAppendingInputStream;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.BitmapPool;
import java.io.InputStream;
import java.nio.ByteBuffer;

@TargetApi(21)
public class ArtDecoder implements PlatformDecoder {
    private static final int DECODE_BUFFER_SIZE = 16384;
    private static final byte[] EOI_TAIL = new byte[]{(byte) -1, (byte) -39};
    private static final Class<?> TAG = ArtDecoder.class;
    private final BitmapPool mBitmapPool;
    @VisibleForTesting
    final C4463b<ByteBuffer> mDecodeBuffers;

    public ArtDecoder(BitmapPool bitmapPool, int i, C4463b c4463b) {
        this.mBitmapPool = bitmapPool;
        this.mDecodeBuffers = c4463b;
        for (bitmapPool = null; bitmapPool < i; bitmapPool++) {
            this.mDecodeBuffers.release(ByteBuffer.allocate(DECODE_BUFFER_SIZE));
        }
    }

    public CloseableReference<Bitmap> decodeFromEncodedImage(EncodedImage encodedImage, Config config, Rect rect) {
        config = getDecodeOptionsForStream(encodedImage, config);
        Object obj = config.inPreferredConfig != Config.ARGB_8888 ? 1 : null;
        try {
            return decodeStaticImageFromStream(encodedImage.getInputStream(), config, rect);
        } catch (Config config2) {
            if (obj != null) {
                return decodeFromEncodedImage(encodedImage, Config.ARGB_8888, rect);
            }
            throw config2;
        }
    }

    public CloseableReference<Bitmap> decodeJPEGFromEncodedImage(EncodedImage encodedImage, Config config, Rect rect, int i) {
        boolean isCompleteAt = encodedImage.isCompleteAt(i);
        config = getDecodeOptionsForStream(encodedImage, config);
        InputStream inputStream = encodedImage.getInputStream();
        Preconditions.checkNotNull(inputStream);
        if (encodedImage.getSize() > i) {
            inputStream = new LimitedInputStream(inputStream, i);
        }
        i = !isCompleteAt ? new TailAppendingInputStream(inputStream, EOI_TAIL) : inputStream;
        Object obj = config.inPreferredConfig != Config.ARGB_8888 ? 1 : null;
        try {
            return decodeStaticImageFromStream(i, config, rect);
        } catch (Config config2) {
            if (obj != null) {
                return decodeFromEncodedImage(encodedImage, Config.ARGB_8888, rect);
            }
            throw config2;
        }
    }

    protected com.facebook.common.references.CloseableReference<android.graphics.Bitmap> decodeStaticImageFromStream(java.io.InputStream r9, android.graphics.BitmapFactory.Options r10, android.graphics.Rect r11) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r8 = this;
        com.facebook.common.internal.Preconditions.checkNotNull(r9);
        r0 = r10.outWidth;
        r1 = r10.outHeight;
        if (r11 == 0) goto L_0x0011;
    L_0x0009:
        r0 = r11.width();
        r1 = r11.height();
    L_0x0011:
        r2 = r10.inPreferredConfig;
        r2 = com.facebook.imageutils.BitmapUtil.getSizeInByteForBitmap(r0, r1, r2);
        r3 = r8.mBitmapPool;
        r2 = r3.get(r2);
        r2 = (android.graphics.Bitmap) r2;
        if (r2 == 0) goto L_0x00be;
    L_0x0021:
        r10.inBitmap = r2;
        r3 = r8.mDecodeBuffers;
        r3 = r3.acquire();
        r3 = (java.nio.ByteBuffer) r3;
        if (r3 != 0) goto L_0x0033;
    L_0x002d:
        r3 = 16384; // 0x4000 float:2.2959E-41 double:8.0948E-320;
        r3 = java.nio.ByteBuffer.allocate(r3);
    L_0x0033:
        r4 = r3.array();	 Catch:{ IllegalArgumentException -> 0x0099, RuntimeException -> 0x0092 }
        r10.inTempStorage = r4;	 Catch:{ IllegalArgumentException -> 0x0099, RuntimeException -> 0x0092 }
        r4 = 0;
        if (r11 == 0) goto L_0x006d;
    L_0x003c:
        r5 = 1;
        r6 = r10.inPreferredConfig;	 Catch:{ IOException -> 0x0053, all -> 0x0050 }
        r2.reconfigure(r0, r1, r6);	 Catch:{ IOException -> 0x0053, all -> 0x0050 }
        r0 = android.graphics.BitmapRegionDecoder.newInstance(r9, r5);	 Catch:{ IOException -> 0x0053, all -> 0x0050 }
        r1 = r0.decodeRegion(r11, r10);	 Catch:{ IOException -> 0x0054 }
        if (r0 == 0) goto L_0x006e;
    L_0x004c:
        r0.recycle();	 Catch:{ IllegalArgumentException -> 0x0099, RuntimeException -> 0x0092 }
        goto L_0x006e;
    L_0x0050:
        r10 = move-exception;
        r0 = r4;
        goto L_0x0067;
    L_0x0053:
        r0 = r4;
    L_0x0054:
        r1 = TAG;	 Catch:{ all -> 0x0066 }
        r6 = "Could not decode region %s, decoding full bitmap instead.";	 Catch:{ all -> 0x0066 }
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0066 }
        r7 = 0;	 Catch:{ all -> 0x0066 }
        r5[r7] = r11;	 Catch:{ all -> 0x0066 }
        com.facebook.common.logging.FLog.m5672e(r1, r6, r5);	 Catch:{ all -> 0x0066 }
        if (r0 == 0) goto L_0x006d;
    L_0x0062:
        r0.recycle();	 Catch:{ IllegalArgumentException -> 0x0099, RuntimeException -> 0x0092 }
        goto L_0x006d;	 Catch:{ IllegalArgumentException -> 0x0099, RuntimeException -> 0x0092 }
    L_0x0066:
        r10 = move-exception;	 Catch:{ IllegalArgumentException -> 0x0099, RuntimeException -> 0x0092 }
    L_0x0067:
        if (r0 == 0) goto L_0x006c;	 Catch:{ IllegalArgumentException -> 0x0099, RuntimeException -> 0x0092 }
    L_0x0069:
        r0.recycle();	 Catch:{ IllegalArgumentException -> 0x0099, RuntimeException -> 0x0092 }
    L_0x006c:
        throw r10;	 Catch:{ IllegalArgumentException -> 0x0099, RuntimeException -> 0x0092 }
    L_0x006d:
        r1 = r4;	 Catch:{ IllegalArgumentException -> 0x0099, RuntimeException -> 0x0092 }
    L_0x006e:
        if (r1 != 0) goto L_0x0074;	 Catch:{ IllegalArgumentException -> 0x0099, RuntimeException -> 0x0092 }
    L_0x0070:
        r1 = android.graphics.BitmapFactory.decodeStream(r9, r4, r10);	 Catch:{ IllegalArgumentException -> 0x0099, RuntimeException -> 0x0092 }
    L_0x0074:
        r9 = r8.mDecodeBuffers;
        r9.release(r3);
        if (r2 != r1) goto L_0x0082;
    L_0x007b:
        r9 = r8.mBitmapPool;
        r9 = com.facebook.common.references.CloseableReference.of(r1, r9);
        return r9;
    L_0x0082:
        r9 = r8.mBitmapPool;
        r9.release(r2);
        r1.recycle();
        r9 = new java.lang.IllegalStateException;
        r9.<init>();
        throw r9;
    L_0x0090:
        r9 = move-exception;
        goto L_0x00b8;
    L_0x0092:
        r9 = move-exception;
        r10 = r8.mBitmapPool;	 Catch:{ all -> 0x0090 }
        r10.release(r2);	 Catch:{ all -> 0x0090 }
        throw r9;	 Catch:{ all -> 0x0090 }
    L_0x0099:
        r10 = move-exception;	 Catch:{ all -> 0x0090 }
        r11 = r8.mBitmapPool;	 Catch:{ all -> 0x0090 }
        r11.release(r2);	 Catch:{ all -> 0x0090 }
        r9.reset();	 Catch:{ IOException -> 0x00b7 }
        r9 = android.graphics.BitmapFactory.decodeStream(r9);	 Catch:{ IOException -> 0x00b7 }
        if (r9 == 0) goto L_0x00b6;	 Catch:{ IOException -> 0x00b7 }
    L_0x00a8:
        r11 = com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser.getInstance();	 Catch:{ IOException -> 0x00b7 }
        r9 = com.facebook.common.references.CloseableReference.of(r9, r11);	 Catch:{ IOException -> 0x00b7 }
        r10 = r8.mDecodeBuffers;
        r10.release(r3);
        return r9;
    L_0x00b6:
        throw r10;	 Catch:{ IOException -> 0x00b7 }
    L_0x00b7:
        throw r10;	 Catch:{ all -> 0x0090 }
    L_0x00b8:
        r10 = r8.mDecodeBuffers;
        r10.release(r3);
        throw r9;
    L_0x00be:
        r9 = new java.lang.NullPointerException;
        r10 = "BitmapPool.get returned null";
        r9.<init>(r10);
        throw r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.platform.ArtDecoder.decodeStaticImageFromStream(java.io.InputStream, android.graphics.BitmapFactory$Options, android.graphics.Rect):com.facebook.common.references.CloseableReference<android.graphics.Bitmap>");
    }

    private static Options getDecodeOptionsForStream(EncodedImage encodedImage, Config config) {
        Options options = new Options();
        options.inSampleSize = encodedImage.getSampleSize();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(encodedImage.getInputStream(), null, options);
        if (options.outWidth == -1 || options.outHeight == -1) {
            throw new IllegalArgumentException();
        }
        options.inJustDecodeBounds = null;
        options.inDither = true;
        options.inPreferredConfig = config;
        options.inMutable = true;
        return options;
    }
}
