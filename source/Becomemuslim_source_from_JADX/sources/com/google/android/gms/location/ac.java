package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C2868t;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

public final class ac extends C4363a {
    public static final Creator<ac> CREATOR = new ad();
    /* renamed from: a */
    private final int f29167a;
    /* renamed from: b */
    private final int f29168b;
    /* renamed from: c */
    private final long f29169c;
    /* renamed from: d */
    private final long f29170d;

    ac(int i, int i2, long j, long j2) {
        this.f29167a = i;
        this.f29168b = i2;
        this.f29169c = j;
        this.f29170d = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                ac acVar = (ac) obj;
                return this.f29167a == acVar.f29167a && this.f29168b == acVar.f29168b && this.f29169c == acVar.f29169c && this.f29170d == acVar.f29170d;
            }
        }
    }

    public final int hashCode() {
        return C2868t.a(new Object[]{Integer.valueOf(this.f29168b), Integer.valueOf(this.f29167a), Long.valueOf(this.f29170d), Long.valueOf(this.f29169c)});
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("NetworkLocationStatus:");
        stringBuilder.append(" Wifi status: ");
        stringBuilder.append(this.f29167a);
        stringBuilder.append(" Cell status: ");
        stringBuilder.append(this.f29168b);
        stringBuilder.append(" elapsed time NS: ");
        stringBuilder.append(this.f29170d);
        stringBuilder.append(" system time ms: ");
        stringBuilder.append(this.f29169c);
        return stringBuilder.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = C2835c.a(parcel);
        C2835c.a(parcel, 1, this.f29167a);
        C2835c.a(parcel, 2, this.f29168b);
        C2835c.a(parcel, 3, this.f29169c);
        C2835c.a(parcel, 4, this.f29170d);
        C2835c.a(parcel, i);
    }
}
