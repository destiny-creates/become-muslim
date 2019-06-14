package com.google.android.gms.p175c.p176a;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.C2814k;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

/* renamed from: com.google.android.gms.c.a.b */
public final class C4758b extends C4363a implements C2814k {
    public static final Creator<C4758b> CREATOR = new C2765c();
    /* renamed from: a */
    private final int f13141a;
    /* renamed from: b */
    private int f13142b;
    /* renamed from: c */
    private Intent f13143c;

    C4758b(int i, int i2, Intent intent) {
        this.f13141a = i;
        this.f13142b = i2;
        this.f13143c = intent;
    }

    public C4758b() {
        this(0, null);
    }

    private C4758b(int i, Intent intent) {
        this(2, null, null);
    }

    /* renamed from: b */
    public final Status mo2360b() {
        if (this.f13142b == 0) {
            return Status.f13151a;
        }
        return Status.f13155e;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = C2835c.m8179a(parcel);
        C2835c.m8184a(parcel, 1, this.f13141a);
        C2835c.m8184a(parcel, 2, this.f13142b);
        C2835c.m8188a(parcel, 3, this.f13143c, i, false);
        C2835c.m8180a(parcel, a);
    }
}
