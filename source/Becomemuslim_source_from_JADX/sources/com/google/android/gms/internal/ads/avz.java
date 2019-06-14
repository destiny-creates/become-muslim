package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.ads.C2678k;
import com.google.android.gms.ads.p168b.C2609c.C2607a;
import com.google.android.gms.ads.p168b.C2609c.C2608b;
import com.google.android.gms.ads.p168b.C4261i;
import com.google.android.gms.p174b.C2758b;
import java.util.ArrayList;
import java.util.List;

@cm
public final class avz extends C4261i {
    /* renamed from: a */
    private final avw f28422a;
    /* renamed from: b */
    private final List<C2608b> f28423b = new ArrayList();
    /* renamed from: c */
    private final avg f28424c;
    /* renamed from: d */
    private final C2678k f28425d = new C2678k();
    /* renamed from: e */
    private final C2607a f28426e;

    public avz(avw avw) {
        avg avg;
        this.f28422a = avw;
        C2607a c2607a = null;
        try {
            List b = this.f28422a.mo4029b();
            if (b != null) {
                for (Object next : b) {
                    avd avf;
                    if (next instanceof IBinder) {
                        IBinder iBinder = (IBinder) next;
                        if (iBinder != null) {
                            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                            avf = queryLocalInterface instanceof avd ? (avd) queryLocalInterface : new avf(iBinder);
                            if (avf != null) {
                                this.f28423b.add(new avg(avf));
                            }
                        }
                    }
                    avf = null;
                    if (avf != null) {
                        this.f28423b.add(new avg(avf));
                    }
                }
            }
        } catch (Throwable e) {
            mt.m19919b("", e);
        }
        try {
            avd f = this.f28422a.mo4035f();
            if (f != null) {
                avg = new avg(f);
                this.f28424c = avg;
                if (this.f28422a.mo4041p() != null) {
                    c2607a = new avc(this.f28422a.mo4041p());
                }
                this.f28426e = c2607a;
            }
        } catch (Throwable e2) {
            mt.m19919b("", e2);
        }
        avg = null;
        this.f28424c = avg;
        try {
            if (this.f28422a.mo4041p() != null) {
                c2607a = new avc(this.f28422a.mo4041p());
            }
        } catch (Throwable e22) {
            mt.m19919b("", e22);
        }
        this.f28426e = c2607a;
    }

    /* renamed from: i */
    private final C2758b m37172i() {
        try {
            return this.f28422a.mo4039j();
        } catch (Throwable e) {
            mt.m19919b("", e);
            return null;
        }
    }

    /* renamed from: a */
    protected final /* synthetic */ Object m37173a() {
        return m37172i();
    }

    /* renamed from: b */
    public final CharSequence m37174b() {
        try {
            return this.f28422a.mo4027a();
        } catch (Throwable e) {
            mt.m19919b("", e);
            return null;
        }
    }

    /* renamed from: c */
    public final List<C2608b> m37175c() {
        return this.f28423b;
    }

    /* renamed from: d */
    public final CharSequence m37176d() {
        try {
            return this.f28422a.mo4034e();
        } catch (Throwable e) {
            mt.m19919b("", e);
            return null;
        }
    }

    /* renamed from: e */
    public final C2608b m37177e() {
        return this.f28424c;
    }

    /* renamed from: f */
    public final CharSequence m37178f() {
        try {
            return this.f28422a.mo4036g();
        } catch (Throwable e) {
            mt.m19919b("", e);
            return null;
        }
    }

    /* renamed from: g */
    public final CharSequence m37179g() {
        try {
            return this.f28422a.mo4037h();
        } catch (Throwable e) {
            mt.m19919b("", e);
            return null;
        }
    }

    /* renamed from: h */
    public final C2678k m37180h() {
        try {
            if (this.f28422a.mo4038i() != null) {
                this.f28425d.a(this.f28422a.mo4038i());
            }
        } catch (Throwable e) {
            mt.m19919b("Exception occurred while getting video controller", e);
        }
        return this.f28425d;
    }
}
