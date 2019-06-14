package com.google.android.gms.iid;

import android.os.IBinder;
import android.os.Message;
import android.os.Parcel;
import com.google.android.gms.internal.p209h.C4977a;
import com.google.android.gms.internal.p209h.C4978b;

/* renamed from: com.google.android.gms.iid.w */
public final class C4433w extends C4977a implements C3076v {
    C4433w(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.iid.IMessengerCompat");
    }

    /* renamed from: a */
    public final void mo2606a(Message message) {
        Parcel a = a();
        C4978b.a(a, message);
        a(1, a);
    }
}
