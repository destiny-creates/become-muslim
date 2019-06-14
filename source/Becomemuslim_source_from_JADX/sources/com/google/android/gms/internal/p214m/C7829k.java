package com.google.android.gms.internal.p214m;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;
import com.google.android.gms.p190g.C3052b;

/* renamed from: com.google.android.gms.internal.m.k */
public final class C7829k extends C4363a {
    public static final Creator<C7829k> CREATOR = new C5060l();
    /* renamed from: a */
    public int f29136a;
    /* renamed from: b */
    public int f29137b;
    /* renamed from: c */
    public int f29138c;
    /* renamed from: d */
    private int f29139d;
    /* renamed from: e */
    private long f29140e;

    public C7829k(int i, int i2, int i3, long j, int i4) {
        this.f29136a = i;
        this.f29137b = i2;
        this.f29139d = i3;
        this.f29140e = j;
        this.f29138c = i4;
    }

    /* renamed from: a */
    public static C7829k m38186a(C3052b c3052b) {
        C7829k c7829k = new C7829k();
        c7829k.f29136a = c3052b.a().a();
        c7829k.f29137b = c3052b.a().b();
        c7829k.f29138c = c3052b.a().e();
        c7829k.f29139d = c3052b.a().c();
        c7829k.f29140e = c3052b.a().d();
        return c7829k;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = C2835c.a(parcel);
        C2835c.a(parcel, 2, this.f29136a);
        C2835c.a(parcel, 3, this.f29137b);
        C2835c.a(parcel, 4, this.f29139d);
        C2835c.a(parcel, 5, this.f29140e);
        C2835c.a(parcel, 6, this.f29138c);
        C2835c.a(parcel, i);
    }
}
