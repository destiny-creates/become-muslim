package com.google.maps.android.p247a.p249b;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.p247a.C6921a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: KmlPolygon */
/* renamed from: com.google.maps.android.a.b.l */
public class C7928l implements C6921a<ArrayList<ArrayList<LatLng>>> {
    /* renamed from: a */
    private final List<LatLng> f29539a;
    /* renamed from: b */
    private final List<List<LatLng>> f29540b;

    /* renamed from: c */
    public String mo4901c() {
        return "Polygon";
    }

    /* renamed from: d */
    public /* synthetic */ Object mo4902d() {
        return m38541e();
    }

    public C7928l(List<LatLng> list, List<List<LatLng>> list2) {
        if (list != null) {
            this.f29539a = list;
            this.f29540b = list2;
            return;
        }
        throw new IllegalArgumentException("Outer boundary coordinates cannot be null");
    }

    /* renamed from: e */
    public List<List<LatLng>> m38541e() {
        List<List<LatLng>> arrayList = new ArrayList();
        arrayList.add(this.f29539a);
        if (this.f29540b != null) {
            arrayList.addAll(this.f29540b);
        }
        return arrayList;
    }

    /* renamed from: a */
    public List<LatLng> mo6264a() {
        return this.f29539a;
    }

    /* renamed from: b */
    public List<List<LatLng>> mo6265b() {
        return this.f29540b;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Polygon");
        stringBuilder.append("{");
        stringBuilder.append("\n outer coordinates=");
        stringBuilder.append(this.f29539a);
        stringBuilder.append(",\n inner coordinates=");
        stringBuilder.append(this.f29540b);
        stringBuilder.append("\n}\n");
        return stringBuilder.toString();
    }
}
