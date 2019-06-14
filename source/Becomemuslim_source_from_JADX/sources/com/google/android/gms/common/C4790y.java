package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.ay;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;
import com.google.android.gms.p174b.C2758b;
import com.google.android.gms.p174b.C4757d;

/* renamed from: com.google.android.gms.common.y */
public final class C4790y extends C4363a {
    public static final Creator<C4790y> CREATOR = new C2915z();
    /* renamed from: a */
    private final String f13252a;
    /* renamed from: b */
    private final C4789s f13253b;
    /* renamed from: c */
    private final boolean f13254c;

    C4790y(String str, IBinder iBinder, boolean z) {
        this.f13252a = str;
        this.f13253b = C4790y.m16869a(iBinder);
        this.f13254c = z;
    }

    C4790y(String str, C4789s c4789s, boolean z) {
        this.f13252a = str;
        this.f13253b = c4789s;
        this.f13254c = z;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        IBinder iBinder;
        i = C2835c.m8179a(parcel);
        C2835c.m8193a(parcel, 1, this.f13252a, false);
        if (this.f13253b == null) {
            Log.w("GoogleCertificatesQuery", "certificate binder is null");
            iBinder = null;
        } else {
            iBinder = this.f13253b.asBinder();
        }
        C2835c.m8187a(parcel, 2, iBinder, false);
        C2835c.m8196a(parcel, 3, this.f13254c);
        C2835c.m8180a(parcel, i);
    }

    /* renamed from: a */
    private static C4789s m16869a(IBinder iBinder) {
        C4789s c4789s = null;
        if (iBinder == null) {
            return null;
        }
        try {
            C2758b a = ay.m14369a(iBinder).mo2469a();
            if (a == null) {
                iBinder = null;
            } else {
                iBinder = (byte[]) C4757d.m16685a(a);
            }
            if (iBinder != null) {
                c4789s = new C4887t(iBinder);
            } else {
                Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
            }
            return c4789s;
        } catch (IBinder iBinder2) {
            Log.e("GoogleCertificatesQuery", "Could not unwrap certificate", iBinder2);
            return null;
        }
    }
}
