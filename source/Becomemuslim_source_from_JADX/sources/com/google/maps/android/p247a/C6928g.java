package com.google.maps.android.p247a;

import com.google.android.gms.maps.model.LatLng;

/* compiled from: Point */
/* renamed from: com.google.maps.android.a.g */
public class C6928g implements C5393c {
    /* renamed from: a */
    private final LatLng f24789a;

    /* renamed from: c */
    public String mo4901c() {
        return "Point";
    }

    /* renamed from: d */
    public /* synthetic */ Object mo4902d() {
        return m32531a();
    }

    public C6928g(LatLng latLng) {
        if (latLng != null) {
            this.f24789a = latLng;
            return;
        }
        throw new IllegalArgumentException("Coordinates cannot be null");
    }

    /* renamed from: a */
    public LatLng m32531a() {
        return this.f24789a;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Point");
        stringBuilder.append("{");
        stringBuilder.append("\n coordinates=");
        stringBuilder.append(this.f24789a);
        stringBuilder.append("\n}\n");
        return stringBuilder.toString();
    }
}
