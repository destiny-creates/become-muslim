package com.google.maps.android.p247a;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

/* compiled from: Feature */
/* renamed from: com.google.maps.android.a.b */
public class C5392b extends Observable {
    /* renamed from: a */
    private final String f18168a;
    /* renamed from: b */
    private final Map<String, String> f18169b;
    /* renamed from: c */
    private C5393c f18170c;

    public C5392b(C5393c c5393c, String str, Map<String, String> map) {
        this.f18170c = c5393c;
        this.f18168a = str;
        if (map == null) {
            this.f18169b = new HashMap();
        } else {
            this.f18169b = map;
        }
    }

    /* renamed from: a */
    public Iterable m22889a() {
        return this.f18169b.entrySet();
    }

    /* renamed from: a */
    public String m22890a(String str) {
        return (String) this.f18169b.get(str);
    }

    /* renamed from: b */
    public String m22891b() {
        return this.f18168a;
    }

    /* renamed from: b */
    public boolean m22892b(String str) {
        return this.f18169b.containsKey(str);
    }

    /* renamed from: c */
    public C5393c m22893c() {
        return this.f18170c;
    }

    /* renamed from: d */
    public boolean m22894d() {
        return this.f18170c != null;
    }
}
