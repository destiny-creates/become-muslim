package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C2868t;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

/* renamed from: com.google.android.gms.fitness.data.f */
public class C4804f extends C4363a {
    public static final Creator<C4804f> CREATOR = new C2996k();
    /* renamed from: a */
    private final long f13529a;
    /* renamed from: b */
    private final long f13530b;
    /* renamed from: c */
    private final String f13531c;
    /* renamed from: d */
    private final String f13532d;
    /* renamed from: e */
    private final String f13533e;
    /* renamed from: f */
    private final int f13534f;
    /* renamed from: g */
    private final C4807o f13535g;
    /* renamed from: h */
    private final Long f13536h;

    public C4804f(long j, long j2, String str, String str2, String str3, int i, C4807o c4807o, Long l) {
        this.f13529a = j;
        this.f13530b = j2;
        this.f13531c = str;
        this.f13532d = str2;
        this.f13533e = str3;
        this.f13534f = i;
        this.f13535g = c4807o;
        this.f13536h = l;
    }

    /* renamed from: a */
    public String m17027a() {
        return this.f13531c;
    }

    /* renamed from: b */
    public String m17028b() {
        return this.f13532d;
    }

    /* renamed from: c */
    public String m17029c() {
        return this.f13533e;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C4804f)) {
            return false;
        }
        C4804f c4804f = (C4804f) obj;
        return this.f13529a == c4804f.f13529a && this.f13530b == c4804f.f13530b && C2868t.m8374a(this.f13531c, c4804f.f13531c) && C2868t.m8374a(this.f13532d, c4804f.f13532d) && C2868t.m8374a(this.f13533e, c4804f.f13533e) && C2868t.m8374a(this.f13535g, c4804f.f13535g) && this.f13534f == c4804f.f13534f;
    }

    public int hashCode() {
        return C2868t.m8372a(Long.valueOf(this.f13529a), Long.valueOf(this.f13530b), this.f13532d);
    }

    public String toString() {
        return C2868t.m8373a((Object) this).m8371a("startTime", Long.valueOf(this.f13529a)).m8371a("endTime", Long.valueOf(this.f13530b)).m8371a("name", this.f13531c).m8371a("identifier", this.f13532d).m8371a("description", this.f13533e).m8371a("activity", Integer.valueOf(this.f13534f)).m8371a("application", this.f13535g).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = C2835c.m8179a(parcel);
        C2835c.m8185a(parcel, 1, this.f13529a);
        C2835c.m8185a(parcel, 2, this.f13530b);
        C2835c.m8193a(parcel, 3, m17027a(), false);
        C2835c.m8193a(parcel, 4, m17028b(), false);
        C2835c.m8193a(parcel, 5, m17029c(), false);
        C2835c.m8184a(parcel, 7, this.f13534f);
        C2835c.m8188a(parcel, 8, this.f13535g, i, false);
        C2835c.m8192a(parcel, 9, this.f13536h, false);
        C2835c.m8180a(parcel, a);
    }
}
