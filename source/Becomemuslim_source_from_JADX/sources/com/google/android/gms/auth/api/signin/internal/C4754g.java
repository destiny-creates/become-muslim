package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.support.v4.content.C3192a;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.C2807l;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.android.gms.auth.api.signin.internal.g */
public final class C4754g extends C3192a<Void> implements C2807l {
    /* renamed from: o */
    private Semaphore f13136o = new Semaphore(0);
    /* renamed from: p */
    private Set<GoogleApiClient> f13137p;

    public C4754g(Context context, Set<GoogleApiClient> set) {
        super(context);
        this.f13137p = set;
    }

    /* renamed from: w */
    private final Void m16677w() {
        int i = 0;
        for (GoogleApiClient a : this.f13137p) {
            if (a.mo2407a((C2807l) this)) {
                i++;
            }
        }
        try {
            this.f13136o.tryAcquire(i, 5, TimeUnit.SECONDS);
        } catch (Throwable e) {
            Log.i("GACSignInLoader", "Unexpected InterruptedException", e);
            Thread.currentThread().interrupt();
        }
        return null;
    }

    /* renamed from: j */
    protected final void mo3269j() {
        this.f13136o.drainPermits();
        m1128l();
    }

    /* renamed from: v */
    public final void mo3270v() {
        this.f13136o.release();
    }

    /* renamed from: d */
    public final /* synthetic */ Object mo3268d() {
        return m16677w();
    }
}
