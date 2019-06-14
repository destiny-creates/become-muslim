package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

public final class Scope extends C4363a implements ReflectedParcelable {
    public static final Creator<Scope> CREATOR = new C2821s();
    /* renamed from: a */
    private final int f13149a;
    /* renamed from: b */
    private final String f13150b;

    Scope(int i, String str) {
        C2872v.m8383a(str, (Object) "scopeUri must not be null or empty");
        this.f13149a = i;
        this.f13150b = str;
    }

    public Scope(String str) {
        this(1, str);
    }

    /* renamed from: a */
    public final String m16700a() {
        return this.f13150b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Scope) {
            return this.f13150b.equals(((Scope) obj).f13150b);
        }
        return null;
    }

    public final int hashCode() {
        return this.f13150b.hashCode();
    }

    public final String toString() {
        return this.f13150b;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = C2835c.m8179a(parcel);
        C2835c.m8184a(parcel, 1, this.f13149a);
        C2835c.m8193a(parcel, 2, m16700a(), false);
        C2835c.m8180a(parcel, i);
    }
}
