package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.maps.model.C5146u;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.p216a.C5091a;

/* renamed from: com.google.android.gms.maps.b */
public final class C5107b {
    /* renamed from: a */
    private static C5091a f17395a;

    /* renamed from: a */
    private static C5091a m21690a() {
        return (C5091a) C2872v.a(f17395a, "CameraUpdateFactory is not initialized");
    }

    /* renamed from: a */
    public static C5106a m21691a(CameraPosition cameraPosition) {
        try {
            return new C5106a(C5107b.m21690a().mo4847a(cameraPosition));
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: a */
    public static C5106a m21692a(LatLng latLng) {
        try {
            return new C5106a(C5107b.m21690a().mo4848a(latLng));
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: a */
    public static C5106a m21693a(LatLng latLng, float f) {
        try {
            return new C5106a(C5107b.m21690a().mo4849a(latLng, f));
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: a */
    public static C5106a m21694a(LatLngBounds latLngBounds, int i) {
        try {
            return new C5106a(C5107b.m21690a().mo4850a(latLngBounds, i));
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: a */
    public static C5106a m21695a(LatLngBounds latLngBounds, int i, int i2, int i3) {
        try {
            return new C5106a(C5107b.m21690a().mo4851a(latLngBounds, i, i2, i3));
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: a */
    public static void m21696a(C5091a c5091a) {
        f17395a = (C5091a) C2872v.a(c5091a);
    }
}
