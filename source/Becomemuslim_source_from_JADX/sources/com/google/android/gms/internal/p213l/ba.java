package com.google.android.gms.internal.p213l;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.C2832i;
import com.google.android.gms.common.internal.C2850d;
import com.google.android.gms.common.internal.C2850d.C2844a;
import com.google.android.gms.common.internal.C2850d.C2845b;

/* renamed from: com.google.android.gms.internal.l.ba */
public final class ba extends C2850d<at> {
    public ba(Context context, Looper looper, C2844a c2844a, C2845b c2845b) {
        super(context, looper, 93, c2844a, c2845b, null);
    }

    /* renamed from: a */
    public final /* synthetic */ IInterface m31943a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
        return queryLocalInterface instanceof at ? (at) queryLocalInterface : new av(iBinder);
    }

    /* renamed from: b */
    protected final String m31944b() {
        return "com.google.android.gms.measurement.internal.IMeasurementService";
    }

    /* renamed from: f */
    public final int m31945f() {
        return C2832i.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    protected final String q_() {
        return "com.google.android.gms.measurement.START";
    }
}
