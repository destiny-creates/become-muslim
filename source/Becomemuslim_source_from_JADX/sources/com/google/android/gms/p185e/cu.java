package com.google.android.gms.p185e;

import com.google.android.gms.internal.p210i.C4992a;
import com.google.android.gms.internal.p210i.ab;

/* renamed from: com.google.android.gms.e.cu */
final class cu extends aq {
    /* renamed from: a */
    private static final String f11671a = C4992a.f16234B.toString();
    /* renamed from: b */
    private static final String f11672b = ab.f16318f.toString();
    /* renamed from: c */
    private static final String f11673c = ab.f16319g.toString();
    /* renamed from: d */
    private static final String f11674d = ab.f16332t.toString();
    /* renamed from: e */
    private static final String f11675e = ab.f16331s.toString();

    public cu() {
        super(f11671a, f11672b, f11673c);
    }

    /* renamed from: a */
    public final boolean mo2507a() {
        return true;
    }

    /* renamed from: a */
    public final com.google.android.gms.internal.p210i.ct mo2506a(java.util.Map<java.lang.String, com.google.android.gms.internal.p210i.ct> r6) {
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
        r5 = this;
        r0 = f11672b;
        r0 = r6.get(r0);
        r0 = (com.google.android.gms.internal.p210i.ct) r0;
        r1 = f11673c;
        r1 = r6.get(r1);
        r1 = (com.google.android.gms.internal.p210i.ct) r1;
        if (r0 == 0) goto L_0x008e;
    L_0x0012:
        r2 = com.google.android.gms.p185e.eu.m8736g();
        if (r0 == r2) goto L_0x008e;
    L_0x0018:
        if (r1 == 0) goto L_0x008e;
    L_0x001a:
        r2 = com.google.android.gms.p185e.eu.m8736g();
        if (r1 != r2) goto L_0x0021;
    L_0x0020:
        goto L_0x008e;
    L_0x0021:
        r2 = 64;
        r3 = f11674d;
        r3 = r6.get(r3);
        r3 = (com.google.android.gms.internal.p210i.ct) r3;
        r3 = com.google.android.gms.p185e.eu.m8731e(r3);
        r3 = r3.booleanValue();
        if (r3 == 0) goto L_0x0037;
    L_0x0035:
        r2 = 66;
    L_0x0037:
        r3 = 1;
        r4 = f11675e;
        r6 = r6.get(r4);
        r6 = (com.google.android.gms.internal.p210i.ct) r6;
        if (r6 == 0) goto L_0x005c;
    L_0x0042:
        r6 = com.google.android.gms.p185e.eu.m8725c(r6);
        r3 = com.google.android.gms.p185e.eu.m8722b();
        if (r6 != r3) goto L_0x0051;
    L_0x004c:
        r6 = com.google.android.gms.p185e.eu.m8736g();
        return r6;
    L_0x0051:
        r3 = r6.intValue();
        if (r3 >= 0) goto L_0x005c;
    L_0x0057:
        r6 = com.google.android.gms.p185e.eu.m8736g();
        return r6;
    L_0x005c:
        r6 = com.google.android.gms.p185e.eu.m8719a(r0);	 Catch:{ PatternSyntaxException -> 0x0089 }
        r0 = com.google.android.gms.p185e.eu.m8719a(r1);	 Catch:{ PatternSyntaxException -> 0x0089 }
        r1 = 0;	 Catch:{ PatternSyntaxException -> 0x0089 }
        r0 = java.util.regex.Pattern.compile(r0, r2);	 Catch:{ PatternSyntaxException -> 0x0089 }
        r6 = r0.matcher(r6);	 Catch:{ PatternSyntaxException -> 0x0089 }
        r0 = r6.find();	 Catch:{ PatternSyntaxException -> 0x0089 }
        if (r0 == 0) goto L_0x007d;	 Catch:{ PatternSyntaxException -> 0x0089 }
    L_0x0073:
        r0 = r6.groupCount();	 Catch:{ PatternSyntaxException -> 0x0089 }
        if (r0 < r3) goto L_0x007d;	 Catch:{ PatternSyntaxException -> 0x0089 }
    L_0x0079:
        r1 = r6.group(r3);	 Catch:{ PatternSyntaxException -> 0x0089 }
    L_0x007d:
        if (r1 != 0) goto L_0x0084;	 Catch:{ PatternSyntaxException -> 0x0089 }
    L_0x007f:
        r6 = com.google.android.gms.p185e.eu.m8736g();	 Catch:{ PatternSyntaxException -> 0x0089 }
        return r6;	 Catch:{ PatternSyntaxException -> 0x0089 }
    L_0x0084:
        r6 = com.google.android.gms.p185e.eu.m8716a(r1);	 Catch:{ PatternSyntaxException -> 0x0089 }
        return r6;
    L_0x0089:
        r6 = com.google.android.gms.p185e.eu.m8736g();
        return r6;
    L_0x008e:
        r6 = com.google.android.gms.p185e.eu.m8736g();
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.e.cu.a(java.util.Map):com.google.android.gms.internal.i.ct");
    }
}
