package com.google.p127a;

import com.google.p127a.p129b.C2141g;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: JsonObject */
/* renamed from: com.google.a.o */
public final class C4052o extends C2162l {
    /* renamed from: a */
    private final C2141g<String, C2162l> f10124a = new C2141g();

    /* renamed from: a */
    public void m12473a(String str, C2162l c2162l) {
        if (c2162l == null) {
            c2162l = C4051n.f10123a;
        }
        this.f10124a.put(str, c2162l);
    }

    /* renamed from: o */
    public Set<Entry<String, C2162l>> m12474o() {
        return this.f10124a.entrySet();
    }

    /* renamed from: a */
    public C2162l m12472a(String str) {
        return (C2162l) this.f10124a.get(str);
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof C4052o) || ((C4052o) obj).f10124a.equals(this.f10124a) == null) {
                return null;
            }
        }
        return true;
    }

    public int hashCode() {
        return this.f10124a.hashCode();
    }
}
