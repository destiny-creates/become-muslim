package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C2868t;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;
import java.util.List;

@cm
public final class aoq extends C4363a {
    public static final Creator<aoq> CREATOR = new aos();
    /* renamed from: a */
    public final int f28261a;
    /* renamed from: b */
    public final long f28262b;
    /* renamed from: c */
    public final Bundle f28263c;
    /* renamed from: d */
    public final int f28264d;
    /* renamed from: e */
    public final List<String> f28265e;
    /* renamed from: f */
    public final boolean f28266f;
    /* renamed from: g */
    public final int f28267g;
    /* renamed from: h */
    public final boolean f28268h;
    /* renamed from: i */
    public final String f28269i;
    /* renamed from: j */
    public final aru f28270j;
    /* renamed from: k */
    public final Location f28271k;
    /* renamed from: l */
    public final String f28272l;
    /* renamed from: m */
    public final Bundle f28273m;
    /* renamed from: n */
    public final Bundle f28274n;
    /* renamed from: o */
    public final List<String> f28275o;
    /* renamed from: p */
    public final String f28276p;
    /* renamed from: q */
    public final String f28277q;
    /* renamed from: r */
    public final boolean f28278r;

    public aoq(int i, long j, Bundle bundle, int i2, List<String> list, boolean z, int i3, boolean z2, String str, aru aru, Location location, String str2, Bundle bundle2, Bundle bundle3, List<String> list2, String str3, String str4, boolean z3) {
        this.f28261a = i;
        this.f28262b = j;
        r0.f28263c = bundle == null ? new Bundle() : bundle;
        r0.f28264d = i2;
        r0.f28265e = list;
        r0.f28266f = z;
        r0.f28267g = i3;
        r0.f28268h = z2;
        r0.f28269i = str;
        r0.f28270j = aru;
        r0.f28271k = location;
        r0.f28272l = str2;
        r0.f28273m = bundle2 == null ? new Bundle() : bundle2;
        r0.f28274n = bundle3;
        r0.f28275o = list2;
        r0.f28276p = str3;
        r0.f28277q = str4;
        r0.f28278r = z3;
    }

    /* renamed from: a */
    public final aoq m36922a() {
        Bundle bundle = this.f28273m.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
        if (bundle == null) {
            bundle = r0.f28263c;
            r0.f28273m.putBundle("com.google.ads.mediation.admob.AdMobAdapter", r0.f28263c);
        }
        return new aoq(r0.f28261a, r0.f28262b, bundle, r0.f28264d, r0.f28265e, r0.f28266f, r0.f28267g, r0.f28268h, r0.f28269i, r0.f28270j, r0.f28271k, r0.f28272l, r0.f28273m, r0.f28274n, r0.f28275o, r0.f28276p, r0.f28277q, r0.f28278r);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof aoq)) {
            return false;
        }
        aoq aoq = (aoq) obj;
        return this.f28261a == aoq.f28261a && this.f28262b == aoq.f28262b && C2868t.a(this.f28263c, aoq.f28263c) && this.f28264d == aoq.f28264d && C2868t.a(this.f28265e, aoq.f28265e) && this.f28266f == aoq.f28266f && this.f28267g == aoq.f28267g && this.f28268h == aoq.f28268h && C2868t.a(this.f28269i, aoq.f28269i) && C2868t.a(this.f28270j, aoq.f28270j) && C2868t.a(this.f28271k, aoq.f28271k) && C2868t.a(this.f28272l, aoq.f28272l) && C2868t.a(this.f28273m, aoq.f28273m) && C2868t.a(this.f28274n, aoq.f28274n) && C2868t.a(this.f28275o, aoq.f28275o) && C2868t.a(this.f28276p, aoq.f28276p) && C2868t.a(this.f28277q, aoq.f28277q) && this.f28278r == aoq.f28278r;
    }

    public final int hashCode() {
        return C2868t.a(new Object[]{Integer.valueOf(this.f28261a), Long.valueOf(this.f28262b), this.f28263c, Integer.valueOf(this.f28264d), this.f28265e, Boolean.valueOf(this.f28266f), Integer.valueOf(this.f28267g), Boolean.valueOf(this.f28268h), this.f28269i, this.f28270j, this.f28271k, this.f28272l, this.f28273m, this.f28274n, this.f28275o, this.f28276p, this.f28277q, Boolean.valueOf(this.f28278r)});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = C2835c.a(parcel);
        C2835c.a(parcel, 1, this.f28261a);
        C2835c.a(parcel, 2, this.f28262b);
        C2835c.a(parcel, 3, this.f28263c, false);
        C2835c.a(parcel, 4, this.f28264d);
        C2835c.b(parcel, 5, this.f28265e, false);
        C2835c.a(parcel, 6, this.f28266f);
        C2835c.a(parcel, 7, this.f28267g);
        C2835c.a(parcel, 8, this.f28268h);
        C2835c.a(parcel, 9, this.f28269i, false);
        C2835c.a(parcel, 10, this.f28270j, i, false);
        C2835c.a(parcel, 11, this.f28271k, i, false);
        C2835c.a(parcel, 12, this.f28272l, false);
        C2835c.a(parcel, 13, this.f28273m, false);
        C2835c.a(parcel, 14, this.f28274n, false);
        C2835c.b(parcel, 15, this.f28275o, false);
        C2835c.a(parcel, 16, this.f28276p, false);
        C2835c.a(parcel, 17, this.f28277q, false);
        C2835c.a(parcel, 18, this.f28278r);
        C2835c.a(parcel, a);
    }
}
