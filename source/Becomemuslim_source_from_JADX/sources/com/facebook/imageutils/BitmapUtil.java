package com.facebook.imageutils;

import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.support.v4.util.Pools.C4463b;
import android.util.Pair;
import com.facebook.common.internal.Preconditions;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class BitmapUtil {
    public static final int ALPHA_8_BYTES_PER_PIXEL = 1;
    public static final int ARGB_4444_BYTES_PER_PIXEL = 2;
    public static final int ARGB_8888_BYTES_PER_PIXEL = 4;
    private static final C4463b<ByteBuffer> DECODE_BUFFERS = new C4463b(12);
    private static final int DECODE_BUFFER_SIZE = 16384;
    public static final float MAX_BITMAP_SIZE = 2048.0f;
    private static final int POOL_SIZE = 12;
    public static final int RGB_565_BYTES_PER_PIXEL = 2;

    /* renamed from: com.facebook.imageutils.BitmapUtil$1 */
    static /* synthetic */ class C17911 {
        static final /* synthetic */ int[] $SwitchMap$android$graphics$Bitmap$Config = new int[Config.values().length];

        static {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
            /*
            r0 = android.graphics.Bitmap.Config.values();
            r0 = r0.length;
            r0 = new int[r0];
            $SwitchMap$android$graphics$Bitmap$Config = r0;
            r0 = $SwitchMap$android$graphics$Bitmap$Config;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = android.graphics.Bitmap.Config.ARGB_8888;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            r0 = $SwitchMap$android$graphics$Bitmap$Config;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = android.graphics.Bitmap.Config.ALPHA_8;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2;	 Catch:{ NoSuchFieldError -> 0x001f }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            r0 = $SwitchMap$android$graphics$Bitmap$Config;	 Catch:{ NoSuchFieldError -> 0x002a }
            r1 = android.graphics.Bitmap.Config.ARGB_4444;	 Catch:{ NoSuchFieldError -> 0x002a }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3;	 Catch:{ NoSuchFieldError -> 0x002a }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            r0 = $SwitchMap$android$graphics$Bitmap$Config;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r1 = android.graphics.Bitmap.Config.RGB_565;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0035 }
            r2 = 4;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0035 }
        L_0x0035:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.imageutils.BitmapUtil.1.<clinit>():void");
        }
    }

    @android.annotation.SuppressLint({"NewApi"})
    public static int getSizeInBytes(android.graphics.Bitmap r2) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        if (r2 != 0) goto L_0x0004;
    L_0x0002:
        r2 = 0;
        return r2;
    L_0x0004:
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 19;
        if (r0 <= r1) goto L_0x000f;
    L_0x000a:
        r0 = r2.getAllocationByteCount();	 Catch:{ NullPointerException -> 0x000f }
        return r0;
    L_0x000f:
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 12;
        if (r0 < r1) goto L_0x001a;
    L_0x0015:
        r2 = r2.getByteCount();
        return r2;
    L_0x001a:
        r0 = r2.getRowBytes();
        r2 = r2.getHeight();
        r0 = r0 * r2;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imageutils.BitmapUtil.getSizeInBytes(android.graphics.Bitmap):int");
    }

    public static Pair<Integer, Integer> decodeDimensions(byte[] bArr) {
        return decodeDimensions(new ByteArrayInputStream(bArr));
    }

    public static Pair<Integer, Integer> decodeDimensions(InputStream inputStream) {
        Preconditions.checkNotNull(inputStream);
        ByteBuffer byteBuffer = (ByteBuffer) DECODE_BUFFERS.acquire();
        if (byteBuffer == null) {
            byteBuffer = ByteBuffer.allocate(DECODE_BUFFER_SIZE);
        }
        Options options = new Options();
        options.inJustDecodeBounds = true;
        try {
            options.inTempStorage = byteBuffer.array();
            Pair<Integer, Integer> pair = null;
            BitmapFactory.decodeStream(inputStream, null, options);
            if (options.outWidth != -1) {
                if (options.outHeight != -1) {
                    pair = new Pair(Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight));
                }
            }
            DECODE_BUFFERS.release(byteBuffer);
            return pair;
        } catch (Throwable th) {
            DECODE_BUFFERS.release(byteBuffer);
        }
    }

    public static int getPixelSizeForBitmapConfig(Config config) {
        switch (C17911.$SwitchMap$android$graphics$Bitmap$Config[config.ordinal()]) {
            case 1:
                return 4;
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 2;
            default:
                throw new UnsupportedOperationException("The provided Bitmap.Config is not supported");
        }
    }

    public static int getSizeInByteForBitmap(int i, int i2, Config config) {
        return (i * i2) * getPixelSizeForBitmapConfig(config);
    }
}
