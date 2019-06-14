package com.google.android.gms.internal.p215n;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.wallet.C7874f;
import com.google.android.gms.wallet.C7878j;

/* renamed from: com.google.android.gms.internal.n.s */
public final class C6829s extends C5061a implements C5070r {
    C6829s(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.wallet.internal.IOwService");
    }

    /* renamed from: a */
    public final void mo4773a(C7874f c7874f, Bundle bundle, C5071t c5071t) {
        Parcel a = m21517a();
        C5064i.m21522a(a, (Parcelable) c7874f);
        C5064i.m21522a(a, (Parcelable) bundle);
        C5064i.m21521a(a, (IInterface) c5071t);
        m21518a(14, a);
    }

    /* renamed from: a */
    public final void mo4774a(C7878j c7878j, Bundle bundle, C5071t c5071t) {
        Parcel a = m21517a();
        C5064i.m21522a(a, (Parcelable) c7878j);
        C5064i.m21522a(a, (Parcelable) bundle);
        C5064i.m21521a(a, (IInterface) c5071t);
        m21518a(19, a);
    }
}
