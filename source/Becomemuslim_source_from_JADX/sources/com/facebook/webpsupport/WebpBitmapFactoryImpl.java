package com.facebook.webpsupport;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.TypedValue;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.webp.BitmapCreator;
import com.facebook.common.webp.WebpBitmapFactory;
import com.facebook.common.webp.WebpBitmapFactory.WebpErrorLogger;
import com.facebook.common.webp.WebpSupportStatus;
import com.facebook.imagepipeline.nativecode.StaticWebpNativeLoader;
import java.io.BufferedInputStream;
import java.io.FileDescriptor;
import java.io.InputStream;

@DoNotStrip
public class WebpBitmapFactoryImpl implements WebpBitmapFactory {
    private static final int HEADER_SIZE = 20;
    public static final boolean IN_BITMAP_SUPPORTED = (VERSION.SDK_INT >= 11);
    private static final int IN_TEMP_BUFFER_SIZE = 8192;
    private static BitmapCreator mBitmapCreator;
    private static WebpErrorLogger mWebpErrorLogger;

    @DoNotStrip
    private static native Bitmap nativeDecodeByteArray(byte[] bArr, int i, int i2, Options options, float f, byte[] bArr2);

    @DoNotStrip
    private static native Bitmap nativeDecodeStream(InputStream inputStream, Options options, float f, byte[] bArr);

    @DoNotStrip
    private static native long nativeSeek(FileDescriptor fileDescriptor, long j, boolean z);

    public void setBitmapCreator(BitmapCreator bitmapCreator) {
        mBitmapCreator = bitmapCreator;
    }

    private static InputStream wrapToMarkSupportedStream(InputStream inputStream) {
        return !inputStream.markSupported() ? new BufferedInputStream(inputStream, 20) : inputStream;
    }

    private static byte[] getWebpHeader(java.io.InputStream r2, android.graphics.BitmapFactory.Options r3) {
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
        r0 = 20;
        r2.mark(r0);
        if (r3 == 0) goto L_0x0013;
    L_0x0007:
        r1 = r3.inTempStorage;
        if (r1 == 0) goto L_0x0013;
    L_0x000b:
        r1 = r3.inTempStorage;
        r1 = r1.length;
        if (r1 < r0) goto L_0x0013;
    L_0x0010:
        r3 = r3.inTempStorage;
        goto L_0x0015;
    L_0x0013:
        r3 = new byte[r0];
    L_0x0015:
        r1 = 0;
        r2.read(r3, r1, r0);	 Catch:{ IOException -> 0x001d }
        r2.reset();	 Catch:{ IOException -> 0x001d }
        return r3;
    L_0x001d:
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.webpsupport.WebpBitmapFactoryImpl.getWebpHeader(java.io.InputStream, android.graphics.BitmapFactory$Options):byte[]");
    }

    private static void setDensityFromOptions(Bitmap bitmap, Options options) {
        if (bitmap != null) {
            if (options != null) {
                int i = options.inDensity;
                if (i != 0) {
                    bitmap.setDensity(i);
                    int i2 = options.inTargetDensity;
                    if (!(i2 == 0 || i == i2)) {
                        if (i != options.inScreenDensity) {
                            if (options.inScaled != null) {
                                bitmap.setDensity(i2);
                            }
                        }
                    }
                } else if (IN_BITMAP_SUPPORTED && options.inBitmap != null) {
                    bitmap.setDensity(160);
                }
            }
        }
    }

    public void setWebpErrorLogger(WebpErrorLogger webpErrorLogger) {
        mWebpErrorLogger = webpErrorLogger;
    }

    public Bitmap decodeFileDescriptor(FileDescriptor fileDescriptor, Rect rect, Options options) {
        return hookDecodeFileDescriptor(fileDescriptor, rect, options);
    }

    public Bitmap decodeStream(InputStream inputStream, Rect rect, Options options) {
        return hookDecodeStream(inputStream, rect, options);
    }

    public Bitmap decodeFile(String str, Options options) {
        return hookDecodeFile(str, options);
    }

    public Bitmap decodeByteArray(byte[] bArr, int i, int i2, Options options) {
        return hookDecodeByteArray(bArr, i, i2, options);
    }

    @DoNotStrip
    public static Bitmap hookDecodeByteArray(byte[] bArr, int i, int i2, Options options) {
        StaticWebpNativeLoader.ensure();
        if (WebpSupportStatus.sIsWebpSupportRequired && WebpSupportStatus.isWebpHeader(bArr, i, i2)) {
            bArr = nativeDecodeByteArray(bArr, i, i2, options, getScaleFromOptions(options), getInTempStorageFromOptions(options));
            if (bArr == null) {
                sendWebpErrorLog("webp_direct_decode_array");
            }
            setWebpBitmapOptions(bArr, options);
        } else {
            bArr = originalDecodeByteArray(bArr, i, i2, options);
            if (bArr == null) {
                sendWebpErrorLog("webp_direct_decode_array_failed_on_no_webp");
            }
        }
        return bArr;
    }

    @DoNotStrip
    private static Bitmap originalDecodeByteArray(byte[] bArr, int i, int i2, Options options) {
        return BitmapFactory.decodeByteArray(bArr, i, i2, options);
    }

    @DoNotStrip
    public static Bitmap hookDecodeByteArray(byte[] bArr, int i, int i2) {
        return hookDecodeByteArray(bArr, i, i2, null);
    }

    @DoNotStrip
    private static Bitmap originalDecodeByteArray(byte[] bArr, int i, int i2) {
        return BitmapFactory.decodeByteArray(bArr, i, i2);
    }

    @DoNotStrip
    public static Bitmap hookDecodeStream(InputStream inputStream, Rect rect, Options options) {
        StaticWebpNativeLoader.ensure();
        inputStream = wrapToMarkSupportedStream(inputStream);
        byte[] webpHeader = getWebpHeader(inputStream, options);
        if (WebpSupportStatus.sIsWebpSupportRequired && WebpSupportStatus.isWebpHeader(webpHeader, 0, 20)) {
            inputStream = nativeDecodeStream(inputStream, options, getScaleFromOptions(options), getInTempStorageFromOptions(options));
            if (inputStream == null) {
                sendWebpErrorLog("webp_direct_decode_stream");
            }
            setWebpBitmapOptions(inputStream, options);
            setPaddingDefaultValues(rect);
        } else {
            inputStream = originalDecodeStream(inputStream, rect, options);
            if (inputStream == null) {
                sendWebpErrorLog("webp_direct_decode_stream_failed_on_no_webp");
            }
        }
        return inputStream;
    }

    @DoNotStrip
    private static Bitmap originalDecodeStream(InputStream inputStream, Rect rect, Options options) {
        return BitmapFactory.decodeStream(inputStream, rect, options);
    }

    @DoNotStrip
    public static Bitmap hookDecodeStream(InputStream inputStream) {
        return hookDecodeStream(inputStream, null, null);
    }

    @DoNotStrip
    private static Bitmap originalDecodeStream(InputStream inputStream) {
        return BitmapFactory.decodeStream(inputStream);
    }

    @com.facebook.common.internal.DoNotStrip
    public static android.graphics.Bitmap hookDecodeFile(java.lang.String r3, android.graphics.BitmapFactory.Options r4) {
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
        r0 = 0;
        r1 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x0026 }
        r1.<init>(r3);	 Catch:{ Exception -> 0x0026 }
        r3 = hookDecodeStream(r1, r0, r4);	 Catch:{ Throwable -> 0x0011, all -> 0x000e }
        r1.close();	 Catch:{ Exception -> 0x0027 }
        goto L_0x0027;
    L_0x000e:
        r3 = move-exception;
        r4 = r0;
        goto L_0x0017;
    L_0x0011:
        r3 = move-exception;
        throw r3;	 Catch:{ all -> 0x0013 }
    L_0x0013:
        r4 = move-exception;
        r2 = r4;
        r4 = r3;
        r3 = r2;
    L_0x0017:
        if (r4 == 0) goto L_0x0022;
    L_0x0019:
        r1.close();	 Catch:{ Throwable -> 0x001d }
        goto L_0x0025;
    L_0x001d:
        r1 = move-exception;
        r4.addSuppressed(r1);	 Catch:{ Exception -> 0x0026 }
        goto L_0x0025;	 Catch:{ Exception -> 0x0026 }
    L_0x0022:
        r1.close();	 Catch:{ Exception -> 0x0026 }
    L_0x0025:
        throw r3;	 Catch:{ Exception -> 0x0026 }
    L_0x0026:
        r3 = r0;
    L_0x0027:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.webpsupport.WebpBitmapFactoryImpl.hookDecodeFile(java.lang.String, android.graphics.BitmapFactory$Options):android.graphics.Bitmap");
    }

    @DoNotStrip
    public static Bitmap hookDecodeFile(String str) {
        return hookDecodeFile(str, null);
    }

    @DoNotStrip
    public static Bitmap hookDecodeResourceStream(Resources resources, TypedValue typedValue, InputStream inputStream, Rect rect, Options options) {
        if (options == null) {
            options = new Options();
        }
        if (options.inDensity == 0 && typedValue != null) {
            typedValue = typedValue.density;
            if (typedValue == null) {
                options.inDensity = 160;
            } else if (typedValue != 65535) {
                options.inDensity = typedValue;
            }
        }
        if (options.inTargetDensity == null && resources != null) {
            options.inTargetDensity = resources.getDisplayMetrics().densityDpi;
        }
        return hookDecodeStream(inputStream, rect, options);
    }

    @DoNotStrip
    private static Bitmap originalDecodeResourceStream(Resources resources, TypedValue typedValue, InputStream inputStream, Rect rect, Options options) {
        return BitmapFactory.decodeResourceStream(resources, typedValue, inputStream, rect, options);
    }

    @com.facebook.common.internal.DoNotStrip
    public static android.graphics.Bitmap hookDecodeResource(android.content.res.Resources r3, int r4, android.graphics.BitmapFactory.Options r5) {
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
        r0 = new android.util.TypedValue;
        r0.<init>();
        r1 = 0;
        r4 = r3.openRawResource(r4, r0);	 Catch:{ Exception -> 0x002e }
        r3 = hookDecodeResourceStream(r3, r0, r4, r1, r5);	 Catch:{ Throwable -> 0x0017, all -> 0x0014 }
        if (r4 == 0) goto L_0x002f;
    L_0x0010:
        r4.close();	 Catch:{ Exception -> 0x002f }
        goto L_0x002f;
    L_0x0014:
        r3 = move-exception;
        r0 = r1;
        goto L_0x001d;
    L_0x0017:
        r3 = move-exception;
        throw r3;	 Catch:{ all -> 0x0019 }
    L_0x0019:
        r0 = move-exception;
        r2 = r0;
        r0 = r3;
        r3 = r2;
    L_0x001d:
        if (r4 == 0) goto L_0x002d;
    L_0x001f:
        if (r0 == 0) goto L_0x002a;
    L_0x0021:
        r4.close();	 Catch:{ Throwable -> 0x0025 }
        goto L_0x002d;
    L_0x0025:
        r4 = move-exception;
        r0.addSuppressed(r4);	 Catch:{ Exception -> 0x002e }
        goto L_0x002d;	 Catch:{ Exception -> 0x002e }
    L_0x002a:
        r4.close();	 Catch:{ Exception -> 0x002e }
    L_0x002d:
        throw r3;	 Catch:{ Exception -> 0x002e }
    L_0x002e:
        r3 = r1;
    L_0x002f:
        r4 = IN_BITMAP_SUPPORTED;
        if (r4 == 0) goto L_0x0044;
    L_0x0033:
        if (r3 != 0) goto L_0x0044;
    L_0x0035:
        if (r5 == 0) goto L_0x0044;
    L_0x0037:
        r4 = r5.inBitmap;
        if (r4 != 0) goto L_0x003c;
    L_0x003b:
        goto L_0x0044;
    L_0x003c:
        r3 = new java.lang.IllegalArgumentException;
        r4 = "Problem decoding into existing bitmap";
        r3.<init>(r4);
        throw r3;
    L_0x0044:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.webpsupport.WebpBitmapFactoryImpl.hookDecodeResource(android.content.res.Resources, int, android.graphics.BitmapFactory$Options):android.graphics.Bitmap");
    }

    @DoNotStrip
    private static Bitmap originalDecodeResource(Resources resources, int i, Options options) {
        return BitmapFactory.decodeResource(resources, i, options);
    }

    @DoNotStrip
    public static Bitmap hookDecodeResource(Resources resources, int i) {
        return hookDecodeResource(resources, i, null);
    }

    @DoNotStrip
    private static Bitmap originalDecodeResource(Resources resources, int i) {
        return BitmapFactory.decodeResource(resources, i);
    }

    @DoNotStrip
    private static boolean setOutDimensions(Options options, int i, int i2) {
        if (options == null || !options.inJustDecodeBounds) {
            return null;
        }
        options.outWidth = i;
        options.outHeight = i2;
        return true;
    }

    @DoNotStrip
    private static void setPaddingDefaultValues(Rect rect) {
        if (rect != null) {
            rect.top = -1;
            rect.left = -1;
            rect.bottom = -1;
            rect.right = -1;
        }
    }

    @DoNotStrip
    private static void setBitmapSize(Options options, int i, int i2) {
        if (options != null) {
            options.outWidth = i;
            options.outHeight = i2;
        }
    }

    @DoNotStrip
    private static Bitmap originalDecodeFile(String str, Options options) {
        return BitmapFactory.decodeFile(str, options);
    }

    @DoNotStrip
    private static Bitmap originalDecodeFile(String str) {
        return BitmapFactory.decodeFile(str);
    }

    @com.facebook.common.internal.DoNotStrip
    public static android.graphics.Bitmap hookDecodeFileDescriptor(java.io.FileDescriptor r6, android.graphics.Rect r7, android.graphics.BitmapFactory.Options r8) {
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
        com.facebook.imagepipeline.nativecode.StaticWebpNativeLoader.ensure();
        r0 = 0;
        r1 = 0;
        r1 = nativeSeek(r6, r1, r0);
        r3 = -1;
        r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r3 == 0) goto L_0x005b;
    L_0x0010:
        r3 = new java.io.FileInputStream;
        r3.<init>(r6);
        r3 = wrapToMarkSupportedStream(r3);
        r4 = getWebpHeader(r3, r8);	 Catch:{ all -> 0x0056 }
        r5 = com.facebook.common.webp.WebpSupportStatus.sIsWebpSupportRequired;	 Catch:{ all -> 0x0056 }
        if (r5 == 0) goto L_0x0043;	 Catch:{ all -> 0x0056 }
    L_0x0021:
        r5 = 20;	 Catch:{ all -> 0x0056 }
        r0 = com.facebook.common.webp.WebpSupportStatus.isWebpHeader(r4, r0, r5);	 Catch:{ all -> 0x0056 }
        if (r0 == 0) goto L_0x0043;	 Catch:{ all -> 0x0056 }
    L_0x0029:
        r6 = getScaleFromOptions(r8);	 Catch:{ all -> 0x0056 }
        r0 = getInTempStorageFromOptions(r8);	 Catch:{ all -> 0x0056 }
        r6 = nativeDecodeStream(r3, r8, r6, r0);	 Catch:{ all -> 0x0056 }
        if (r6 != 0) goto L_0x003c;	 Catch:{ all -> 0x0056 }
    L_0x0037:
        r0 = "webp_direct_decode_fd";	 Catch:{ all -> 0x0056 }
        sendWebpErrorLog(r0);	 Catch:{ all -> 0x0056 }
    L_0x003c:
        setPaddingDefaultValues(r7);	 Catch:{ all -> 0x0056 }
        setWebpBitmapOptions(r6, r8);	 Catch:{ all -> 0x0056 }
        goto L_0x0052;	 Catch:{ all -> 0x0056 }
    L_0x0043:
        r0 = 1;	 Catch:{ all -> 0x0056 }
        nativeSeek(r6, r1, r0);	 Catch:{ all -> 0x0056 }
        r6 = originalDecodeFileDescriptor(r6, r7, r8);	 Catch:{ all -> 0x0056 }
        if (r6 != 0) goto L_0x0052;	 Catch:{ all -> 0x0056 }
    L_0x004d:
        r7 = "webp_direct_decode_fd_failed_on_no_webp";	 Catch:{ all -> 0x0056 }
        sendWebpErrorLog(r7);	 Catch:{ all -> 0x0056 }
    L_0x0052:
        r3.close();	 Catch:{ Throwable -> 0x0067 }
        goto L_0x0067;
    L_0x0056:
        r6 = move-exception;
        r3.close();	 Catch:{ Throwable -> 0x005a }
    L_0x005a:
        throw r6;
    L_0x005b:
        r0 = new java.io.FileInputStream;
        r0.<init>(r6);
        r6 = hookDecodeStream(r0, r7, r8);
        setPaddingDefaultValues(r7);
    L_0x0067:
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.webpsupport.WebpBitmapFactoryImpl.hookDecodeFileDescriptor(java.io.FileDescriptor, android.graphics.Rect, android.graphics.BitmapFactory$Options):android.graphics.Bitmap");
    }

    @DoNotStrip
    private static Bitmap originalDecodeFileDescriptor(FileDescriptor fileDescriptor, Rect rect, Options options) {
        return BitmapFactory.decodeFileDescriptor(fileDescriptor, rect, options);
    }

    @DoNotStrip
    public static Bitmap hookDecodeFileDescriptor(FileDescriptor fileDescriptor) {
        return hookDecodeFileDescriptor(fileDescriptor, null, null);
    }

    @DoNotStrip
    private static Bitmap originalDecodeFileDescriptor(FileDescriptor fileDescriptor) {
        return BitmapFactory.decodeFileDescriptor(fileDescriptor);
    }

    private static void setWebpBitmapOptions(Bitmap bitmap, Options options) {
        setDensityFromOptions(bitmap, options);
        if (options != null) {
            options.outMimeType = "image/webp";
        }
    }

    @SuppressLint({"NewApi"})
    @DoNotStrip
    private static boolean shouldPremultiply(Options options) {
        return (VERSION.SDK_INT < 19 || options == null) ? true : options.inPremultiplied;
    }

    @DoNotStrip
    private static Bitmap createBitmap(int i, int i2, Options options) {
        if (!IN_BITMAP_SUPPORTED || options == null || options.inBitmap == null || !options.inBitmap.isMutable()) {
            return mBitmapCreator.createNakedBitmap(i, i2, Config.ARGB_8888);
        }
        return options.inBitmap;
    }

    @DoNotStrip
    private static byte[] getInTempStorageFromOptions(Options options) {
        if (options == null || options.inTempStorage == null) {
            return new byte[8192];
        }
        return options.inTempStorage;
    }

    @DoNotStrip
    private static float getScaleFromOptions(Options options) {
        float f = 1.0f;
        if (options == null) {
            return 1.0f;
        }
        int i = options.inSampleSize;
        if (i > 1) {
            f = 1.0f / ((float) i);
        }
        if (!options.inScaled) {
            return f;
        }
        i = options.inDensity;
        int i2 = options.inTargetDensity;
        return (i == 0 || i2 == 0 || i == options.inScreenDensity) ? f : ((float) i2) / ((float) i);
    }

    private static void sendWebpErrorLog(String str) {
        if (mWebpErrorLogger != null) {
            mWebpErrorLogger.onWebpErrorLog(str, "decoding_failure");
        }
    }
}
