package com.google.android.gms.maps;

import android.graphics.Point;
import android.os.RemoteException;
import com.google.android.gms.maps.model.C5146u;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.ab;
import com.google.android.gms.maps.p216a.C5094d;
import com.google.android.gms.p174b.C4757d;

/* renamed from: com.google.android.gms.maps.g */
public final class C5129g {
    /* renamed from: a */
    private final C5094d f17399a;

    C5129g(C5094d c5094d) {
        this.f17399a = c5094d;
    }

    /* renamed from: a */
    public final Point m21740a(LatLng latLng) {
        try {
            return (Point) C4757d.a(this.f17399a.mo4779a(latLng));
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: a */
    public final LatLng m21741a(Point point) {
        try {
            return this.f17399a.mo4780a(C4757d.a(point));
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: a */
    public final ab m21742a() {
        try {
            return this.f17399a.mo4781a();
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }
}
