package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.ads.C2678k;
import com.google.android.gms.ads.p168b.C2609c.C2607a;
import com.google.android.gms.ads.p168b.C2609c.C2608b;
import com.google.android.gms.ads.p168b.C2620m;
import com.google.android.gms.p174b.C2758b;
import com.google.android.gms.p174b.C4757d;
import java.util.ArrayList;
import java.util.List;

@cm
public final class axc extends C2620m {
    /* renamed from: a */
    private final awz f23839a;
    /* renamed from: b */
    private final List<C2608b> f23840b = new ArrayList();
    /* renamed from: c */
    private final avg f23841c;
    /* renamed from: d */
    private final C2678k f23842d = new C2678k();
    /* renamed from: e */
    private final C2607a f23843e;

    public axc(awz awz) {
        avg avg;
        this.f23839a = awz;
        C2607a c2607a = null;
        try {
            List b = this.f23839a.mo4065b();
            if (b != null) {
                for (Object next : b) {
                    avd avf;
                    if (next instanceof IBinder) {
                        IBinder iBinder = (IBinder) next;
                        if (iBinder != null) {
                            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                            avf = queryLocalInterface instanceof avd ? (avd) queryLocalInterface : new avf(iBinder);
                            if (avf != null) {
                                this.f23840b.add(new avg(avf));
                            }
                        }
                    }
                    avf = null;
                    if (avf != null) {
                        this.f23840b.add(new avg(avf));
                    }
                }
            }
        } catch (Throwable e) {
            mt.m19919b("", e);
        }
        try {
            avd d = this.f23839a.mo4069d();
            if (d != null) {
                avg = new avg(d);
                this.f23841c = avg;
                if (this.f23839a.mo4080s() != null) {
                    c2607a = new avc(this.f23839a.mo4080s());
                }
                this.f23843e = c2607a;
            }
        } catch (Throwable e2) {
            mt.m19919b("", e2);
        }
        avg = null;
        this.f23841c = avg;
        try {
            if (this.f23839a.mo4080s() != null) {
                c2607a = new avc(this.f23839a.mo4080s());
            }
        } catch (Throwable e22) {
            mt.m19919b("", e22);
        }
        this.f23843e = c2607a;
    }

    /* renamed from: m */
    private final C2758b m30354m() {
        try {
            return this.f23839a.mo4076n();
        } catch (Throwable e) {
            mt.m19919b("", e);
            return null;
        }
    }

    /* renamed from: a */
    public final String m30355a() {
        try {
            return this.f23839a.mo4062a();
        } catch (Throwable e) {
            mt.m19919b("", e);
            return null;
        }
    }

    /* renamed from: b */
    public final List<C2608b> m30356b() {
        return this.f23840b;
    }

    /* renamed from: c */
    public final String m30357c() {
        try {
            return this.f23839a.mo4067c();
        } catch (Throwable e) {
            mt.m19919b("", e);
            return null;
        }
    }

    /* renamed from: d */
    public final C2608b m30358d() {
        return this.f23841c;
    }

    /* renamed from: e */
    public final String m30359e() {
        try {
            return this.f23839a.mo4070e();
        } catch (Throwable e) {
            mt.m19919b("", e);
            return null;
        }
    }

    /* renamed from: f */
    public final String m30360f() {
        try {
            return this.f23839a.mo4071f();
        } catch (Throwable e) {
            mt.m19919b("", e);
            return null;
        }
    }

    /* renamed from: g */
    public final Double m30361g() {
        try {
            double g = this.f23839a.mo4072g();
            return g == -1.0d ? null : Double.valueOf(g);
        } catch (Throwable e) {
            mt.m19919b("", e);
            return null;
        }
    }

    /* renamed from: h */
    public final String m30362h() {
        try {
            return this.f23839a.mo4073h();
        } catch (Throwable e) {
            mt.m19919b("", e);
            return null;
        }
    }

    /* renamed from: i */
    public final String m30363i() {
        try {
            return this.f23839a.mo4074i();
        } catch (Throwable e) {
            mt.m19919b("", e);
            return null;
        }
    }

    /* renamed from: j */
    public final C2678k m30364j() {
        try {
            if (this.f23839a.mo4075j() != null) {
                this.f23842d.a(this.f23839a.mo4075j());
            }
        } catch (Throwable e) {
            mt.m19919b("Exception occurred while getting video controller", e);
        }
        return this.f23842d;
    }

    /* renamed from: k */
    protected final /* synthetic */ Object m30365k() {
        return m30354m();
    }

    /* renamed from: l */
    public final Object m30366l() {
        try {
            C2758b p = this.f23839a.mo4077p();
            if (p != null) {
                return C4757d.a(p);
            }
        } catch (Throwable e) {
            mt.m19919b("", e);
        }
        return null;
    }
}
