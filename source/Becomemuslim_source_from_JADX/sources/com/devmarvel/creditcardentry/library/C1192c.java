package com.devmarvel.creditcardentry.library;

import java.io.Serializable;

/* compiled from: CreditCard */
/* renamed from: com.devmarvel.creditcardentry.library.c */
public class C1192c implements Serializable {
    /* renamed from: a */
    private final String f3342a;
    /* renamed from: b */
    private final String f3343b;
    /* renamed from: c */
    private final String f3344c;
    /* renamed from: d */
    private final String f3345d;
    /* renamed from: e */
    private final C1190a f3346e;

    public C1192c(String str, String str2, String str3, String str4, C1190a c1190a) {
        this.f3342a = str;
        this.f3343b = str2;
        this.f3344c = str3;
        this.f3345d = str4;
        this.f3346e = c1190a;
    }

    /* renamed from: a */
    public String m4168a() {
        return this.f3342a;
    }

    /* renamed from: b */
    public String m4169b() {
        return this.f3344c;
    }

    /* renamed from: c */
    public Integer m4170c() {
        return m4167a(0);
    }

    /* renamed from: d */
    public Integer m4171d() {
        return m4167a(1);
    }

    /* renamed from: a */
    private java.lang.Integer m4167a(int r4) {
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
        r3 = this;
        r0 = r3.f3343b;
        if (r0 == 0) goto L_0x0021;
    L_0x0004:
        r0 = r3.f3343b;
        r1 = "/";
        r0 = r0.contains(r1);
        if (r0 == 0) goto L_0x0021;
    L_0x000e:
        r0 = r3.f3343b;
        r1 = "/";
        r0 = r0.split(r1);
        r1 = r0.length;
        r2 = 1;
        if (r1 <= r2) goto L_0x0021;
    L_0x001a:
        r4 = r0[r4];	 Catch:{ NumberFormatException -> 0x0021 }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ NumberFormatException -> 0x0021 }
        return r4;
    L_0x0021:
        r4 = 0;
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.devmarvel.creditcardentry.library.c.a(int):java.lang.Integer");
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("CreditCard{");
        stringBuilder.append("cardNumber='");
        stringBuilder.append(this.f3342a);
        stringBuilder.append('\'');
        stringBuilder.append(", expDate='");
        stringBuilder.append(this.f3343b);
        stringBuilder.append('\'');
        stringBuilder.append(", securityCode='");
        stringBuilder.append(this.f3344c);
        stringBuilder.append('\'');
        stringBuilder.append(", zipCode='");
        stringBuilder.append(this.f3345d);
        stringBuilder.append('\'');
        stringBuilder.append(", cardType=");
        stringBuilder.append(this.f3346e);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
