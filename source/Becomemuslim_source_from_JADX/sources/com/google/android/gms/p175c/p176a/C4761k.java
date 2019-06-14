package com.google.android.gms.p175c.p176a;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.C4775b;
import com.google.android.gms.common.internal.C4787x;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

/* renamed from: com.google.android.gms.c.a.k */
public final class C4761k extends C4363a {
    public static final Creator<C4761k> CREATOR = new C2769l();
    /* renamed from: a */
    private final int f13146a;
    /* renamed from: b */
    private final C4775b f13147b;
    /* renamed from: c */
    private final C4787x f13148c;

    C4761k(int i, C4775b c4775b, C4787x c4787x) {
        this.f13146a = i;
        this.f13147b = c4775b;
        this.f13148c = c4787x;
    }

    public C4761k(int i) {
        this(new C4775b(8, null), null);
    }

    private C4761k(C4775b c4775b, C4787x c4787x) {
        this(1, c4775b, null);
    }

    /* renamed from: a */
    public final C4775b m16692a() {
        return this.f13147b;
    }

    /* renamed from: b */
    public final C4787x m16693b() {
        return this.f13148c;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = C2835c.m8179a(parcel);
        C2835c.m8184a(parcel, 1, this.f13146a);
        C2835c.m8188a(parcel, 2, this.f13147b, i, false);
        C2835c.m8188a(parcel, 3, this.f13148c, i, false);
        C2835c.m8180a(parcel, a);
    }
}
