package com.google.android.gms.ads.internal;

import android.content.Context;
import android.support.v4.util.C0463l;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.ads.p168b.C4735l;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.internal.ads.aoq;
import com.google.android.gms.internal.ads.aou;
import com.google.android.gms.internal.ads.aph;
import com.google.android.gms.internal.ads.apn;
import com.google.android.gms.internal.ads.apr;
import com.google.android.gms.internal.ads.aqn;
import com.google.android.gms.internal.ads.asp;
import com.google.android.gms.internal.ads.aus;
import com.google.android.gms.internal.ads.awe;
import com.google.android.gms.internal.ads.awh;
import com.google.android.gms.internal.ads.awl;
import com.google.android.gms.internal.ads.awo;
import com.google.android.gms.internal.ads.awr;
import com.google.android.gms.internal.ads.awu;
import com.google.android.gms.internal.ads.bcy;
import com.google.android.gms.internal.ads.cm;
import com.google.android.gms.internal.ads.jn;
import com.google.android.gms.internal.ads.jw;
import com.google.android.gms.internal.ads.mv;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

@cm
/* renamed from: com.google.android.gms.ads.internal.i */
public final class C4737i extends apr {
    /* renamed from: a */
    private final Context f12986a;
    /* renamed from: b */
    private final apn f12987b;
    /* renamed from: c */
    private final bcy f12988c;
    /* renamed from: d */
    private final awe f12989d;
    /* renamed from: e */
    private final awu f12990e;
    /* renamed from: f */
    private final awh f12991f;
    /* renamed from: g */
    private final awr f12992g;
    /* renamed from: h */
    private final aou f12993h;
    /* renamed from: i */
    private final C4735l f12994i;
    /* renamed from: j */
    private final C0463l<String, awo> f12995j;
    /* renamed from: k */
    private final C0463l<String, awl> f12996k;
    /* renamed from: l */
    private final aus f12997l;
    /* renamed from: m */
    private final List<String> f12998m;
    /* renamed from: n */
    private final aqn f12999n;
    /* renamed from: o */
    private final String f13000o;
    /* renamed from: p */
    private final mv f13001p;
    /* renamed from: q */
    private WeakReference<bb> f13002q;
    /* renamed from: r */
    private final bu f13003r;
    /* renamed from: s */
    private final Object f13004s = new Object();

    C4737i(Context context, String str, bcy bcy, mv mvVar, apn apn, awe awe, awu awu, awh awh, C0463l<String, awo> c0463l, C0463l<String, awl> c0463l2, aus aus, aqn aqn, bu buVar, awr awr, aou aou, C4735l c4735l) {
        this.f12986a = context;
        this.f13000o = str;
        this.f12988c = bcy;
        this.f13001p = mvVar;
        this.f12987b = apn;
        this.f12991f = awh;
        this.f12989d = awe;
        this.f12990e = awu;
        this.f12995j = c0463l;
        this.f12996k = c0463l2;
        this.f12997l = aus;
        this.f12998m = m16537f();
        this.f12999n = aqn;
        this.f13003r = buVar;
        this.f12992g = awr;
        this.f12993h = aou;
        this.f12994i = c4735l;
        asp.a(this.f12986a);
    }

    /* renamed from: a */
    private final void m16528a(int i) {
        if (this.f12987b != null) {
            try {
                this.f12987b.a(0);
            } catch (Throwable e) {
                jn.c("Failed calling onAdFailedToLoad.", e);
            }
        }
    }

    /* renamed from: a */
    private static void m16531a(Runnable runnable) {
        jw.f15691a.post(runnable);
    }

    /* renamed from: b */
    private final void m16532b(aoq aoq) {
        if (((Boolean) aph.f().a(asp.cl)).booleanValue() || this.f12990e == null) {
            C4736a boVar = new bo(this.f12986a, this.f13003r, this.f12993h, this.f13000o, this.f12988c, this.f13001p);
            this.f13002q = new WeakReference(boVar);
            awr awr = this.f12992g;
            C2872v.m8389b("setOnPublisherAdViewLoadedListener must be called on the main UI thread.");
            boVar.e.f6815z = awr;
            if (this.f12994i != null) {
                if (this.f12994i.m16415b() != null) {
                    boVar.m16434a(this.f12994i.m16415b());
                }
                boVar.mo3550b(this.f12994i.m16414a());
            }
            awe awe = this.f12989d;
            C2872v.m8389b("setOnAppInstallAdLoadedListener must be called on the main UI thread.");
            boVar.e.f6807r = awe;
            awu awu = this.f12990e;
            C2872v.m8389b("setOnUnifiedNativeAdLoadedListener must be called on the main UI thread.");
            boVar.e.f6809t = awu;
            awh awh = this.f12991f;
            C2872v.m8389b("setOnContentAdLoadedListener must be called on the main UI thread.");
            boVar.e.f6808s = awh;
            C0463l c0463l = this.f12995j;
            C2872v.m8389b("setOnCustomTemplateAdLoadedListeners must be called on the main UI thread.");
            boVar.e.f6811v = c0463l;
            c0463l = this.f12996k;
            C2872v.m8389b("setOnCustomClickListener must be called on the main UI thread.");
            boVar.e.f6810u = c0463l;
            aus aus = this.f12997l;
            C2872v.m8389b("setNativeAdOptions must be called on the main UI thread.");
            boVar.e.f6812w = aus;
            boVar.m17714c(m16537f());
            boVar.m16432a(this.f12987b);
            boVar.m16435a(this.f12999n);
            List arrayList = new ArrayList();
            if (m16536e()) {
                arrayList.add(Integer.valueOf(1));
            }
            if (this.f12992g != null) {
                arrayList.add(Integer.valueOf(2));
            }
            boVar.m17715d(arrayList);
            if (m16536e()) {
                aoq.f28263c.putBoolean("ina", true);
            }
            if (this.f12992g != null) {
                aoq.f28263c.putBoolean("iba", true);
            }
            boVar.mo3551b(aoq);
            return;
        }
        m16528a(0);
    }

    /* renamed from: b */
    private final void m16533b(aoq aoq, int i) {
        if (((Boolean) aph.f().a(asp.cl)).booleanValue() || this.f12990e == null) {
            C4736a aeVar = new ae(this.f12986a, this.f13003r, aou.a(this.f12986a), this.f13000o, this.f12988c, this.f13001p);
            this.f13002q = new WeakReference(aeVar);
            awe awe = this.f12989d;
            C2872v.m8389b("setOnAppInstallAdLoadedListener must be called on the main UI thread.");
            aeVar.e.f6807r = awe;
            awu awu = this.f12990e;
            C2872v.m8389b("setOnUnifiedNativeAdLoadedListener must be called on the main UI thread.");
            aeVar.e.f6809t = awu;
            awh awh = this.f12991f;
            C2872v.m8389b("setOnContentAdLoadedListener must be called on the main UI thread.");
            aeVar.e.f6808s = awh;
            C0463l c0463l = this.f12995j;
            C2872v.m8389b("setOnCustomTemplateAdLoadedListeners must be called on the main UI thread.");
            aeVar.e.f6811v = c0463l;
            aeVar.m16432a(this.f12987b);
            c0463l = this.f12996k;
            C2872v.m8389b("setOnCustomClickListener must be called on the main UI thread.");
            aeVar.e.f6810u = c0463l;
            aeVar.m17674c(m16537f());
            aus aus = this.f12997l;
            C2872v.m8389b("setNativeAdOptions must be called on the main UI thread.");
            aeVar.e.f6812w = aus;
            aeVar.m16435a(this.f12999n);
            aeVar.m17671b(i);
            aeVar.mo3551b(aoq);
            return;
        }
        m16528a(0);
    }

    /* renamed from: d */
    private final boolean m16535d() {
        return ((Boolean) aph.f().a(asp.aM)).booleanValue() && this.f12992g != null;
    }

    /* renamed from: e */
    private final boolean m16536e() {
        if (this.f12989d == null && this.f12991f == null && this.f12990e == null) {
            if (this.f12995j == null || this.f12995j.size() <= 0) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: f */
    private final List<String> m16537f() {
        List<String> arrayList = new ArrayList();
        if (this.f12991f != null) {
            arrayList.add(AppEventsConstants.EVENT_PARAM_VALUE_YES);
        }
        if (this.f12989d != null) {
            arrayList.add("2");
        }
        if (this.f12990e != null) {
            arrayList.add("6");
        }
        if (this.f12995j.size() > 0) {
            arrayList.add("3");
        }
        return arrayList;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final java.lang.String m16538a() {
        /*
        r3 = this;
        r0 = r3.f13004s;
        monitor-enter(r0);
        r1 = r3.f13002q;	 Catch:{ all -> 0x001a }
        r2 = 0;
        if (r1 == 0) goto L_0x0018;
    L_0x0008:
        r1 = r3.f13002q;	 Catch:{ all -> 0x001a }
        r1 = r1.get();	 Catch:{ all -> 0x001a }
        r1 = (com.google.android.gms.ads.internal.bb) r1;	 Catch:{ all -> 0x001a }
        if (r1 == 0) goto L_0x0016;
    L_0x0012:
        r2 = r1.m17424a();	 Catch:{ all -> 0x001a }
    L_0x0016:
        monitor-exit(r0);	 Catch:{ all -> 0x001a }
        return r2;
    L_0x0018:
        monitor-exit(r0);	 Catch:{ all -> 0x001a }
        return r2;
    L_0x001a:
        r1 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x001a }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.i.a():java.lang.String");
    }

    /* renamed from: a */
    public final void m16539a(aoq aoq) {
        C4737i.m16531a(new C2654j(this, aoq));
    }

    /* renamed from: a */
    public final void m16540a(aoq aoq, int i) {
        if (i > 0) {
            C4737i.m16531a(new C2655k(this, aoq, i));
            return;
        }
        throw new IllegalArgumentException("Number of ads has to be more than 0");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    public final java.lang.String m16541b() {
        /*
        r3 = this;
        r0 = r3.f13004s;
        monitor-enter(r0);
        r1 = r3.f13002q;	 Catch:{ all -> 0x001a }
        r2 = 0;
        if (r1 == 0) goto L_0x0018;
    L_0x0008:
        r1 = r3.f13002q;	 Catch:{ all -> 0x001a }
        r1 = r1.get();	 Catch:{ all -> 0x001a }
        r1 = (com.google.android.gms.ads.internal.bb) r1;	 Catch:{ all -> 0x001a }
        if (r1 == 0) goto L_0x0016;
    L_0x0012:
        r2 = r1.w_();	 Catch:{ all -> 0x001a }
    L_0x0016:
        monitor-exit(r0);	 Catch:{ all -> 0x001a }
        return r2;
    L_0x0018:
        monitor-exit(r0);	 Catch:{ all -> 0x001a }
        return r2;
    L_0x001a:
        r1 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x001a }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.i.b():java.lang.String");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: c */
    public final boolean m16542c() {
        /*
        r3 = this;
        r0 = r3.f13004s;
        monitor-enter(r0);
        r1 = r3.f13002q;	 Catch:{ all -> 0x001a }
        r2 = 0;
        if (r1 == 0) goto L_0x0018;
    L_0x0008:
        r1 = r3.f13002q;	 Catch:{ all -> 0x001a }
        r1 = r1.get();	 Catch:{ all -> 0x001a }
        r1 = (com.google.android.gms.ads.internal.bb) r1;	 Catch:{ all -> 0x001a }
        if (r1 == 0) goto L_0x0016;
    L_0x0012:
        r2 = r1.m16471r();	 Catch:{ all -> 0x001a }
    L_0x0016:
        monitor-exit(r0);	 Catch:{ all -> 0x001a }
        return r2;
    L_0x0018:
        monitor-exit(r0);	 Catch:{ all -> 0x001a }
        return r2;
    L_0x001a:
        r1 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x001a }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.i.c():boolean");
    }
}
