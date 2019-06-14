package com.google.android.gms.location;

import android.content.Intent;
import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class LocationResult extends C4363a implements ReflectedParcelable {
    public static final Creator<LocationResult> CREATOR = new C5088v();
    /* renamed from: a */
    static final List<Location> f29165a = Collections.emptyList();
    /* renamed from: b */
    private final List<Location> f29166b;

    LocationResult(List<Location> list) {
        this.f29166b = list;
    }

    /* renamed from: a */
    public static boolean m38216a(Intent intent) {
        return intent == null ? false : intent.hasExtra("com.google.android.gms.location.EXTRA_LOCATION_RESULT");
    }

    /* renamed from: b */
    public static LocationResult m38217b(Intent intent) {
        return !m38216a(intent) ? null : (LocationResult) intent.getExtras().getParcelable("com.google.android.gms.location.EXTRA_LOCATION_RESULT");
    }

    /* renamed from: a */
    public final List<Location> m38218a() {
        return this.f29166b;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof LocationResult)) {
            return false;
        }
        LocationResult locationResult = (LocationResult) obj;
        if (locationResult.f29166b.size() != this.f29166b.size()) {
            return false;
        }
        Iterator it = this.f29166b.iterator();
        for (Location time : locationResult.f29166b) {
            if (((Location) it.next()).getTime() != time.getTime()) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 17;
        for (Location time : this.f29166b) {
            long time2 = time.getTime();
            i = (i * 31) + ((int) (time2 ^ (time2 >>> 32)));
        }
        return i;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f29166b);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 27);
        stringBuilder.append("LocationResult[locations: ");
        stringBuilder.append(valueOf);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = C2835c.a(parcel);
        C2835c.c(parcel, 1, m38218a(), false);
        C2835c.a(parcel, i);
    }
}
