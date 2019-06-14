package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C2868t;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

/* renamed from: com.google.android.gms.fitness.data.o */
public final class C4807o extends C4363a {
    public static final Creator<C4807o> CREATOR = new C3000p();
    /* renamed from: a */
    public static final C4807o f13549a = new C4807o("com.google.android.gms", null);
    /* renamed from: b */
    private final String f13550b;
    /* renamed from: c */
    private final String f13551c;

    public C4807o(String str, String str2) {
        this.f13550b = (String) C2872v.m8380a((Object) str);
        this.f13551c = str2;
    }

    /* renamed from: a */
    public final String m17035a() {
        return this.f13550b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C4807o)) {
            return false;
        }
        C4807o c4807o = (C4807o) obj;
        return this.f13550b.equals(c4807o.f13550b) && C2868t.m8374a(this.f13551c, c4807o.f13551c);
    }

    public final int hashCode() {
        return C2868t.m8372a(this.f13550b, this.f13551c);
    }

    public final String toString() {
        return String.format("Application{%s:%s}", new Object[]{this.f13550b, this.f13551c});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = C2835c.m8179a(parcel);
        C2835c.m8193a(parcel, 1, this.f13550b, false);
        C2835c.m8193a(parcel, 3, this.f13551c, false);
        C2835c.m8180a(parcel, i);
    }
}
