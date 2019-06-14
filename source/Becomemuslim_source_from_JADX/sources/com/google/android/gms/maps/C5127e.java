package com.google.android.gms.maps;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.C2831g;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.maps.model.C5137b;
import com.google.android.gms.maps.model.C5146u;
import com.google.android.gms.maps.p216a.ak;
import com.google.android.gms.maps.p216a.an;

/* renamed from: com.google.android.gms.maps.e */
public final class C5127e {
    /* renamed from: a */
    private static boolean f17398a = false;

    /* renamed from: a */
    public static synchronized int m21739a(Context context) {
        synchronized (C5127e.class) {
            C2872v.a(context, "Context is null");
            if (f17398a) {
                return 0;
            }
            try {
                an a = ak.m21594a(context);
                try {
                    C5107b.m21696a(a.mo4792a());
                    C5137b.m21765a(a.mo4795b());
                    f17398a = true;
                    return 0;
                } catch (RemoteException e) {
                    throw new C5146u(e);
                }
            } catch (C2831g e2) {
                return e2.f7234a;
            }
        }
    }
}
