package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.ads.p168b.C2609c.C2607a;
import com.google.android.gms.ads.p168b.C2609c.C2608b;
import java.util.ArrayList;
import java.util.List;

@cm
public final class avc extends C2607a {
    /* renamed from: a */
    private final auz f23828a;
    /* renamed from: b */
    private final List<C2608b> f23829b = new ArrayList();
    /* renamed from: c */
    private String f23830c;

    public avc(auz auz) {
        this.f23828a = auz;
        try {
            this.f23830c = this.f23828a.mo3994a();
        } catch (Throwable e) {
            mt.m19919b("", e);
            this.f23830c = "";
        }
        try {
            for (Object next : auz.mo3995b()) {
                avd avf;
                if (next instanceof IBinder) {
                    IBinder iBinder = (IBinder) next;
                    if (iBinder != null) {
                        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                        avf = queryLocalInterface instanceof avd ? (avd) queryLocalInterface : new avf(iBinder);
                        if (avf != null) {
                            this.f23829b.add(new avg(avf));
                        }
                    }
                }
                avf = null;
                if (avf != null) {
                    this.f23829b.add(new avg(avf));
                }
            }
        } catch (Throwable e2) {
            mt.m19919b("", e2);
        }
    }
}
