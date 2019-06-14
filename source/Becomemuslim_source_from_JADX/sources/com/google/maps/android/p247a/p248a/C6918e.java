package com.google.maps.android.p247a.p248a;

import com.google.android.gms.maps.model.C7855s;
import com.google.maps.android.p247a.C5396i;
import java.util.Arrays;

/* compiled from: GeoJsonLineStringStyle */
/* renamed from: com.google.maps.android.a.a.e */
public class C6918e extends C5396i implements C5382m {
    /* renamed from: d */
    private static final String[] f24765d = new String[]{"LineString", "MultiLineString", "GeometryCollection"};

    /* renamed from: b */
    public String[] mo4897b() {
        return f24765d;
    }

    /* renamed from: c */
    public int m32428c() {
        return this.b.m38368c();
    }

    /* renamed from: d */
    public boolean m32429d() {
        return this.b.m38377k();
    }

    /* renamed from: e */
    public boolean m32430e() {
        return this.b.m38376j();
    }

    /* renamed from: f */
    public float m32431f() {
        return this.b.m38364b();
    }

    /* renamed from: g */
    public float m32432g() {
        return this.b.m38374h();
    }

    /* renamed from: h */
    public boolean m32433h() {
        return this.b.m38375i();
    }

    /* renamed from: i */
    public C7855s m32434i() {
        C7855s c7855s = new C7855s();
        c7855s.m38359a(this.b.m38368c());
        c7855s.m38369c(this.b.m38377k());
        c7855s.m38367b(this.b.m38376j());
        c7855s.m38362a(this.b.m38375i());
        c7855s.m38358a(this.b.m38364b());
        c7855s.m38365b(this.b.m38374h());
        return c7855s;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("LineStringStyle{");
        stringBuilder.append("\n geometry type=");
        stringBuilder.append(Arrays.toString(f24765d));
        stringBuilder.append(",\n color=");
        stringBuilder.append(m32428c());
        stringBuilder.append(",\n clickable=");
        stringBuilder.append(m32429d());
        stringBuilder.append(",\n geodesic=");
        stringBuilder.append(m32430e());
        stringBuilder.append(",\n visible=");
        stringBuilder.append(m32433h());
        stringBuilder.append(",\n width=");
        stringBuilder.append(m32431f());
        stringBuilder.append(",\n z index=");
        stringBuilder.append(m32432g());
        stringBuilder.append("\n}\n");
        return stringBuilder.toString();
    }
}
