package com.google.p127a;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: DefaultDateTypeAdapter */
/* renamed from: com.google.a.a */
final class C3991a implements C2161k<Date>, C2165s<Date> {
    /* renamed from: a */
    private final DateFormat f10005a;
    /* renamed from: b */
    private final DateFormat f10006b;
    /* renamed from: c */
    private final DateFormat f10007c;

    /* renamed from: b */
    public /* synthetic */ Object mo13b(C2162l c2162l, Type type, C2160j c2160j) {
        return m12213a(c2162l, type, c2160j);
    }

    C3991a() {
        this(DateFormat.getDateTimeInstance(2, 2, Locale.US), DateFormat.getDateTimeInstance(2, 2));
    }

    C3991a(String str) {
        this(new SimpleDateFormat(str, Locale.US), new SimpleDateFormat(str));
    }

    public C3991a(int i, int i2) {
        this(DateFormat.getDateTimeInstance(i, i2, Locale.US), DateFormat.getDateTimeInstance(i, i2));
    }

    C3991a(DateFormat dateFormat, DateFormat dateFormat2) {
        this.f10005a = dateFormat;
        this.f10006b = dateFormat2;
        this.f10007c = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        this.f10007c.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    /* renamed from: a */
    public C2162l m12212a(Date date, Type type, C2164r c2164r) {
        synchronized (this.f10006b) {
            c2164r = new C4053q(this.f10005a.format(date));
        }
        return c2164r;
    }

    /* renamed from: a */
    public Date m12213a(C2162l c2162l, Type type, C2160j c2160j) {
        if ((c2162l instanceof C4053q) != null) {
            c2162l = m12210a(c2162l);
            if (type == Date.class) {
                return c2162l;
            }
            if (type == Timestamp.class) {
                return new Timestamp(c2162l.getTime());
            }
            if (type == java.sql.Date.class) {
                return new java.sql.Date(c2162l.getTime());
            }
            c2160j = new StringBuilder();
            c2160j.append(getClass());
            c2160j.append(" cannot deserialize to ");
            c2160j.append(type);
            throw new IllegalArgumentException(c2160j.toString());
        }
        throw new C2163p("The date should be a string value");
    }

    /* renamed from: a */
    private java.util.Date m12210a(com.google.p127a.C2162l r4) {
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
        r0 = r3.f10006b;
        monitor-enter(r0);
        r1 = r3.f10006b;	 Catch:{ ParseException -> 0x0011 }
        r2 = r4.mo2032b();	 Catch:{ ParseException -> 0x0011 }
        r1 = r1.parse(r2);	 Catch:{ ParseException -> 0x0011 }
        monitor-exit(r0);	 Catch:{ all -> 0x000f }
        return r1;
    L_0x000f:
        r4 = move-exception;
        goto L_0x0034;
    L_0x0011:
        r1 = r3.f10005a;	 Catch:{ ParseException -> 0x001d }
        r2 = r4.mo2032b();	 Catch:{ ParseException -> 0x001d }
        r1 = r1.parse(r2);	 Catch:{ ParseException -> 0x001d }
        monitor-exit(r0);	 Catch:{ all -> 0x000f }
        return r1;
    L_0x001d:
        r1 = r3.f10007c;	 Catch:{ ParseException -> 0x0029 }
        r2 = r4.mo2032b();	 Catch:{ ParseException -> 0x0029 }
        r1 = r1.parse(r2);	 Catch:{ ParseException -> 0x0029 }
        monitor-exit(r0);	 Catch:{ all -> 0x000f }
        return r1;	 Catch:{ all -> 0x000f }
    L_0x0029:
        r1 = move-exception;	 Catch:{ all -> 0x000f }
        r2 = new com.google.a.t;	 Catch:{ all -> 0x000f }
        r4 = r4.mo2032b();	 Catch:{ all -> 0x000f }
        r2.<init>(r4, r1);	 Catch:{ all -> 0x000f }
        throw r2;	 Catch:{ all -> 0x000f }
    L_0x0034:
        monitor-exit(r0);	 Catch:{ all -> 0x000f }
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.a.a(com.google.a.l):java.util.Date");
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(C3991a.class.getSimpleName());
        stringBuilder.append('(');
        stringBuilder.append(this.f10006b.getClass().getSimpleName());
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
