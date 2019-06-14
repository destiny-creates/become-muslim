package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C2868t;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;
import java.util.Arrays;

public final class LocationAvailability extends C4363a implements ReflectedParcelable {
    public static final Creator<LocationAvailability> CREATOR = new C5086t();
    @Deprecated
    /* renamed from: a */
    private int f29152a;
    @Deprecated
    /* renamed from: b */
    private int f29153b;
    /* renamed from: c */
    private long f29154c;
    /* renamed from: d */
    private int f29155d;
    /* renamed from: e */
    private ac[] f29156e;

    LocationAvailability(int i, int i2, int i3, long j, ac[] acVarArr) {
        this.f29155d = i;
        this.f29152a = i2;
        this.f29153b = i3;
        this.f29154c = j;
        this.f29156e = acVarArr;
    }

    /* renamed from: a */
    public final boolean m38206a() {
        return this.f29155d < 1000;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                LocationAvailability locationAvailability = (LocationAvailability) obj;
                return this.f29152a == locationAvailability.f29152a && this.f29153b == locationAvailability.f29153b && this.f29154c == locationAvailability.f29154c && this.f29155d == locationAvailability.f29155d && Arrays.equals(this.f29156e, locationAvailability.f29156e);
            }
        }
    }

    public final int hashCode() {
        return C2868t.a(new Object[]{Integer.valueOf(this.f29155d), Integer.valueOf(this.f29152a), Integer.valueOf(this.f29153b), Long.valueOf(this.f29154c), this.f29156e});
    }

    public final String toString() {
        boolean a = m38206a();
        StringBuilder stringBuilder = new StringBuilder(48);
        stringBuilder.append("LocationAvailability[isLocationAvailable: ");
        stringBuilder.append(a);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = C2835c.a(parcel);
        C2835c.a(parcel, 1, this.f29152a);
        C2835c.a(parcel, 2, this.f29153b);
        C2835c.a(parcel, 3, this.f29154c);
        C2835c.a(parcel, 4, this.f29155d);
        C2835c.a(parcel, 5, this.f29156e, i, false);
        C2835c.a(parcel, a);
    }
}
