package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.C2850d;
import com.google.android.gms.common.internal.C2850d.C2844a;
import com.google.android.gms.common.internal.C2850d.C2845b;

public final class tl extends C2850d<tq> {
    public tl(Context context, Looper looper, C2844a c2844a, C2845b c2845b) {
        super(context, looper, 116, c2844a, c2845b, null);
    }

    /* renamed from: a */
    protected final /* synthetic */ IInterface m31126a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.gass.internal.IGassService");
        return queryLocalInterface instanceof tq ? (tq) queryLocalInterface : new tr(iBinder);
    }

    /* renamed from: b */
    protected final String m31127b() {
        return "com.google.android.gms.gass.internal.IGassService";
    }

    /* renamed from: e */
    public final tq m31128e() {
        return (tq) super.w();
    }

    protected final String q_() {
        return "com.google.android.gms.gass.START";
    }
}
