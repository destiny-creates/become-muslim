package com.facebook.stetho.common;

import java.io.Closeable;
import java.io.FileInputStream;

public class ProcessUtil {
    private static final int CMDLINE_BUFFER_SIZE = 64;
    private static String sProcessName;
    private static boolean sProcessNameRead;

    public static synchronized java.lang.String getProcessName() {
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
        r0 = com.facebook.stetho.common.ProcessUtil.class;
        monitor-enter(r0);
        r1 = sProcessNameRead;	 Catch:{ all -> 0x0014 }
        if (r1 != 0) goto L_0x0010;	 Catch:{ all -> 0x0014 }
    L_0x0007:
        r1 = 1;	 Catch:{ all -> 0x0014 }
        sProcessNameRead = r1;	 Catch:{ all -> 0x0014 }
        r1 = readProcessName();	 Catch:{ IOException -> 0x0010 }
        sProcessName = r1;	 Catch:{ IOException -> 0x0010 }
    L_0x0010:
        r1 = sProcessName;	 Catch:{ all -> 0x0014 }
        monitor-exit(r0);
        return r1;
    L_0x0014:
        r1 = move-exception;
        monitor-exit(r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.stetho.common.ProcessUtil.getProcessName():java.lang.String");
    }

    private static String readProcessName() {
        Throwable th;
        byte[] bArr = new byte[64];
        Closeable fileInputStream = new FileInputStream("/proc/self/cmdline");
        int i = 0;
        try {
            int read = fileInputStream.read(bArr);
            try {
                int indexOf = indexOf(bArr, 0, read, (byte) 0);
                if (indexOf > 0) {
                    read = indexOf;
                }
                String str = new String(bArr, 0, read);
                Util.close(fileInputStream, false);
                return str;
            } catch (Throwable th2) {
                th = th2;
                i = 1;
                Util.close(fileInputStream, true ^ i);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            Util.close(fileInputStream, true ^ i);
            throw th;
        }
    }

    private static int indexOf(byte[] bArr, int i, int i2, byte b) {
        for (i = 0; i < bArr.length; i++) {
            if (bArr[i] == b) {
                return i;
            }
        }
        return -1;
    }
}
