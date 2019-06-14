package com.polidea.p254a.p256b.p257a;

import com.polidea.p254a.p256b.C5577b;
import java.util.Map.Entry;

/* compiled from: CacheEntry */
/* renamed from: com.polidea.a.b.a.a */
class C5556a implements Entry<String, C5577b> {
    /* renamed from: a */
    private final String f18631a;
    /* renamed from: b */
    private final C5559d f18632b;

    public /* synthetic */ Object getKey() {
        return m23640a();
    }

    public /* synthetic */ Object getValue() {
        return m23641b();
    }

    public /* synthetic */ Object setValue(Object obj) {
        return m23639a((C5577b) obj);
    }

    C5556a(String str, C5559d c5559d) {
        this.f18631a = str;
        this.f18632b = c5559d;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C5556a)) {
            return false;
        }
        C5556a c5556a = (C5556a) obj;
        if (!this.f18631a.equals(c5556a.m23640a()) || this.f18632b.equals(c5556a.f18632b) == null) {
            z = false;
        }
        return z;
    }

    /* renamed from: a */
    public String m23640a() {
        return this.f18631a;
    }

    /* renamed from: b */
    public C5577b m23641b() {
        return (C5577b) this.f18632b.get();
    }

    public int hashCode() {
        return (this.f18631a.hashCode() * 31) + this.f18632b.hashCode();
    }

    /* renamed from: a */
    public C5577b m23639a(C5577b c5577b) {
        throw new UnsupportedOperationException("Not implemented");
    }
}
