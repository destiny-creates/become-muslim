package com.google.android.gms.internal.ads;

import com.facebook.imageutils.JfifUtil;
import com.facebook.stetho.common.Utf8Charset;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;

final class agj {
    /* renamed from: a */
    static CountDownLatch f14448a = new CountDownLatch(1);
    /* renamed from: b */
    private static boolean f14449b = false;
    /* renamed from: c */
    private static MessageDigest f14450c;
    /* renamed from: d */
    private static final Object f14451d = new Object();
    /* renamed from: e */
    private static final Object f14452e = new Object();

    /* renamed from: a */
    private static aaa m18407a(long j) {
        aaa aaa = new aaa();
        aaa.f27962k = Long.valueOf(4096);
        return aaa;
    }

    /* renamed from: a */
    static String m18408a(aaa aaa, String str) {
        byte[] a = afo.m18388a((afo) aaa);
        if (((Boolean) aph.m18688f().m18889a(asp.bL)).booleanValue()) {
            Vector a2 = m18410a(a, (int) JfifUtil.MARKER_FIRST_BYTE);
            if (a2 != null) {
                if (a2.size() != 0) {
                    afo agf = new agf();
                    agf.f28097a = new byte[a2.size()][];
                    Iterator it = a2.iterator();
                    int i = 0;
                    while (it.hasNext()) {
                        int i2 = i + 1;
                        agf.f28097a[i] = m18413a((byte[]) it.next(), str, false);
                        i = i2;
                    }
                    agf.f28098b = m18412a(a);
                    a = afo.m18388a(agf);
                }
            }
            a = m18413a(afo.m18388a(m18407a(4096)), str, true);
        } else if (aif.f14565a != null) {
            a = aif.f14565a.mo4387a(a, str != null ? str.getBytes() : new byte[0]);
            afo agf2 = new agf();
            agf2.f28097a = new byte[][]{a};
            agf2.f28099c = Integer.valueOf(2);
            a = afo.m18388a(agf2);
        } else {
            throw new GeneralSecurityException();
        }
        return agh.m18405a(a, true);
    }

    /* renamed from: a */
    private static java.util.Vector<byte[]> m18410a(byte[] r6, int r7) {
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
        r7 = 0;
        if (r6 == 0) goto L_0x002c;
    L_0x0003:
        r0 = r6.length;
        if (r0 > 0) goto L_0x0007;
    L_0x0006:
        goto L_0x002c;
    L_0x0007:
        r0 = r6.length;
        r1 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        r0 = r0 + r1;
        r0 = r0 + -1;
        r0 = r0 / r1;
        r2 = new java.util.Vector;
        r2.<init>();
        r3 = 0;
    L_0x0014:
        if (r3 >= r0) goto L_0x002b;
    L_0x0016:
        r4 = r3 * 255;
        r5 = r6.length;	 Catch:{ IndexOutOfBoundsException -> 0x002a }
        r5 = r5 - r4;	 Catch:{ IndexOutOfBoundsException -> 0x002a }
        if (r5 <= r1) goto L_0x001f;	 Catch:{ IndexOutOfBoundsException -> 0x002a }
    L_0x001c:
        r5 = r4 + 255;	 Catch:{ IndexOutOfBoundsException -> 0x002a }
        goto L_0x0020;	 Catch:{ IndexOutOfBoundsException -> 0x002a }
    L_0x001f:
        r5 = r6.length;	 Catch:{ IndexOutOfBoundsException -> 0x002a }
    L_0x0020:
        r4 = java.util.Arrays.copyOfRange(r6, r4, r5);	 Catch:{ IndexOutOfBoundsException -> 0x002a }
        r2.add(r4);	 Catch:{ IndexOutOfBoundsException -> 0x002a }
        r3 = r3 + 1;
        goto L_0x0014;
    L_0x002a:
        return r7;
    L_0x002b:
        return r2;
    L_0x002c:
        return r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.agj.a(byte[], int):java.util.Vector<byte[]>");
    }

    /* renamed from: a */
    static void m18411a() {
        synchronized (f14452e) {
            if (!f14449b) {
                f14449b = true;
                new Thread(new agl()).start();
            }
        }
    }

    /* renamed from: a */
    public static byte[] m18412a(byte[] bArr) {
        synchronized (f14451d) {
            MessageDigest b = m18414b();
            if (b != null) {
                b.reset();
                b.update(bArr);
                bArr = f14450c.digest();
            } else {
                throw new NoSuchAlgorithmException("Cannot compute hash");
            }
        }
        return bArr;
    }

    /* renamed from: a */
    private static byte[] m18413a(byte[] bArr, String str, boolean z) {
        ByteBuffer put;
        int i = z ? 239 : JfifUtil.MARKER_FIRST_BYTE;
        if (bArr.length > i) {
            bArr = afo.m18388a(m18407a(4096));
        }
        if (bArr.length < i) {
            byte[] bArr2 = new byte[(i - bArr.length)];
            new SecureRandom().nextBytes(bArr2);
            put = ByteBuffer.allocate(i + 1).put((byte) bArr.length).put(bArr).put(bArr2);
        } else {
            put = ByteBuffer.allocate(i + 1).put((byte) bArr.length).put(bArr);
        }
        bArr = put.array();
        if (z) {
            bArr = ByteBuffer.allocate(256).put(m18412a(bArr)).put(bArr).array();
        }
        byte[] bArr3 = new byte[256];
        for (ago a : new agm().cN) {
            a.mo3809a(bArr, bArr3);
        }
        if (str != null && str.length() > 0) {
            if (str.length() > 32) {
                str = str.substring(0, 32);
            }
            new zw(str.getBytes(Utf8Charset.NAME)).m20206a(bArr3);
        }
        return bArr3;
    }

    /* renamed from: b */
    private static java.security.MessageDigest m18414b() {
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
        m18411a();
        r0 = f14448a;	 Catch:{ InterruptedException -> 0x000e }
        r1 = 2;	 Catch:{ InterruptedException -> 0x000e }
        r3 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ InterruptedException -> 0x000e }
        r0 = r0.await(r1, r3);	 Catch:{ InterruptedException -> 0x000e }
        goto L_0x000f;
    L_0x000e:
        r0 = 0;
    L_0x000f:
        r1 = 0;
        if (r0 != 0) goto L_0x0013;
    L_0x0012:
        return r1;
    L_0x0013:
        r0 = f14450c;
        if (r0 != 0) goto L_0x0018;
    L_0x0017:
        return r1;
    L_0x0018:
        r0 = f14450c;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.agj.b():java.security.MessageDigest");
    }
}
