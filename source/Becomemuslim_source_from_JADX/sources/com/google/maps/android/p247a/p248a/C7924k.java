package com.google.maps.android.p247a.p248a;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.p247a.C6921a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: GeoJsonPolygon */
/* renamed from: com.google.maps.android.a.a.k */
public class C7924k implements C6921a {
    /* renamed from: a */
    private final List<? extends List<LatLng>> f29538a;

    /* renamed from: e */
    public String m38526e() {
        return "Polygon";
    }

    /* renamed from: a */
    public /* synthetic */ List mo6264a() {
        return m38529h();
    }

    /* renamed from: b */
    public /* synthetic */ List mo6265b() {
        return m38530i();
    }

    /* renamed from: d */
    public /* synthetic */ Object mo4902d() {
        return m38528g();
    }

    /* renamed from: f */
    public List<? extends List<LatLng>> m38527f() {
        return this.f29538a;
    }

    /* renamed from: g */
    public List<? extends List<LatLng>> m38528g() {
        return m38527f();
    }

    /* renamed from: c */
    public String mo4901c() {
        return m38526e();
    }

    /* renamed from: h */
    public ArrayList<LatLng> m38529h() {
        return (ArrayList) m38527f().get(0);
    }

    /* renamed from: i */
    public ArrayList<ArrayList<LatLng>> m38530i() {
        ArrayList<ArrayList<LatLng>> arrayList = new ArrayList();
        for (int i = 1; i < m38527f().size(); i++) {
            arrayList.add((ArrayList) m38527f().get(i));
        }
        return arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Polygon");
        stringBuilder.append("{");
        stringBuilder.append("\n coordinates=");
        stringBuilder.append(this.f29538a);
        stringBuilder.append("\n}\n");
        return stringBuilder.toString();
    }
}
