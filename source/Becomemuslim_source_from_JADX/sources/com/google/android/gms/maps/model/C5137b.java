package com.google.android.gms.maps.model;

import android.graphics.Bitmap;
import android.os.RemoteException;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.internal.p212k.C5028m;

/* renamed from: com.google.android.gms.maps.model.b */
public final class C5137b {
    /* renamed from: a */
    private static C5028m f17410a;

    /* renamed from: a */
    public static C5136a m21761a() {
        try {
            return new C5136a(C5137b.m21766b().A_());
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: a */
    public static C5136a m21762a(float f) {
        try {
            return new C5136a(C5137b.m21766b().mo4708a(f));
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: a */
    public static C5136a m21763a(int i) {
        try {
            return new C5136a(C5137b.m21766b().mo4709a(i));
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: a */
    public static C5136a m21764a(Bitmap bitmap) {
        try {
            return new C5136a(C5137b.m21766b().mo4710a(bitmap));
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: a */
    public static void m21765a(C5028m c5028m) {
        if (f17410a == null) {
            f17410a = (C5028m) C2872v.a(c5028m);
        }
    }

    /* renamed from: b */
    private static C5028m m21766b() {
        return (C5028m) C2872v.a(f17410a, "IBitmapDescriptorFactory is not initialized");
    }
}
