package com.google.android.gms.ads.internal;

import android.os.Build.VERSION;
import com.google.android.gms.ads.internal.overlay.C2656a;
import com.google.android.gms.ads.internal.overlay.C2663l;
import com.google.android.gms.ads.internal.overlay.C2669u;
import com.google.android.gms.ads.internal.overlay.C2670v;
import com.google.android.gms.common.util.C2895e;
import com.google.android.gms.common.util.C4376h;
import com.google.android.gms.internal.ads.C4935p;
import com.google.android.gms.internal.ads.alk;
import com.google.android.gms.internal.ads.amh;
import com.google.android.gms.internal.ads.ami;
import com.google.android.gms.internal.ads.amw;
import com.google.android.gms.internal.ads.ao;
import com.google.android.gms.internal.ads.asu;
import com.google.android.gms.internal.ads.azd;
import com.google.android.gms.internal.ads.azy;
import com.google.android.gms.internal.ads.bbq;
import com.google.android.gms.internal.ads.bcr;
import com.google.android.gms.internal.ads.cm;
import com.google.android.gms.internal.ads.cn;
import com.google.android.gms.internal.ads.fk;
import com.google.android.gms.internal.ads.ii;
import com.google.android.gms.internal.ads.ix;
import com.google.android.gms.internal.ads.jg;
import com.google.android.gms.internal.ads.jw;
import com.google.android.gms.internal.ads.kc;
import com.google.android.gms.internal.ads.kh;
import com.google.android.gms.internal.ads.ki;
import com.google.android.gms.internal.ads.kj;
import com.google.android.gms.internal.ads.kk;
import com.google.android.gms.internal.ads.kl;
import com.google.android.gms.internal.ads.kn;
import com.google.android.gms.internal.ads.ko;
import com.google.android.gms.internal.ads.kx;
import com.google.android.gms.internal.ads.lu;
import com.google.android.gms.internal.ads.lv;
import com.google.android.gms.internal.ads.me;
import com.google.android.gms.internal.ads.oa;
import com.google.android.gms.internal.ads.oh;
import com.google.android.gms.internal.ads.py;
import com.google.android.gms.internal.ads.qv;

@cm
public final class ax {
    /* renamed from: a */
    private static final Object f6737a = new Object();
    /* renamed from: b */
    private static ax f6738b;
    /* renamed from: A */
    private final ad f6739A;
    /* renamed from: B */
    private final C4935p f6740B;
    /* renamed from: C */
    private final amw f6741C;
    /* renamed from: D */
    private final ii f6742D;
    /* renamed from: E */
    private final py f6743E;
    /* renamed from: F */
    private final oh f6744F;
    /* renamed from: G */
    private final azy f6745G;
    /* renamed from: H */
    private final ko f6746H;
    /* renamed from: I */
    private final me f6747I;
    /* renamed from: J */
    private final jg f6748J;
    /* renamed from: c */
    private final C2656a f6749c = new C2656a();
    /* renamed from: d */
    private final cn f6750d = new cn();
    /* renamed from: e */
    private final C2663l f6751e = new C2663l();
    /* renamed from: f */
    private final ao f6752f = new ao();
    /* renamed from: g */
    private final jw f6753g = new jw();
    /* renamed from: h */
    private final qv f6754h = new qv();
    /* renamed from: i */
    private final kc f6755i;
    /* renamed from: j */
    private final alk f6756j;
    /* renamed from: k */
    private final ix f6757k;
    /* renamed from: l */
    private final amh f6758l;
    /* renamed from: m */
    private final ami f6759m;
    /* renamed from: n */
    private final C2895e f6760n;
    /* renamed from: o */
    private final C2642e f6761o;
    /* renamed from: p */
    private final asu f6762p;
    /* renamed from: q */
    private final kx f6763q;
    /* renamed from: r */
    private final fk f6764r;
    /* renamed from: s */
    private final oa f6765s;
    /* renamed from: t */
    private final azd f6766t;
    /* renamed from: u */
    private final bbq f6767u;
    /* renamed from: v */
    private final lu f6768v;
    /* renamed from: w */
    private final C2669u f6769w;
    /* renamed from: x */
    private final C2670v f6770x;
    /* renamed from: y */
    private final bcr f6771y;
    /* renamed from: z */
    private final lv f6772z;

    static {
        ax axVar = new ax();
        synchronized (f6737a) {
            f6738b = axVar;
        }
    }

    protected ax() {
        int i = VERSION.SDK_INT;
        kc knVar = i >= 21 ? new kn() : i >= 19 ? new kl() : i >= 18 ? new kj() : i >= 17 ? new ki() : i >= 16 ? new kk() : new kh();
        this.f6755i = knVar;
        this.f6756j = new alk();
        this.f6757k = new ix();
        this.f6748J = new jg();
        this.f6758l = new amh();
        this.f6759m = new ami();
        this.f6760n = C4376h.m14397d();
        this.f6761o = new C2642e();
        this.f6762p = new asu();
        this.f6763q = new kx();
        this.f6764r = new fk();
        this.f6745G = new azy();
        this.f6765s = new oa();
        this.f6766t = new azd();
        this.f6767u = new bbq();
        this.f6768v = new lu();
        this.f6769w = new C2669u();
        this.f6770x = new C2670v();
        this.f6771y = new bcr();
        this.f6772z = new lv();
        this.f6739A = new ad();
        this.f6740B = new C4935p();
        this.f6741C = new amw();
        this.f6742D = new ii();
        this.f6743E = new py();
        this.f6744F = new oh();
        this.f6746H = new ko();
        this.f6747I = new me();
    }

    /* renamed from: A */
    public static oh m7454A() {
        return m7459F().f6744F;
    }

    /* renamed from: B */
    public static ii m7455B() {
        return m7459F().f6742D;
    }

    /* renamed from: C */
    public static azy m7456C() {
        return m7459F().f6745G;
    }

    /* renamed from: D */
    public static ko m7457D() {
        return m7459F().f6746H;
    }

    /* renamed from: E */
    public static me m7458E() {
        return m7459F().f6747I;
    }

    /* renamed from: F */
    private static ax m7459F() {
        ax axVar;
        synchronized (f6737a) {
            axVar = f6738b;
        }
        return axVar;
    }

    /* renamed from: a */
    public static cn m7460a() {
        return m7459F().f6750d;
    }

    /* renamed from: b */
    public static C2656a m7461b() {
        return m7459F().f6749c;
    }

    /* renamed from: c */
    public static C2663l m7462c() {
        return m7459F().f6751e;
    }

    /* renamed from: d */
    public static ao m7463d() {
        return m7459F().f6752f;
    }

    /* renamed from: e */
    public static jw m7464e() {
        return m7459F().f6753g;
    }

    /* renamed from: f */
    public static qv m7465f() {
        return m7459F().f6754h;
    }

    /* renamed from: g */
    public static kc m7466g() {
        return m7459F().f6755i;
    }

    /* renamed from: h */
    public static alk m7467h() {
        return m7459F().f6756j;
    }

    /* renamed from: i */
    public static ix m7468i() {
        return m7459F().f6757k;
    }

    /* renamed from: j */
    public static jg m7469j() {
        return m7459F().f6748J;
    }

    /* renamed from: k */
    public static ami m7470k() {
        return m7459F().f6759m;
    }

    /* renamed from: l */
    public static C2895e m7471l() {
        return m7459F().f6760n;
    }

    /* renamed from: m */
    public static C2642e m7472m() {
        return m7459F().f6761o;
    }

    /* renamed from: n */
    public static asu m7473n() {
        return m7459F().f6762p;
    }

    /* renamed from: o */
    public static kx m7474o() {
        return m7459F().f6763q;
    }

    /* renamed from: p */
    public static fk m7475p() {
        return m7459F().f6764r;
    }

    /* renamed from: q */
    public static oa m7476q() {
        return m7459F().f6765s;
    }

    /* renamed from: r */
    public static azd m7477r() {
        return m7459F().f6766t;
    }

    /* renamed from: s */
    public static bbq m7478s() {
        return m7459F().f6767u;
    }

    /* renamed from: t */
    public static lu m7479t() {
        return m7459F().f6768v;
    }

    /* renamed from: u */
    public static C4935p m7480u() {
        return m7459F().f6740B;
    }

    /* renamed from: v */
    public static C2669u m7481v() {
        return m7459F().f6769w;
    }

    /* renamed from: w */
    public static C2670v m7482w() {
        return m7459F().f6770x;
    }

    /* renamed from: x */
    public static bcr m7483x() {
        return m7459F().f6771y;
    }

    /* renamed from: y */
    public static lv m7484y() {
        return m7459F().f6772z;
    }

    /* renamed from: z */
    public static py m7485z() {
        return m7459F().f6743E;
    }
}
