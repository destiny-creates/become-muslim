package com.google.android.exoplayer2.p149h.p151b.p152a;

import android.net.Uri;
import com.google.android.exoplayer2.p164l.C2539u;

/* compiled from: RangedUri */
/* renamed from: com.google.android.exoplayer2.h.b.a.f */
public final class C2380f {
    /* renamed from: a */
    public final long f5859a;
    /* renamed from: b */
    public final long f5860b;
    /* renamed from: c */
    private final String f5861c;
    /* renamed from: d */
    private int f5862d;

    public C2380f(String str, long j, long j2) {
        if (str == null) {
            str = "";
        }
        this.f5861c = str;
        this.f5859a = j;
        this.f5860b = j2;
    }

    /* renamed from: a */
    public Uri m6573a(String str) {
        return C2539u.m7158a(str, this.f5861c);
    }

    /* renamed from: b */
    public String m6575b(String str) {
        return C2539u.m7161b(str, this.f5861c);
    }

    /* renamed from: a */
    public C2380f m6574a(C2380f c2380f, String str) {
        String b = m6575b(str);
        if (c2380f != null) {
            if (b.equals(c2380f.m6575b(str)) != null) {
                long j = -1;
                long j2;
                if (this.f5860b != -1 && this.f5859a + this.f5860b == c2380f.f5859a) {
                    j2 = this.f5859a;
                    if (c2380f.f5860b != -1) {
                        j = this.f5860b + c2380f.f5860b;
                    }
                    return new C2380f(b, j2, j);
                } else if (c2380f.f5860b == -1 || c2380f.f5859a + c2380f.f5860b != this.f5859a) {
                    return null;
                } else {
                    j2 = c2380f.f5859a;
                    if (this.f5860b != -1) {
                        j = c2380f.f5860b + this.f5860b;
                    }
                    return new C2380f(b, j2, j);
                }
            }
        }
        return null;
    }

    public int hashCode() {
        if (this.f5862d == 0) {
            this.f5862d = ((((527 + ((int) this.f5859a)) * 31) + ((int) this.f5860b)) * 31) + this.f5861c.hashCode();
        }
        return this.f5862d;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                C2380f c2380f = (C2380f) obj;
                if (this.f5859a != c2380f.f5859a || this.f5860b != c2380f.f5860b || this.f5861c.equals(c2380f.f5861c) == null) {
                    z = false;
                }
                return z;
            }
        }
        return false;
    }
}
