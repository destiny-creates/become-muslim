package com.google.android.gms.internal.p210i;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.util.Pair;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.analytics.C2705a;
import com.google.android.gms.analytics.C2714o;
import com.google.android.gms.analytics.C2717r;
import com.google.android.gms.analytics.C2721s;
import com.google.android.gms.analytics.C4308i;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.p180d.C2829c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.internal.i.ad */
final class ad extends C6797o {
    /* renamed from: a */
    private boolean f28788a;
    /* renamed from: b */
    private final C7819z f28789b;
    /* renamed from: c */
    private final bn f28790c;
    /* renamed from: d */
    private final bm f28791d;
    /* renamed from: e */
    private final C7818u f28792e;
    /* renamed from: f */
    private long f28793f = Long.MIN_VALUE;
    /* renamed from: g */
    private final au f28794g;
    /* renamed from: h */
    private final au f28795h;
    /* renamed from: i */
    private final by f28796i;
    /* renamed from: j */
    private long f28797j;
    /* renamed from: k */
    private boolean f28798k;

    protected ad(C5008q c5008q, C5010s c5010s) {
        super(c5008q);
        C2872v.a(c5010s);
        this.f28791d = new bm(c5008q);
        this.f28789b = new C7819z(c5008q);
        this.f28790c = new bn(c5008q);
        this.f28792e = new C7818u(c5008q);
        this.f28796i = new by(m21043j());
        this.f28794g = new ae(this, c5008q);
        this.f28795h = new af(this, c5008q);
    }

    /* renamed from: a */
    protected final void mo6145a() {
        this.f28789b.m31797A();
        this.f28790c.m31797A();
        this.f28792e.m31797A();
    }

    /* renamed from: b */
    final void m37725b() {
        m31800z();
        C2872v.a(this.f28788a ^ true, "Analytics backend already started");
        this.f28788a = true;
        m21047n().a(new ag(this));
    }

    /* renamed from: b */
    private final boolean m37717b(String str) {
        return C2829c.a(m21044k()).a(str) == null ? true : null;
    }

    /* renamed from: c */
    protected final void m37726c() {
        m31800z();
        C2721s.d();
        Context a = m21041i().m21059a();
        if (!bs.m20353a(a)) {
            m21040h("AnalyticsReceiver is not registered or is disabled. Register the receiver for reliable dispatching on non-Google Play devices. See http://goo.gl/8Rd3yj for instructions.");
        } else if (!bt.m20356a(a)) {
            m21042i("AnalyticsService is not registered or is disabled. Analytics service at risk of not starting. See http://goo.gl/8Rd3yj for instructions.");
        }
        if (!C2705a.a(a)) {
            m21040h("CampaignTrackingReceiver is not registered, not exported or is disabled. Installation campaign tracking is not possible. See http://goo.gl/8Rd3yj for instructions.");
        }
        m21052s().m37773b();
        if (!m37717b("android.permission.ACCESS_NETWORK_STATE")) {
            m21042i("Missing required android.permission.ACCESS_NETWORK_STATE. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            m37713J();
        }
        if (!m37717b("android.permission.INTERNET")) {
            m21042i("Missing required android.permission.INTERNET. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            m37713J();
        }
        if (bt.m20356a(m21044k())) {
            m21036e("AnalyticsService registered in the app manifest and enabled");
        } else {
            m21040h("AnalyticsService not registered in the app manifest. Hits might not be delivered reliably. See http://goo.gl/8Rd3yj for instructions.");
        }
        if (!(this.f28798k || this.f28789b.m38008e())) {
            m37707D();
        }
        m37731h();
    }

    /* renamed from: B */
    private final void m37705B() {
        m37721a(new ah(this));
    }

    /* renamed from: d */
    final void m37727d() {
        C2721s.d();
        this.f28797j = m21043j().a();
    }

    /* renamed from: e */
    protected final void m37728e() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:37)
	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:61)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:33)
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
        r5 = this;
        com.google.android.gms.analytics.C2721s.d();
        com.google.android.gms.analytics.C2721s.d();
        r5.m31800z();
        r0 = com.google.android.gms.internal.p210i.as.m20287b();
        if (r0 != 0) goto L_0x0014;
    L_0x000f:
        r0 = "Service client disabled. Can't dispatch local hits to device AnalyticsService";
        r5.m21040h(r0);
    L_0x0014:
        r0 = r5.f28792e;
        r0 = r0.m37984b();
        if (r0 != 0) goto L_0x0022;
    L_0x001c:
        r0 = "Service not connected";
        r5.m21036e(r0);
        return;
    L_0x0022:
        r0 = r5.f28789b;
        r0 = r0.m38008e();
        if (r0 != 0) goto L_0x007e;
    L_0x002a:
        r0 = "Dispatching local hits to device AnalyticsService";
        r5.m21036e(r0);
    L_0x002f:
        r0 = r5.f28789b;	 Catch:{ SQLiteException -> 0x0074 }
        r1 = com.google.android.gms.internal.p210i.as.m20291f();	 Catch:{ SQLiteException -> 0x0074 }
        r1 = (long) r1;	 Catch:{ SQLiteException -> 0x0074 }
        r0 = r0.m37999a(r1);	 Catch:{ SQLiteException -> 0x0074 }
        r1 = r0.isEmpty();	 Catch:{ SQLiteException -> 0x0074 }
        if (r1 == 0) goto L_0x0044;	 Catch:{ SQLiteException -> 0x0074 }
    L_0x0040:
        r5.m37731h();	 Catch:{ SQLiteException -> 0x0074 }
        return;
    L_0x0044:
        r1 = r0.isEmpty();
        if (r1 != 0) goto L_0x002f;
    L_0x004a:
        r1 = 0;
        r1 = r0.get(r1);
        r1 = (com.google.android.gms.internal.p210i.bg) r1;
        r2 = r5.f28792e;
        r2 = r2.m37983a(r1);
        if (r2 != 0) goto L_0x005d;
    L_0x0059:
        r5.m37731h();
        return;
    L_0x005d:
        r0.remove(r1);
        r2 = r5.f28789b;	 Catch:{ SQLiteException -> 0x006a }
        r3 = r1.m20322c();	 Catch:{ SQLiteException -> 0x006a }
        r2.m38004b(r3);	 Catch:{ SQLiteException -> 0x006a }
        goto L_0x0044;
    L_0x006a:
        r0 = move-exception;
        r1 = "Failed to remove hit that was send for delivery";
        r5.m21037e(r1, r0);
        r5.m37711H();
        return;
    L_0x0074:
        r0 = move-exception;
        r1 = "Failed to read hits from store";
        r5.m21037e(r1, r0);
        r5.m37711H();
        return;
    L_0x007e:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.i.ad.e():void");
    }

    /* renamed from: C */
    private final void m37706C() {
        try {
            this.f28789b.m38009f();
            m37731h();
        } catch (SQLiteException e) {
            m21034d("Failed to delete stale hits", e);
        }
        this.f28795h.m20303a(86400000);
    }

    /* renamed from: a */
    protected final void m37723a(C5011t c5011t) {
        C2721s.d();
        m21029b("Sending first hit to property", c5011t.m21081c());
        if (!m21052s().m37774c().m20366a(as.m20296l())) {
            String f = m21052s().m37777f();
            if (!TextUtils.isEmpty(f)) {
                fh a = bz.m20369a(m21045l(), f);
                m21029b("Found relevant installation campaign", a);
                m37715a(c5011t, a);
            }
        }
    }

    /* renamed from: a */
    public final void m37720a(long j) {
        C2721s.d();
        m31800z();
        if (j < 0) {
            j = 0;
        }
        this.f28793f = j;
        m37731h();
    }

    /* renamed from: D */
    private final void m37707D() {
        if (!this.f28798k && as.m20287b() && !this.f28792e.m37984b()) {
            if (this.f28796i.m20366a(((Long) ba.f16366C.m20315a()).longValue())) {
                this.f28796i.m20365a();
                m21036e("Connecting to service");
                if (this.f28792e.m37986d()) {
                    m21036e("Connected to service");
                    this.f28796i.m20367b();
                    m37728e();
                }
            }
        }
    }

    /* renamed from: a */
    public final long m37718a(C5011t c5011t, boolean z) {
        C2872v.a(c5011t);
        m31800z();
        C2721s.d();
        try {
            this.f28789b.m38003b();
            z = this.f28789b;
            long a = c5011t.m21078a();
            C2872v.a(c5011t.m21080b());
            z.m31800z();
            C2721s.d();
            int delete = z.m38011h().delete("properties", "app_uid=? AND cid<>?", new String[]{String.valueOf(a), r4});
            if (delete > 0) {
                z.m21026a("Deleted property records", Integer.valueOf(delete));
            }
            a = this.f28789b.m37998a(c5011t.m21078a(), c5011t.m21080b(), c5011t.m21081c());
            c5011t.m21079a(1 + a);
            z = this.f28789b;
            C2872v.a(c5011t);
            z.m31800z();
            C2721s.d();
            SQLiteDatabase h = z.m38011h();
            Map f = c5011t.m21084f();
            C2872v.a(f);
            Builder builder = new Builder();
            for (Entry entry : f.entrySet()) {
                builder.appendQueryParameter((String) entry.getKey(), (String) entry.getValue());
            }
            String encodedQuery = builder.build().getEncodedQuery();
            if (encodedQuery == null) {
                encodedQuery = "";
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_uid", Long.valueOf(c5011t.m21078a()));
            contentValues.put("cid", c5011t.m21080b());
            contentValues.put("tid", c5011t.m21081c());
            contentValues.put("adid", Integer.valueOf(c5011t.m21082d()));
            contentValues.put("hits_count", Long.valueOf(c5011t.m21083e()));
            contentValues.put(NativeProtocol.WEB_DIALOG_PARAMS, encodedQuery);
            try {
                if (h.insertWithOnConflict("properties", null, contentValues, 5) == -1) {
                    z.m21042i("Failed to insert/update a property (got -1)");
                }
            } catch (C5011t c5011t2) {
                z.m21037e("Error storing a property", c5011t2);
            }
            this.f28789b.m38006c();
            return a;
        } catch (C5011t c5011t22) {
            m21037e("Failed to update Analytics property", c5011t22);
            return -1;
        } finally {
            try {
                this.f28789b.m38007d();
            } catch (boolean z2) {
                m21037e("Failed to end transaction", z2);
            }
        }
    }

    /* renamed from: a */
    public final void m37722a(bg bgVar) {
        C2872v.a(bgVar);
        C2721s.d();
        m31800z();
        if (this.f28798k) {
            m21038f("Hit delivery not possible. Missing network permissions. See http://goo.gl/8Rd3yj for instructions");
        } else {
            m21026a("Delivering hit", bgVar);
        }
        if (TextUtils.isEmpty(bgVar.m20327h())) {
            Pair a = m21052s().m37778g().m20350a();
            if (a != null) {
                Long l = (Long) a.second;
                String str = (String) a.first;
                String valueOf = String.valueOf(l);
                StringBuilder stringBuilder = new StringBuilder((String.valueOf(valueOf).length() + 1) + String.valueOf(str).length());
                stringBuilder.append(valueOf);
                stringBuilder.append(":");
                stringBuilder.append(str);
                str = stringBuilder.toString();
                Map hashMap = new HashMap(bgVar.m20321b());
                hashMap.put("_m", str);
                bgVar = new bg(this, hashMap, bgVar.m20323d(), bgVar.m20325f(), bgVar.m20322c(), bgVar.m20320a(), bgVar.m20324e());
            }
        }
        m37707D();
        if (this.f28792e.m37983a(bgVar)) {
            m21038f("Hit sent to the device AnalyticsService for delivery");
            return;
        }
        try {
            this.f28789b.m38001a(bgVar);
            m37731h();
        } catch (SQLiteException e) {
            m21037e("Delivery failed to save hit to a database", e);
            m21045l().m37754a(bgVar, "deliver: failed to insert hit to database");
        }
    }

    /* renamed from: f */
    public final void m37729f() {
        C2721s.d();
        m31800z();
        m21036e("Delete all hits from local store");
        try {
            C6797o c6797o = this.f28789b;
            C2721s.d();
            c6797o.m31800z();
            c6797o.m38011h().delete("hits2", null, null);
            c6797o = this.f28789b;
            C2721s.d();
            c6797o.m31800z();
            c6797o.m38011h().delete("properties", null, null);
            m37731h();
        } catch (SQLiteException e) {
            m21034d("Failed to delete hits from store", e);
        }
        m37707D();
        if (this.f28792e.m37985c()) {
            m21036e("Device service unavailable. Can't clear hits stored on the device service.");
        }
    }

    /* renamed from: E */
    private final boolean m37708E() {
        C2721s.d();
        m31800z();
        m21036e("Dispatching a batch of local hits");
        int b = this.f28790c.m37769b() ^ 1;
        if ((this.f28792e.m37984b() ^ 1) == 0 || b == 0) {
            List<bg> a;
            long max = (long) Math.max(as.m20291f(), as.m20292g());
            List arrayList = new ArrayList();
            long j = 0;
            while (true) {
                this.f28789b.m38003b();
                arrayList.clear();
                try {
                    a = this.f28789b.m37999a(max);
                    if (a.isEmpty()) {
                        m21036e("Store is empty, nothing to dispatch");
                        m37711H();
                        try {
                            this.f28789b.m38006c();
                            this.f28789b.m38007d();
                            return false;
                        } catch (SQLiteException e) {
                            m21037e("Failed to commit local dispatch transaction", e);
                            m37711H();
                            return false;
                        }
                    }
                    m21026a("Hits loaded from store. count", Integer.valueOf(a.size()));
                    try {
                        for (bg c : a) {
                            if (c.m20322c() == j) {
                                break;
                            }
                        }
                        if (this.f28792e.m37984b()) {
                            m21036e("Service connected, sending hits to the service");
                            while (!a.isEmpty()) {
                                bg bgVar = (bg) a.get(0);
                                if (this.f28792e.m37983a(bgVar)) {
                                    j = Math.max(j, bgVar.m20322c());
                                    a.remove(bgVar);
                                    m21029b("Hit sent do device AnalyticsService for delivery", bgVar);
                                    this.f28789b.m38004b(bgVar.m20322c());
                                    arrayList.add(Long.valueOf(bgVar.m20322c()));
                                }
                            }
                        }
                        if (this.f28790c.m37769b()) {
                            List<Long> a2 = this.f28790c.m37767a((List) a);
                            for (Long longValue : a2) {
                                j = Math.max(j, longValue.longValue());
                            }
                            try {
                                this.f28789b.m38002a((List) a2);
                                arrayList.addAll(a2);
                            } catch (SQLiteException e2) {
                                m21037e("Failed to remove successfully uploaded hits", e2);
                                m37711H();
                                try {
                                    this.f28789b.m38006c();
                                    this.f28789b.m38007d();
                                    return false;
                                } catch (SQLiteException e22) {
                                    m21037e("Failed to commit local dispatch transaction", e22);
                                    m37711H();
                                    return false;
                                }
                            }
                        }
                        if (arrayList.isEmpty()) {
                            try {
                                this.f28789b.m38006c();
                                this.f28789b.m38007d();
                                return false;
                            } catch (SQLiteException e222) {
                                m21037e("Failed to commit local dispatch transaction", e222);
                                m37711H();
                                return false;
                            }
                        }
                        try {
                            this.f28789b.m38006c();
                            this.f28789b.m38007d();
                        } catch (SQLiteException e2222) {
                            m21037e("Failed to commit local dispatch transaction", e2222);
                            m37711H();
                            return false;
                        }
                    } catch (SQLiteException e22222) {
                        m21037e("Failed to remove hit that was send for delivery", e22222);
                        m37711H();
                        return false;
                    } finally {
                        try {
                            this.f28789b.m38006c();
                            this.f28789b.m38007d();
                        } catch (SQLiteException e222222) {
                            m21037e("Failed to commit local dispatch transaction", e222222);
                            m37711H();
                            return false;
                        }
                    }
                } catch (SQLiteException e2222222) {
                    m21034d("Failed to read hits from persisted store", e2222222);
                    m37711H();
                    try {
                        this.f28789b.m38006c();
                        this.f28789b.m38007d();
                        return false;
                    } catch (SQLiteException e22222222) {
                        m21037e("Failed to commit local dispatch transaction", e22222222);
                        m37711H();
                        return false;
                    }
                }
            }
            m21035d("Database contains successfully uploaded hit", Long.valueOf(j), Integer.valueOf(a.size()));
            m37711H();
            return false;
        }
        m21036e("No network or service available. Will retry later");
        return false;
    }

    /* renamed from: a */
    public final void m37721a(ay ayVar) {
        long j = this.f28797j;
        C2721s.d();
        m31800z();
        long d = m21052s().m37775d();
        m21029b("Dispatching local hits. Elapsed time since last dispatch (ms)", Long.valueOf(d != 0 ? Math.abs(m21043j().a() - d) : -1));
        m37707D();
        try {
            m37708E();
            m21052s().m37776e();
            m37731h();
            if (ayVar != null) {
                ayVar.mo4413a(null);
            }
            if (this.f28797j != j) {
                this.f28791d.m20340c();
            }
        } catch (Throwable e) {
            m21037e("Local dispatch failed", e);
            m21052s().m37776e();
            m37731h();
            if (ayVar != null) {
                ayVar.mo4413a(e);
            }
        }
    }

    /* renamed from: g */
    public final void m37730g() {
        C2721s.d();
        m31800z();
        m21038f("Sync dispatching local hits");
        long j = this.f28797j;
        m37707D();
        try {
            m37708E();
            m21052s().m37776e();
            m37731h();
            if (this.f28797j != j) {
                this.f28791d.m20340c();
            }
        } catch (Exception e) {
            m21037e("Sync local dispatch failed", e);
            m37731h();
        }
    }

    /* renamed from: F */
    private final long m37709F() {
        C2721s.d();
        m31800z();
        try {
            return this.f28789b.m38010g();
        } catch (SQLiteException e) {
            m21037e("Failed to get min/max hit times from local store", e);
            return 0;
        }
    }

    /* renamed from: h */
    public final void m37731h() {
        C2721s.d();
        m31800z();
        boolean z = true;
        Object obj = (this.f28798k || m37712I() <= 0) ? null : 1;
        if (obj == null) {
            this.f28791d.m20339b();
            m37711H();
        } else if (this.f28789b.m38008e()) {
            this.f28791d.m20339b();
            m37711H();
        } else {
            if (!((Boolean) ba.f16407z.m20315a()).booleanValue()) {
                this.f28791d.m20338a();
                z = this.f28791d.m20341d();
            }
            if (z) {
                m37710G();
                long I = m37712I();
                long d = m21052s().m37775d();
                if (d != 0) {
                    d = I - Math.abs(m21043j().a() - d);
                    if (d <= 0) {
                        d = Math.min(as.m20289d(), I);
                    }
                } else {
                    d = Math.min(as.m20289d(), I);
                }
                m21026a("Dispatch scheduled (ms)", Long.valueOf(d));
                if (this.f28794g.m20306c()) {
                    this.f28794g.m20305b(Math.max(1, d + this.f28794g.m20304b()));
                    return;
                } else {
                    this.f28794g.m20303a(d);
                    return;
                }
            }
            m37711H();
            m37710G();
        }
    }

    /* renamed from: G */
    private final void m37710G() {
        ax q = m21050q();
        if (q.m37746b() && !q.m37747c()) {
            long F = m37709F();
            if (F != 0 && Math.abs(m21043j().a() - F) <= ((Long) ba.f16389h.m20315a()).longValue()) {
                m21026a("Dispatch alarm scheduled (ms)", Long.valueOf(as.m20290e()));
                q.m37748d();
            }
        }
    }

    /* renamed from: H */
    private final void m37711H() {
        if (this.f28794g.m20306c()) {
            m21036e("All hits dispatched or no network/service. Going to power save mode");
        }
        this.f28794g.m20307d();
        ax q = m21050q();
        if (q.m37747c()) {
            q.m37749e();
        }
    }

    /* renamed from: I */
    private final long m37712I() {
        if (this.f28793f != Long.MIN_VALUE) {
            return this.f28793f;
        }
        long longValue = ((Long) ba.f16386e.m20315a()).longValue();
        C6797o r = m21051r();
        r.m31800z();
        if (r.f28813a) {
            C6797o r2 = m21051r();
            r2.m31800z();
            longValue = ((long) r2.f28814b) * 1000;
        }
        return longValue;
    }

    /* renamed from: a */
    public final void m37724a(String str) {
        C2872v.a(str);
        C2721s.d();
        fh a = bz.m20369a(m21045l(), str);
        if (a == null) {
            m21034d("Parsing failed. Ignoring invalid campaign data", str);
            return;
        }
        CharSequence f = m21052s().m37777f();
        if (str.equals(f)) {
            m21040h("Ignoring duplicate install campaign");
        } else if (TextUtils.isEmpty(f)) {
            m21052s().m37772a(str);
            if (m21052s().m37774c().m20366a(as.m20296l()) != null) {
                m21034d("Campaign received too late, ignoring", a);
                return;
            }
            m21029b("Received installation campaign", a);
            for (C5011t a2 : this.f28789b.m38005c(0)) {
                m37715a(a2, a);
            }
        } else {
            m21035d("Ignoring multiple install campaigns. original, new", f, str);
        }
    }

    /* renamed from: a */
    private final void m37715a(C5011t c5011t, fh fhVar) {
        C2872v.a(c5011t);
        C2872v.a(fhVar);
        C2717r c4308i = new C4308i(m21041i());
        c4308i.b(c5011t.m21081c());
        c4308i.c(c5011t.m21082d());
        C2714o h = c4308i.h();
        jp jpVar = (jp) h.b(jp.class);
        jpVar.m31784a("data");
        jpVar.m31788b(true);
        h.a(fhVar);
        ik ikVar = (ik) h.b(ik.class);
        eg egVar = (eg) h.b(eg.class);
        for (Entry entry : c5011t.m21084f().entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            if ("an".equals(str)) {
                egVar.m31341a(str2);
            } else if ("av".equals(str)) {
                egVar.m31343b(str2);
            } else if ("aid".equals(str)) {
                egVar.m31345c(str2);
            } else if ("aiid".equals(str)) {
                egVar.m31347d(str2);
            } else if ("uid".equals(str)) {
                jpVar.m31790c(str2);
            } else {
                ikVar.m31753a(str, str2);
            }
        }
        m21030b("Sending installation campaign to", c5011t.m21081c(), fhVar);
        h.a(m21052s().m37773b());
        h.e();
    }

    /* renamed from: J */
    private final void m37713J() {
        m31800z();
        C2721s.d();
        this.f28798k = true;
        this.f28792e.m37987e();
        m37731h();
    }
}
