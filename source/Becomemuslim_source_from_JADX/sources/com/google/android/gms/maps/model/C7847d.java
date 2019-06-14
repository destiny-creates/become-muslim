package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C2868t;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;
import com.google.android.gms.p174b.C2758b.C4325a;

/* renamed from: com.google.android.gms.maps.model.d */
public class C7847d extends C4363a {
    public static final Creator<C7847d> CREATOR = new ad();
    /* renamed from: a */
    private static final String f29241a = "d";
    /* renamed from: b */
    private final int f29242b;
    /* renamed from: c */
    private final C5136a f29243c;
    /* renamed from: d */
    private final Float f29244d;

    protected C7847d(int i) {
        this(i, null, null);
    }

    C7847d(int i, IBinder iBinder, Float f) {
        this(i, iBinder == null ? null : new C5136a(C4325a.a(iBinder)), f);
    }

    private C7847d(int i, C5136a c5136a, Float f) {
        boolean z;
        Object obj = (f == null || f.floatValue() <= 0.0f) ? null : 1;
        if (i == 3) {
            if (c5136a == null || obj == null) {
                z = false;
                C2872v.b(z, String.format("Invalid Cap: type=%s bitmapDescriptor=%s bitmapRefWidth=%s", new Object[]{Integer.valueOf(i), c5136a, f}));
                this.f29242b = i;
                this.f29243c = c5136a;
                this.f29244d = f;
            }
        }
        z = true;
        C2872v.b(z, String.format("Invalid Cap: type=%s bitmapDescriptor=%s bitmapRefWidth=%s", new Object[]{Integer.valueOf(i), c5136a, f}));
        this.f29242b = i;
        this.f29243c = c5136a;
        this.f29244d = f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C7847d)) {
            return false;
        }
        C7847d c7847d = (C7847d) obj;
        return this.f29242b == c7847d.f29242b && C2868t.a(this.f29243c, c7847d.f29243c) && C2868t.a(this.f29244d, c7847d.f29244d);
    }

    public int hashCode() {
        return C2868t.a(new Object[]{Integer.valueOf(this.f29242b), this.f29243c, this.f29244d});
    }

    public String toString() {
        int i = this.f29242b;
        StringBuilder stringBuilder = new StringBuilder(23);
        stringBuilder.append("[Cap: type=");
        stringBuilder.append(i);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        i = C2835c.a(parcel);
        C2835c.a(parcel, 2, this.f29242b);
        C2835c.a(parcel, 3, this.f29243c == null ? null : this.f29243c.m21760a().asBinder(), false);
        C2835c.a(parcel, 4, this.f29244d, false);
        C2835c.a(parcel, i);
    }
}
