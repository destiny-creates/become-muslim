package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C2868t;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

public final class LatLngBounds extends C4363a implements ReflectedParcelable {
    public static final Creator<LatLngBounds> CREATOR = new ag();
    /* renamed from: a */
    public final LatLng f29233a;
    /* renamed from: b */
    public final LatLng f29234b;

    /* renamed from: com.google.android.gms.maps.model.LatLngBounds$a */
    public static final class C5135a {
        /* renamed from: a */
        private double f17405a = Double.POSITIVE_INFINITY;
        /* renamed from: b */
        private double f17406b = Double.NEGATIVE_INFINITY;
        /* renamed from: c */
        private double f17407c = Double.NaN;
        /* renamed from: d */
        private double f17408d = Double.NaN;

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        public final com.google.android.gms.maps.model.LatLngBounds.C5135a m21758a(com.google.android.gms.maps.model.LatLng r8) {
            /*
            r7 = this;
            r0 = r7.f17405a;
            r2 = r8.f29231a;
            r0 = java.lang.Math.min(r0, r2);
            r7.f17405a = r0;
            r0 = r7.f17406b;
            r2 = r8.f29231a;
            r0 = java.lang.Math.max(r0, r2);
            r7.f17406b = r0;
            r0 = r8.f29232b;
            r2 = r7.f17407c;
            r8 = java.lang.Double.isNaN(r2);
            if (r8 == 0) goto L_0x0021;
        L_0x001e:
            r7.f17407c = r0;
            goto L_0x005b;
        L_0x0021:
            r2 = r7.f17407c;
            r4 = r7.f17408d;
            r8 = 1;
            r6 = 0;
            r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
            if (r2 > 0) goto L_0x003a;
        L_0x002b:
            r2 = r7.f17407c;
            r2 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1));
            if (r2 > 0) goto L_0x0038;
        L_0x0031:
            r2 = r7.f17408d;
            r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
            if (r2 > 0) goto L_0x0038;
        L_0x0037:
            goto L_0x0046;
        L_0x0038:
            r8 = 0;
            goto L_0x0046;
        L_0x003a:
            r2 = r7.f17407c;
            r2 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1));
            if (r2 <= 0) goto L_0x0046;
        L_0x0040:
            r2 = r7.f17408d;
            r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
            if (r2 > 0) goto L_0x0038;
        L_0x0046:
            if (r8 != 0) goto L_0x005d;
        L_0x0048:
            r2 = r7.f17407c;
            r2 = com.google.android.gms.maps.model.LatLngBounds.m38279c(r2, r0);
            r4 = r7.f17408d;
            r4 = com.google.android.gms.maps.model.LatLngBounds.m38280d(r4, r0);
            r8 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
            if (r8 >= 0) goto L_0x005b;
        L_0x0058:
            r7.f17407c = r0;
            goto L_0x005d;
        L_0x005b:
            r7.f17408d = r0;
        L_0x005d:
            return r7;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.maps.model.LatLngBounds.a.a(com.google.android.gms.maps.model.LatLng):com.google.android.gms.maps.model.LatLngBounds$a");
        }

        /* renamed from: a */
        public final LatLngBounds m21759a() {
            C2872v.a(Double.isNaN(this.f17407c) ^ 1, "no included points");
            return new LatLngBounds(new LatLng(this.f17405a, this.f17407c), new LatLng(this.f17406b, this.f17408d));
        }
    }

    public LatLngBounds(LatLng latLng, LatLng latLng2) {
        C2872v.a(latLng, "null southwest");
        C2872v.a(latLng2, "null northeast");
        C2872v.b(latLng2.f29231a >= latLng.f29231a, "southern latitude exceeds northern latitude (%s > %s)", new Object[]{Double.valueOf(latLng.f29231a), Double.valueOf(latLng2.f29231a)});
        this.f29233a = latLng;
        this.f29234b = latLng2;
    }

    /* renamed from: c */
    private static double m38279c(double d, double d2) {
        return ((d - d2) + 360.0d) % 360.0d;
    }

    /* renamed from: d */
    private static double m38280d(double d, double d2) {
        return ((d2 - d) + 360.0d) % 360.0d;
    }

    /* renamed from: a */
    public final LatLng m38281a() {
        double d = (this.f29233a.f29231a + this.f29234b.f29231a) / 2.0d;
        double d2 = this.f29234b.f29232b;
        double d3 = this.f29233a.f29232b;
        if (d3 > d2) {
            d2 += 360.0d;
        }
        return new LatLng(d, (d2 + d3) / 2.0d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLngBounds)) {
            return false;
        }
        LatLngBounds latLngBounds = (LatLngBounds) obj;
        return this.f29233a.equals(latLngBounds.f29233a) && this.f29234b.equals(latLngBounds.f29234b);
    }

    public final int hashCode() {
        return C2868t.a(new Object[]{this.f29233a, this.f29234b});
    }

    public final String toString() {
        return C2868t.a(this).a("southwest", this.f29233a).a("northeast", this.f29234b).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = C2835c.a(parcel);
        C2835c.a(parcel, 2, this.f29233a, i, false);
        C2835c.a(parcel, 3, this.f29234b, i, false);
        C2835c.a(parcel, a);
    }
}
