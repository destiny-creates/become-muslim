package com.google.p127a.p129b;

import java.math.BigDecimal;

/* compiled from: LazilyParsedNumber */
/* renamed from: com.google.a.b.f */
public final class C2135f extends Number {
    /* renamed from: a */
    private final String f5104a;

    public C2135f(String str) {
        this.f5104a = str;
    }

    public int intValue() {
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
        r2 = this;
        r0 = r2.f5104a;	 Catch:{ NumberFormatException -> 0x0007 }
        r0 = java.lang.Integer.parseInt(r0);	 Catch:{ NumberFormatException -> 0x0007 }
        return r0;
    L_0x0007:
        r0 = r2.f5104a;	 Catch:{ NumberFormatException -> 0x000f }
        r0 = java.lang.Long.parseLong(r0);	 Catch:{ NumberFormatException -> 0x000f }
        r0 = (int) r0;
        return r0;
    L_0x000f:
        r0 = new java.math.BigDecimal;
        r1 = r2.f5104a;
        r0.<init>(r1);
        r0 = r0.intValue();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.b.f.intValue():int");
    }

    public long longValue() {
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
        r2 = this;
        r0 = r2.f5104a;	 Catch:{ NumberFormatException -> 0x0007 }
        r0 = java.lang.Long.parseLong(r0);	 Catch:{ NumberFormatException -> 0x0007 }
        return r0;
    L_0x0007:
        r0 = new java.math.BigDecimal;
        r1 = r2.f5104a;
        r0.<init>(r1);
        r0 = r0.longValue();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.b.f.longValue():long");
    }

    public float floatValue() {
        return Float.parseFloat(this.f5104a);
    }

    public double doubleValue() {
        return Double.parseDouble(this.f5104a);
    }

    public String toString() {
        return this.f5104a;
    }

    private Object writeReplace() {
        return new BigDecimal(this.f5104a);
    }
}
