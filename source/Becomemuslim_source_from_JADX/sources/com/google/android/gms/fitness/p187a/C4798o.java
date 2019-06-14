package com.google.android.gms.fitness.p187a;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C2868t;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.internal.p208g.ax;
import com.google.android.gms.internal.p208g.ay;

/* renamed from: com.google.android.gms.fitness.a.o */
public final class C4798o extends C4363a {
    public static final Creator<C4798o> CREATOR = new C2978p();
    /* renamed from: a */
    private final DataSet f13363a;
    /* renamed from: b */
    private final ax f13364b;
    /* renamed from: c */
    private final boolean f13365c;

    C4798o(DataSet dataSet, IBinder iBinder, boolean z) {
        this.f13363a = dataSet;
        this.f13364b = ay.a(iBinder);
        this.f13365c = z;
    }

    public C4798o(DataSet dataSet, ax axVar, boolean z) {
        this.f13363a = dataSet;
        this.f13364b = axVar;
        this.f13365c = z;
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof C4798o) {
                if (C2868t.m8374a(this.f13363a, ((C4798o) obj).f13363a)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return C2868t.m8372a(this.f13363a);
    }

    public final String toString() {
        return C2868t.m8373a((Object) this).m8371a("dataSet", this.f13363a).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = C2835c.m8179a(parcel);
        C2835c.m8188a(parcel, 1, this.f13363a, i, false);
        C2835c.m8187a(parcel, 2, this.f13364b == null ? null : this.f13364b.asBinder(), false);
        C2835c.m8196a(parcel, 4, this.f13365c);
        C2835c.m8180a(parcel, a);
    }
}
