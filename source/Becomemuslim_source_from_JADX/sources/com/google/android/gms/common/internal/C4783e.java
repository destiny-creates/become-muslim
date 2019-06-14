package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

/* renamed from: com.google.android.gms.common.internal.e */
public class C4783e extends C4363a {
    public static final Creator<C4783e> CREATOR = new ad();
    /* renamed from: a */
    private final int f13222a;
    /* renamed from: b */
    private final String f13223b;

    public C4783e(int i, String str) {
        this.f13222a = i;
        this.f13223b = str;
    }

    public int hashCode() {
        return this.f13222a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null) {
            if (obj instanceof C4783e) {
                C4783e c4783e = (C4783e) obj;
                return c4783e.f13222a == this.f13222a && C2868t.m8374a(c4783e.f13223b, this.f13223b) != null;
            }
        }
        return false;
    }

    public String toString() {
        int i = this.f13222a;
        String str = this.f13223b;
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 12);
        stringBuilder.append(i);
        stringBuilder.append(":");
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        i = C2835c.m8179a(parcel);
        C2835c.m8184a(parcel, 1, this.f13222a);
        C2835c.m8193a(parcel, 2, this.f13223b, false);
        C2835c.m8180a(parcel, i);
    }
}
