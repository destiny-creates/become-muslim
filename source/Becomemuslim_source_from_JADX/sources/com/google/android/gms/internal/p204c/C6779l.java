package com.google.android.gms.internal.p204c;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.google.android.gms.internal.c.l */
public final class C6779l extends C4945a implements C4951j {
    C6779l(IBinder iBinder) {
        super(iBinder, "com.google.android.auth.IAuthManagerService");
    }

    /* renamed from: a */
    public final Bundle mo4396a(String str, Bundle bundle) {
        Parcel a = m20216a();
        a.writeString(str);
        C4949h.m20222a(a, (Parcelable) bundle);
        Parcel a2 = m20217a(2, a);
        bundle = (Bundle) C4949h.m20221a(a2, Bundle.CREATOR);
        a2.recycle();
        return bundle;
    }

    /* renamed from: a */
    public final Bundle mo4395a(Account account, String str, Bundle bundle) {
        Parcel a = m20216a();
        C4949h.m20222a(a, (Parcelable) account);
        a.writeString(str);
        C4949h.m20222a(a, (Parcelable) bundle);
        Parcel a2 = m20217a(5, a);
        Bundle bundle2 = (Bundle) C4949h.m20221a(a2, Bundle.CREATOR);
        a2.recycle();
        return bundle2;
    }
}
