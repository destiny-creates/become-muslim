package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C2868t;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

public final class ab extends C4363a {
    public static final Creator<ab> CREATOR = new as();
    /* renamed from: a */
    public final LatLng f29235a;
    /* renamed from: b */
    public final LatLng f29236b;
    /* renamed from: c */
    public final LatLng f29237c;
    /* renamed from: d */
    public final LatLng f29238d;
    /* renamed from: e */
    public final LatLngBounds f29239e;

    public ab(LatLng latLng, LatLng latLng2, LatLng latLng3, LatLng latLng4, LatLngBounds latLngBounds) {
        this.f29235a = latLng;
        this.f29236b = latLng2;
        this.f29237c = latLng3;
        this.f29238d = latLng4;
        this.f29239e = latLngBounds;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ab)) {
            return false;
        }
        ab abVar = (ab) obj;
        return this.f29235a.equals(abVar.f29235a) && this.f29236b.equals(abVar.f29236b) && this.f29237c.equals(abVar.f29237c) && this.f29238d.equals(abVar.f29238d) && this.f29239e.equals(abVar.f29239e);
    }

    public final int hashCode() {
        return C2868t.a(new Object[]{this.f29235a, this.f29236b, this.f29237c, this.f29238d, this.f29239e});
    }

    public final String toString() {
        return C2868t.a(this).a("nearLeft", this.f29235a).a("nearRight", this.f29236b).a("farLeft", this.f29237c).a("farRight", this.f29238d).a("latLngBounds", this.f29239e).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = C2835c.a(parcel);
        C2835c.a(parcel, 2, this.f29235a, i, false);
        C2835c.a(parcel, 3, this.f29236b, i, false);
        C2835c.a(parcel, 4, this.f29237c, i, false);
        C2835c.a(parcel, 5, this.f29238d, i, false);
        C2835c.a(parcel, 6, this.f29239e, i, false);
        C2835c.a(parcel, a);
    }
}
