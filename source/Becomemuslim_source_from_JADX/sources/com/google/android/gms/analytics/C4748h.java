package com.google.android.gms.analytics;

import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.internal.p210i.C5008q;
import com.google.android.gms.internal.p210i.C6797o;
import com.google.android.gms.internal.p210i.bj;
import com.google.android.gms.internal.p210i.bz;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

/* renamed from: com.google.android.gms.analytics.h */
public class C4748h extends C6797o {
    /* renamed from: a */
    private boolean f13101a;
    /* renamed from: b */
    private final Map<String, String> f13102b = new HashMap();
    /* renamed from: c */
    private final Map<String, String> f13103c = new HashMap();
    /* renamed from: d */
    private final bj f13104d;
    /* renamed from: e */
    private final C4747a f13105e;
    /* renamed from: f */
    private C2707c f13106f;

    /* renamed from: com.google.android.gms.analytics.h$a */
    class C4747a extends C6797o {
        /* renamed from: a */
        private long f13098a = -1;
        /* renamed from: b */
        private boolean f13099b;
        /* renamed from: c */
        private final /* synthetic */ C4748h f13100c;

        protected C4747a(C4748h c4748h, C5008q c5008q) {
            this.f13100c = c4748h;
            super(c5008q);
        }

        /* renamed from: a */
        protected final void m16622a() {
        }

        /* renamed from: b */
        public final synchronized boolean m16623b() {
            boolean z;
            z = this.f13099b;
            this.f13099b = false;
            return z;
        }
    }

    C4748h(C5008q c5008q, String str, bj bjVar) {
        super(c5008q);
        if (str != null) {
            this.f13102b.put("&tid", str);
        }
        this.f13102b.put("useSecure", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        this.f13102b.put("&a", Integer.toString(new Random().nextInt(Integer.MAX_VALUE) + 1));
        this.f13104d = new bj("tracking", j());
        this.f13105e = new C4747a(this, c5008q);
    }

    /* renamed from: a */
    protected final void m16637a() {
        this.f13105e.A();
        String c = r().c();
        if (c != null) {
            m16639a("&an", c);
        }
        c = r().b();
        if (c != null) {
            m16639a("&av", c);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public void m16641a(boolean r3) {
        /*
        r2 = this;
        monitor-enter(r2);
        r0 = r2.f13106f;	 Catch:{ all -> 0x0038 }
        if (r0 == 0) goto L_0x0007;
    L_0x0005:
        r0 = 1;
        goto L_0x0008;
    L_0x0007:
        r0 = 0;
    L_0x0008:
        if (r0 != r3) goto L_0x000c;
    L_0x000a:
        monitor-exit(r2);	 Catch:{ all -> 0x0038 }
        return;
    L_0x000c:
        if (r3 == 0) goto L_0x0028;
    L_0x000e:
        r3 = r2.k();	 Catch:{ all -> 0x0038 }
        r0 = java.lang.Thread.getDefaultUncaughtExceptionHandler();	 Catch:{ all -> 0x0038 }
        r1 = new com.google.android.gms.analytics.c;	 Catch:{ all -> 0x0038 }
        r1.<init>(r2, r0, r3);	 Catch:{ all -> 0x0038 }
        r2.f13106f = r1;	 Catch:{ all -> 0x0038 }
        r3 = r2.f13106f;	 Catch:{ all -> 0x0038 }
        java.lang.Thread.setDefaultUncaughtExceptionHandler(r3);	 Catch:{ all -> 0x0038 }
        r3 = "Uncaught exceptions will be reported to Google Analytics";
        r2.e(r3);	 Catch:{ all -> 0x0038 }
        goto L_0x0036;
    L_0x0028:
        r3 = r2.f13106f;	 Catch:{ all -> 0x0038 }
        r3 = r3.m7710a();	 Catch:{ all -> 0x0038 }
        java.lang.Thread.setDefaultUncaughtExceptionHandler(r3);	 Catch:{ all -> 0x0038 }
        r3 = "Uncaught exceptions will not be reported to Google Analytics";
        r2.e(r3);	 Catch:{ all -> 0x0038 }
    L_0x0036:
        monitor-exit(r2);	 Catch:{ all -> 0x0038 }
        return;
    L_0x0038:
        r3 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0038 }
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.h.a(boolean):void");
    }

    /* renamed from: a */
    private static String m16625a(Entry<String, String> entry) {
        Object obj;
        String str = (String) entry.getKey();
        if (str.startsWith("&")) {
            if (str.length() >= 2) {
                obj = 1;
                if (obj != null) {
                    return null;
                }
                return ((String) entry.getKey()).substring(1);
            }
        }
        obj = null;
        if (obj != null) {
            return ((String) entry.getKey()).substring(1);
        }
        return null;
    }

    /* renamed from: a */
    private static void m16626a(Map<String, String> map, Map<String, String> map2) {
        C2872v.m8380a((Object) map2);
        if (map != null) {
            map = map.entrySet().iterator();
            while (map.hasNext()) {
                Entry entry = (Entry) map.next();
                String a = C4748h.m16625a(entry);
                if (a != null) {
                    map2.put(a, (String) entry.getValue());
                }
            }
        }
    }

    /* renamed from: a */
    public void m16640a(Map<String, String> map) {
        long a = j().mo2482a();
        if (o().m16620e()) {
            f("AppOptOut is set to true. Not sending Google Analytics hit");
            return;
        }
        boolean d = o().m16619d();
        Object hashMap = new HashMap();
        C4748h.m16626a(this.f13102b, (Map) hashMap);
        C4748h.m16626a((Map) map, (Map) hashMap);
        boolean a2 = bz.a((String) this.f13102b.get("useSecure"), true);
        map = this.f13103c;
        C2872v.m8380a(hashMap);
        if (map != null) {
            map = map.entrySet().iterator();
            while (map.hasNext()) {
                Entry entry = (Entry) map.next();
                String a3 = C4748h.m16625a(entry);
                if (!(a3 == null || hashMap.containsKey(a3))) {
                    hashMap.put(a3, (String) entry.getValue());
                }
            }
        }
        this.f13103c.clear();
        String str = (String) hashMap.get("t");
        if (TextUtils.isEmpty(str) != null) {
            l().a(hashMap, "Missing hit type parameter");
            return;
        }
        String str2 = (String) hashMap.get("tid");
        if (TextUtils.isEmpty(str2) != null) {
            l().a(hashMap, "Missing tracking id parameter");
            return;
        }
        boolean z = this.f13101a;
        synchronized (this) {
            if (!("screenview".equalsIgnoreCase(str) == null && "pageview".equalsIgnoreCase(str) == null && "appview".equalsIgnoreCase(str) == null && TextUtils.isEmpty(str) == null)) {
                map = Integer.parseInt((String) this.f13102b.get("&a")) + 1;
                if (map >= Integer.MAX_VALUE) {
                    map = true;
                }
                this.f13102b.put("&a", Integer.toString(map));
            }
        }
        n().m7774a(new C2726x(this, hashMap, z, str, a, d, a2, str2));
    }

    /* renamed from: a */
    public String m16636a(String str) {
        z();
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.f13102b.containsKey(str)) {
            return (String) this.f13102b.get(str);
        }
        if (str.equals("&ul")) {
            return bz.a(Locale.getDefault());
        }
        if (str.equals("&cid")) {
            return t().b();
        }
        if (str.equals("&sr")) {
            return w().c();
        }
        if (str.equals("&aid")) {
            return v().b().c();
        }
        if (str.equals("&an")) {
            return v().b().a();
        }
        if (str.equals("&av")) {
            return v().b().b();
        }
        if (str.equals("&aiid") != null) {
            return v().b().d();
        }
        return null;
    }

    /* renamed from: a */
    public void m16639a(String str, String str2) {
        C2872v.m8381a((Object) str, (Object) "Key should be non-null");
        if (!TextUtils.isEmpty(str)) {
            this.f13102b.put(str, str2);
        }
    }

    /* renamed from: a */
    public void m16638a(double d) {
        m16639a("&sf", Double.toString(d));
    }

    /* renamed from: b */
    public void m16642b(String str) {
        m16639a("&cd", str);
    }

    /* renamed from: c */
    public void m16644c(String str) {
        m16639a("&an", str);
    }

    /* renamed from: d */
    public void m16646d(String str) {
        m16639a("&av", str);
    }

    /* renamed from: b */
    public void m16643b(boolean z) {
        m16639a("&aip", bz.a(z));
    }

    /* renamed from: c */
    public void m16645c(boolean z) {
        this.f13101a = z;
    }
}
