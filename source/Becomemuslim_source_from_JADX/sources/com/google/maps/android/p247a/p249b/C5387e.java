package com.google.maps.android.p247a.p249b;

import com.google.android.gms.maps.model.C7849h;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.HashMap;
import java.util.Map;

/* compiled from: KmlGroundOverlay */
/* renamed from: com.google.maps.android.a.b.e */
public class C5387e {
    /* renamed from: a */
    private final Map<String, String> f18154a;
    /* renamed from: b */
    private final C7849h f18155b = new C7849h();
    /* renamed from: c */
    private String f18156c;
    /* renamed from: d */
    private LatLngBounds f18157d;

    C5387e(String str, LatLngBounds latLngBounds, float f, int i, HashMap<String, String> hashMap, float f2) {
        this.f18156c = str;
        this.f18154a = hashMap;
        if (latLngBounds != null) {
            this.f18157d = latLngBounds;
            this.f18155b.m38300a(latLngBounds);
            this.f18155b.m38299a(f2);
            this.f18155b.m38304b(f);
            this.f18155b.m38302a(i != 0 ? true : null);
            return;
        }
        throw new IllegalArgumentException("No LatLonBox given");
    }

    /* renamed from: a */
    public String m22866a() {
        return this.f18156c;
    }

    /* renamed from: b */
    public LatLngBounds m22867b() {
        return this.f18157d;
    }

    /* renamed from: c */
    C7849h m22868c() {
        return this.f18155b;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("GroundOverlay");
        stringBuilder.append("{");
        stringBuilder.append("\n properties=");
        stringBuilder.append(this.f18154a);
        stringBuilder.append(",\n image url=");
        stringBuilder.append(this.f18156c);
        stringBuilder.append(",\n LatLngBox=");
        stringBuilder.append(this.f18157d);
        stringBuilder.append("\n}\n");
        return stringBuilder.toString();
    }
}
