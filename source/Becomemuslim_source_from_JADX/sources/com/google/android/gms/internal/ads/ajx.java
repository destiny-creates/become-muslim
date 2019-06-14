package com.google.android.gms.internal.ads;

import android.view.View;
import java.lang.ref.WeakReference;

public final class ajx implements alh {
    /* renamed from: a */
    private WeakReference<auf> f23675a;

    public ajx(auf auf) {
        this.f23675a = new WeakReference(auf);
    }

    /* renamed from: a */
    public final View mo3831a() {
        auf auf = (auf) this.f23675a.get();
        return auf != null ? auf.mo3992l() : null;
    }

    /* renamed from: b */
    public final boolean mo3832b() {
        return this.f23675a.get() == null;
    }

    /* renamed from: c */
    public final alh mo3833c() {
        return new ajz((auf) this.f23675a.get());
    }
}
