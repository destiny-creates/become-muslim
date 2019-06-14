package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C2868t;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

/* renamed from: com.google.android.gms.fitness.data.b */
public final class C4802b extends C4363a {
    public static final Creator<C4802b> CREATOR = new C3007w();
    /* renamed from: a */
    private final String f13472a;
    /* renamed from: b */
    private final String f13473b;
    /* renamed from: c */
    private final String f13474c;
    /* renamed from: d */
    private final int f13475d;
    /* renamed from: e */
    private final int f13476e;

    public C4802b(String str, String str2, String str3, int i, int i2) {
        this.f13472a = (String) C2872v.m8380a((Object) str);
        this.f13473b = (String) C2872v.m8380a((Object) str2);
        if (str3 != null) {
            this.f13474c = str3;
            this.f13475d = i;
            this.f13476e = i2;
            return;
        }
        throw new IllegalStateException("Device UID is null.");
    }

    /* renamed from: a */
    public final String m17012a() {
        return this.f13472a;
    }

    /* renamed from: b */
    public final String m17013b() {
        return this.f13473b;
    }

    /* renamed from: c */
    public final String m17014c() {
        return this.f13474c;
    }

    /* renamed from: d */
    public final int m17015d() {
        return this.f13475d;
    }

    /* renamed from: e */
    final String m17016e() {
        return String.format("%s:%s:%s", new Object[]{this.f13472a, this.f13473b, this.f13474c});
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C4802b)) {
            return false;
        }
        C4802b c4802b = (C4802b) obj;
        return C2868t.m8374a(this.f13472a, c4802b.f13472a) && C2868t.m8374a(this.f13473b, c4802b.f13473b) && C2868t.m8374a(this.f13474c, c4802b.f13474c) && this.f13475d == c4802b.f13475d && this.f13476e == c4802b.f13476e;
    }

    public final int hashCode() {
        return C2868t.m8372a(this.f13472a, this.f13473b, this.f13474c, Integer.valueOf(this.f13475d));
    }

    public final String toString() {
        return String.format("Device{%s:%s:%s}", new Object[]{m17016e(), Integer.valueOf(this.f13475d), Integer.valueOf(this.f13476e)});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = C2835c.m8179a(parcel);
        C2835c.m8193a(parcel, 1, m17012a(), false);
        C2835c.m8193a(parcel, 2, m17013b(), false);
        C2835c.m8193a(parcel, 4, m17014c(), false);
        C2835c.m8184a(parcel, 5, m17015d());
        C2835c.m8184a(parcel, 6, this.f13476e);
        C2835c.m8180a(parcel, i);
    }
}
