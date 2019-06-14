package com.google.android.gms.internal.p213l;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.net.Uri;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.google.android.gms.internal.l.ha */
public final class ha {
    /* renamed from: a */
    private static final ConcurrentHashMap<Uri, ha> f17267a = new ConcurrentHashMap();
    /* renamed from: i */
    private static final String[] f17268i = new String[]{"key", "value"};
    /* renamed from: b */
    private final ContentResolver f17269b;
    /* renamed from: c */
    private final Uri f17270c;
    /* renamed from: d */
    private final ContentObserver f17271d;
    /* renamed from: e */
    private final Object f17272e = new Object();
    /* renamed from: f */
    private volatile Map<String, String> f17273f;
    /* renamed from: g */
    private final Object f17274g = new Object();
    /* renamed from: h */
    private final List<hc> f17275h = new ArrayList();

    private ha(ContentResolver contentResolver, Uri uri) {
        this.f17269b = contentResolver;
        this.f17270c = uri;
        this.f17271d = new hb(this, null);
    }

    /* renamed from: a */
    public static ha m21399a(ContentResolver contentResolver, Uri uri) {
        ha haVar = (ha) f17267a.get(uri);
        if (haVar != null) {
            return haVar;
        }
        haVar = new ha(contentResolver, uri);
        ha haVar2 = (ha) f17267a.putIfAbsent(uri, haVar);
        if (haVar2 != null) {
            return haVar2;
        }
        haVar.f17269b.registerContentObserver(haVar.f17270c, false, haVar.f17271d);
        return haVar;
    }

    /* renamed from: c */
    private final java.util.Map<java.lang.String, java.lang.String> m21401c() {
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
        r7 = this;
        r0 = new java.util.HashMap;	 Catch:{ SecurityException -> 0x0032, SecurityException -> 0x0032 }
        r0.<init>();	 Catch:{ SecurityException -> 0x0032, SecurityException -> 0x0032 }
        r1 = r7.f17269b;	 Catch:{ SecurityException -> 0x0032, SecurityException -> 0x0032 }
        r2 = r7.f17270c;	 Catch:{ SecurityException -> 0x0032, SecurityException -> 0x0032 }
        r3 = f17268i;	 Catch:{ SecurityException -> 0x0032, SecurityException -> 0x0032 }
        r4 = 0;	 Catch:{ SecurityException -> 0x0032, SecurityException -> 0x0032 }
        r5 = 0;	 Catch:{ SecurityException -> 0x0032, SecurityException -> 0x0032 }
        r6 = 0;	 Catch:{ SecurityException -> 0x0032, SecurityException -> 0x0032 }
        r1 = r1.query(r2, r3, r4, r5, r6);	 Catch:{ SecurityException -> 0x0032, SecurityException -> 0x0032 }
        if (r1 == 0) goto L_0x0031;
    L_0x0014:
        r2 = r1.moveToNext();	 Catch:{ all -> 0x002c }
        if (r2 == 0) goto L_0x0028;	 Catch:{ all -> 0x002c }
    L_0x001a:
        r2 = 0;	 Catch:{ all -> 0x002c }
        r2 = r1.getString(r2);	 Catch:{ all -> 0x002c }
        r3 = 1;	 Catch:{ all -> 0x002c }
        r3 = r1.getString(r3);	 Catch:{ all -> 0x002c }
        r0.put(r2, r3);	 Catch:{ all -> 0x002c }
        goto L_0x0014;
    L_0x0028:
        r1.close();	 Catch:{ SecurityException -> 0x0032, SecurityException -> 0x0032 }
        goto L_0x0031;	 Catch:{ SecurityException -> 0x0032, SecurityException -> 0x0032 }
    L_0x002c:
        r0 = move-exception;	 Catch:{ SecurityException -> 0x0032, SecurityException -> 0x0032 }
        r1.close();	 Catch:{ SecurityException -> 0x0032, SecurityException -> 0x0032 }
        throw r0;	 Catch:{ SecurityException -> 0x0032, SecurityException -> 0x0032 }
    L_0x0031:
        return r0;
    L_0x0032:
        r0 = "ConfigurationContentLoader";
        r1 = "PhenotypeFlag unable to load ContentProvider, using default values";
        android.util.Log.e(r0, r1);
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.l.ha.c():java.util.Map<java.lang.String, java.lang.String>");
    }

    /* renamed from: d */
    private final void m21402d() {
        synchronized (this.f17274g) {
            for (hc a : this.f17275h) {
                a.m21405a();
            }
        }
    }

    /* renamed from: a */
    public final Map<String, String> m21403a() {
        Map<String, String> c = hd.m21413a("gms:phenotype:phenotype_flag:debug_disable_caching", false) ? m21401c() : this.f17273f;
        if (c == null) {
            synchronized (this.f17272e) {
                c = this.f17273f;
                if (c == null) {
                    c = m21401c();
                    this.f17273f = c;
                }
            }
        }
        return c != null ? c : Collections.emptyMap();
    }

    /* renamed from: b */
    public final void m21404b() {
        synchronized (this.f17272e) {
            this.f17273f = null;
        }
    }
}
