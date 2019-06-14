package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.internal.p212k.ah;
import java.util.List;

/* renamed from: com.google.android.gms.maps.model.r */
public final class C5145r {
    /* renamed from: a */
    private final ah f17419a;

    public C5145r(ah ahVar) {
        this.f17419a = (ah) C2872v.a(ahVar);
    }

    /* renamed from: a */
    public final void m21817a() {
        try {
            this.f17419a.mo4693b();
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: a */
    public final void m21818a(float f) {
        try {
            this.f17419a.mo4687a(f);
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: a */
    public final void m21819a(int i) {
        try {
            this.f17419a.mo4688a(i);
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: a */
    public final void m21820a(C7847d c7847d) {
        C2872v.a(c7847d, "startCap must not be null");
        try {
            this.f17419a.mo4689a(c7847d);
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: a */
    public final void m21821a(List<LatLng> list) {
        try {
            this.f17419a.mo4690a((List) list);
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: a */
    public final void m21822a(boolean z) {
        try {
            this.f17419a.mo4691a(z);
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: b */
    public final List<LatLng> m21823b() {
        try {
            return this.f17419a.mo4697c();
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: b */
    public final void m21824b(float f) {
        try {
            this.f17419a.mo4694b(f);
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: b */
    public final void m21825b(C7847d c7847d) {
        C2872v.a(c7847d, "endCap must not be null");
        try {
            this.f17419a.mo4695b(c7847d);
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: b */
    public final void m21826b(boolean z) {
        try {
            this.f17419a.mo4696b(z);
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: c */
    public final void m21827c(boolean z) {
        try {
            this.f17419a.mo4698c(z);
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C5145r)) {
            return false;
        }
        try {
            return this.f17419a.mo4692a(((C5145r) obj).f17419a);
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    public final int hashCode() {
        try {
            return this.f17419a.mo4699d();
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }
}
