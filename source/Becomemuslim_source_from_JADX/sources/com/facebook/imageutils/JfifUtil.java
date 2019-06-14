package com.facebook.imageutils;

import com.facebook.common.internal.Preconditions;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class JfifUtil {
    public static final int APP1_EXIF_MAGIC = 1165519206;
    public static final int MARKER_APP1 = 225;
    public static final int MARKER_EOI = 217;
    public static final int MARKER_ESCAPE_BYTE = 0;
    public static final int MARKER_FIRST_BYTE = 255;
    public static final int MARKER_RST0 = 208;
    public static final int MARKER_RST7 = 215;
    public static final int MARKER_SOFn = 192;
    public static final int MARKER_SOI = 216;
    public static final int MARKER_SOS = 218;
    public static final int MARKER_TEM = 1;

    private static boolean isSOFn(int i) {
        switch (i) {
            case MARKER_SOFn /*192*/:
            case 193:
            case 194:
            case 195:
            case 197:
            case 198:
            case 199:
            case 201:
            case 202:
            case 203:
            case 205:
            case 206:
            case 207:
                return true;
            default:
                return false;
        }
    }

    private JfifUtil() {
    }

    public static int getAutoRotateAngleFromOrientation(int i) {
        return TiffUtil.getAutoRotateAngleFromOrientation(i);
    }

    public static int getOrientation(byte[] bArr) {
        return getOrientation(new ByteArrayInputStream(bArr));
    }

    public static int getOrientation(java.io.InputStream r2) {
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
        r0 = 0;
        r1 = moveToAPP1EXIF(r2);	 Catch:{ IOException -> 0x000d }
        if (r1 != 0) goto L_0x0008;	 Catch:{ IOException -> 0x000d }
    L_0x0007:
        return r0;	 Catch:{ IOException -> 0x000d }
    L_0x0008:
        r2 = com.facebook.imageutils.TiffUtil.readOrientationFromTIFF(r2, r1);	 Catch:{ IOException -> 0x000d }
        return r2;
    L_0x000d:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imageutils.JfifUtil.getOrientation(java.io.InputStream):int");
    }

    public static boolean moveToMarker(InputStream inputStream, int i) {
        Preconditions.checkNotNull(inputStream);
        while (StreamProcessor.readPackedInt(inputStream, 1, false) == MARKER_FIRST_BYTE) {
            int i2 = MARKER_FIRST_BYTE;
            while (i2 == MARKER_FIRST_BYTE) {
                i2 = StreamProcessor.readPackedInt(inputStream, 1, false);
            }
            if ((i == MARKER_SOFn && isSOFn(i2)) || i2 == i) {
                return true;
            }
            if (i2 != MARKER_SOI) {
                if (i2 != 1) {
                    if (i2 != MARKER_EOI) {
                        if (i2 != MARKER_SOS) {
                            inputStream.skip((long) (StreamProcessor.readPackedInt(inputStream, 2, false) - 2));
                        }
                    }
                    return false;
                }
            }
        }
        return false;
    }

    private static int moveToAPP1EXIF(InputStream inputStream) {
        if (moveToMarker(inputStream, MARKER_APP1)) {
            int readPackedInt = StreamProcessor.readPackedInt(inputStream, 2, false) - 2;
            if (readPackedInt > 6) {
                int readPackedInt2 = StreamProcessor.readPackedInt(inputStream, 4, false);
                readPackedInt -= 4;
                inputStream = StreamProcessor.readPackedInt(inputStream, 2, false);
                readPackedInt -= 2;
                if (readPackedInt2 == APP1_EXIF_MAGIC && inputStream == null) {
                    return readPackedInt;
                }
                return 0;
            }
        }
        return 0;
    }
}
