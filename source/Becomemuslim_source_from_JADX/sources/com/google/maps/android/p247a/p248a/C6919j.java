package com.google.maps.android.p247a.p248a;

import com.google.android.gms.maps.model.C7851m;
import com.google.maps.android.p247a.C5396i;
import java.util.Arrays;

/* compiled from: GeoJsonPointStyle */
/* renamed from: com.google.maps.android.a.a.j */
public class C6919j extends C5396i implements C5382m {
    /* renamed from: d */
    private static final String[] f24766d = new String[]{"Point", "MultiPoint", "GeometryCollection"};

    /* renamed from: b */
    public String[] mo4897b() {
        return f24766d;
    }

    /* renamed from: c */
    public float m32437c() {
        return this.a.m38338m();
    }

    /* renamed from: d */
    public float m32438d() {
        return this.a.m38330e();
    }

    /* renamed from: e */
    public float m32439e() {
        return this.a.m38331f();
    }

    /* renamed from: f */
    public boolean m32440f() {
        return this.a.m38332g();
    }

    /* renamed from: g */
    public boolean m32441g() {
        return this.a.m38334i();
    }

    /* renamed from: h */
    public float m32442h() {
        return this.a.m38336k();
    }

    /* renamed from: i */
    public float m32443i() {
        return this.a.m38337l();
    }

    /* renamed from: a */
    public float mo4898a() {
        return this.a.m38335j();
    }

    /* renamed from: j */
    public String m32444j() {
        return this.a.m38328c();
    }

    /* renamed from: k */
    public String m32445k() {
        return this.a.m38325b();
    }

    /* renamed from: l */
    public boolean m32446l() {
        return this.a.m38333h();
    }

    /* renamed from: m */
    public C7851m m32447m() {
        C7851m c7851m = new C7851m();
        c7851m.m38326c(this.a.m38338m());
        c7851m.m38316a(this.a.m38330e(), this.a.m38331f());
        c7851m.m38320a(this.a.m38332g());
        c7851m.m38327c(this.a.m38334i());
        c7851m.m38318a(this.a.m38329d());
        c7851m.m38322b(this.a.m38336k(), this.a.m38337l());
        c7851m.m38321b(this.a.m38335j());
        c7851m.m38323b(this.a.m38328c());
        c7851m.m38319a(this.a.m38325b());
        c7851m.m38324b(this.a.m38333h());
        return c7851m;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("PointStyle{");
        stringBuilder.append("\n geometry type=");
        stringBuilder.append(Arrays.toString(f24766d));
        stringBuilder.append(",\n alpha=");
        stringBuilder.append(m32437c());
        stringBuilder.append(",\n anchor U=");
        stringBuilder.append(m32438d());
        stringBuilder.append(",\n anchor V=");
        stringBuilder.append(m32439e());
        stringBuilder.append(",\n draggable=");
        stringBuilder.append(m32440f());
        stringBuilder.append(",\n flat=");
        stringBuilder.append(m32441g());
        stringBuilder.append(",\n info window anchor U=");
        stringBuilder.append(m32442h());
        stringBuilder.append(",\n info window anchor V=");
        stringBuilder.append(m32443i());
        stringBuilder.append(",\n rotation=");
        stringBuilder.append(mo4898a());
        stringBuilder.append(",\n snippet=");
        stringBuilder.append(m32444j());
        stringBuilder.append(",\n title=");
        stringBuilder.append(m32445k());
        stringBuilder.append(",\n visible=");
        stringBuilder.append(m32446l());
        stringBuilder.append("\n}\n");
        return stringBuilder.toString();
    }
}
