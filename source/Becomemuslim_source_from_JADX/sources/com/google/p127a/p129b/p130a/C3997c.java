package com.google.p127a.p129b.p130a;

import com.google.p127a.C2157f;
import com.google.p127a.C2168w;
import com.google.p127a.C2169x;
import com.google.p127a.p131c.C2150a;
import com.google.p127a.p132d.C2152a;
import com.google.p127a.p132d.C2153b;
import com.google.p127a.p132d.C2154c;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: DateTypeAdapter */
/* renamed from: com.google.a.b.a.c */
public final class C3997c extends C2168w<Date> {
    /* renamed from: a */
    public static final C2169x f10014a = new C39961();
    /* renamed from: b */
    private final DateFormat f10015b = DateFormat.getDateTimeInstance(2, 2, Locale.US);
    /* renamed from: c */
    private final DateFormat f10016c = DateFormat.getDateTimeInstance(2, 2);
    /* renamed from: d */
    private final DateFormat f10017d = C3997c.m12224a();

    /* compiled from: DateTypeAdapter */
    /* renamed from: com.google.a.b.a.c$1 */
    static class C39961 implements C2169x {
        C39961() {
        }

        /* renamed from: a */
        public <T> C2168w<T> mo1990a(C2157f c2157f, C2150a<T> c2150a) {
            return c2150a.m5891a() == Date.class ? new C3997c() : null;
        }
    }

    /* renamed from: b */
    public /* synthetic */ Object mo1992b(C2152a c2152a) {
        return m12226a(c2152a);
    }

    /* renamed from: a */
    private static DateFormat m12224a() {
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat;
    }

    /* renamed from: a */
    public Date m12226a(C2152a c2152a) {
        if (c2152a.mo1999f() != C2153b.NULL) {
            return m12225a(c2152a.mo2001h());
        }
        c2152a.mo2003j();
        return null;
    }

    /* renamed from: a */
    private synchronized java.util.Date m12225a(java.lang.String r3) {
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
        r2 = this;
        monitor-enter(r2);
        r0 = r2.f10016c;	 Catch:{ ParseException -> 0x000b }
        r0 = r0.parse(r3);	 Catch:{ ParseException -> 0x000b }
        monitor-exit(r2);
        return r0;
    L_0x0009:
        r3 = move-exception;
        goto L_0x0022;
    L_0x000b:
        r0 = r2.f10015b;	 Catch:{ ParseException -> 0x0013 }
        r0 = r0.parse(r3);	 Catch:{ ParseException -> 0x0013 }
        monitor-exit(r2);
        return r0;
    L_0x0013:
        r0 = r2.f10017d;	 Catch:{ ParseException -> 0x001b }
        r0 = r0.parse(r3);	 Catch:{ ParseException -> 0x001b }
        monitor-exit(r2);
        return r0;
    L_0x001b:
        r0 = move-exception;
        r1 = new com.google.a.t;	 Catch:{ all -> 0x0009 }
        r1.<init>(r3, r0);	 Catch:{ all -> 0x0009 }
        throw r1;	 Catch:{ all -> 0x0009 }
    L_0x0022:
        monitor-exit(r2);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.b.a.c.a(java.lang.String):java.util.Date");
    }

    /* renamed from: a */
    public synchronized void m12228a(C2154c c2154c, Date date) {
        if (date == null) {
            c2154c.mo2021f();
        } else {
            c2154c.mo2016b(this.f10015b.format(date));
        }
    }
}
