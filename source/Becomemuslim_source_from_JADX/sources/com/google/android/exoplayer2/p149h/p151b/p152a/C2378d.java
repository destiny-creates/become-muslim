package com.google.android.exoplayer2.p149h.p151b.p152a;

import com.google.android.exoplayer2.p164l.C2541v;

/* compiled from: Descriptor */
/* renamed from: com.google.android.exoplayer2.h.b.a.d */
public final class C2378d {
    /* renamed from: a */
    public final String f5853a;
    /* renamed from: b */
    public final String f5854b;
    /* renamed from: c */
    public final String f5855c;

    public C2378d(String str, String str2, String str3) {
        this.f5853a = str;
        this.f5854b = str2;
        this.f5855c = str3;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                C2378d c2378d = (C2378d) obj;
                if (!C2541v.m7179a(this.f5853a, c2378d.f5853a) || !C2541v.m7179a(this.f5854b, c2378d.f5854b) || C2541v.m7179a(this.f5855c, c2378d.f5855c) == null) {
                    z = false;
                }
                return z;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (((this.f5853a != null ? this.f5853a.hashCode() : 0) * 31) + (this.f5854b != null ? this.f5854b.hashCode() : 0)) * 31;
        if (this.f5855c != null) {
            i = this.f5855c.hashCode();
        }
        return hashCode + i;
    }
}
