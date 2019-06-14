package com.google.maps.android.p247a;

import com.google.android.gms.maps.model.LatLng;
import java.util.List;

/* compiled from: LineString */
/* renamed from: com.google.maps.android.a.e */
public class C6926e implements C5393c<List<LatLng>> {
    /* renamed from: a */
    private final List<LatLng> f24786a;

    /* renamed from: c */
    public String mo4901c() {
        return "LineString";
    }

    /* renamed from: d */
    public /* synthetic */ Object mo4902d() {
        return mo6266a();
    }

    public C6926e(List<LatLng> list) {
        if (list != null) {
            this.f24786a = list;
            return;
        }
        throw new IllegalArgumentException("Coordinates cannot be null");
    }

    /* renamed from: a */
    public List<LatLng> mo6266a() {
        return this.f24786a;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("LineString");
        stringBuilder.append("{");
        stringBuilder.append("\n coordinates=");
        stringBuilder.append(this.f24786a);
        stringBuilder.append("\n}\n");
        return stringBuilder.toString();
    }
}
