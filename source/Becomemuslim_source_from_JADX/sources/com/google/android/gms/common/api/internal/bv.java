package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.api.C2789g;
import com.google.android.gms.common.api.C2791i;
import com.google.android.gms.common.api.C2814k;
import com.google.android.gms.common.api.C2815l;
import com.google.android.gms.common.api.C2816n;
import com.google.android.gms.common.api.C2817o;
import com.google.android.gms.common.api.C4358m;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C2872v;
import java.lang.ref.WeakReference;

public final class bv<R extends C2814k> extends C2817o<R> implements C2815l<R> {
    /* renamed from: a */
    private C2816n<? super R, ? extends C2814k> f11473a;
    /* renamed from: b */
    private bv<? extends C2814k> f11474b;
    /* renamed from: c */
    private volatile C4358m<? super R> f11475c;
    /* renamed from: d */
    private C2789g<R> f11476d;
    /* renamed from: e */
    private final Object f11477e;
    /* renamed from: f */
    private Status f11478f;
    /* renamed from: g */
    private final WeakReference<GoogleApiClient> f11479g;
    /* renamed from: h */
    private final bx f11480h;
    /* renamed from: i */
    private boolean f11481i;

    public final void onResult(R r) {
        synchronized (this.f11477e) {
            if (!r.mo2360b().m16705d()) {
                m14180a(r.mo2360b());
                m14183a((C2814k) r);
            } else if (this.f11473a != null) {
                bp.m8021a().submit(new bw(this, r));
            } else if (m14188c()) {
                this.f11475c.m14328a((C2814k) r);
            }
        }
    }

    /* renamed from: a */
    public final void m14192a(C2789g<?> c2789g) {
        synchronized (this.f11477e) {
            this.f11476d = c2789g;
            m14185b();
        }
    }

    /* renamed from: b */
    private final void m14185b() {
        if (this.f11473a != null || this.f11475c != null) {
            GoogleApiClient googleApiClient = (GoogleApiClient) this.f11479g.get();
            if (!(this.f11481i || this.f11473a == null || googleApiClient == null)) {
                googleApiClient.mo2404a(this);
                this.f11481i = true;
            }
            if (this.f11478f != null) {
                m14186b(this.f11478f);
                return;
            }
            if (this.f11476d != null) {
                this.f11476d.mo2379a((C2815l) this);
            }
        }
    }

    /* renamed from: a */
    private final void m14180a(Status status) {
        synchronized (this.f11477e) {
            this.f11478f = status;
            m14186b(this.f11478f);
        }
    }

    /* renamed from: b */
    private final void m14186b(Status status) {
        synchronized (this.f11477e) {
            if (this.f11473a != null) {
                status = this.f11473a.m8109a(status);
                C2872v.m8381a((Object) status, (Object) "onFailure must not return null");
                this.f11474b.m14180a(status);
            } else if (m14188c()) {
                this.f11475c.m14327a(status);
            }
        }
    }

    /* renamed from: a */
    final void m14191a() {
        this.f11475c = null;
    }

    /* renamed from: c */
    private final boolean m14188c() {
        return (this.f11475c == null || ((GoogleApiClient) this.f11479g.get()) == null) ? false : true;
    }

    /* renamed from: a */
    private static void m14183a(C2814k c2814k) {
        if (c2814k instanceof C2791i) {
            try {
                ((C2791i) c2814k).mo3299a();
            } catch (Throwable e) {
                c2814k = String.valueOf(c2814k);
                StringBuilder stringBuilder = new StringBuilder(String.valueOf(c2814k).length() + 18);
                stringBuilder.append("Unable to release ");
                stringBuilder.append(c2814k);
                Log.w("TransformedResultImpl", stringBuilder.toString(), e);
            }
        }
    }
}
