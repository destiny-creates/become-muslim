package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.internal.p212k.C5030s;

/* renamed from: com.google.android.gms.maps.model.g */
public final class C5139g {
    /* renamed from: a */
    private final C5030s f17412a;

    public C5139g(C5030s c5030s) {
        this.f17412a = (C5030s) C2872v.a(c5030s);
    }

    /* renamed from: a */
    public final void m21774a() {
        try {
            this.f17412a.C_();
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: a */
    public final void m21775a(float f) {
        try {
            this.f17412a.mo4721a(f);
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: a */
    public final void m21776a(LatLngBounds latLngBounds) {
        try {
            this.f17412a.mo4723a(latLngBounds);
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: a */
    public final void m21777a(C5136a c5136a) {
        C2872v.a(c5136a, "imageDescriptor must not be null");
        try {
            this.f17412a.mo4722a(c5136a.m21760a());
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: a */
    public final void m21778a(boolean z) {
        try {
            this.f17412a.mo4724a(z);
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: b */
    public final void m21779b(boolean z) {
        try {
            this.f17412a.mo4727b(z);
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C5139g)) {
            return false;
        }
        try {
            return this.f17412a.mo4725a(((C5139g) obj).f17412a);
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    public final int hashCode() {
        try {
            return this.f17412a.mo4726b();
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }
}
