package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;
import com.google.android.gms.p174b.C2758b.C4325a;

/* renamed from: com.google.android.gms.maps.model.h */
public final class C7849h extends C4363a {
    public static final Creator<C7849h> CREATOR = new af();
    /* renamed from: a */
    private C5136a f29254a;
    /* renamed from: b */
    private LatLng f29255b;
    /* renamed from: c */
    private float f29256c;
    /* renamed from: d */
    private float f29257d;
    /* renamed from: e */
    private LatLngBounds f29258e;
    /* renamed from: f */
    private float f29259f;
    /* renamed from: g */
    private float f29260g;
    /* renamed from: h */
    private boolean f29261h = true;
    /* renamed from: i */
    private float f29262i = 0.0f;
    /* renamed from: j */
    private float f29263j = 0.5f;
    /* renamed from: k */
    private float f29264k = 0.5f;
    /* renamed from: l */
    private boolean f29265l = false;

    C7849h(IBinder iBinder, LatLng latLng, float f, float f2, LatLngBounds latLngBounds, float f3, float f4, boolean z, float f5, float f6, float f7, boolean z2) {
        this.f29254a = new C5136a(C4325a.a(iBinder));
        this.f29255b = latLng;
        this.f29256c = f;
        this.f29257d = f2;
        this.f29258e = latLngBounds;
        this.f29259f = f3;
        this.f29260g = f4;
        this.f29261h = z;
        this.f29262i = f5;
        this.f29263j = f6;
        this.f29264k = f7;
        this.f29265l = z2;
    }

    /* renamed from: a */
    public final LatLng m38298a() {
        return this.f29255b;
    }

    /* renamed from: a */
    public final C7849h m38299a(float f) {
        this.f29259f = ((f % 360.0f) + 360.0f) % 360.0f;
        return this;
    }

    /* renamed from: a */
    public final C7849h m38300a(LatLngBounds latLngBounds) {
        boolean z = this.f29255b == null;
        String valueOf = String.valueOf(this.f29255b);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 46);
        stringBuilder.append("Position has already been set using position: ");
        stringBuilder.append(valueOf);
        C2872v.a(z, stringBuilder.toString());
        this.f29258e = latLngBounds;
        return this;
    }

    /* renamed from: a */
    public final C7849h m38301a(C5136a c5136a) {
        C2872v.a(c5136a, "imageDescriptor must not be null");
        this.f29254a = c5136a;
        return this;
    }

    /* renamed from: a */
    public final C7849h m38302a(boolean z) {
        this.f29261h = z;
        return this;
    }

    /* renamed from: b */
    public final float m38303b() {
        return this.f29256c;
    }

    /* renamed from: b */
    public final C7849h m38304b(float f) {
        this.f29260g = f;
        return this;
    }

    /* renamed from: c */
    public final float m38305c() {
        return this.f29257d;
    }

    /* renamed from: d */
    public final LatLngBounds m38306d() {
        return this.f29258e;
    }

    /* renamed from: e */
    public final float m38307e() {
        return this.f29259f;
    }

    /* renamed from: f */
    public final float m38308f() {
        return this.f29260g;
    }

    /* renamed from: g */
    public final float m38309g() {
        return this.f29262i;
    }

    /* renamed from: h */
    public final float m38310h() {
        return this.f29263j;
    }

    /* renamed from: i */
    public final float m38311i() {
        return this.f29264k;
    }

    /* renamed from: j */
    public final boolean m38312j() {
        return this.f29261h;
    }

    /* renamed from: k */
    public final boolean m38313k() {
        return this.f29265l;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = C2835c.a(parcel);
        C2835c.a(parcel, 2, this.f29254a.m21760a().asBinder(), false);
        C2835c.a(parcel, 3, m38298a(), i, false);
        C2835c.a(parcel, 4, m38303b());
        C2835c.a(parcel, 5, m38305c());
        C2835c.a(parcel, 6, m38306d(), i, false);
        C2835c.a(parcel, 7, m38307e());
        C2835c.a(parcel, 8, m38308f());
        C2835c.a(parcel, 9, m38312j());
        C2835c.a(parcel, 10, m38309g());
        C2835c.a(parcel, 11, m38310h());
        C2835c.a(parcel, 12, m38311i());
        C2835c.a(parcel, 13, m38313k());
        C2835c.a(parcel, a);
    }
}
