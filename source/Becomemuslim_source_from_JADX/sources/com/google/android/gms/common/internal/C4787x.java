package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.C4775b;
import com.google.android.gms.common.internal.C2862o.C4371a;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

/* renamed from: com.google.android.gms.common.internal.x */
public class C4787x extends C4363a {
    public static final Creator<C4787x> CREATOR = new ao();
    /* renamed from: a */
    private final int f13242a;
    /* renamed from: b */
    private IBinder f13243b;
    /* renamed from: c */
    private C4775b f13244c;
    /* renamed from: d */
    private boolean f13245d;
    /* renamed from: e */
    private boolean f13246e;

    C4787x(int i, IBinder iBinder, C4775b c4775b, boolean z, boolean z2) {
        this.f13242a = i;
        this.f13243b = iBinder;
        this.f13244c = c4775b;
        this.f13245d = z;
        this.f13246e = z2;
    }

    /* renamed from: a */
    public C2862o m16854a() {
        return C4371a.m14389a(this.f13243b);
    }

    /* renamed from: b */
    public C4775b m16855b() {
        return this.f13244c;
    }

    /* renamed from: c */
    public boolean m16856c() {
        return this.f13245d;
    }

    /* renamed from: d */
    public boolean m16857d() {
        return this.f13246e;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = C2835c.m8179a(parcel);
        C2835c.m8184a(parcel, 1, this.f13242a);
        C2835c.m8187a(parcel, 2, this.f13243b, false);
        C2835c.m8188a(parcel, 3, m16855b(), i, false);
        C2835c.m8196a(parcel, 4, m16856c());
        C2835c.m8196a(parcel, 5, m16857d());
        C2835c.m8180a(parcel, a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C4787x)) {
            return false;
        }
        C4787x c4787x = (C4787x) obj;
        return this.f13244c.equals(c4787x.f13244c) && m16854a().equals(c4787x.m16854a()) != null;
    }
}
