package com.google.android.gms.ads.internal;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.util.C0463l;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import com.google.android.gms.internal.ads.ahe;
import com.google.android.gms.internal.ads.ahi;
import com.google.android.gms.internal.ads.aou;
import com.google.android.gms.internal.ads.aph;
import com.google.android.gms.internal.ads.apk;
import com.google.android.gms.internal.ads.apn;
import com.google.android.gms.internal.ads.aqd;
import com.google.android.gms.internal.ads.aqh;
import com.google.android.gms.internal.ads.aqn;
import com.google.android.gms.internal.ads.arb;
import com.google.android.gms.internal.ads.ary;
import com.google.android.gms.internal.ads.asp;
import com.google.android.gms.internal.ads.atj;
import com.google.android.gms.internal.ads.aus;
import com.google.android.gms.internal.ads.awe;
import com.google.android.gms.internal.ads.awh;
import com.google.android.gms.internal.ads.awl;
import com.google.android.gms.internal.ads.awo;
import com.google.android.gms.internal.ads.awr;
import com.google.android.gms.internal.ads.awu;
import com.google.android.gms.internal.ads.cm;
import com.google.android.gms.internal.ads.gf;
import com.google.android.gms.internal.ads.gn;
import com.google.android.gms.internal.ads.is;
import com.google.android.gms.internal.ads.it;
import com.google.android.gms.internal.ads.iu;
import com.google.android.gms.internal.ads.jf;
import com.google.android.gms.internal.ads.ji;
import com.google.android.gms.internal.ads.kp;
import com.google.android.gms.internal.ads.lx;
import com.google.android.gms.internal.ads.mi;
import com.google.android.gms.internal.ads.mv;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

@cm
public final class ay implements OnGlobalLayoutListener, OnScrollChangedListener {
    /* renamed from: A */
    List<Integer> f6773A;
    /* renamed from: B */
    atj f6774B;
    /* renamed from: C */
    gn f6775C;
    /* renamed from: D */
    gf f6776D;
    /* renamed from: E */
    public String f6777E;
    /* renamed from: F */
    List<String> f6778F;
    /* renamed from: G */
    public jf f6779G;
    /* renamed from: H */
    View f6780H;
    /* renamed from: I */
    public int f6781I;
    /* renamed from: J */
    boolean f6782J;
    /* renamed from: K */
    private HashSet<iu> f6783K;
    /* renamed from: L */
    private int f6784L;
    /* renamed from: M */
    private int f6785M;
    /* renamed from: N */
    private lx f6786N;
    /* renamed from: O */
    private boolean f6787O;
    /* renamed from: P */
    private boolean f6788P;
    /* renamed from: Q */
    private boolean f6789Q;
    /* renamed from: a */
    final String f6790a;
    /* renamed from: b */
    public String f6791b;
    /* renamed from: c */
    public final Context f6792c;
    /* renamed from: d */
    final ahi f6793d;
    /* renamed from: e */
    public final mv f6794e;
    /* renamed from: f */
    az f6795f;
    /* renamed from: g */
    public ji f6796g;
    /* renamed from: h */
    public kp f6797h;
    /* renamed from: i */
    public aou f6798i;
    /* renamed from: j */
    public is f6799j;
    /* renamed from: k */
    public it f6800k;
    /* renamed from: l */
    public iu f6801l;
    /* renamed from: m */
    apk f6802m;
    /* renamed from: n */
    apn f6803n;
    /* renamed from: o */
    aqh f6804o;
    /* renamed from: p */
    aqd f6805p;
    /* renamed from: q */
    aqn f6806q;
    /* renamed from: r */
    awe f6807r;
    /* renamed from: s */
    awh f6808s;
    /* renamed from: t */
    awu f6809t;
    /* renamed from: u */
    C0463l<String, awl> f6810u;
    /* renamed from: v */
    C0463l<String, awo> f6811v;
    /* renamed from: w */
    aus f6812w;
    /* renamed from: x */
    ary f6813x;
    /* renamed from: y */
    arb f6814y;
    /* renamed from: z */
    awr f6815z;

    public ay(Context context, aou aou, String str, mv mvVar) {
        this(context, aou, str, mvVar, null);
    }

    private ay(Context context, aou aou, String str, mv mvVar, ahi ahi) {
        this.f6779G = null;
        this.f6780H = null;
        this.f6781I = 0;
        this.f6782J = false;
        this.f6783K = null;
        this.f6784L = -1;
        this.f6785M = -1;
        this.f6787O = true;
        this.f6788P = true;
        this.f6789Q = false;
        asp.a(context);
        if (ax.m7468i().b() != null) {
            List b = asp.b();
            if (mvVar.f28710b != 0) {
                b.add(Integer.toString(mvVar.f28710b));
            }
            ax.m7468i().b().a(b);
        }
        this.f6790a = UUID.randomUUID().toString();
        if (!aou.f28282d) {
            if (!aou.f28286h) {
                this.f6795f = new az(context, str, mvVar.f28709a, this, this);
                this.f6795f.setMinimumWidth(aou.f28284f);
                this.f6795f.setMinimumHeight(aou.f28281c);
                this.f6795f.setVisibility(4);
                this.f6798i = aou;
                this.f6791b = str;
                this.f6792c = context;
                this.f6794e = mvVar;
                this.f6793d = new ahi(new C4286h(this));
                this.f6786N = new lx(200);
                this.f6811v = new C0463l();
            }
        }
        this.f6795f = null;
        this.f6798i = aou;
        this.f6791b = str;
        this.f6792c = context;
        this.f6794e = mvVar;
        this.f6793d = new ahi(new C4286h(this));
        this.f6786N = new lx(200);
        this.f6811v = new C0463l();
    }

    /* renamed from: b */
    private final void m7486b(boolean z) {
        if (!(this.f6795f == null || this.f6799j == null || this.f6799j.f15575b == null)) {
            if (this.f6799j.f15575b.v() != null) {
                if (!z || this.f6786N.a()) {
                    if (this.f6799j.f15575b.v().b()) {
                        int[] iArr = new int[2];
                        this.f6795f.getLocationOnScreen(iArr);
                        aph.a();
                        int b = mi.b(this.f6792c, iArr[0]);
                        aph.a();
                        int b2 = mi.b(this.f6792c, iArr[1]);
                        if (!(b == this.f6784L && b2 == this.f6785M)) {
                            this.f6784L = b;
                            this.f6785M = b2;
                            this.f6799j.f15575b.v().a(this.f6784L, this.f6785M, z ^ true);
                        }
                    }
                    if (this.f6795f != null) {
                        View findViewById = this.f6795f.getRootView().findViewById(16908290);
                        if (findViewById != null) {
                            Rect rect = new Rect();
                            Rect rect2 = new Rect();
                            this.f6795f.getGlobalVisibleRect(rect);
                            findViewById.getGlobalVisibleRect(rect2);
                            if (rect.top != rect2.top) {
                                this.f6787O = false;
                            }
                            if (rect.bottom != rect2.bottom) {
                                this.f6788P = false;
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public final HashSet<iu> m7487a() {
        return this.f6783K;
    }

    /* renamed from: a */
    final void m7488a(View view) {
        if (((Boolean) aph.f().a(asp.bG)).booleanValue()) {
            ahe a = this.f6793d.a();
            if (a != null) {
                a.a(view);
            }
        }
    }

    /* renamed from: a */
    public final void m7489a(HashSet<iu> hashSet) {
        this.f6783K = hashSet;
    }

    /* renamed from: a */
    public final void m7490a(boolean z) {
        if (!(this.f6781I != 0 || this.f6799j == null || this.f6799j.f15575b == null)) {
            this.f6799j.f15575b.stopLoading();
        }
        if (this.f6796g != null) {
            this.f6796g.b();
        }
        if (this.f6797h != null) {
            this.f6797h.b();
        }
        if (z) {
            this.f6799j = null;
        }
    }

    /* renamed from: b */
    public final void m7491b() {
        if (this.f6799j != null && this.f6799j.f15575b != null) {
            this.f6799j.f15575b.destroy();
        }
    }

    /* renamed from: c */
    public final void m7492c() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r1 = this;
        r0 = r1.f6799j;
        if (r0 == 0) goto L_0x0017;
    L_0x0004:
        r0 = r1.f6799j;
        r0 = r0.f15589p;
        if (r0 == 0) goto L_0x0017;
    L_0x000a:
        r0 = r1.f6799j;	 Catch:{ RemoteException -> 0x0012 }
        r0 = r0.f15589p;	 Catch:{ RemoteException -> 0x0012 }
        r0.c();	 Catch:{ RemoteException -> 0x0012 }
        return;
    L_0x0012:
        r0 = "Could not destroy mediation adapter.";
        com.google.android.gms.internal.ads.jn.e(r0);
    L_0x0017:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.ay.c():void");
    }

    /* renamed from: d */
    public final boolean m7493d() {
        return this.f6781I == 0;
    }

    /* renamed from: e */
    public final boolean m7494e() {
        return this.f6781I == 1;
    }

    /* renamed from: f */
    public final String m7495f() {
        return (this.f6787O && this.f6788P) ? "" : this.f6787O ? this.f6789Q ? "top-scrollable" : "top-locked" : this.f6788P ? this.f6789Q ? "bottom-scrollable" : "bottom-locked" : "";
    }

    public final void onGlobalLayout() {
        m7486b(false);
    }

    public final void onScrollChanged() {
        m7486b(true);
        this.f6789Q = true;
    }
}
