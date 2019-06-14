package com.google.android.gms.p185e;

/* renamed from: com.google.android.gms.e.et */
final class et extends Number implements Comparable<et> {
    /* renamed from: a */
    private double f7567a;
    /* renamed from: b */
    private long f7568b;
    /* renamed from: c */
    private boolean f7569c = 0.0d;

    private et(double d) {
        this.f7567a = d;
    }

    private et(long j) {
        this.f7568b = j;
    }

    /* renamed from: a */
    public static et m8711a(Double d) {
        return new et(d.doubleValue());
    }

    /* renamed from: a */
    public static et m8710a(long j) {
        return new et(j);
    }

    /* renamed from: a */
    public static com.google.android.gms.p185e.et m8712a(java.lang.String r3) {
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
        r0 = new com.google.android.gms.e.et;	 Catch:{ NumberFormatException -> 0x000a }
        r1 = java.lang.Long.parseLong(r3);	 Catch:{ NumberFormatException -> 0x000a }
        r0.<init>(r1);	 Catch:{ NumberFormatException -> 0x000a }
        return r0;
    L_0x000a:
        r0 = new com.google.android.gms.e.et;	 Catch:{ NumberFormatException -> 0x0014 }
        r1 = java.lang.Double.parseDouble(r3);	 Catch:{ NumberFormatException -> 0x0014 }
        r0.<init>(r1);	 Catch:{ NumberFormatException -> 0x0014 }
        return r0;
    L_0x0014:
        r0 = new java.lang.NumberFormatException;
        r3 = java.lang.String.valueOf(r3);
        r1 = " is not a valid TypedNumber";
        r3 = r3.concat(r1);
        r0.<init>(r3);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.e.et.a(java.lang.String):com.google.android.gms.e.et");
    }

    public final String toString() {
        return this.f7569c ? Long.toString(this.f7568b) : Double.toString(this.f7567a);
    }

    public final boolean equals(Object obj) {
        return ((obj instanceof et) && m8713a((et) obj) == null) ? true : null;
    }

    public final int hashCode() {
        return new Long(longValue()).hashCode();
    }

    /* renamed from: a */
    public final int m8713a(et etVar) {
        if (this.f7569c && etVar.f7569c) {
            return new Long(this.f7568b).compareTo(Long.valueOf(etVar.f7568b));
        }
        return Double.compare(doubleValue(), etVar.doubleValue());
    }

    /* renamed from: a */
    public final boolean m8714a() {
        return !this.f7569c;
    }

    /* renamed from: b */
    public final boolean m8715b() {
        return this.f7569c;
    }

    public final double doubleValue() {
        return this.f7569c ? (double) this.f7568b : this.f7567a;
    }

    public final float floatValue() {
        return (float) doubleValue();
    }

    public final long longValue() {
        return this.f7569c ? this.f7568b : (long) this.f7567a;
    }

    public final int intValue() {
        return (int) longValue();
    }

    public final short shortValue() {
        return (short) ((int) longValue());
    }

    public final byte byteValue() {
        return (byte) ((int) longValue());
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return m8713a((et) obj);
    }
}
