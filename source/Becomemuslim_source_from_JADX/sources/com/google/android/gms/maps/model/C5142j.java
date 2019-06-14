package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.internal.p212k.C5032y;

/* renamed from: com.google.android.gms.maps.model.j */
public final class C5142j {
    /* renamed from: a */
    private final C5032y f17416a;

    public C5142j(C5032y c5032y) {
        this.f17416a = (C5032y) C2872v.a(c5032y);
    }

    /* renamed from: a */
    public final String m21785a() {
        try {
            return this.f17416a.mo4649a();
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: b */
    public final String m21786b() {
        try {
            return this.f17416a.mo4651b();
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: c */
    public final void m21787c() {
        try {
            this.f17416a.mo4652c();
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C5142j)) {
            return false;
        }
        try {
            return this.f17416a.mo4650a(((C5142j) obj).f17416a);
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    public final int hashCode() {
        try {
            return this.f17416a.mo4653d();
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }
}
