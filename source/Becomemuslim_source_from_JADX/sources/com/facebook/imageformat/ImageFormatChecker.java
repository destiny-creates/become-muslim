package com.facebook.imageformat;

import com.facebook.common.internal.ByteStreams;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import com.facebook.imageformat.ImageFormat.FormatChecker;
import java.io.InputStream;
import java.util.List;

public class ImageFormatChecker {
    private static ImageFormatChecker sInstance;
    private List<FormatChecker> mCustomImageFormatCheckers;
    private final FormatChecker mDefaultFormatChecker = new DefaultImageFormatChecker();
    private int mMaxHeaderLength;

    private ImageFormatChecker() {
        updateMaxHeaderLength();
    }

    public void setCustomImageFormatCheckers(List<FormatChecker> list) {
        this.mCustomImageFormatCheckers = list;
        updateMaxHeaderLength();
    }

    public ImageFormat determineImageFormat(InputStream inputStream) {
        Preconditions.checkNotNull(inputStream);
        byte[] bArr = new byte[this.mMaxHeaderLength];
        inputStream = readHeaderFromStream(this.mMaxHeaderLength, inputStream, bArr);
        ImageFormat determineFormat = this.mDefaultFormatChecker.determineFormat(bArr, inputStream);
        if (determineFormat != null && determineFormat != ImageFormat.UNKNOWN) {
            return determineFormat;
        }
        if (this.mCustomImageFormatCheckers != null) {
            for (FormatChecker determineFormat2 : this.mCustomImageFormatCheckers) {
                ImageFormat determineFormat3 = determineFormat2.determineFormat(bArr, inputStream);
                if (determineFormat3 != null && determineFormat3 != ImageFormat.UNKNOWN) {
                    return determineFormat3;
                }
            }
        }
        return ImageFormat.UNKNOWN;
    }

    private void updateMaxHeaderLength() {
        this.mMaxHeaderLength = this.mDefaultFormatChecker.getHeaderSize();
        if (this.mCustomImageFormatCheckers != null) {
            for (FormatChecker headerSize : this.mCustomImageFormatCheckers) {
                this.mMaxHeaderLength = Math.max(this.mMaxHeaderLength, headerSize.getHeaderSize());
            }
        }
    }

    private static int readHeaderFromStream(int i, InputStream inputStream, byte[] bArr) {
        Preconditions.checkNotNull(inputStream);
        Preconditions.checkNotNull(bArr);
        Preconditions.checkArgument(bArr.length >= i);
        if (!inputStream.markSupported()) {
            return ByteStreams.read(inputStream, bArr, 0, i);
        }
        try {
            inputStream.mark(i);
            i = ByteStreams.read(inputStream, bArr, 0, i);
            return i;
        } finally {
            inputStream.reset();
        }
    }

    public static synchronized ImageFormatChecker getInstance() {
        ImageFormatChecker imageFormatChecker;
        synchronized (ImageFormatChecker.class) {
            if (sInstance == null) {
                sInstance = new ImageFormatChecker();
            }
            imageFormatChecker = sInstance;
        }
        return imageFormatChecker;
    }

    public static ImageFormat getImageFormat(InputStream inputStream) {
        return getInstance().determineImageFormat(inputStream);
    }

    public static ImageFormat getImageFormat_WrapIOException(InputStream inputStream) {
        try {
            return getImageFormat(inputStream);
        } catch (InputStream inputStream2) {
            throw Throwables.propagate(inputStream2);
        }
    }

    public static com.facebook.imageformat.ImageFormat getImageFormat(java.lang.String r2) {
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
        r1 = new java.io.FileInputStream;	 Catch:{ IOException -> 0x0015 }
        r1.<init>(r2);	 Catch:{ IOException -> 0x0015 }
        r2 = getImageFormat(r1);	 Catch:{ IOException -> 0x0011, all -> 0x000e }
        com.facebook.common.internal.Closeables.closeQuietly(r1);
        return r2;
    L_0x000e:
        r2 = move-exception;
        r0 = r1;
        goto L_0x001b;
    L_0x0011:
        r0 = r1;
        goto L_0x0015;
    L_0x0013:
        r2 = move-exception;
        goto L_0x001b;
    L_0x0015:
        r2 = com.facebook.imageformat.ImageFormat.UNKNOWN;	 Catch:{ all -> 0x0013 }
        com.facebook.common.internal.Closeables.closeQuietly(r0);
        return r2;
    L_0x001b:
        com.facebook.common.internal.Closeables.closeQuietly(r0);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imageformat.ImageFormatChecker.getImageFormat(java.lang.String):com.facebook.imageformat.ImageFormat");
    }
}
