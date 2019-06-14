package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import com.google.android.gms.internal.p203b.C4941b;

/* renamed from: com.google.android.gms.auth.api.signin.internal.t */
public abstract class C4317t extends C4941b implements C2747s {
    public C4317t() {
        super("com.google.android.gms.auth.api.signin.internal.IRevocationService");
    }

    /* renamed from: a */
    protected final boolean m14014a(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                mo3271a();
                break;
            case 2:
                mo3272b();
                break;
            default:
                return false;
        }
        return true;
    }
}
