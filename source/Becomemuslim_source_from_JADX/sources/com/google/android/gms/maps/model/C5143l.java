package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.internal.p212k.ab;

/* renamed from: com.google.android.gms.maps.model.l */
public final class C5143l {
    /* renamed from: a */
    private final ab f17417a;

    public C5143l(ab abVar) {
        this.f17417a = (ab) C2872v.a(abVar);
    }

    /* renamed from: a */
    public final void m21788a() {
        try {
            this.f17417a.mo4654a();
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: a */
    public final void m21789a(float f) {
        try {
            this.f17417a.mo4668c(f);
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: a */
    public final void m21790a(float f, float f2) {
        try {
            this.f17417a.mo4656a(f, f2);
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: a */
    public final void m21791a(LatLng latLng) {
        if (latLng != null) {
            try {
                this.f17417a.mo4658a(latLng);
                return;
            } catch (RemoteException e) {
                throw new C5146u(e);
            }
        }
        throw new IllegalArgumentException("latlng cannot be null - a position is required.");
    }

    /* renamed from: a */
    public final void m21792a(C5136a c5136a) {
        if (c5136a == null) {
            try {
                this.f17417a.mo4657a(null);
                return;
            } catch (RemoteException e) {
                throw new C5146u(e);
            }
        }
        this.f17417a.mo4657a(c5136a.m21760a());
    }

    /* renamed from: a */
    public final void m21793a(String str) {
        try {
            this.f17417a.mo4659a(str);
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: a */
    public final void m21794a(boolean z) {
        try {
            this.f17417a.mo4660a(z);
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: b */
    public final LatLng m21795b() {
        try {
            return this.f17417a.mo4662b();
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: b */
    public final void m21796b(float f) {
        try {
            this.f17417a.mo4655a(f);
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: b */
    public final void m21797b(float f, float f2) {
        try {
            this.f17417a.mo4664b(f, f2);
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: b */
    public final void m21798b(String str) {
        try {
            this.f17417a.mo4665b(str);
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: b */
    public final void m21799b(boolean z) {
        try {
            this.f17417a.mo4666b(z);
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: c */
    public final String m21800c() {
        try {
            return this.f17417a.mo4667c();
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: c */
    public final void m21801c(float f) {
        try {
            this.f17417a.mo4663b(f);
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: c */
    public final void m21802c(boolean z) {
        try {
            this.f17417a.mo4669c(z);
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: d */
    public final String m21803d() {
        try {
            return this.f17417a.mo4670d();
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: e */
    public final void m21804e() {
        try {
            this.f17417a.mo4671e();
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C5143l)) {
            return false;
        }
        try {
            return this.f17417a.mo4661a(((C5143l) obj).f17417a);
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: f */
    public final void m21805f() {
        try {
            this.f17417a.mo4672f();
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    public final int hashCode() {
        try {
            return this.f17417a.mo4673g();
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }
}
