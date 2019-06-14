package com.google.android.exoplayer2.p137e;

import com.google.android.exoplayer2.p145g.C2344a;
import com.google.android.exoplayer2.p145g.C2344a.C2342a;
import com.google.android.exoplayer2.p145g.p147b.C4162g.C2351a;
import com.google.android.exoplayer2.p145g.p147b.C4699e;
import java.util.regex.Pattern;

/* compiled from: GaplessInfoHolder */
/* renamed from: com.google.android.exoplayer2.e.i */
public final class C2324i {
    /* renamed from: a */
    public static final C2351a f5758a = new C41531();
    /* renamed from: d */
    private static final Pattern f5759d = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");
    /* renamed from: b */
    public int f5760b = -1;
    /* renamed from: c */
    public int f5761c = -1;

    /* compiled from: GaplessInfoHolder */
    /* renamed from: com.google.android.exoplayer2.e.i$1 */
    static class C41531 implements C2351a {
        /* renamed from: a */
        public boolean mo2220a(int i, int i2, int i3, int i4, int i5) {
            return i2 == 67 && i3 == 79 && i4 == 77 && (i5 == 77 || i == 2);
        }

        C41531() {
        }
    }

    /* renamed from: a */
    public boolean m6446a(int i) {
        int i2 = i >> 12;
        i &= 4095;
        if (i2 <= 0) {
            if (i <= 0) {
                return false;
            }
        }
        this.f5760b = i2;
        this.f5761c = i;
        return true;
    }

    /* renamed from: a */
    public boolean m6447a(C2344a c2344a) {
        for (int i = 0; i < c2344a.m6504a(); i++) {
            C2342a a = c2344a.m6505a(i);
            if (a instanceof C4699e) {
                C4699e c4699e = (C4699e) a;
                if (m6444a(c4699e.f12697b, c4699e.f12698c)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    private boolean m6444a(java.lang.String r5, java.lang.String r6) {
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
        r4 = this;
        r0 = "iTunSMPB";
        r5 = r0.equals(r5);
        r0 = 0;
        if (r5 != 0) goto L_0x000a;
    L_0x0009:
        return r0;
    L_0x000a:
        r5 = f5759d;
        r5 = r5.matcher(r6);
        r6 = r5.find();
        if (r6 == 0) goto L_0x0033;
    L_0x0016:
        r6 = 1;
        r1 = r5.group(r6);	 Catch:{ NumberFormatException -> 0x0033 }
        r2 = 16;	 Catch:{ NumberFormatException -> 0x0033 }
        r1 = java.lang.Integer.parseInt(r1, r2);	 Catch:{ NumberFormatException -> 0x0033 }
        r3 = 2;	 Catch:{ NumberFormatException -> 0x0033 }
        r5 = r5.group(r3);	 Catch:{ NumberFormatException -> 0x0033 }
        r5 = java.lang.Integer.parseInt(r5, r2);	 Catch:{ NumberFormatException -> 0x0033 }
        if (r1 > 0) goto L_0x002e;	 Catch:{ NumberFormatException -> 0x0033 }
    L_0x002c:
        if (r5 <= 0) goto L_0x0033;	 Catch:{ NumberFormatException -> 0x0033 }
    L_0x002e:
        r4.f5760b = r1;	 Catch:{ NumberFormatException -> 0x0033 }
        r4.f5761c = r5;	 Catch:{ NumberFormatException -> 0x0033 }
        return r6;
    L_0x0033:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.e.i.a(java.lang.String, java.lang.String):boolean");
    }

    /* renamed from: a */
    public boolean m6445a() {
        return (this.f5760b == -1 || this.f5761c == -1) ? false : true;
    }
}
