package com.google.maps.android.p247a.p249b;

import com.google.android.gms.maps.model.C7851m;
import com.google.android.gms.maps.model.C7854q;
import com.google.android.gms.maps.model.C7855s;
import com.google.maps.android.p247a.C5392b;
import com.google.maps.android.p247a.C5393c;
import java.util.HashMap;

/* compiled from: KmlPlacemark */
/* renamed from: com.google.maps.android.a.b.j */
public class C6923j extends C5392b {
    /* renamed from: a */
    private final String f24768a;
    /* renamed from: b */
    private final C6925n f24769b;

    public C6923j(C5393c c5393c, String str, C6925n c6925n, HashMap<String, String> hashMap) {
        super(c5393c, str, hashMap);
        this.f24768a = str;
        this.f24769b = c6925n;
    }

    /* renamed from: e */
    public String m32461e() {
        return super.m22891b();
    }

    /* renamed from: f */
    public C6925n m32462f() {
        return this.f24769b;
    }

    /* renamed from: g */
    public C7854q m32463g() {
        return this.f24769b.m32524n();
    }

    /* renamed from: h */
    public C7851m m32464h() {
        return this.f24769b.m32522l();
    }

    /* renamed from: i */
    public C7855s m32465i() {
        return this.f24769b.m32523m();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Placemark");
        stringBuilder.append("{");
        stringBuilder.append("\n style id=");
        stringBuilder.append(this.f24768a);
        stringBuilder.append(",\n inline style=");
        stringBuilder.append(this.f24769b);
        stringBuilder.append("\n}\n");
        return stringBuilder.toString();
    }
}
