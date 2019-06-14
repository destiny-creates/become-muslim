package com.polidea.reactnativeble.p269e;

import com.polidea.p254a.ah;
import java.util.UUID;

/* compiled from: IdGeneratorKey */
/* renamed from: com.polidea.reactnativeble.e.d */
public class C5644d {
    /* renamed from: a */
    private final ah f18881a;
    /* renamed from: b */
    private final UUID f18882b;
    /* renamed from: c */
    private final int f18883c;

    public C5644d(ah ahVar, UUID uuid, int i) {
        this.f18881a = ahVar;
        this.f18882b = uuid;
        this.f18883c = i;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C5644d)) {
            return false;
        }
        C5644d c5644d = (C5644d) obj;
        if (this.f18883c != c5644d.f18883c || !this.f18881a.mo5026c().equals(c5644d.f18881a.mo5026c()) || this.f18882b.equals(c5644d.f18882b) == null) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return (((this.f18881a.mo5026c().hashCode() * 31) + this.f18882b.hashCode()) * 31) + this.f18883c;
    }
}
