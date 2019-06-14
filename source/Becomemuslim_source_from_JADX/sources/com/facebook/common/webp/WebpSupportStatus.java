package com.facebook.common.webp;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.util.Base64;

public class WebpSupportStatus {
    private static final int EXTENDED_WEBP_HEADER_LENGTH = 21;
    private static final int SIMPLE_WEBP_HEADER_LENGTH = 20;
    private static final String VP8X_WEBP_BASE64 = "UklGRkoAAABXRUJQVlA4WAoAAAAQAAAAAAAAAAAAQUxQSAwAAAARBxAR/Q9ERP8DAABWUDggGAAAABQBAJ0BKgEAAQAAAP4AAA3AAP7mtQAAAA==";
    private static final byte[] WEBP_NAME_BYTES = asciiBytes("WEBP");
    private static final byte[] WEBP_RIFF_BYTES = asciiBytes("RIFF");
    private static final byte[] WEBP_VP8L_BYTES = asciiBytes("VP8L");
    private static final byte[] WEBP_VP8X_BYTES = asciiBytes("VP8X");
    private static final byte[] WEBP_VP8_BYTES = asciiBytes("VP8 ");
    public static final boolean sIsExtendedWebpSupported = isExtendedWebpSupported();
    public static final boolean sIsSimpleWebpSupported;
    public static final boolean sIsWebpSupportRequired = (VERSION.SDK_INT <= 17);
    public static WebpBitmapFactory sWebpBitmapFactory = null;
    private static boolean sWebpLibraryChecked = false;

    static {
        boolean z = true;
        if (VERSION.SDK_INT < 14) {
            z = false;
        }
        sIsSimpleWebpSupported = z;
    }

    public static com.facebook.common.webp.WebpBitmapFactory loadWebpBitmapFactoryIfExists() {
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
        r0 = sWebpLibraryChecked;
        if (r0 == 0) goto L_0x0007;
    L_0x0004:
        r0 = sWebpBitmapFactory;
        return r0;
    L_0x0007:
        r0 = 0;
        r1 = "com.facebook.webpsupport.WebpBitmapFactoryImpl";	 Catch:{ Throwable -> 0x0015 }
        r1 = java.lang.Class.forName(r1);	 Catch:{ Throwable -> 0x0015 }
        r1 = r1.newInstance();	 Catch:{ Throwable -> 0x0015 }
        r1 = (com.facebook.common.webp.WebpBitmapFactory) r1;	 Catch:{ Throwable -> 0x0015 }
        r0 = r1;
    L_0x0015:
        r1 = 1;
        sWebpLibraryChecked = r1;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.webp.WebpSupportStatus.loadWebpBitmapFactoryIfExists():com.facebook.common.webp.WebpBitmapFactory");
    }

    private static byte[] asciiBytes(String str) {
        try {
            return str.getBytes("ASCII");
        } catch (String str2) {
            throw new RuntimeException("ASCII not found!", str2);
        }
    }

    private static boolean isExtendedWebpSupported() {
        if (VERSION.SDK_INT < 17) {
            return false;
        }
        if (VERSION.SDK_INT == 17) {
            byte[] decode = Base64.decode(VP8X_WEBP_BASE64, 0);
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(decode, 0, decode.length, options);
            if (!(options.outHeight == 1 && options.outWidth == 1)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isWebpSupportedByPlatform(byte[] bArr, int i, int i2) {
        if (isSimpleWebpHeader(bArr, i)) {
            return sIsSimpleWebpSupported;
        }
        if (isLosslessWebpHeader(bArr, i)) {
            return sIsExtendedWebpSupported;
        }
        if (isExtendedWebpHeader(bArr, i, i2) == 0 || isAnimatedWebpHeader(bArr, i) != null) {
            return false;
        }
        return sIsExtendedWebpSupported;
    }

    public static boolean isAnimatedWebpHeader(byte[] bArr, int i) {
        return matchBytePattern(bArr, i + 12, WEBP_VP8X_BYTES) && ((bArr[i + 20] & 2) == 2 ? 1 : null) != null;
    }

    public static boolean isSimpleWebpHeader(byte[] bArr, int i) {
        return matchBytePattern(bArr, i + 12, WEBP_VP8_BYTES);
    }

    public static boolean isLosslessWebpHeader(byte[] bArr, int i) {
        return matchBytePattern(bArr, i + 12, WEBP_VP8L_BYTES);
    }

    public static boolean isExtendedWebpHeader(byte[] bArr, int i, int i2) {
        return (i2 < 21 || matchBytePattern(bArr, i + 12, WEBP_VP8X_BYTES) == null) ? null : 1;
    }

    public static boolean isExtendedWebpHeaderWithAlpha(byte[] bArr, int i) {
        return matchBytePattern(bArr, i + 12, WEBP_VP8X_BYTES) && ((bArr[i + 20] & 16) == 16 ? 1 : null) != null;
    }

    public static boolean isWebpHeader(byte[] bArr, int i, int i2) {
        return (i2 < 20 || matchBytePattern(bArr, i, WEBP_RIFF_BYTES) == 0 || matchBytePattern(bArr, i + 8, WEBP_NAME_BYTES) == null) ? null : 1;
    }

    private static boolean matchBytePattern(byte[] bArr, int i, byte[] bArr2) {
        if (bArr2 != null) {
            if (bArr != null) {
                if (bArr2.length + i > bArr.length) {
                    return false;
                }
                for (int i2 = 0; i2 < bArr2.length; i2++) {
                    if (bArr[i2 + i] != bArr2[i2]) {
                        return false;
                    }
                }
                return 1;
            }
        }
        return false;
    }
}
