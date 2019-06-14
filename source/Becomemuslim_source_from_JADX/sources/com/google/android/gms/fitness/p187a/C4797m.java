package com.google.android.gms.fitness.p187a;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C2868t;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;
import com.google.android.gms.fitness.data.C4805g;
import com.google.android.gms.internal.p208g.ax;
import com.google.android.gms.internal.p208g.ay;

/* renamed from: com.google.android.gms.fitness.a.m */
public final class C4797m extends C4363a {
    public static final Creator<C4797m> CREATOR = new C2977n();
    /* renamed from: a */
    private C4805g f13360a;
    /* renamed from: b */
    private final boolean f13361b;
    /* renamed from: c */
    private final ax f13362c;

    C4797m(C4805g c4805g, boolean z, IBinder iBinder) {
        this.f13360a = c4805g;
        this.f13361b = z;
        this.f13362c = ay.a(iBinder);
    }

    public C4797m(C4805g c4805g, boolean z, ax axVar) {
        this.f13360a = c4805g;
        this.f13361b = false;
        this.f13362c = axVar;
    }

    public final String toString() {
        return C2868t.m8373a((Object) this).m8371a("subscription", this.f13360a).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = C2835c.m8179a(parcel);
        C2835c.m8188a(parcel, 1, this.f13360a, i, false);
        C2835c.m8196a(parcel, 2, this.f13361b);
        C2835c.m8187a(parcel, 3, this.f13362c == null ? null : this.f13362c.asBinder(), false);
        C2835c.m8180a(parcel, a);
    }
}
