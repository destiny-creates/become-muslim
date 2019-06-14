package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

public class MapValue extends C4363a implements ReflectedParcelable {
    public static final Creator<MapValue> CREATOR = new ab();
    /* renamed from: a */
    private final int f13444a;
    /* renamed from: b */
    private final float f13445b;

    public MapValue(int i, float f) {
        this.f13444a = i;
        this.f13445b = f;
    }

    /* renamed from: a */
    public final float m16994a() {
        C2872v.m8387a(this.f13444a == 2, (Object) "Value is not in float format");
        return this.f13445b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapValue)) {
            return false;
        }
        MapValue mapValue = (MapValue) obj;
        if (this.f13444a == mapValue.f13444a) {
            if (this.f13444a != 2) {
                return this.f13445b == mapValue.f13445b;
            } else {
                if (m16994a() == mapValue.m16994a()) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        return (int) this.f13445b;
    }

    public String toString() {
        return this.f13444a != 2 ? "unknown" : Float.toString(m16994a());
    }

    public void writeToParcel(Parcel parcel, int i) {
        i = C2835c.m8179a(parcel);
        C2835c.m8184a(parcel, 1, this.f13444a);
        C2835c.m8183a(parcel, 2, this.f13445b);
        C2835c.m8180a(parcel, i);
    }
}
