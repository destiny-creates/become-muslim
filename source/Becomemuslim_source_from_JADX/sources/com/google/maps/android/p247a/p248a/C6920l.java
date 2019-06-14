package com.google.maps.android.p247a.p248a;

import com.google.android.gms.maps.model.C7854q;
import com.google.maps.android.p247a.C5396i;
import java.util.Arrays;

/* compiled from: GeoJsonPolygonStyle */
/* renamed from: com.google.maps.android.a.a.l */
public class C6920l extends C5396i implements C5382m {
    /* renamed from: d */
    private static final String[] f24767d = new String[]{"Polygon", "MultiPolygon", "GeometryCollection"};

    /* renamed from: b */
    public String[] mo4897b() {
        return f24767d;
    }

    /* renamed from: c */
    public int m32449c() {
        return this.c.m38353f();
    }

    /* renamed from: d */
    public boolean m32450d() {
        return this.c.m38356i();
    }

    /* renamed from: e */
    public int m32451e() {
        return this.c.m38350c();
    }

    /* renamed from: f */
    public float m32452f() {
        return this.c.m38345b();
    }

    /* renamed from: g */
    public float m32453g() {
        return this.c.m38354g();
    }

    /* renamed from: h */
    public boolean m32454h() {
        return this.c.m38355h();
    }

    /* renamed from: i */
    public C7854q m32455i() {
        C7854q c7854q = new C7854q();
        c7854q.m38347b(this.c.m38353f());
        c7854q.m38349b(this.c.m38356i());
        c7854q.m38341a(this.c.m38350c());
        c7854q.m38340a(this.c.m38345b());
        c7854q.m38343a(this.c.m38355h());
        c7854q.m38346b(this.c.m38354g());
        return c7854q;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("PolygonStyle{");
        stringBuilder.append("\n geometry type=");
        stringBuilder.append(Arrays.toString(f24767d));
        stringBuilder.append(",\n fill color=");
        stringBuilder.append(m32449c());
        stringBuilder.append(",\n geodesic=");
        stringBuilder.append(m32450d());
        stringBuilder.append(",\n stroke color=");
        stringBuilder.append(m32451e());
        stringBuilder.append(",\n stroke width=");
        stringBuilder.append(m32452f());
        stringBuilder.append(",\n visible=");
        stringBuilder.append(m32454h());
        stringBuilder.append(",\n z index=");
        stringBuilder.append(m32453g());
        stringBuilder.append("\n}\n");
        return stringBuilder.toString();
    }
}
