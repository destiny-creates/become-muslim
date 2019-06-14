package com.facebook.react.modules.network;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class ProgressiveStringDecoder {
    private static final String EMPTY_STRING = "";
    private final CharsetDecoder mDecoder;
    private byte[] remainder = null;

    public ProgressiveStringDecoder(Charset charset) {
        this.mDecoder = charset.newDecoder();
    }

    public java.lang.String decodeNext(byte[] r9, int r10) {
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
        r0 = r8.remainder;
        r1 = 0;
        if (r0 == 0) goto L_0x001e;
    L_0x0005:
        r0 = r8.remainder;
        r0 = r0.length;
        r0 = r0 + r10;
        r0 = new byte[r0];
        r2 = r8.remainder;
        r3 = r8.remainder;
        r3 = r3.length;
        java.lang.System.arraycopy(r2, r1, r0, r1, r3);
        r2 = r8.remainder;
        r2 = r2.length;
        java.lang.System.arraycopy(r9, r1, r0, r2, r10);
        r9 = r8.remainder;
        r9 = r9.length;
        r10 = r10 + r9;
        r9 = r0;
    L_0x001e:
        r0 = java.nio.ByteBuffer.wrap(r9, r1, r10);
        r2 = 0;
        r3 = 1;
        r5 = r0;
        r6 = r2;
        r0 = 0;
        r4 = 0;
    L_0x0028:
        if (r0 != 0) goto L_0x003f;
    L_0x002a:
        r7 = 4;
        if (r4 >= r7) goto L_0x003f;
    L_0x002d:
        r7 = r8.mDecoder;	 Catch:{ CharacterCodingException -> 0x0036 }
        r7 = r7.decode(r5);	 Catch:{ CharacterCodingException -> 0x0036 }
        r6 = r7;
        r0 = 1;
        goto L_0x0028;
    L_0x0036:
        r4 = r4 + 1;
        r5 = r10 - r4;
        r5 = java.nio.ByteBuffer.wrap(r9, r1, r5);
        goto L_0x0028;
    L_0x003f:
        if (r0 == 0) goto L_0x0044;
    L_0x0041:
        if (r4 <= 0) goto L_0x0044;
    L_0x0043:
        goto L_0x0045;
    L_0x0044:
        r3 = 0;
    L_0x0045:
        if (r3 == 0) goto L_0x0052;
    L_0x0047:
        r2 = new byte[r4];
        r8.remainder = r2;
        r10 = r10 - r4;
        r2 = r8.remainder;
        java.lang.System.arraycopy(r9, r10, r2, r1, r4);
        goto L_0x0054;
    L_0x0052:
        r8.remainder = r2;
    L_0x0054:
        if (r0 != 0) goto L_0x0060;
    L_0x0056:
        r9 = "ReactNative";
        r10 = "failed to decode string from byte array";
        com.facebook.common.logging.FLog.m5714w(r9, r10);
        r9 = "";
        return r9;
    L_0x0060:
        r9 = new java.lang.String;
        r10 = r6.array();
        r0 = r6.length();
        r9.<init>(r10, r1, r0);
        return r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.modules.network.ProgressiveStringDecoder.decodeNext(byte[], int):java.lang.String");
    }
}
