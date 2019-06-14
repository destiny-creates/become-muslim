package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;
import java.io.InputStream;

@cm
public final class amn extends C4363a {
    public static final Creator<amn> CREATOR = new amo();
    /* renamed from: a */
    private ParcelFileDescriptor f28116a;

    public amn() {
        this(null);
    }

    public amn(ParcelFileDescriptor parcelFileDescriptor) {
        this.f28116a = parcelFileDescriptor;
    }

    /* renamed from: c */
    private final synchronized ParcelFileDescriptor m36798c() {
        return this.f28116a;
    }

    /* renamed from: a */
    public final synchronized boolean m36799a() {
        return this.f28116a != null;
    }

    /* renamed from: b */
    public final synchronized InputStream m36800b() {
        if (this.f28116a == null) {
            return null;
        }
        InputStream autoCloseInputStream = new AutoCloseInputStream(this.f28116a);
        this.f28116a = null;
        return autoCloseInputStream;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = C2835c.a(parcel);
        C2835c.a(parcel, 2, m36798c(), i, false);
        C2835c.a(parcel, a);
    }
}
