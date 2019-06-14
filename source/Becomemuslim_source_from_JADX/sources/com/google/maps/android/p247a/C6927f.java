package com.google.maps.android.p247a;

import java.util.ArrayList;
import java.util.List;

/* compiled from: MultiGeometry */
/* renamed from: com.google.maps.android.a.f */
public class C6927f implements C5393c {
    /* renamed from: a */
    private String f24787a = "MultiGeometry";
    /* renamed from: b */
    private List<C5393c> f24788b;

    /* renamed from: d */
    public /* synthetic */ Object mo4902d() {
        return mo6267a();
    }

    public C6927f(List<? extends C5393c> list) {
        if (list != null) {
            List arrayList = new ArrayList();
            for (C5393c add : list) {
                arrayList.add(add);
            }
            this.f24788b = arrayList;
            return;
        }
        throw new IllegalArgumentException("Geometries cannot be null");
    }

    /* renamed from: c */
    public String mo4901c() {
        return this.f24787a;
    }

    /* renamed from: a */
    public List<C5393c> mo6267a() {
        return this.f24788b;
    }

    public String toString() {
        String str = "Geometries=";
        if (this.f24787a.equals("MultiPoint")) {
            str = "LineStrings=";
        }
        if (this.f24787a.equals("MultiLineString")) {
            str = "points=";
        }
        if (this.f24787a.equals("MultiPolygon")) {
            str = "Polygons=";
        }
        StringBuilder stringBuilder = new StringBuilder(mo4901c());
        stringBuilder.append("{");
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("\n ");
        stringBuilder2.append(str);
        stringBuilder.append(stringBuilder2.toString());
        stringBuilder.append(mo6267a());
        stringBuilder.append("\n}\n");
        return stringBuilder.toString();
    }
}
