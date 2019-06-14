package com.google.android.exoplayer2.p145g.p147b;

import android.util.Log;
import com.facebook.imageutils.JfifUtil;
import com.facebook.stetho.common.Utf8Charset;
import com.google.android.exoplayer2.p145g.C2344a;
import com.google.android.exoplayer2.p145g.C2356b;
import com.google.android.exoplayer2.p145g.C4709e;
import com.google.android.exoplayer2.p164l.C2529l;
import com.google.android.exoplayer2.p164l.C2541v;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* compiled from: Id3Decoder */
/* renamed from: com.google.android.exoplayer2.g.b.g */
public final class C4162g implements C2356b {
    /* renamed from: a */
    public static final int f10796a = C2541v.m7193g("ID3");
    /* renamed from: b */
    private final C2351a f10797b;

    /* compiled from: Id3Decoder */
    /* renamed from: com.google.android.exoplayer2.g.b.g$a */
    public interface C2351a {
        /* renamed from: a */
        boolean mo2220a(int i, int i2, int i3, int i4, int i5);
    }

    /* compiled from: Id3Decoder */
    /* renamed from: com.google.android.exoplayer2.g.b.g$b */
    private static final class C2352b {
        /* renamed from: a */
        private final int f5807a;
        /* renamed from: b */
        private final boolean f5808b;
        /* renamed from: c */
        private final int f5809c;

        public C2352b(int i, boolean z, int i2) {
            this.f5807a = i;
            this.f5808b = z;
            this.f5809c = i2;
        }
    }

    /* renamed from: a */
    private static String m13239a(int i) {
        switch (i) {
            case 0:
                return "ISO-8859-1";
            case 1:
                return "UTF-16";
            case 2:
                return "UTF-16BE";
            case 3:
                return Utf8Charset.NAME;
            default:
                return "ISO-8859-1";
        }
    }

    /* renamed from: b */
    private static int m13242b(int i) {
        if (i != 0) {
            if (i != 3) {
                return 2;
            }
        }
        return 1;
    }

    public C4162g() {
        this(null);
    }

    public C4162g(C2351a c2351a) {
        this.f10797b = c2351a;
    }

    /* renamed from: a */
    public C2344a mo2227a(C4709e c4709e) {
        c4709e = c4709e.b;
        return m13254a(c4709e.array(), c4709e.limit());
    }

    /* renamed from: a */
    public C2344a m13254a(byte[] bArr, int i) {
        List arrayList = new ArrayList();
        C2529l c2529l = new C2529l(bArr, i);
        bArr = C4162g.m13235a(c2529l);
        if (bArr == null) {
            return null;
        }
        int d = c2529l.m7097d();
        int i2 = bArr.f5807a == 2 ? 6 : 10;
        int b = bArr.f5809c;
        if (bArr.f5808b) {
            b = C4162g.m13252f(c2529l, bArr.f5809c);
        }
        c2529l.m7094b(d + b);
        boolean z = false;
        if (!C4162g.m13241a(c2529l, bArr.f5807a, i2, false)) {
            if (bArr.f5807a == 4 && C4162g.m13241a(c2529l, 4, i2, true)) {
                z = true;
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Failed to validate ID3 tag with majorVersion=");
                stringBuilder.append(bArr.f5807a);
                Log.w("Id3Decoder", stringBuilder.toString());
                return null;
            }
        }
        while (c2529l.m7093b() >= i2) {
            i = C4162g.m13236a(bArr.f5807a, c2529l, z, i2, this.f10797b);
            if (i != 0) {
                arrayList.add(i);
            }
        }
        return new C2344a(arrayList);
    }

    /* renamed from: a */
    private static C2352b m13235a(C2529l c2529l) {
        if (c2529l.m7093b() < 10) {
            Log.w("Id3Decoder", "Data too short to be an ID3 tag");
            return null;
        }
        int k = c2529l.m7107k();
        if (k != f10796a) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unexpected first three bytes of ID3 tag header: ");
            stringBuilder.append(k);
            Log.w("Id3Decoder", stringBuilder.toString());
            return null;
        }
        k = c2529l.m7103g();
        boolean z = true;
        c2529l.m7098d(1);
        int g = c2529l.m7103g();
        int t = c2529l.m7116t();
        if (k == 2) {
            if (((g & 64) != null ? true : null) != null) {
                Log.w("Id3Decoder", "Skipped ID3 tag with majorVersion=2 and undefined compression scheme");
                return null;
            }
        } else if (k == 3) {
            if (((g & 64) != 0 ? 1 : null) != null) {
                r1 = c2529l.m7111o();
                c2529l.m7098d(r1);
                t -= r1 + 4;
            }
        } else if (k == 4) {
            if (((g & 64) != 0 ? 1 : null) != null) {
                r1 = c2529l.m7116t();
                c2529l.m7098d(r1 - 4);
                t -= r1;
            }
            if (((g & 16) != null ? true : null) != null) {
                t -= 10;
            }
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Skipped ID3 tag with unsupported majorVersion=");
            stringBuilder.append(k);
            Log.w("Id3Decoder", stringBuilder.toString());
            return null;
        }
        if (k >= 4 || (g & 128) == null) {
            z = false;
        }
        return new C2352b(k, z, t);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private static boolean m13241a(com.google.android.exoplayer2.p164l.C2529l r18, int r19, int r20, boolean r21) {
        /*
        r1 = r18;
        r0 = r19;
        r2 = r18.m7097d();
    L_0x0008:
        r3 = r18.m7093b();	 Catch:{ all -> 0x00b2 }
        r4 = 1;
        r5 = r20;
        if (r3 < r5) goto L_0x00ae;
    L_0x0011:
        r3 = 3;
        r6 = 0;
        if (r0 < r3) goto L_0x0022;
    L_0x0015:
        r7 = r18.m7111o();	 Catch:{ all -> 0x00b2 }
        r8 = r18.m7109m();	 Catch:{ all -> 0x00b2 }
        r10 = r18.m7104h();	 Catch:{ all -> 0x00b2 }
        goto L_0x002c;
    L_0x0022:
        r7 = r18.m7107k();	 Catch:{ all -> 0x00b2 }
        r8 = r18.m7107k();	 Catch:{ all -> 0x00b2 }
        r8 = (long) r8;
        r10 = 0;
    L_0x002c:
        r11 = 0;
        if (r7 != 0) goto L_0x003a;
    L_0x0030:
        r7 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1));
        if (r7 != 0) goto L_0x003a;
    L_0x0034:
        if (r10 != 0) goto L_0x003a;
    L_0x0036:
        r1.m7096c(r2);
        return r4;
    L_0x003a:
        r7 = 4;
        if (r0 != r7) goto L_0x006b;
    L_0x003d:
        if (r21 != 0) goto L_0x006b;
    L_0x003f:
        r13 = 8421504; // 0x808080 float:1.180104E-38 double:4.160776E-317;
        r13 = r13 & r8;
        r11 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1));
        if (r11 == 0) goto L_0x004b;
    L_0x0047:
        r1.m7096c(r2);
        return r6;
    L_0x004b:
        r11 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        r13 = r8 & r11;
        r15 = 8;
        r15 = r8 >> r15;
        r15 = r15 & r11;
        r17 = 7;
        r15 = r15 << r17;
        r13 = r13 | r15;
        r15 = 16;
        r15 = r8 >> r15;
        r15 = r15 & r11;
        r17 = 14;
        r15 = r15 << r17;
        r13 = r13 | r15;
        r15 = 24;
        r8 = r8 >> r15;
        r8 = r8 & r11;
        r11 = 21;
        r8 = r8 << r11;
        r8 = r8 | r13;
    L_0x006b:
        if (r0 != r7) goto L_0x007a;
    L_0x006d:
        r3 = r10 & 64;
        if (r3 == 0) goto L_0x0073;
    L_0x0071:
        r3 = 1;
        goto L_0x0074;
    L_0x0073:
        r3 = 0;
    L_0x0074:
        r7 = r10 & 1;
        if (r7 == 0) goto L_0x0089;
    L_0x0078:
        r7 = 1;
        goto L_0x008a;
    L_0x007a:
        if (r0 != r3) goto L_0x0088;
    L_0x007c:
        r3 = r10 & 32;
        if (r3 == 0) goto L_0x0082;
    L_0x0080:
        r3 = 1;
        goto L_0x0083;
    L_0x0082:
        r3 = 0;
    L_0x0083:
        r7 = r10 & 128;
        if (r7 == 0) goto L_0x0089;
    L_0x0087:
        goto L_0x0078;
    L_0x0088:
        r3 = 0;
    L_0x0089:
        r7 = 0;
    L_0x008a:
        if (r3 == 0) goto L_0x008d;
    L_0x008c:
        goto L_0x008e;
    L_0x008d:
        r4 = 0;
    L_0x008e:
        if (r7 == 0) goto L_0x0092;
    L_0x0090:
        r4 = r4 + 4;
    L_0x0092:
        r3 = (long) r4;
        r3 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1));
        if (r3 >= 0) goto L_0x009b;
    L_0x0097:
        r1.m7096c(r2);
        return r6;
    L_0x009b:
        r3 = r18.m7093b();	 Catch:{ all -> 0x00b2 }
        r3 = (long) r3;
        r3 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1));
        if (r3 >= 0) goto L_0x00a8;
    L_0x00a4:
        r1.m7096c(r2);
        return r6;
    L_0x00a8:
        r3 = (int) r8;
        r1.m7098d(r3);	 Catch:{ all -> 0x00b2 }
        goto L_0x0008;
    L_0x00ae:
        r1.m7096c(r2);
        return r4;
    L_0x00b2:
        r0 = move-exception;
        r1.m7096c(r2);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.g.b.g.a(com.google.android.exoplayer2.l.l, int, int, boolean):boolean");
    }

    /* renamed from: a */
    private static com.google.android.exoplayer2.p145g.p147b.C4163h m13236a(int r19, com.google.android.exoplayer2.p164l.C2529l r20, boolean r21, int r22, com.google.android.exoplayer2.p145g.p147b.C4162g.C2351a r23) {
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
        r0 = r19;
        r7 = r20;
        r8 = r20.m7103g();
        r9 = r20.m7103g();
        r10 = r20.m7103g();
        r11 = 3;
        if (r0 < r11) goto L_0x0019;
    L_0x0013:
        r1 = r20.m7103g();
        r13 = r1;
        goto L_0x001a;
    L_0x0019:
        r13 = 0;
    L_0x001a:
        r14 = 4;
        if (r0 != r14) goto L_0x003c;
    L_0x001d:
        r1 = r20.m7117u();
        if (r21 != 0) goto L_0x003a;
    L_0x0023:
        r2 = r1 & 255;
        r3 = r1 >> 8;
        r3 = r3 & 255;
        r3 = r3 << 7;
        r2 = r2 | r3;
        r3 = r1 >> 16;
        r3 = r3 & 255;
        r3 = r3 << 14;
        r2 = r2 | r3;
        r1 = r1 >> 24;
        r1 = r1 & 255;
        r1 = r1 << 21;
        r1 = r1 | r2;
    L_0x003a:
        r15 = r1;
        goto L_0x0048;
    L_0x003c:
        if (r0 != r11) goto L_0x0043;
    L_0x003e:
        r1 = r20.m7117u();
        goto L_0x003a;
    L_0x0043:
        r1 = r20.m7107k();
        goto L_0x003a;
    L_0x0048:
        if (r0 < r11) goto L_0x0050;
    L_0x004a:
        r1 = r20.m7104h();
        r6 = r1;
        goto L_0x0051;
    L_0x0050:
        r6 = 0;
    L_0x0051:
        r16 = 0;
        if (r8 != 0) goto L_0x0067;
    L_0x0055:
        if (r9 != 0) goto L_0x0067;
    L_0x0057:
        if (r10 != 0) goto L_0x0067;
    L_0x0059:
        if (r13 != 0) goto L_0x0067;
    L_0x005b:
        if (r15 != 0) goto L_0x0067;
    L_0x005d:
        if (r6 != 0) goto L_0x0067;
    L_0x005f:
        r0 = r20.m7095c();
        r7.m7096c(r0);
        return r16;
    L_0x0067:
        r1 = r20.m7097d();
        r5 = r1 + r15;
        r1 = r20.m7095c();
        if (r5 <= r1) goto L_0x0082;
    L_0x0073:
        r0 = "Id3Decoder";
        r1 = "Frame size exceeds remaining tag data";
        android.util.Log.w(r0, r1);
        r0 = r20.m7095c();
        r7.m7096c(r0);
        return r16;
    L_0x0082:
        if (r23 == 0) goto L_0x0098;
    L_0x0084:
        r1 = r23;
        r2 = r19;
        r3 = r8;
        r4 = r9;
        r12 = r5;
        r5 = r10;
        r14 = r6;
        r6 = r13;
        r1 = r1.mo2220a(r2, r3, r4, r5, r6);
        if (r1 != 0) goto L_0x009a;
    L_0x0094:
        r7.m7096c(r12);
        return r16;
    L_0x0098:
        r12 = r5;
        r14 = r6;
    L_0x009a:
        r1 = 1;
        if (r0 != r11) goto L_0x00b7;
    L_0x009d:
        r2 = r14 & 128;
        if (r2 == 0) goto L_0x00a3;
    L_0x00a1:
        r2 = 1;
        goto L_0x00a4;
    L_0x00a3:
        r2 = 0;
    L_0x00a4:
        r3 = r14 & 64;
        if (r3 == 0) goto L_0x00aa;
    L_0x00a8:
        r3 = 1;
        goto L_0x00ab;
    L_0x00aa:
        r3 = 0;
    L_0x00ab:
        r4 = r14 & 32;
        if (r4 == 0) goto L_0x00b1;
    L_0x00af:
        r4 = 1;
        goto L_0x00b2;
    L_0x00b1:
        r4 = 0;
    L_0x00b2:
        r17 = r3;
        r5 = 0;
        r3 = r2;
        goto L_0x00ee;
    L_0x00b7:
        r2 = 4;
        if (r0 != r2) goto L_0x00e8;
    L_0x00ba:
        r2 = r14 & 64;
        if (r2 == 0) goto L_0x00c0;
    L_0x00be:
        r2 = 1;
        goto L_0x00c1;
    L_0x00c0:
        r2 = 0;
    L_0x00c1:
        r3 = r14 & 8;
        if (r3 == 0) goto L_0x00c7;
    L_0x00c5:
        r3 = 1;
        goto L_0x00c8;
    L_0x00c7:
        r3 = 0;
    L_0x00c8:
        r4 = r14 & 4;
        if (r4 == 0) goto L_0x00ce;
    L_0x00cc:
        r4 = 1;
        goto L_0x00cf;
    L_0x00ce:
        r4 = 0;
    L_0x00cf:
        r5 = r14 & 2;
        if (r5 == 0) goto L_0x00d5;
    L_0x00d3:
        r5 = 1;
        goto L_0x00d6;
    L_0x00d5:
        r5 = 0;
    L_0x00d6:
        r6 = r14 & 1;
        if (r6 == 0) goto L_0x00dd;
    L_0x00da:
        r17 = 1;
        goto L_0x00df;
    L_0x00dd:
        r17 = 0;
    L_0x00df:
        r18 = r4;
        r4 = r2;
        r2 = r3;
        r3 = r17;
        r17 = r18;
        goto L_0x00ee;
    L_0x00e8:
        r2 = 0;
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r17 = 0;
    L_0x00ee:
        if (r2 != 0) goto L_0x021d;
    L_0x00f0:
        if (r17 == 0) goto L_0x00f4;
    L_0x00f2:
        goto L_0x021d;
    L_0x00f4:
        if (r4 == 0) goto L_0x00fb;
    L_0x00f6:
        r15 = r15 + -1;
        r7.m7098d(r1);
    L_0x00fb:
        if (r3 == 0) goto L_0x0103;
    L_0x00fd:
        r15 = r15 + -4;
        r1 = 4;
        r7.m7098d(r1);
    L_0x0103:
        r1 = r15;
        if (r5 == 0) goto L_0x010a;
    L_0x0106:
        r1 = com.google.android.exoplayer2.p145g.p147b.C4162g.m13252f(r7, r1);
    L_0x010a:
        r11 = r1;
        r1 = 84;
        r2 = 88;
        r3 = 2;
        if (r8 != r1) goto L_0x0120;
    L_0x0112:
        if (r9 != r2) goto L_0x0120;
    L_0x0114:
        if (r10 != r2) goto L_0x0120;
    L_0x0116:
        if (r0 == r3) goto L_0x011a;
    L_0x0118:
        if (r13 != r2) goto L_0x0120;
    L_0x011a:
        r1 = com.google.android.exoplayer2.p145g.p147b.C4162g.m13237a(r7, r11);	 Catch:{ UnsupportedEncodingException -> 0x020e }
        goto L_0x01e6;	 Catch:{ UnsupportedEncodingException -> 0x020e }
    L_0x0120:
        if (r8 != r1) goto L_0x012f;	 Catch:{ UnsupportedEncodingException -> 0x020e }
    L_0x0122:
        r1 = com.google.android.exoplayer2.p145g.p147b.C4162g.m13240a(r0, r8, r9, r10, r13);	 Catch:{ UnsupportedEncodingException -> 0x020e }
        r1 = com.google.android.exoplayer2.p145g.p147b.C4162g.m13238a(r7, r11, r1);	 Catch:{ UnsupportedEncodingException -> 0x020e }
        goto L_0x01e6;	 Catch:{ UnsupportedEncodingException -> 0x020e }
    L_0x012c:
        r0 = move-exception;	 Catch:{ UnsupportedEncodingException -> 0x020e }
        goto L_0x0219;	 Catch:{ UnsupportedEncodingException -> 0x020e }
    L_0x012f:
        r4 = 87;	 Catch:{ UnsupportedEncodingException -> 0x020e }
        if (r8 != r4) goto L_0x0141;	 Catch:{ UnsupportedEncodingException -> 0x020e }
    L_0x0133:
        if (r9 != r2) goto L_0x0141;	 Catch:{ UnsupportedEncodingException -> 0x020e }
    L_0x0135:
        if (r10 != r2) goto L_0x0141;	 Catch:{ UnsupportedEncodingException -> 0x020e }
    L_0x0137:
        if (r0 == r3) goto L_0x013b;	 Catch:{ UnsupportedEncodingException -> 0x020e }
    L_0x0139:
        if (r13 != r2) goto L_0x0141;	 Catch:{ UnsupportedEncodingException -> 0x020e }
    L_0x013b:
        r1 = com.google.android.exoplayer2.p145g.p147b.C4162g.m13245b(r7, r11);	 Catch:{ UnsupportedEncodingException -> 0x020e }
        goto L_0x01e6;	 Catch:{ UnsupportedEncodingException -> 0x020e }
    L_0x0141:
        r2 = 87;	 Catch:{ UnsupportedEncodingException -> 0x020e }
        if (r8 != r2) goto L_0x014f;	 Catch:{ UnsupportedEncodingException -> 0x020e }
    L_0x0145:
        r1 = com.google.android.exoplayer2.p145g.p147b.C4162g.m13240a(r0, r8, r9, r10, r13);	 Catch:{ UnsupportedEncodingException -> 0x020e }
        r1 = com.google.android.exoplayer2.p145g.p147b.C4162g.m13246b(r7, r11, r1);	 Catch:{ UnsupportedEncodingException -> 0x020e }
        goto L_0x01e6;	 Catch:{ UnsupportedEncodingException -> 0x020e }
    L_0x014f:
        r2 = 73;	 Catch:{ UnsupportedEncodingException -> 0x020e }
        r4 = 80;	 Catch:{ UnsupportedEncodingException -> 0x020e }
        if (r8 != r4) goto L_0x0165;	 Catch:{ UnsupportedEncodingException -> 0x020e }
    L_0x0155:
        r5 = 82;	 Catch:{ UnsupportedEncodingException -> 0x020e }
        if (r9 != r5) goto L_0x0165;	 Catch:{ UnsupportedEncodingException -> 0x020e }
    L_0x0159:
        if (r10 != r2) goto L_0x0165;	 Catch:{ UnsupportedEncodingException -> 0x020e }
    L_0x015b:
        r5 = 86;	 Catch:{ UnsupportedEncodingException -> 0x020e }
        if (r13 != r5) goto L_0x0165;	 Catch:{ UnsupportedEncodingException -> 0x020e }
    L_0x015f:
        r1 = com.google.android.exoplayer2.p145g.p147b.C4162g.m13249c(r7, r11);	 Catch:{ UnsupportedEncodingException -> 0x020e }
        goto L_0x01e6;	 Catch:{ UnsupportedEncodingException -> 0x020e }
    L_0x0165:
        r5 = 71;	 Catch:{ UnsupportedEncodingException -> 0x020e }
        r6 = 79;	 Catch:{ UnsupportedEncodingException -> 0x020e }
        if (r8 != r5) goto L_0x017d;	 Catch:{ UnsupportedEncodingException -> 0x020e }
    L_0x016b:
        r5 = 69;	 Catch:{ UnsupportedEncodingException -> 0x020e }
        if (r9 != r5) goto L_0x017d;	 Catch:{ UnsupportedEncodingException -> 0x020e }
    L_0x016f:
        if (r10 != r6) goto L_0x017d;	 Catch:{ UnsupportedEncodingException -> 0x020e }
    L_0x0171:
        r5 = 66;	 Catch:{ UnsupportedEncodingException -> 0x020e }
        if (r13 == r5) goto L_0x0177;	 Catch:{ UnsupportedEncodingException -> 0x020e }
    L_0x0175:
        if (r0 != r3) goto L_0x017d;	 Catch:{ UnsupportedEncodingException -> 0x020e }
    L_0x0177:
        r1 = com.google.android.exoplayer2.p145g.p147b.C4162g.m13250d(r7, r11);	 Catch:{ UnsupportedEncodingException -> 0x020e }
        goto L_0x01e6;	 Catch:{ UnsupportedEncodingException -> 0x020e }
    L_0x017d:
        r5 = 67;	 Catch:{ UnsupportedEncodingException -> 0x020e }
        if (r0 != r3) goto L_0x0188;	 Catch:{ UnsupportedEncodingException -> 0x020e }
    L_0x0181:
        if (r8 != r4) goto L_0x0197;	 Catch:{ UnsupportedEncodingException -> 0x020e }
    L_0x0183:
        if (r9 != r2) goto L_0x0197;	 Catch:{ UnsupportedEncodingException -> 0x020e }
    L_0x0185:
        if (r10 != r5) goto L_0x0197;	 Catch:{ UnsupportedEncodingException -> 0x020e }
    L_0x0187:
        goto L_0x0192;	 Catch:{ UnsupportedEncodingException -> 0x020e }
    L_0x0188:
        r14 = 65;	 Catch:{ UnsupportedEncodingException -> 0x020e }
        if (r8 != r14) goto L_0x0197;	 Catch:{ UnsupportedEncodingException -> 0x020e }
    L_0x018c:
        if (r9 != r4) goto L_0x0197;	 Catch:{ UnsupportedEncodingException -> 0x020e }
    L_0x018e:
        if (r10 != r2) goto L_0x0197;	 Catch:{ UnsupportedEncodingException -> 0x020e }
    L_0x0190:
        if (r13 != r5) goto L_0x0197;	 Catch:{ UnsupportedEncodingException -> 0x020e }
    L_0x0192:
        r1 = com.google.android.exoplayer2.p145g.p147b.C4162g.m13233a(r7, r11, r0);	 Catch:{ UnsupportedEncodingException -> 0x020e }
        goto L_0x01e6;	 Catch:{ UnsupportedEncodingException -> 0x020e }
    L_0x0197:
        if (r8 != r5) goto L_0x01aa;	 Catch:{ UnsupportedEncodingException -> 0x020e }
    L_0x0199:
        if (r9 != r6) goto L_0x01aa;	 Catch:{ UnsupportedEncodingException -> 0x020e }
    L_0x019b:
        r2 = 77;	 Catch:{ UnsupportedEncodingException -> 0x020e }
        if (r10 != r2) goto L_0x01aa;	 Catch:{ UnsupportedEncodingException -> 0x020e }
    L_0x019f:
        r2 = 77;	 Catch:{ UnsupportedEncodingException -> 0x020e }
        if (r13 == r2) goto L_0x01a5;	 Catch:{ UnsupportedEncodingException -> 0x020e }
    L_0x01a3:
        if (r0 != r3) goto L_0x01aa;	 Catch:{ UnsupportedEncodingException -> 0x020e }
    L_0x01a5:
        r1 = com.google.android.exoplayer2.p145g.p147b.C4162g.m13251e(r7, r11);	 Catch:{ UnsupportedEncodingException -> 0x020e }
        goto L_0x01e6;	 Catch:{ UnsupportedEncodingException -> 0x020e }
    L_0x01aa:
        if (r8 != r5) goto L_0x01c6;	 Catch:{ UnsupportedEncodingException -> 0x020e }
    L_0x01ac:
        r2 = 72;	 Catch:{ UnsupportedEncodingException -> 0x020e }
        if (r9 != r2) goto L_0x01c6;	 Catch:{ UnsupportedEncodingException -> 0x020e }
    L_0x01b0:
        r2 = 65;	 Catch:{ UnsupportedEncodingException -> 0x020e }
        if (r10 != r2) goto L_0x01c6;	 Catch:{ UnsupportedEncodingException -> 0x020e }
    L_0x01b4:
        if (r13 != r4) goto L_0x01c6;	 Catch:{ UnsupportedEncodingException -> 0x020e }
    L_0x01b6:
        r1 = r20;	 Catch:{ UnsupportedEncodingException -> 0x020e }
        r2 = r11;	 Catch:{ UnsupportedEncodingException -> 0x020e }
        r3 = r19;	 Catch:{ UnsupportedEncodingException -> 0x020e }
        r4 = r21;	 Catch:{ UnsupportedEncodingException -> 0x020e }
        r5 = r22;	 Catch:{ UnsupportedEncodingException -> 0x020e }
        r6 = r23;	 Catch:{ UnsupportedEncodingException -> 0x020e }
        r1 = com.google.android.exoplayer2.p145g.p147b.C4162g.m13234a(r1, r2, r3, r4, r5, r6);	 Catch:{ UnsupportedEncodingException -> 0x020e }
        goto L_0x01e6;	 Catch:{ UnsupportedEncodingException -> 0x020e }
    L_0x01c6:
        if (r8 != r5) goto L_0x01de;	 Catch:{ UnsupportedEncodingException -> 0x020e }
    L_0x01c8:
        if (r9 != r1) goto L_0x01de;	 Catch:{ UnsupportedEncodingException -> 0x020e }
    L_0x01ca:
        if (r10 != r6) goto L_0x01de;	 Catch:{ UnsupportedEncodingException -> 0x020e }
    L_0x01cc:
        if (r13 != r5) goto L_0x01de;	 Catch:{ UnsupportedEncodingException -> 0x020e }
    L_0x01ce:
        r1 = r20;	 Catch:{ UnsupportedEncodingException -> 0x020e }
        r2 = r11;	 Catch:{ UnsupportedEncodingException -> 0x020e }
        r3 = r19;	 Catch:{ UnsupportedEncodingException -> 0x020e }
        r4 = r21;	 Catch:{ UnsupportedEncodingException -> 0x020e }
        r5 = r22;	 Catch:{ UnsupportedEncodingException -> 0x020e }
        r6 = r23;	 Catch:{ UnsupportedEncodingException -> 0x020e }
        r1 = com.google.android.exoplayer2.p145g.p147b.C4162g.m13244b(r1, r2, r3, r4, r5, r6);	 Catch:{ UnsupportedEncodingException -> 0x020e }
        goto L_0x01e6;	 Catch:{ UnsupportedEncodingException -> 0x020e }
    L_0x01de:
        r1 = com.google.android.exoplayer2.p145g.p147b.C4162g.m13240a(r0, r8, r9, r10, r13);	 Catch:{ UnsupportedEncodingException -> 0x020e }
        r1 = com.google.android.exoplayer2.p145g.p147b.C4162g.m13248c(r7, r11, r1);	 Catch:{ UnsupportedEncodingException -> 0x020e }
    L_0x01e6:
        if (r1 != 0) goto L_0x020a;	 Catch:{ UnsupportedEncodingException -> 0x020e }
    L_0x01e8:
        r2 = "Id3Decoder";	 Catch:{ UnsupportedEncodingException -> 0x020e }
        r3 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x020e }
        r3.<init>();	 Catch:{ UnsupportedEncodingException -> 0x020e }
        r4 = "Failed to decode frame: id=";	 Catch:{ UnsupportedEncodingException -> 0x020e }
        r3.append(r4);	 Catch:{ UnsupportedEncodingException -> 0x020e }
        r0 = com.google.android.exoplayer2.p145g.p147b.C4162g.m13240a(r0, r8, r9, r10, r13);	 Catch:{ UnsupportedEncodingException -> 0x020e }
        r3.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x020e }
        r0 = ", frameSize=";	 Catch:{ UnsupportedEncodingException -> 0x020e }
        r3.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x020e }
        r3.append(r11);	 Catch:{ UnsupportedEncodingException -> 0x020e }
        r0 = r3.toString();	 Catch:{ UnsupportedEncodingException -> 0x020e }
        android.util.Log.w(r2, r0);	 Catch:{ UnsupportedEncodingException -> 0x020e }
    L_0x020a:
        r7.m7096c(r12);
        return r1;
    L_0x020e:
        r0 = "Id3Decoder";	 Catch:{ all -> 0x012c }
        r1 = "Unsupported character encoding";	 Catch:{ all -> 0x012c }
        android.util.Log.w(r0, r1);	 Catch:{ all -> 0x012c }
        r7.m7096c(r12);
        return r16;
    L_0x0219:
        r7.m7096c(r12);
        throw r0;
    L_0x021d:
        r0 = "Id3Decoder";
        r1 = "Skipping unsupported compressed or encrypted frame";
        android.util.Log.w(r0, r1);
        r7.m7096c(r12);
        return r16;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.g.b.g.a(int, com.google.android.exoplayer2.l.l, boolean, int, com.google.android.exoplayer2.g.b.g$a):com.google.android.exoplayer2.g.b.h");
    }

    /* renamed from: a */
    private static C4702j m13237a(C2529l c2529l, int i) {
        if (i < 1) {
            return null;
        }
        int g = c2529l.m7103g();
        String a = C4162g.m13239a(g);
        i--;
        byte[] bArr = new byte[i];
        c2529l.m7092a(bArr, 0, i);
        c2529l = C4162g.m13232a(bArr, 0, g);
        i = new String(bArr, 0, c2529l, a);
        int b = c2529l + C4162g.m13242b(g);
        return new C4702j("TXXX", i, b < bArr.length ? new String(bArr, b, C4162g.m13232a(bArr, b, g) - b, a) : "");
    }

    /* renamed from: a */
    private static C4702j m13238a(C2529l c2529l, int i, String str) {
        if (i < 1) {
            return null;
        }
        int g = c2529l.m7103g();
        String a = C4162g.m13239a(g);
        i--;
        byte[] bArr = new byte[i];
        c2529l.m7092a(bArr, 0, i);
        return new C4702j(str, null, new String(bArr, 0, C4162g.m13232a(bArr, 0, g), a));
    }

    /* renamed from: b */
    private static C4703k m13245b(C2529l c2529l, int i) {
        if (i < 1) {
            return null;
        }
        int g = c2529l.m7103g();
        String a = C4162g.m13239a(g);
        i--;
        byte[] bArr = new byte[i];
        c2529l.m7092a(bArr, 0, i);
        c2529l = C4162g.m13232a(bArr, 0, g);
        i = new String(bArr, 0, c2529l, a);
        int b = c2529l + C4162g.m13242b(g);
        return new C4703k("WXXX", i, b < bArr.length ? new String(bArr, b, C4162g.m13243b(bArr, b) - b, "ISO-8859-1") : "");
    }

    /* renamed from: b */
    private static C4703k m13246b(C2529l c2529l, int i, String str) {
        byte[] bArr = new byte[i];
        c2529l.m7092a(bArr, 0, i);
        return new C4703k(str, null, new String(bArr, 0, C4162g.m13243b(bArr, 0), "ISO-8859-1"));
    }

    /* renamed from: c */
    private static C4701i m13249c(C2529l c2529l, int i) {
        byte[] bArr = new byte[i];
        c2529l.m7092a(bArr, 0, i);
        c2529l = C4162g.m13243b(bArr, 0);
        return new C4701i(new String(bArr, 0, c2529l, "ISO-8859-1"), C4162g.m13247b(bArr, c2529l + 1, bArr.length));
    }

    /* renamed from: d */
    private static C4700f m13250d(C2529l c2529l, int i) {
        int g = c2529l.m7103g();
        String a = C4162g.m13239a(g);
        i--;
        byte[] bArr = new byte[i];
        c2529l.m7092a(bArr, 0, i);
        c2529l = C4162g.m13243b(bArr, 0);
        i = new String(bArr, 0, c2529l, "ISO-8859-1");
        int i2 = c2529l + 1;
        int a2 = C4162g.m13232a(bArr, i2, g);
        String str = new String(bArr, i2, a2 - i2, a);
        a2 += C4162g.m13242b(g);
        c2529l = C4162g.m13232a(bArr, a2, g);
        return new C4700f(i, str, new String(bArr, a2, c2529l - a2, a), C4162g.m13247b(bArr, c2529l + C4162g.m13242b(g), bArr.length));
    }

    /* renamed from: a */
    private static C4695a m13233a(C2529l c2529l, int i, int i2) {
        int g = c2529l.m7103g();
        String a = C4162g.m13239a(g);
        i--;
        byte[] bArr = new byte[i];
        c2529l.m7092a(bArr, 0, i);
        if (i2 == 2) {
            i = new StringBuilder();
            i.append("image/");
            i.append(C2541v.m7190d(new String(bArr, 0, 3, "ISO-8859-1")));
            i = i.toString();
            if (i.equals("image/jpg") != 0) {
                i = "image/jpeg";
            }
            i2 = i;
            i = 2;
        } else {
            i = C4162g.m13243b(bArr, 0);
            i2 = C2541v.m7190d(new String(bArr, 0, i, "ISO-8859-1"));
            if (i2.indexOf(47) == -1) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("image/");
                stringBuilder.append(i2);
                i2 = stringBuilder.toString();
            }
        }
        int i3 = bArr[i + 1] & JfifUtil.MARKER_FIRST_BYTE;
        i += 2;
        c2529l = C4162g.m13232a(bArr, i, g);
        return new C4695a(i2, new String(bArr, i, c2529l - i, a), i3, C4162g.m13247b(bArr, c2529l + C4162g.m13242b(g), bArr.length));
    }

    /* renamed from: e */
    private static C4699e m13251e(C2529l c2529l, int i) {
        if (i < 4) {
            return null;
        }
        int g = c2529l.m7103g();
        String a = C4162g.m13239a(g);
        byte[] bArr = new byte[3];
        c2529l.m7092a(bArr, 0, 3);
        String str = new String(bArr, 0, 3);
        i -= 4;
        byte[] bArr2 = new byte[i];
        c2529l.m7092a(bArr2, 0, i);
        c2529l = C4162g.m13232a(bArr2, 0, g);
        i = new String(bArr2, 0, c2529l, a);
        int b = c2529l + C4162g.m13242b(g);
        return new C4699e(str, i, b < bArr2.length ? new String(bArr2, b, C4162g.m13232a(bArr2, b, g) - b, a) : "");
    }

    /* renamed from: a */
    private static C4697c m13234a(C2529l c2529l, int i, int i2, boolean z, int i3, C2351a c2351a) {
        C2529l c2529l2 = c2529l;
        int d = c2529l.m7097d();
        int b = C4162g.m13243b(c2529l2.f6441a, d);
        String str = new String(c2529l2.f6441a, d, b - d, "ISO-8859-1");
        c2529l.m7096c(b + 1);
        int o = c2529l.m7111o();
        int o2 = c2529l.m7111o();
        long m = c2529l.m7109m();
        long j = m == 4294967295L ? -1 : m;
        m = c2529l.m7109m();
        long j2 = m == 4294967295L ? -1 : m;
        ArrayList arrayList = new ArrayList();
        d += i;
        while (c2529l.m7097d() < d) {
            C4163h a = C4162g.m13236a(i2, c2529l, z, i3, c2351a);
            if (a != null) {
                arrayList.add(a);
            }
        }
        C4163h[] c4163hArr = new C4163h[arrayList.size()];
        arrayList.toArray(c4163hArr);
        return new C4697c(str, o, o2, j, j2, c4163hArr);
    }

    /* renamed from: b */
    private static C4698d m13244b(C2529l c2529l, int i, int i2, boolean z, int i3, C2351a c2351a) {
        C2529l c2529l2 = c2529l;
        int d = c2529l.m7097d();
        int b = C4162g.m13243b(c2529l2.f6441a, d);
        String str = new String(c2529l2.f6441a, d, b - d, "ISO-8859-1");
        c2529l.m7096c(b + 1);
        b = c2529l.m7103g();
        int i4 = (b & 2) != 0 ? 1 : 0;
        boolean z2 = (b & 1) != 0;
        int g = c2529l.m7103g();
        String[] strArr = new String[g];
        for (int i5 = 0; i5 < g; i5++) {
            int d2 = c2529l.m7097d();
            int b2 = C4162g.m13243b(c2529l2.f6441a, d2);
            strArr[i5] = new String(c2529l2.f6441a, d2, b2 - d2, "ISO-8859-1");
            c2529l.m7096c(b2 + 1);
        }
        ArrayList arrayList = new ArrayList();
        d += i;
        while (c2529l.m7097d() < d) {
            C4163h a = C4162g.m13236a(i2, c2529l, z, i3, c2351a);
            if (a != null) {
                arrayList.add(a);
            }
        }
        C4163h[] c4163hArr = new C4163h[arrayList.size()];
        arrayList.toArray(c4163hArr);
        return new C4698d(str, i4, z2, strArr, c4163hArr);
    }

    /* renamed from: c */
    private static C4696b m13248c(C2529l c2529l, int i, String str) {
        byte[] bArr = new byte[i];
        c2529l.m7092a(bArr, 0, i);
        return new C4696b(str, bArr);
    }

    /* renamed from: f */
    private static int m13252f(C2529l c2529l, int i) {
        Object obj = c2529l.f6441a;
        c2529l = c2529l.m7097d();
        while (true) {
            int i2 = c2529l + 1;
            if (i2 >= i) {
                return i;
            }
            if ((obj[c2529l] & JfifUtil.MARKER_FIRST_BYTE) == JfifUtil.MARKER_FIRST_BYTE && obj[i2] == (byte) 0) {
                System.arraycopy(obj, c2529l + 2, obj, i2, (i - c2529l) - 2);
                i--;
            }
            c2529l = i2;
        }
    }

    /* renamed from: a */
    private static String m13240a(int i, int i2, int i3, int i4, int i5) {
        if (i == 2) {
            return String.format(Locale.US, "%c%c%c", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        }
        return String.format(Locale.US, "%c%c%c%c", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)});
    }

    /* renamed from: a */
    private static int m13232a(byte[] bArr, int i, int i2) {
        i = C4162g.m13243b(bArr, i);
        if (i2 != 0) {
            if (i2 != 3) {
                while (i < bArr.length - 1) {
                    if (i % 2 == 0 && bArr[i + 1] == 0) {
                        return i;
                    }
                    i = C4162g.m13243b(bArr, i + 1);
                }
                return bArr.length;
            }
        }
        return i;
    }

    /* renamed from: b */
    private static int m13243b(byte[] bArr, int i) {
        while (i < bArr.length) {
            if (bArr[i] == (byte) 0) {
                return i;
            }
            i++;
        }
        return bArr.length;
    }

    /* renamed from: b */
    private static byte[] m13247b(byte[] bArr, int i, int i2) {
        if (i2 <= i) {
            return new byte[null];
        }
        return Arrays.copyOfRange(bArr, i, i2);
    }
}
