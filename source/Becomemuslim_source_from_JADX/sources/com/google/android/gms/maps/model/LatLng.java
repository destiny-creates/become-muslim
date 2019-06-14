package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

public final class LatLng extends C4363a implements ReflectedParcelable {
    public static final Creator<LatLng> CREATOR = new ah();
    /* renamed from: a */
    public final double f29231a;
    /* renamed from: b */
    public final double f29232b;

    public LatLng(double d, double d2) {
        if (-180.0d > d2 || d2 >= 180.0d) {
            d2 = ((((d2 - 180.0d) % 360.0d) + 360.0d) % 360.0d) - 180.0d;
        }
        this.f29232b = d2;
        this.f29231a = Math.max(-90.0d, Math.min(90.0d, d));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLng)) {
            return false;
        }
        LatLng latLng = (LatLng) obj;
        return Double.doubleToLongBits(this.f29231a) == Double.doubleToLongBits(latLng.f29231a) && Double.doubleToLongBits(this.f29232b) == Double.doubleToLongBits(latLng.f29232b);
    }

    public final int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.f29231a);
        int i = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31;
        long doubleToLongBits2 = Double.doubleToLongBits(this.f29232b);
        return (i * 31) + ((int) ((doubleToLongBits2 >>> 32) ^ doubleToLongBits2));
    }

    public final String toString() {
        double d = this.f29231a;
        double d2 = this.f29232b;
        StringBuilder stringBuilder = new StringBuilder(60);
        stringBuilder.append("lat/lng: (");
        stringBuilder.append(d);
        stringBuilder.append(",");
        stringBuilder.append(d2);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = C2835c.a(parcel);
        C2835c.a(parcel, 2, this.f29231a);
        C2835c.a(parcel, 3, this.f29232b);
        C2835c.a(parcel, i);
    }
}
