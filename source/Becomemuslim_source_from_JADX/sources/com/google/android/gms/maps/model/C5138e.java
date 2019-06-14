package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.internal.p212k.C5029p;

/* renamed from: com.google.android.gms.maps.model.e */
public final class C5138e {
    /* renamed from: a */
    private final C5029p f17411a;

    public C5138e(C5029p c5029p) {
        this.f17411a = (C5029p) C2872v.a(c5029p);
    }

    /* renamed from: a */
    public final void m21767a() {
        try {
            this.f17411a.B_();
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: a */
    public final void m21768a(double d) {
        try {
            this.f17411a.mo4712a(d);
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: a */
    public final void m21769a(float f) {
        try {
            this.f17411a.mo4713a(f);
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: a */
    public final void m21770a(int i) {
        try {
            this.f17411a.mo4714a(i);
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: a */
    public final void m21771a(LatLng latLng) {
        try {
            this.f17411a.mo4715a(latLng);
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: b */
    public final void m21772b(float f) {
        try {
            this.f17411a.mo4718b(f);
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: b */
    public final void m21773b(int i) {
        try {
            this.f17411a.mo4719b(i);
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C5138e)) {
            return false;
        }
        try {
            return this.f17411a.mo4716a(((C5138e) obj).f17411a);
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    public final int hashCode() {
        try {
            return this.f17411a.mo4717b();
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }
}
