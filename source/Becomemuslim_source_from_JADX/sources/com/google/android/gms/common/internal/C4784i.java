package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.C2830f;
import com.google.android.gms.common.C4776d;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.C2862o.C4371a;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

/* renamed from: com.google.android.gms.common.internal.i */
public class C4784i extends C4363a {
    public static final Creator<C4784i> CREATOR = new as();
    /* renamed from: a */
    String f13224a;
    /* renamed from: b */
    IBinder f13225b;
    /* renamed from: c */
    Scope[] f13226c;
    /* renamed from: d */
    Bundle f13227d;
    /* renamed from: e */
    Account f13228e;
    /* renamed from: f */
    C4776d[] f13229f;
    /* renamed from: g */
    C4776d[] f13230g;
    /* renamed from: h */
    private final int f13231h;
    /* renamed from: i */
    private final int f13232i;
    /* renamed from: j */
    private int f13233j;
    /* renamed from: k */
    private boolean f13234k;

    public C4784i(int i) {
        this.f13231h = 4;
        this.f13233j = C2830f.f7233b;
        this.f13232i = i;
        this.f13234k = true;
    }

    C4784i(int i, int i2, int i3, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, C4776d[] c4776dArr, C4776d[] c4776dArr2, boolean z) {
        this.f13231h = i;
        this.f13232i = i2;
        this.f13233j = i3;
        if ("com.google.android.gms".equals(str) != 0) {
            this.f13224a = "com.google.android.gms";
        } else {
            this.f13224a = str;
        }
        if (i < 2) {
            i = 0;
            if (iBinder != null) {
                i = C4777a.m16832a(C4371a.m14389a(iBinder));
            }
            this.f13228e = i;
        } else {
            this.f13225b = iBinder;
            this.f13228e = account;
        }
        this.f13226c = scopeArr;
        this.f13227d = bundle;
        this.f13229f = c4776dArr;
        this.f13230g = c4776dArr2;
        this.f13234k = z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = C2835c.m8179a(parcel);
        C2835c.m8184a(parcel, 1, this.f13231h);
        C2835c.m8184a(parcel, 2, this.f13232i);
        C2835c.m8184a(parcel, 3, this.f13233j);
        C2835c.m8193a(parcel, 4, this.f13224a, false);
        C2835c.m8187a(parcel, 5, this.f13225b, false);
        C2835c.m8200a(parcel, 6, this.f13226c, i, false);
        C2835c.m8186a(parcel, 7, this.f13227d, false);
        C2835c.m8188a(parcel, 8, this.f13228e, i, false);
        C2835c.m8200a(parcel, 10, this.f13229f, i, false);
        C2835c.m8200a(parcel, 11, this.f13230g, i, false);
        C2835c.m8196a(parcel, 12, this.f13234k);
        C2835c.m8180a(parcel, a);
    }
}
