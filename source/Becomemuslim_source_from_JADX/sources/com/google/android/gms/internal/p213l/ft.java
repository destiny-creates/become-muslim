package com.google.android.gms.internal.p213l;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

/* renamed from: com.google.android.gms.internal.l.ft */
public final class ft extends C4363a {
    public static final Creator<ft> CREATOR = new fu();
    /* renamed from: a */
    public final String f28979a;
    /* renamed from: b */
    public final long f28980b;
    /* renamed from: c */
    public final String f28981c;
    /* renamed from: d */
    private final int f28982d;
    /* renamed from: e */
    private final Long f28983e;
    /* renamed from: f */
    private final Float f28984f;
    /* renamed from: g */
    private final String f28985g;
    /* renamed from: h */
    private final Double f28986h;

    ft(int i, String str, long j, Long l, Float f, String str2, String str3, Double d) {
        this.f28982d = i;
        this.f28979a = str;
        this.f28980b = j;
        this.f28983e = l;
        Double d2 = null;
        this.f28984f = null;
        if (i == 1) {
            if (f != null) {
                d2 = Double.valueOf(f.doubleValue());
            }
            this.f28986h = d2;
        } else {
            this.f28986h = d;
        }
        this.f28985g = str2;
        this.f28981c = str3;
    }

    ft(fv fvVar) {
        this(fvVar.f17239c, fvVar.f17240d, fvVar.f17241e, fvVar.f17238b);
    }

    ft(String str, long j, Object obj, String str2) {
        C2872v.a(str);
        this.f28982d = 2;
        this.f28979a = str;
        this.f28980b = j;
        this.f28981c = str2;
        if (obj == null) {
            this.f28983e = null;
            this.f28984f = null;
            this.f28986h = null;
            this.f28985g = null;
        } else if (obj instanceof Long) {
            this.f28983e = (Long) obj;
            this.f28984f = null;
            this.f28986h = null;
            this.f28985g = null;
        } else if (obj instanceof String) {
            this.f28983e = null;
            this.f28984f = null;
            this.f28986h = null;
            this.f28985g = (String) obj;
        } else if (obj instanceof Double) {
            this.f28983e = null;
            this.f28984f = null;
            this.f28986h = (Double) obj;
            this.f28985g = null;
        } else {
            throw new IllegalArgumentException("User attribute given of un-supported type");
        }
    }

    /* renamed from: a */
    public final Object m38105a() {
        return this.f28983e != null ? this.f28983e : this.f28986h != null ? this.f28986h : this.f28985g != null ? this.f28985g : null;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = C2835c.a(parcel);
        C2835c.a(parcel, 1, this.f28982d);
        C2835c.a(parcel, 2, this.f28979a, false);
        C2835c.a(parcel, 3, this.f28980b);
        C2835c.a(parcel, 4, this.f28983e, false);
        C2835c.a(parcel, 5, null, false);
        C2835c.a(parcel, 6, this.f28985g, false);
        C2835c.a(parcel, 7, this.f28981c, false);
        C2835c.a(parcel, 8, this.f28986h, false);
        C2835c.a(parcel, i);
    }
}
