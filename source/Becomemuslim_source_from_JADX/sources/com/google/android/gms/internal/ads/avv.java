package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.ads.C2678k;
import com.google.android.gms.ads.p168b.C2609c.C2607a;
import com.google.android.gms.ads.p168b.C2609c.C2608b;
import com.google.android.gms.ads.p168b.C4259g;
import com.google.android.gms.p174b.C2758b;
import java.util.ArrayList;
import java.util.List;

@cm
public final class avv extends C4259g {
    /* renamed from: a */
    private final avs f28417a;
    /* renamed from: b */
    private final List<C2608b> f28418b = new ArrayList();
    /* renamed from: c */
    private final avg f28419c;
    /* renamed from: d */
    private final C2678k f28420d = new C2678k();
    /* renamed from: e */
    private final C2607a f28421e;

    public avv(avs avs) {
        avg avg;
        this.f28417a = avs;
        C2607a c2607a = null;
        try {
            List b = this.f28417a.mo4011b();
            if (b != null) {
                for (Object next : b) {
                    avd avf;
                    if (next instanceof IBinder) {
                        IBinder iBinder = (IBinder) next;
                        if (iBinder != null) {
                            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                            avf = queryLocalInterface instanceof avd ? (avd) queryLocalInterface : new avf(iBinder);
                            if (avf != null) {
                                this.f28418b.add(new avg(avf));
                            }
                        }
                    }
                    avf = null;
                    if (avf != null) {
                        this.f28418b.add(new avg(avf));
                    }
                }
            }
        } catch (Throwable e) {
            mt.m19919b("", e);
        }
        try {
            avd d = this.f28417a.mo4015d();
            if (d != null) {
                avg = new avg(d);
                this.f28419c = avg;
                if (this.f28417a.mo4025r() != null) {
                    c2607a = new avc(this.f28417a.mo4025r());
                }
                this.f28421e = c2607a;
            }
        } catch (Throwable e2) {
            mt.m19919b("", e2);
        }
        avg = null;
        this.f28419c = avg;
        try {
            if (this.f28417a.mo4025r() != null) {
                c2607a = new avc(this.f28417a.mo4025r());
            }
        } catch (Throwable e22) {
            mt.m19919b("", e22);
        }
        this.f28421e = c2607a;
    }

    /* renamed from: k */
    private final C2758b m37161k() {
        try {
            return this.f28417a.mo4021j();
        } catch (Throwable e) {
            mt.m19919b("", e);
            return null;
        }
    }

    /* renamed from: a */
    protected final /* synthetic */ Object m37162a() {
        return m37161k();
    }

    /* renamed from: b */
    public final CharSequence m37163b() {
        try {
            return this.f28417a.mo4009a();
        } catch (Throwable e) {
            mt.m19919b("", e);
            return null;
        }
    }

    /* renamed from: c */
    public final List<C2608b> m37164c() {
        return this.f28418b;
    }

    /* renamed from: d */
    public final CharSequence m37165d() {
        try {
            return this.f28417a.mo4013c();
        } catch (Throwable e) {
            mt.m19919b("", e);
            return null;
        }
    }

    /* renamed from: e */
    public final C2608b m37166e() {
        return this.f28419c;
    }

    /* renamed from: f */
    public final CharSequence m37167f() {
        try {
            return this.f28417a.mo4016e();
        } catch (Throwable e) {
            mt.m19919b("", e);
            return null;
        }
    }

    /* renamed from: g */
    public final Double m37168g() {
        try {
            double f = this.f28417a.mo4017f();
            return f == -1.0d ? null : Double.valueOf(f);
        } catch (Throwable e) {
            mt.m19919b("", e);
            return null;
        }
    }

    /* renamed from: h */
    public final CharSequence m37169h() {
        try {
            return this.f28417a.mo4018g();
        } catch (Throwable e) {
            mt.m19919b("", e);
            return null;
        }
    }

    /* renamed from: i */
    public final CharSequence m37170i() {
        try {
            return this.f28417a.mo4019h();
        } catch (Throwable e) {
            mt.m19919b("", e);
            return null;
        }
    }

    /* renamed from: j */
    public final C2678k m37171j() {
        try {
            if (this.f28417a.mo4020i() != null) {
                this.f28420d.a(this.f28417a.mo4020i());
            }
        } catch (Throwable e) {
            mt.m19919b("Exception occurred while getting video controller", e);
        }
        return this.f28420d;
    }
}
