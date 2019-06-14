package com.google.maps.android.p247a.p249b;

import com.google.android.gms.maps.model.C5139g;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: KmlContainer */
/* renamed from: com.google.maps.android.a.b.b */
public class C5384b {
    /* renamed from: a */
    private final HashMap<String, String> f18147a;
    /* renamed from: b */
    private final HashMap<C6923j, Object> f18148b;
    /* renamed from: c */
    private final ArrayList<C5384b> f18149c;
    /* renamed from: d */
    private final HashMap<C5387e, C5139g> f18150d;
    /* renamed from: e */
    private final HashMap<String, String> f18151e;
    /* renamed from: f */
    private HashMap<String, C6925n> f18152f;
    /* renamed from: g */
    private String f18153g;

    C5384b(HashMap<String, String> hashMap, HashMap<String, C6925n> hashMap2, HashMap<C6923j, Object> hashMap3, HashMap<String, String> hashMap4, ArrayList<C5384b> arrayList, HashMap<C5387e, C5139g> hashMap5, String str) {
        this.f18147a = hashMap;
        this.f18148b = hashMap3;
        this.f18152f = hashMap2;
        this.f18151e = hashMap4;
        this.f18149c = arrayList;
        this.f18150d = hashMap5;
        this.f18153g = str;
    }

    /* renamed from: a */
    HashMap<String, C6925n> m22837a() {
        return this.f18152f;
    }

    /* renamed from: a */
    void m22838a(C6923j c6923j, Object obj) {
        this.f18148b.put(c6923j, obj);
    }

    /* renamed from: b */
    HashMap<String, String> m22840b() {
        return this.f18151e;
    }

    /* renamed from: c */
    HashMap<C5387e, C5139g> m22841c() {
        return this.f18150d;
    }

    /* renamed from: a */
    public C6925n m22836a(String str) {
        return (C6925n) this.f18152f.get(str);
    }

    /* renamed from: d */
    HashMap<C6923j, Object> m22843d() {
        return this.f18148b;
    }

    /* renamed from: b */
    public String m22839b(String str) {
        return (String) this.f18147a.get(str);
    }

    /* renamed from: c */
    public boolean m22842c(String str) {
        return this.f18147a.containsKey(str);
    }

    /* renamed from: e */
    public boolean m22844e() {
        return this.f18149c.size() > 0;
    }

    /* renamed from: f */
    public Iterable<C5384b> m22845f() {
        return this.f18149c;
    }

    /* renamed from: g */
    public Iterable<C6923j> m22846g() {
        return this.f18148b.keySet();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Container");
        stringBuilder.append("{");
        stringBuilder.append("\n properties=");
        stringBuilder.append(this.f18147a);
        stringBuilder.append(",\n placemarks=");
        stringBuilder.append(this.f18148b);
        stringBuilder.append(",\n containers=");
        stringBuilder.append(this.f18149c);
        stringBuilder.append(",\n ground overlays=");
        stringBuilder.append(this.f18150d);
        stringBuilder.append(",\n style maps=");
        stringBuilder.append(this.f18151e);
        stringBuilder.append(",\n styles=");
        stringBuilder.append(this.f18152f);
        stringBuilder.append("\n}\n");
        return stringBuilder.toString();
    }
}
