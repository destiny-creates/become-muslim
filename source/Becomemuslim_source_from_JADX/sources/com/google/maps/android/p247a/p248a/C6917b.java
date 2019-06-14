package com.google.maps.android.p247a.p248a;

import com.google.android.gms.maps.model.C7851m;
import com.google.android.gms.maps.model.C7854q;
import com.google.android.gms.maps.model.C7855s;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.maps.android.p247a.C5392b;
import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;

/* compiled from: GeoJsonFeature */
/* renamed from: com.google.maps.android.a.a.b */
public class C6917b extends C5392b implements Observer {
    /* renamed from: a */
    private final String f24760a;
    /* renamed from: b */
    private final LatLngBounds f24761b;
    /* renamed from: c */
    private C6919j f24762c;
    /* renamed from: d */
    private C6918e f24763d;
    /* renamed from: e */
    private C6920l f24764e;

    /* renamed from: e */
    public C6919j m32421e() {
        return this.f24762c;
    }

    /* renamed from: a */
    public void m32419a(C6919j c6919j) {
        if (c6919j != null) {
            if (this.f24762c != null) {
                this.f24762c.deleteObserver(this);
            }
            this.f24762c = c6919j;
            this.f24762c.addObserver(this);
            m32417a(this.f24762c);
            return;
        }
        throw new IllegalArgumentException("Point style cannot be null");
    }

    /* renamed from: f */
    public C6918e m32422f() {
        return this.f24763d;
    }

    /* renamed from: a */
    public void m32418a(C6918e c6918e) {
        if (c6918e != null) {
            if (this.f24763d != null) {
                this.f24763d.deleteObserver(this);
            }
            this.f24763d = c6918e;
            this.f24763d.addObserver(this);
            m32417a(this.f24763d);
            return;
        }
        throw new IllegalArgumentException("Line string style cannot be null");
    }

    /* renamed from: g */
    public C6920l m32423g() {
        return this.f24764e;
    }

    /* renamed from: a */
    public void m32420a(C6920l c6920l) {
        if (c6920l != null) {
            if (this.f24764e != null) {
                this.f24764e.deleteObserver(this);
            }
            this.f24764e = c6920l;
            this.f24764e.addObserver(this);
            m32417a(this.f24764e);
            return;
        }
        throw new IllegalArgumentException("Polygon style cannot be null");
    }

    /* renamed from: h */
    public C7854q m32424h() {
        return this.f24764e.m32455i();
    }

    /* renamed from: i */
    public C7851m m32425i() {
        return this.f24762c.m32447m();
    }

    /* renamed from: j */
    public C7855s m32426j() {
        return this.f24763d.m32434i();
    }

    /* renamed from: a */
    private void m32417a(C5382m c5382m) {
        if (m22894d() && Arrays.asList(c5382m.mo4897b()).contains(m22893c().mo4901c()) != null) {
            setChanged();
            notifyObservers();
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Feature{");
        stringBuilder.append("\n bounding box=");
        stringBuilder.append(this.f24761b);
        stringBuilder.append(",\n geometry=");
        stringBuilder.append(m22893c());
        stringBuilder.append(",\n point style=");
        stringBuilder.append(this.f24762c);
        stringBuilder.append(",\n line string style=");
        stringBuilder.append(this.f24763d);
        stringBuilder.append(",\n polygon style=");
        stringBuilder.append(this.f24764e);
        stringBuilder.append(",\n id=");
        stringBuilder.append(this.f24760a);
        stringBuilder.append(",\n properties=");
        stringBuilder.append(m22889a());
        stringBuilder.append("\n}\n");
        return stringBuilder.toString();
    }

    public void update(Observable observable, Object obj) {
        if ((observable instanceof C5382m) != null) {
            m32417a((C5382m) observable);
        }
    }
}
