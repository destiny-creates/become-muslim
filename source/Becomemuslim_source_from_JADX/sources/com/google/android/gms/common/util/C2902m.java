package com.google.android.gms.common.util;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.google.android.gms.common.util.m */
public final class C2902m {
    /* renamed from: a */
    public static void m8452a(java.io.Closeable r0) {
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
        if (r0 == 0) goto L_0x0006;
    L_0x0002:
        r0.close();	 Catch:{ IOException -> 0x0006 }
        return;
    L_0x0006:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.m.a(java.io.Closeable):void");
    }

    /* renamed from: a */
    private static long m8450a(InputStream inputStream, OutputStream outputStream, boolean z) {
        return C2902m.m8451a(inputStream, outputStream, z, 1024);
    }

    /* renamed from: a */
    public static long m8451a(InputStream inputStream, OutputStream outputStream, boolean z, int i) {
        byte[] bArr = new byte[i];
        long j = 0;
        while (true) {
            try {
                int read = inputStream.read(bArr, 0, i);
                if (read == -1) {
                    break;
                }
                j += (long) read;
                outputStream.write(bArr, 0, read);
            } finally {
                if (z) {
                    C2902m.m8452a(inputStream);
                    C2902m.m8452a(outputStream);
                }
            }
        }
        return j;
    }

    /* renamed from: a */
    public static byte[] m8453a(InputStream inputStream, boolean z) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        C2902m.m8450a(inputStream, byteArrayOutputStream, z);
        return byteArrayOutputStream.toByteArray();
    }
}
