package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

public final class to extends C4363a {
    public static final Creator<to> CREATOR = new tp();
    /* renamed from: a */
    private final int f28760a;
    /* renamed from: b */
    private aaa f28761b = null;
    /* renamed from: c */
    private byte[] f28762c;

    to(int i, byte[] bArr) {
        this.f28760a = i;
        this.f28762c = bArr;
        m37661b();
    }

    /* renamed from: b */
    private final void m37661b() {
        if (this.f28761b == null && this.f28762c != null) {
            return;
        }
        if (this.f28761b == null || this.f28762c != null) {
            if (this.f28761b != null) {
                if (this.f28762c != null) {
                    throw new IllegalStateException("Invalid internal representation - full");
                }
            }
            if (this.f28761b == null && this.f28762c == null) {
                throw new IllegalStateException("Invalid internal representation - empty");
            }
            throw new IllegalStateException("Impossible");
        }
    }

    /* renamed from: a */
    public final aaa m37662a() {
        if ((this.f28761b != null ? 1 : null) == null) {
            try {
                this.f28761b = (aaa) afo.m18386a(new aaa(), this.f28762c);
                this.f28762c = null;
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        }
        m37661b();
        return this.f28761b;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = C2835c.a(parcel);
        C2835c.a(parcel, 1, this.f28760a);
        C2835c.a(parcel, 2, this.f28762c != null ? this.f28762c : afo.m18388a(this.f28761b), false);
        C2835c.a(parcel, i);
    }
}
