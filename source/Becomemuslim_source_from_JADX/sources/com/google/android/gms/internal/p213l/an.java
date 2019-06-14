package com.google.android.gms.internal.p213l;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;
import java.util.Iterator;

/* renamed from: com.google.android.gms.internal.l.an */
public final class an extends C4363a implements Iterable<String> {
    public static final Creator<an> CREATOR = new ap();
    /* renamed from: a */
    private final Bundle f28969a;

    an(Bundle bundle) {
        this.f28969a = bundle;
    }

    /* renamed from: a */
    public final int m38073a() {
        return this.f28969a.size();
    }

    /* renamed from: a */
    final Object m38074a(String str) {
        return this.f28969a.get(str);
    }

    /* renamed from: b */
    public final Bundle m38075b() {
        return new Bundle(this.f28969a);
    }

    /* renamed from: b */
    final Long m38076b(String str) {
        return Long.valueOf(this.f28969a.getLong(str));
    }

    /* renamed from: c */
    final Double m38077c(String str) {
        return Double.valueOf(this.f28969a.getDouble(str));
    }

    /* renamed from: d */
    final String m38078d(String str) {
        return this.f28969a.getString(str);
    }

    public final Iterator<String> iterator() {
        return new ao(this);
    }

    public final String toString() {
        return this.f28969a.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = C2835c.a(parcel);
        C2835c.a(parcel, 2, m38075b(), false);
        C2835c.a(parcel, i);
    }
}
