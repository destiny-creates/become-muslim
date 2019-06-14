package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.internal.p212k.ae;
import java.util.List;

/* renamed from: com.google.android.gms.maps.model.p */
public final class C5144p {
    /* renamed from: a */
    private final ae f17418a;

    public C5144p(ae aeVar) {
        this.f17418a = (ae) C2872v.a(aeVar);
    }

    /* renamed from: a */
    public final void m21806a() {
        try {
            this.f17418a.mo4674a();
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: a */
    public final void m21807a(float f) {
        try {
            this.f17418a.mo4675a(f);
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: a */
    public final void m21808a(int i) {
        try {
            this.f17418a.mo4676a(i);
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: a */
    public final void m21809a(List<LatLng> list) {
        try {
            this.f17418a.mo4677a((List) list);
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: a */
    public final void m21810a(boolean z) {
        try {
            this.f17418a.mo4678a(z);
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: b */
    public final List<LatLng> m21811b() {
        try {
            return this.f17418a.mo4680b();
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: b */
    public final void m21812b(float f) {
        try {
            this.f17418a.mo4681b(f);
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: b */
    public final void m21813b(int i) {
        try {
            this.f17418a.mo4682b(i);
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: b */
    public final void m21814b(List<? extends List<LatLng>> list) {
        try {
            this.f17418a.mo4683b((List) list);
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: b */
    public final void m21815b(boolean z) {
        try {
            this.f17418a.mo4684b(z);
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: c */
    public final void m21816c(boolean z) {
        try {
            this.f17418a.mo4686c(z);
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C5144p)) {
            return false;
        }
        try {
            return this.f17418a.mo4679a(((C5144p) obj).f17418a);
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    public final int hashCode() {
        try {
            return this.f17418a.mo4685c();
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }
}
