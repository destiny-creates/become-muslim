package com.google.maps.android.p247a.p249b;

import com.google.maps.android.p247a.C5393c;
import com.google.maps.android.p247a.C6927f;
import java.util.ArrayList;
import java.util.List;

/* compiled from: KmlMultiGeometry */
/* renamed from: com.google.maps.android.a.b.h */
public class C7926h extends C6927f {
    /* renamed from: a */
    public /* synthetic */ List mo6267a() {
        return m38535b();
    }

    /* renamed from: d */
    public /* synthetic */ Object mo4902d() {
        return m38535b();
    }

    public C7926h(ArrayList<C5393c> arrayList) {
        super(arrayList);
    }

    /* renamed from: b */
    public ArrayList<C5393c> m38535b() {
        return new ArrayList(super.mo6267a());
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(mo4901c());
        stringBuilder.append("{");
        stringBuilder.append("\n geometries=");
        stringBuilder.append(m38535b());
        stringBuilder.append("\n}\n");
        return stringBuilder.toString();
    }
}
