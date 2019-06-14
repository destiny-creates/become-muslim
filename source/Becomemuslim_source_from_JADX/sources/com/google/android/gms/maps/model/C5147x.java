package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.internal.p212k.C5023d;

/* renamed from: com.google.android.gms.maps.model.x */
public final class C5147x {
    /* renamed from: a */
    private final C5023d f17420a;

    public C5147x(C5023d c5023d) {
        this.f17420a = (C5023d) C2872v.a(c5023d);
    }

    /* renamed from: a */
    public final void m21828a() {
        try {
            this.f17420a.z_();
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: a */
    public final void m21829a(float f) {
        try {
            this.f17420a.mo4700a(f);
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: b */
    public final void m21830b() {
        try {
            this.f17420a.mo4702b();
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C5147x)) {
            return false;
        }
        try {
            return this.f17420a.mo4701a(((C5147x) obj).f17420a);
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    public final int hashCode() {
        try {
            return this.f17420a.mo4703c();
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }
}
