package com.google.android.gms.internal.p213l;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

/* renamed from: com.google.android.gms.internal.l.aq */
public final class aq extends C4363a {
    public static final Creator<aq> CREATOR = new ar();
    /* renamed from: a */
    public final String f28970a;
    /* renamed from: b */
    public final an f28971b;
    /* renamed from: c */
    public final String f28972c;
    /* renamed from: d */
    public final long f28973d;

    aq(aq aqVar, long j) {
        C2872v.a(aqVar);
        this.f28970a = aqVar.f28970a;
        this.f28971b = aqVar.f28971b;
        this.f28972c = aqVar.f28972c;
        this.f28973d = j;
    }

    public aq(String str, an anVar, String str2, long j) {
        this.f28970a = str;
        this.f28971b = anVar;
        this.f28972c = str2;
        this.f28973d = j;
    }

    public final String toString() {
        String str = this.f28972c;
        String str2 = this.f28970a;
        String valueOf = String.valueOf(this.f28971b);
        StringBuilder stringBuilder = new StringBuilder(((String.valueOf(str).length() + 21) + String.valueOf(str2).length()) + String.valueOf(valueOf).length());
        stringBuilder.append("origin=");
        stringBuilder.append(str);
        stringBuilder.append(",name=");
        stringBuilder.append(str2);
        stringBuilder.append(",params=");
        stringBuilder.append(valueOf);
        return stringBuilder.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = C2835c.a(parcel);
        C2835c.a(parcel, 2, this.f28970a, false);
        C2835c.a(parcel, 3, this.f28971b, i, false);
        C2835c.a(parcel, 4, this.f28972c, false);
        C2835c.a(parcel, 5, this.f28973d);
        C2835c.a(parcel, a);
    }
}
