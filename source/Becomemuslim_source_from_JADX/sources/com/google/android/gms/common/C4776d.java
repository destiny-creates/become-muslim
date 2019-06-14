package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.common.internal.C2868t;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

/* renamed from: com.google.android.gms.common.d */
public class C4776d extends C4363a {
    public static final Creator<C4776d> CREATOR = new C2879p();
    /* renamed from: a */
    private final String f13211a;
    @Deprecated
    /* renamed from: b */
    private final int f13212b;
    /* renamed from: c */
    private final long f13213c;

    public C4776d(String str, int i, long j) {
        this.f13211a = str;
        this.f13212b = i;
        this.f13213c = j;
    }

    /* renamed from: a */
    public String m16830a() {
        return this.f13211a;
    }

    /* renamed from: b */
    public long m16831b() {
        return this.f13213c == -1 ? (long) this.f13212b : this.f13213c;
    }

    public void writeToParcel(Parcel parcel, int i) {
        i = C2835c.m8179a(parcel);
        C2835c.m8193a(parcel, 1, m16830a(), false);
        C2835c.m8184a(parcel, 2, this.f13212b);
        C2835c.m8185a(parcel, 3, m16831b());
        C2835c.m8180a(parcel, i);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C4776d)) {
            return false;
        }
        C4776d c4776d = (C4776d) obj;
        if (((m16830a() == null || !m16830a().equals(c4776d.m16830a())) && (m16830a() != null || c4776d.m16830a() != null)) || m16831b() != c4776d.m16831b()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return C2868t.m8372a(m16830a(), Long.valueOf(m16831b()));
    }

    public String toString() {
        return C2868t.m8373a((Object) this).m8371a("name", m16830a()).m8371a(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, Long.valueOf(m16831b())).toString();
    }
}
