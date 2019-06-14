package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.ads.C2678k;
import com.google.android.gms.ads.p168b.C2606b;
import com.google.android.gms.ads.p168b.C2618k;
import com.google.android.gms.p174b.C4757d;
import java.util.WeakHashMap;

@cm
public final class awd implements C2618k {
    /* renamed from: a */
    private static WeakHashMap<IBinder, awd> f23835a = new WeakHashMap();
    /* renamed from: b */
    private final awa f23836b;
    /* renamed from: c */
    private final C2606b f23837c;
    /* renamed from: d */
    private final C2678k f23838d = new C2678k();

    private awd(awa awa) {
        Context context;
        this.f23836b = awa;
        C2606b c2606b = null;
        try {
            context = (Context) C4757d.a(awa.mo4051e());
        } catch (Throwable e) {
            mt.m19919b("", e);
            context = null;
        }
        if (context != null) {
            C2606b c2606b2 = new C2606b(context);
            try {
                if (this.f23836b.mo4045a(C4757d.a(c2606b2))) {
                    c2606b = c2606b2;
                }
            } catch (Throwable e2) {
                mt.m19919b("", e2);
            }
        }
        this.f23837c = c2606b;
    }

    /* renamed from: a */
    public static awd m30316a(awa awa) {
        synchronized (f23835a) {
            awd awd = (awd) f23835a.get(awa.asBinder());
            if (awd != null) {
                return awd;
            }
            awd = new awd(awa);
            f23835a.put(awa.asBinder(), awd);
            return awd;
        }
    }

    /* renamed from: a */
    public final String m30317a() {
        try {
            return this.f23836b.mo4053l();
        } catch (Throwable e) {
            mt.m19919b("", e);
            return null;
        }
    }

    /* renamed from: b */
    public final awa m30318b() {
        return this.f23836b;
    }
}
