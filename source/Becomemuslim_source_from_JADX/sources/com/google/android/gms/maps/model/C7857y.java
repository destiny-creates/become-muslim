package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;
import com.google.android.gms.internal.p212k.C5024g;
import com.google.android.gms.internal.p212k.C6812h;

/* renamed from: com.google.android.gms.maps.model.y */
public final class C7857y extends C4363a {
    public static final Creator<C7857y> CREATOR = new ar();
    /* renamed from: a */
    private C5024g f29313a;
    /* renamed from: b */
    private C5148z f29314b;
    /* renamed from: c */
    private boolean f29315c = true;
    /* renamed from: d */
    private float f29316d;
    /* renamed from: e */
    private boolean f29317e = true;
    /* renamed from: f */
    private float f29318f = 0.0f;

    C7857y(IBinder iBinder, boolean z, float f, boolean z2, float f2) {
        this.f29313a = C6812h.m31894a(iBinder);
        this.f29314b = this.f29313a == null ? null : new ap(this);
        this.f29315c = z;
        this.f29316d = f;
        this.f29317e = z2;
        this.f29318f = f2;
    }

    /* renamed from: a */
    public final float m38379a() {
        return this.f29316d;
    }

    /* renamed from: a */
    public final C7857y m38380a(float f) {
        this.f29316d = f;
        return this;
    }

    /* renamed from: a */
    public final C7857y m38381a(C5148z c5148z) {
        this.f29314b = c5148z;
        this.f29313a = this.f29314b == null ? null : new aq(this, c5148z);
        return this;
    }

    /* renamed from: b */
    public final boolean m38382b() {
        return this.f29315c;
    }

    /* renamed from: c */
    public final boolean m38383c() {
        return this.f29317e;
    }

    /* renamed from: d */
    public final float m38384d() {
        return this.f29318f;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = C2835c.a(parcel);
        C2835c.a(parcel, 2, this.f29313a.asBinder(), false);
        C2835c.a(parcel, 3, m38382b());
        C2835c.a(parcel, 4, m38379a());
        C2835c.a(parcel, 5, m38383c());
        C2835c.a(parcel, 6, m38384d());
        C2835c.a(parcel, i);
    }
}
